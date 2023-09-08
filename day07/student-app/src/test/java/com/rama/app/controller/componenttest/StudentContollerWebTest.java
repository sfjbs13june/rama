package com.rama.app.controller.componenttest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.rama.app.controller.StudentController;
import com.rama.app.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest({StudentController.class})
@ActiveProfiles(value = "test")
public class StudentContollerWebTest {
    @Autowired
    private MockMvc mockMvc;

    @Value("${student.create.url}")
    String create_url;
    @Value("${student.read.url}")
    String read_url;
    @Value("${student.update.url}")
    String update_url;
    @Value("${student.delete.url}")
    String delete_url;


    @Test
    public void test_createStudent() throws Exception {
        Student student = new Student("stud1", "123", 12, "std7");
        ResultActions resultActions=mockMvc.perform(post(create_url).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(student)).accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string=resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
        Student result = g.fromJson(result_string, Student.class);
        assertEquals("stud1",result.getName());
        assertEquals("123",result.getRollNo());
        assertEquals("std7",result.getStd());
        assertEquals(12,result.getAge());
    }

    @Test
    public void test_readeStudent() throws Exception {
        Student student = new Student("stud1", "123", 12, "std7");
        ResultActions resultActions_create=mockMvc.perform(post("/create").contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(student)).accept(MediaType.APPLICATION_JSON));
        resultActions_create.andExpect(status().isOk());
        ResultActions resultActions=mockMvc.perform(get("/read").param("name","stud1").accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string=resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
        Student result = g.fromJson(result_string, Student.class);
        assertEquals("stud1",result.getName());
        assertEquals("123",result.getRollNo());
        assertEquals("std7",result.getStd());
        assertEquals(12,result.getAge());
    }

    @Test
    public void test_updateStudent() throws Exception {
        Student student = new Student("stud1", "123", 12, "std7");
        ResultActions resultActions_create=mockMvc.perform(post("/create").contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(student)).accept(MediaType.APPLICATION_JSON));
        resultActions_create.andExpect(status().isOk());
        ResultActions resultActions=mockMvc.perform(put("/update")
                .param("name","stud1")
                .param("age","13")
                .accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string=resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
        Student result = g.fromJson(result_string, Student.class);
        assertEquals("stud1",result.getName());
        assertEquals("123",result.getRollNo());
        assertEquals("std7",result.getStd());
        assertEquals(13,result.getAge());

    }

    @Test
    public void test_deleteStudent() {

    }

    private String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
