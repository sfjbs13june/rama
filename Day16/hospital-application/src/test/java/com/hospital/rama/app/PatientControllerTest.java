package com.hospital.rama.app;

import com.hospital.rama.app.controller.PatientController;
import com.hospital.rama.app.model.Patient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PatientControllerTest {
    @InjectMocks
    private PatientController patientController;


    @Test
    public void getAllTest(){
        //Patient patient;
       /* List<Users> usersList=new ArrayList<>();
        usersList.add(user1);
        when(usersRepository.findAll()).thenReturn(usersList);
        List<Users> results= (List<Users>) usersController.getAll();
        Users result =results.get(0);
        assertEquals(1,result.getId());
        assertEquals("test",result.getName());
        assertEquals(20000,result.getSalary());
        assertEquals("test1",result.getTeamName());*/

    }

    @Test
    public void storeTest(){

    }

}
