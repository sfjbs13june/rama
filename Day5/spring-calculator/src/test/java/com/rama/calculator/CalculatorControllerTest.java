package com.rama.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorControllerTest {

     @InjectMocks
     CalculatorController calculatorController;

     MyCalculator myCalculator;

     @BeforeEach
     void setUp(){
         myCalculator=mock(MyCalculator.class);
         calculatorController=new CalculatorController(myCalculator);
     }

    @Test
    public void addStringTest(){
        when(myCalculator.addString(anyString(),anyString())).thenReturn("helloworld");
        String result= calculatorController.addString("a","b");
        assertEquals("helloworld",result);

    }
}
