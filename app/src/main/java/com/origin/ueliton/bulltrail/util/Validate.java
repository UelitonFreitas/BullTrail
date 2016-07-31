package com.origin.ueliton.bulltrail.util;

import com.origin.ueliton.bulltrail.exceptions.EmptyFieldException;

/**
 * Created by ueliton on 7/31/16.
 */
public abstract class Validate {
    public static void validateEmptyField(String field) throws EmptyFieldException {
        if (StringUtil.isEmpty(field))
            throw new EmptyFieldException();
    }
}
