package com.rama.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest({CalculatorController.class})
@ActiveProfiles(value = "test")
public class CalculatorWebControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Value("${calculator.add.url}")
    String addurl;

    @Value("${calculator.sub.url}")
    String suburl;

    @Value("${calculator.mul.url}")
    String mulurl;

    @Value("${calculator.div.url}")
    String divurl;

    @Value("${calculator.addstr.url}")
    String addstrurl;

    @Test
    public void testAddition() throws Exception {
        ResultActions responseEntity  = mockMvc.perform(get(addurl).header("a","4.0")
                .header("b","3.0"));
        responseEntity.andExpect(status().isOk());
        String result = responseEntity.andReturn().getResponse().getContentAsString();
        assertEquals("7.0", result);
    }

    @Test
    public void testSubstration() throws Exception {
        ResultActions responseEntity  = mockMvc.perform(get(suburl).header("a","7.0")
                .header("b","3.0"));
        responseEntity.andExpect(status().isOk());
        String result = responseEntity.andReturn().getResponse().getContentAsString();
        assertEquals("4.0", result);
    }

    @Test
    public void testMultiplication() throws Exception {
        ResultActions responseEntity  = mockMvc.perform(get(mulurl).header("a","5.0")
                .header("b","3.0"));
        responseEntity.andExpect(status().isOk());
        String result = responseEntity.andReturn().getResponse().getContentAsString();
        assertEquals("15.0", result);
    }

    @Test
    public void testDivision() throws Exception {
        ResultActions responseEntity  = mockMvc.perform(get(divurl).header("a","4.0")
                .header("b","2.0"));
        responseEntity.andExpect(status().isOk());
        String result = responseEntity.andReturn().getResponse().getContentAsString();
        assertEquals("2.0", result);
    }

    @Test
    public void testAddStr() throws Exception {
        ResultActions responseEntity  = mockMvc.perform(get(addstrurl).header("a","hello")
                .header("b","test"));
        responseEntity.andExpect(status().isOk());
        String result = responseEntity.andReturn().getResponse().getContentAsString();
        assertEquals("hellotest", result);
    }

    @Test
    public void testsendPath() throws Exception {
        ResultActions responseEntity  = mockMvc.perform(get("/sendpath/v.1"));
        responseEntity.andExpect(status().isOk());
        String result = responseEntity.andReturn().getResponse().getContentAsString();
        assertEquals("v.1", result);
    }



}
