package com.hospital.rama.app.repository;

import com.hospital.rama.app.model.Patient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DataRepository {

    private Map<String, Patient> patientMap= new HashMap<String,Patient>();

    public Patient getPatient(String name){
        return patientMap.get(name);
    }

    public void savePatient(String name,Patient patient){
         patientMap.put(name,patient);
    }

    public void removePatient(String name){
         patientMap.remove(name);
    }

}
