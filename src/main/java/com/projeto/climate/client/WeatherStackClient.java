package com.projeto.climate.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class WeatherStackClient {

    private final String API_KEY = "9a8e9b4e7e6522e4b3733487cea2ee6e";
    private final String BASE_URL = "http://api.weatherstack.com/current?access_key=";

    public Map<String, Object> getWeather(String city) {
        RestTemplate restTemplate = new RestTemplate();
        String url = BASE_URL + API_KEY + "&query=" + city;

        // Faz a requisição da API
        try {
            return restTemplate.getForObject(url, Map.class);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar dados da API WeatherStack: " + e.getMessage());
        }
    }
}

