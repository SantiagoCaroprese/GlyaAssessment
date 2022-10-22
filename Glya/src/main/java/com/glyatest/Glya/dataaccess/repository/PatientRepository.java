package com.glyatest.Glya.dataaccess.repository;

import com.glyatest.Glya.crosscuting.entities.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PatientRepository extends MongoRepository<Patient, String> {

}
