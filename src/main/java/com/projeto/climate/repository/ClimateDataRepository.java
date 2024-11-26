package com.projeto.climate.repository;

import com.projeto.climate.entity.ClimateData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClimateDataRepository extends JpaRepository<ClimateData, Long> {
}
