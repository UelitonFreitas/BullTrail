package com.origin.ueliton.bulltrail.data;

import java.util.Collection;
import java.util.Iterator;

import se.emilsjolander.sprinkles.Model;

/**
 * Created by ueliton on 02/04/16.
 */
public class Repository<T extends Model> {

    public void save(T t){
        t.save();
    }

    public void delete(T t){
        t.delete();
    }

    public void save(Collection<T> aLotOfTs){

        Iterator<T> iterator = aLotOfTs.iterator();
        while (iterator.hasNext()){
            T t = iterator.next();
            t.save();
        }
    }
}
