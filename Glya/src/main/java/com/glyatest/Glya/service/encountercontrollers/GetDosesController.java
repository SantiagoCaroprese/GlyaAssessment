package com.glyatest.Glya.service.encountercontrollers;

import com.glyatest.Glya.business.encounter.DosesPerDayFinder;
import com.glyatest.Glya.business.encounter.TotalDosesBetweenDatesFinder;
import com.glyatest.Glya.crosscuting.entities.Encounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("glya/encounter")
public class GetDosesController {

    @Autowired
    DosesPerDayFinder dosesPerDayObtainer;

    @Autowired
    TotalDosesBetweenDatesFinder dosesBetweenDatesObtainer;

    @GetMapping("/days")
    public ResponseEntity executePerDay(@RequestParam(value = "vacuna") String vacuna){
        Map<LocalDate, Integer> encounters = dosesPerDayObtainer.execute(vacuna);
        return ResponseEntity.status(HttpStatus.OK).body(encounters);
    }

    @GetMapping()
    public ResponseEntity executeBetweenDates(@RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate  start,
                                              @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end){

        int result = dosesBetweenDatesObtainer.execute(start, end);
        Map<String, Integer> data = new HashMap<>();
        data.put("Doses", result);

        return ResponseEntity.status(HttpStatus.OK).body(data);
    }
}
