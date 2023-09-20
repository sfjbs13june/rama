package com.hospital.rama.app.controller;

import com.hospital.rama.app.model.Patient;
import com.hospital.rama.app.repository.DataRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PatientControllerTest {
    @InjectMocks
    private PatientController patientController;
    @Mock
    private DataRepository dataRepository;

    @BeforeEach
    void setUp(){
        dataRepository= Mockito.mock(DataRepository.class);
    }
    @Test
    public void getPatientTest(){
        Patient patient= new Patient("id1","pat01","hospital01","dis01");
        when(dataRepository.getPatient(anyString())).thenReturn(patient);
        Patient result= patientController.getPatient("pat01");

        assertEquals("id1",result.getId());
        assertEquals("pat01",result.getName());
        assertEquals("hospital01",result.getHospital());
        assertEquals("dis01",result.getDisease());

    }
    @Test
    public void savePatientTest(){
        Patient patient= new Patient("id1","pat01","hospital01","dis01");
        doNothing().when(dataRepository).savePatient(anyString(),any(Patient.class));
        patientController.savePatient(patient);
    }
    @Test
    public void updatePatientTest(){
        Patient patient= new Patient("id1","pat01","hospital01","dis01");
        when(dataRepository.getPatient(anyString())).thenReturn(patient);
        Patient result=patientController.updatePatient("pat01","hospital02");
        assertEquals("id1",result.getId());
        assertEquals("pat01",result.getName());
        assertEquals("hospital02",result.getHospital());
        assertEquals("dis01",result.getDisease());
        verify(dataRepository,times(1)).savePatient("pat01",patient);
    }

    @Test
    public void removePatientTest(){
        doNothing().when(dataRepository).removePatient(anyString());
        patientController.deletePatient("patient");
    }

    @Test
    public void getPatientHeaderTest(){
        Patient patient= new Patient("id1","pat01","hospital01","dis01");
        when(dataRepository.getPatient(anyString())).thenReturn(patient);
        Patient result= patientController.getPatientHeader("pat01","dis01");

        assertEquals("id1",result.getId());
        assertEquals("pat01",result.getName());
        assertEquals("hospital01",result.getHospital());
        assertEquals("dis01",result.getDisease());

    }

}
