package com.projeto.climate.service;
import com.projeto.climate.client.WeatherStackClient;

import com.projeto.climate.dto.ClimateDataDTO;
import com.projeto.climate.entity.ClimateData;
import com.projeto.climate.entity.City;
import com.projeto.climate.repository.ClimateDataRepository;
import com.projeto.climate.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ClimateDataService {
    @Autowired
    private ClimateDataRepository climateDataRepository;

    @Autowired
    private CityRepository cityRepository;

    public List<ClimateData> getAllClimateData() {
        return climateDataRepository.findAll();
    }

    public ClimateData createClimateData(ClimateDataDTO dto) {
        City city = cityRepository.findById(dto.getCityId())
                .orElseThrow(() -> new RuntimeException("City not found"));

        ClimateData climateData = new ClimateData();
        climateData.setDate(dto.getDate());
        climateData.setTemperature(dto.getTemperature());
        climateData.setHumidity(dto.getHumidity());
        climateData.setWeatherDescription(dto.getWeatherDescription());
        climateData.setCity(city);
        return climateDataRepository.save(climateData);
    }

    public void deleteClimateData(Long id) {
        climateDataRepository.deleteById(id);
    }

    @Autowired
    private WeatherStackClient weatherStackClient;

    public Map<String, Object> getWeatherForCity(String city) {
        return weatherStackClient.getWeather(city);
    }
}
