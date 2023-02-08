package org.example.clientinfo.serviceImpl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import javax.persistence.Table;

@RunWith(MockitoJUnitRunner.class)
public class IDValidationServiceTest {

    @InjectMocks
    IDValidationServiceImpl idValidationServiceImpl;

    @Test
    public void testForValidIdNumber(){
        String idNumber = "0311251002094";
        boolean response = idValidationServiceImpl.validateClientIdNumber(idNumber);

        Assert.assertNotNull(response);
        Assert.assertTrue(response);
    }

    @Test
    public void testForInValidIdNumber(){
        String idNumber = "0311251002092";
        boolean response = idValidationServiceImpl.validateClientIdNumber(idNumber);

        Assert.assertNotNull(response);
        Assert.assertFalse(response);
    }
}
