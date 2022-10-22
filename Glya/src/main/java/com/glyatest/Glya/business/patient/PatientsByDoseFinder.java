package com.glyatest.Glya.business.patient;

import com.glyatest.Glya.crosscuting.entities.Encounter;
import com.glyatest.Glya.crosscuting.entities.Patient;
import com.glyatest.Glya.dataaccess.repository.EncounterRepository;
import com.glyatest.Glya.dataaccess.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientsByDoseFinder {

    private EncounterRepository repository;
    private PatientRepository patientRepository;

    @Autowired
    public PatientsByDoseFinder(EncounterRepository repository, PatientRepository patientRepository) {
        this.repository = repository;
        this.patientRepository = patientRepository;
    }

    public List<Patient> execute(){
        List<Encounter> result = repository.findAll();
        List<Patient> allPatients = patientRepository.findAll();

        List<Patient> patients = new ArrayList<>();

        if(result != null){

            for( Encounter e : result ){
                if( e.getDosis() == 1 || e.getDosis() == 2 ){

                    Patient patient = findPatient(allPatients, e.getPatient_id());
                    if(patient == null){
                        continue;
                    }
                    patients.add( patient );

                }
            }

        }

        return patients;
    }

    private Patient findPatient( List<Patient> patients, String id){
        for(Patient p : patients){
            if(p.getId().equals(id)){
                return p;
            }
        }
        return null;
    }
}
