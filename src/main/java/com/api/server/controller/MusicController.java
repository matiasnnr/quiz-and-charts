package com.api.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.api.server.entity.Music;
import com.api.server.models.Chart;
import com.api.server.models.Type;
import com.api.server.service.MusicServiceInterface;

@RestController
public class MusicController {

    @Autowired
    private MusicServiceInterface musicService;

    @GetMapping(value = "read")
    public List<Music> readMusics() {
        return musicService.readMusics();
    }

    @GetMapping(value = "readtypes")
    public List<Type> readTypesMusic() {
        return musicService.readTypesMusics();
    }

    @PostMapping(value = "create")
    public String createMusic(@RequestBody Music music) {
        return musicService.createMusic(music);
    }

    @PutMapping(value = "update")
    public String updateStudet(@RequestBody Music music) {
        return musicService.updateMusic(music);
    }

    @DeleteMapping(value = "delete")
    public String deleteMusic(@RequestBody Music music) {
        return musicService.deleteMusic(music);
    }

    @GetMapping(value = "charts")
    public List<Chart> getChartData() {
        return musicService.getChartData();
    }

}
