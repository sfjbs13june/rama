package com.hospital.rama.app.repository;

import com.hospital.rama.app.model.Patient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class DataRepositoryTest {
    @InjectMocks
    private DataRepository dataRepository;

    @Test
    public void getPatientTestWithNull() {
        Patient result = dataRepository.getPatient("pat01");
        assertNull(result);
    }

    @Test
    public void savePatientTest() {
        Patient patient = new Patient("id1", "pat01", "hospital01", "dis01");
        dataRepository.savePatient("pat01", patient);

    }

    @Test
    public void getPatientTestWith() {
        Patient patient = new Patient();
        patient.setDisease("dis01");
        patient.setId("id1");
        patient.setHospital("hospital01");
        patient.setName("pat01");
        dataRepository.savePatient("pat01", patient);
        Patient result = dataRepository.getPatient("pat01");
        assertEquals("id1", result.getId());
        assertEquals("pat01", result.getName());
        assertEquals("hospital01", result.getHospital());
        assertEquals("dis01", result.getDisease());
    }
}
