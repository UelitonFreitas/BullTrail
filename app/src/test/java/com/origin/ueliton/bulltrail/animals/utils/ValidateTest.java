package com.origin.ueliton.bulltrail.animals.utils;

import com.origin.ueliton.bulltrail.exceptions.EmptyFieldException;
import com.origin.ueliton.bulltrail.util.Validate;

import org.junit.Test;

import static junit.framework.Assert.assertNull;

/**
 * Created by ueliton on 7/31/16.
 */
public class ValidateTest {


    @Test(expected = EmptyFieldException.class)
    public void shouldThrowEmptyExceptionForEmptyField() throws EmptyFieldException {
        Validate.validateEmptyField("");
    }

    @Test
    public void should_NOT_ThrowEmptyExceptionForEmptyField(){

        EmptyFieldException emptyFieldException = null;

        try {
            Validate.validateEmptyField("a");
        } catch (EmptyFieldException e) {
            e.printStackTrace();
            emptyFieldException = e;
        }

        assertNull(emptyFieldException);
    }

}
