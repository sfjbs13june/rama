package com.hospital.rama.app.controller;

import com.hospital.rama.app.model.Patient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PatientController {

    private Map<String, Patient> patientMap= new HashMap<String,Patient>();

    @GetMapping("/get/patient")
    public Patient getPatient(@RequestParam String name){
        Patient result= patientMap.get(name);
        return result;
    }
    @PostMapping("save/patient")
    public void savePatient(@RequestBody Patient student){
        String name= student.getName();
        patientMap.put(name,student);
    }
    @PutMapping("update/patient")
    public Patient updatePatient(@RequestParam String name,@RequestParam String hospital){
        Patient result= patientMap.get(name);
        result.setHospital(hospital);
        patientMap.put(name,result);
        return result;

    }
    @DeleteMapping("remove/patient")
    public void deletePatient(@RequestParam String name){
        patientMap.remove(name);
    }
}
