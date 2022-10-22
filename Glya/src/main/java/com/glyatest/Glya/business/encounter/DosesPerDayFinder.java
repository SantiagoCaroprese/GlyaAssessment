package com.glyatest.Glya.business.encounter;

import com.glyatest.Glya.crosscuting.entities.Encounter;
import com.glyatest.Glya.dataaccess.repository.EncounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class DosesPerDayFinder {

    private EncounterRepository repository;

    @Autowired
    public DosesPerDayFinder(EncounterRepository repository) {
        this.repository = repository;
    }

    public Map<LocalDate, Integer> execute(String vacuna){
        List<Encounter> result = repository.findByVacuna(vacuna);

        if(result != null){
            return formatter(result);
        }
        return null;
    }

    private Map<LocalDate, Integer> formatter(List<Encounter> encounters){
        Map<LocalDate, Integer> dosesPerDay = new HashMap<>();
        for(Encounter e : encounters){
            if(dosesPerDay.containsKey( e.getFecha() )){
                dosesPerDay.put( e.getFecha() , dosesPerDay.get( e.getFecha() ) + 1);
            }else{
                dosesPerDay.put( e.getFecha() , 1);
            }
        }

        return dosesPerDay;
    }
}
