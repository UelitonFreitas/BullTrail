package com.origin.ueliton.bulltrail.util;

import java.util.Collection;

/**
 * Created by ueliton on 18/06/16.
 */
public class CollectionsUtils {
    public static boolean  isEmpty(Collection animals) {
        return animals == null || animals.isEmpty();
    }
}
