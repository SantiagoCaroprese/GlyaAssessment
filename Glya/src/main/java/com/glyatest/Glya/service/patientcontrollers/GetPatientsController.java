package com.glyatest.Glya.service.patientcontrollers;

import com.glyatest.Glya.business.patient.PatientsByDoseFinder;
import com.glyatest.Glya.crosscuting.entities.Patient;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("glya/patients")
public class GetPatientsController {

    @Autowired
    PatientsByDoseFinder patientObtainer;

    @GetMapping("/twodoses")
    public ResponseEntity execute(){
        List<Patient> patients = patientObtainer.execute();
        return ResponseEntity.status(HttpStatus.OK).body(patients);
    }
}
