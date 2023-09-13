package com.rama.app.controller.unittest;

import com.rama.app.controller.StudentController;
import com.rama.app.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class StudentControllerTest {
    @InjectMocks
    private StudentController studentController;
    @Test
    public void test_createStudent(){
        Student student=new Student("stud1", "123",12,"std7");
        Student result=studentController.createStudent(student);
        assertEquals(student.getName(),result.getName());
        assertEquals(student.getRollNo(),result.getRollNo());
        assertEquals(student.getStd(),result.getStd());
        assertEquals(student.getAge(),result.getAge());
    }

    @Test
    public void test_readeStudent(){
        Student student=new Student("stud1", "123",12,"std7");
        studentController.createStudent(student);
        Student result=studentController.readeStudent("stud1");
        assertEquals("stud1",result.getName());
        assertEquals("123",result.getRollNo());
        assertEquals("std7",result.getStd());
        assertEquals(12,result.getAge());
    }

    @Test
    public void test_updateStudent(){
        Student student=new Student("stud1", "123",12,"std7");
        studentController.createStudent(student);
        Student result=studentController.updateStudent("stud1",13);
        assertEquals("stud1",result.getName());
        assertEquals("123",result.getRollNo());
        assertEquals("std7",result.getStd());
        assertEquals(13,result.getAge());

    }

    @Test
    public void test_deleteStudent(){
        Student student=new Student();
        student.setAge(12);
        student.setName("stud1");
        student.setStd("std8");
        student.setRollNo("123");
        studentController.createStudent(student);
        studentController.deleteStudent("stud1");
        Student result=studentController.readeStudent("stud1");
        assertNull(result);
    }
}
