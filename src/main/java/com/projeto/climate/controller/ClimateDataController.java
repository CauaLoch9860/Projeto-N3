package com.projeto.climate.controller;

import com.projeto.climate.dto.ClimateDataDTO;
import com.projeto.climate.entity.ClimateData;
import com.projeto.climate.service.ClimateDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/climate-data")
public class ClimateDataController {

    @Autowired
    private ClimateDataService climateDataService;

    @GetMapping
    public ResponseEntity<List<ClimateData>> getAllClimateData() {
        return ResponseEntity.ok(climateDataService.getAllClimateData());
    }

    @PostMapping
    public ResponseEntity<ClimateData> createClimateData(@RequestBody ClimateDataDTO dto) {
        return ResponseEntity.ok(climateDataService.createClimateData(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClimateData(@PathVariable Long id) {
        climateDataService.deleteClimateData(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/weather/{city}")
    public ResponseEntity<Map<String, Object>> getWeatherForCity(@PathVariable String city) {
        return ResponseEntity.ok(climateDataService.getWeatherForCity(city));
    }
}

