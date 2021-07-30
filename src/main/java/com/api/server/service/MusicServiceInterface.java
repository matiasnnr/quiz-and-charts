package com.api.server.service;

import java.util.List;

import com.api.server.entity.Music;
import com.api.server.models.Chart;
import com.api.server.models.Type;

public interface MusicServiceInterface {

    public String createMusic(Music music);

    public List<Type> readTypesMusics();

    public List<Chart> getChartData();

    public List<Music> readMusics();

    public String updateMusic(Music music);

    public String deleteMusic(Music music);

}
