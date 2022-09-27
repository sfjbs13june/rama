package com.hospital.rama.app.controller;

import com.hospital.rama.app.model.Patient;
import com.hospital.rama.app.repository.DataRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PatientControllerTest {
    @InjectMocks
    private PatientController patientController;
    @Mock
    private DataRepository dataRepository;

    @Test
    public void getPatientTest(){
        dataRepository= Mockito.mock(DataRepository.class);
        Patient patient= new Patient("id1","pat01","hospital01","dis01");
        when(dataRepository.getPatient("pat01")).thenReturn(patient);
        Patient result= patientController.getPatient("pat01");

        assertEquals("id1",result.getId());
        assertEquals("pat01",result.getName());
        assertEquals("hospital01",result.getHospital());
        assertEquals("dis01",result.getDisease());

    }

    @Test
    public void storeTest(){

    }

}
