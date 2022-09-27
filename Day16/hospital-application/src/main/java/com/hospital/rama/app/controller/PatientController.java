package com.hospital.rama.app.controller;

import com.hospital.rama.app.model.Patient;
import com.hospital.rama.app.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientController {

    private final DataRepository dataRepository;
    @Autowired
    public PatientController( DataRepository dataRepository){
        this.dataRepository=dataRepository;
    }

    @GetMapping("/get/patient")
    public Patient getPatient(@RequestParam String name){

        return dataRepository.getPatient(name);
    }
    @PostMapping("save/patient")
    public void savePatient(@RequestBody Patient patient){
        String name= patient.getName();
        dataRepository.savePatient(name,patient);
    }
    @PutMapping("update/patient")
    public Patient updatePatient(@RequestParam String name,@RequestParam String hospital){
        Patient result= dataRepository.getPatient(name);
        result.setHospital(hospital);
        dataRepository.savePatient(name,result);
        return result;

    }
    @DeleteMapping("remove/patient")
    public void deletePatient(@RequestParam String name){
        dataRepository.removePatient(name);
    }

    @GetMapping("/get/header")
    public Patient getPatientHeader(@RequestParam String name,@RequestHeader String disease){
        Patient result= dataRepository.getPatient(name);
        result.setDisease(disease);
        return result;
    }
}
