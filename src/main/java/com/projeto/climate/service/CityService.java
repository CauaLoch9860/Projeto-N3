package com.projeto.climate.service;

import com.projeto.climate.dto.CityDTO;
import com.projeto.climate.entity.City;
import com.projeto.climate.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    // Pegar todas as cidades
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    // Pegar cidade pelo ID
    public Optional<City> getCityById(Long id) {
        return cityRepository.findById(id);
    }

    // Criar uma cidade nova
    public City createCity(CityDTO cityDTO) {
        City city = new City();
        city.setName(cityDTO.getName()); // Define o nome da cidade
        city.setCountry(cityDTO.getCountry()); // Define o país da cidade
        return cityRepository.save(city); // Salva e retorna a cidade criada
    }

    // Atualizar os dados de uma cidade que já existe
    public City updateCity(Long id, CityDTO cityDTO) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City not found"));
        city.setName(cityDTO.getName());
        city.setCountry(cityDTO.getCountry());
        return cityRepository.save(city);
    }

    // Exclui cidade pelo ID
    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }
}
