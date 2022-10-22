package com.glyatest.Glya.business.encounter;

import com.glyatest.Glya.crosscuting.entities.Encounter;
import com.glyatest.Glya.dataaccess.repository.EncounterRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TotalDosesBetweenDatesFinder {

    private EncounterRepository repository;

    @Autowired
    public TotalDosesBetweenDatesFinder(EncounterRepository repository) {
        this.repository = repository;
    }

    public int execute(LocalDate start, LocalDate end){
        List<Encounter> result = repository.findByFechaBetween(start, end);

        return result.size();
    }
}
