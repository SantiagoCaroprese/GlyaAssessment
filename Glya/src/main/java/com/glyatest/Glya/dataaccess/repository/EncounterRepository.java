package com.glyatest.Glya.dataaccess.repository;

import com.glyatest.Glya.crosscuting.entities.Encounter;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface EncounterRepository extends MongoRepository<Encounter, String> {
    List<Encounter> findByVacuna(String vacuna);
    List<Encounter> findByFechaBetween(LocalDate dateGT, LocalDate dateLT);
}
