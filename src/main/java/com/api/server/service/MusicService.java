package com.api.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.server.entity.Music;
import com.api.server.models.Chart;
import com.api.server.models.Type;
import com.api.server.repository.MusicRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MusicService implements MusicServiceInterface {

    @Autowired
    private MusicRepository musicRepository;

    public String createMusic(Music music) {
        try {
            if (!musicRepository.existsByEmail(music.getEmail())) {
                musicRepository.save(music);
                return "Se registro tu estilo de música exitosamente.";
            } else {
                return "Ya registraste un tipo de música con este correo electrónico.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Type> readTypesMusics() {
        // se podría hacer una lista en la base de datos pero por temas de desarrollo se
        // hará agregando los tipos a la lista directamente
        List<Type> typesMusicList = new ArrayList<>();
        typesMusicList.add(new Type(1, "Rock"));
        typesMusicList.add(new Type(2, "Pop"));
        typesMusicList.add(new Type(3, "Jazz"));
        typesMusicList.add(new Type(4, "Clásica"));
        return typesMusicList;
    }

    public List<Music> readMusics() {
        return musicRepository.findAll();
    }

    public String updateMusic(Music music) {
        if (musicRepository.existsByEmail(music.getEmail())) {
            try {
                Music musicToBeUpdate = musicRepository.findByEmail(music.getEmail());
                musicToBeUpdate.setType(music.getType());
                musicRepository.save(musicToBeUpdate);
                return "Se actualizó correctamente.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "No existe este registro en la base de datos.";
        }
    }

    public String deleteMusic(Music music) {
        if (musicRepository.existsByEmail(music.getEmail())) {
            try {
                Music musicToBeDeleted = musicRepository.findByEmail(music.getEmail());
                musicRepository.delete(musicToBeDeleted);
                return "Se eliminó correctamente.";
            } catch (Exception e) {
                throw e;
            }

        } else {
            return "No existe este registro en la base de datos.";
        }
    }

    public List<Chart> getChartData() {

        List<Type> typesMusicList = readTypesMusics();
        List<Chart> chartData = new ArrayList<Chart>();

        for (Type type : typesMusicList) {
            Integer totalType = musicRepository.countType(type.getName());
            chartData.add(new Chart(totalType, type.getName()));
        }

        return chartData;
    }
}
