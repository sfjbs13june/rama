package com.rama.calculator;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorUnitTest {

    @InjectMocks
    private CalculatorController calculatorController;

    @Mock
    private MyCalculator myCalculator;

    @Test
    public void addStringTest(){
        when(myCalculator.addString(anyString(),anyString())).thenReturn("helloworld");
        String result= calculatorController.addString("hello","world");
        assertEquals("helloworld",result);

    }
}
