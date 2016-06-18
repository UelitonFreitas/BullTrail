package com.origin.ueliton.bulltrail.data;

import android.os.Handler;
import android.util.ArrayMap;

import com.origin.ueliton.bulltrail.model.Animal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ueliton on 11/06/16.
 * Implementação do serviço dos animais e adiciona latência as requisições.
 */
public class AnimalsServiceApiImpl implements AnimalsServiceApi {

    private static final long SERVICE_LATENCY_IN_MILLIS = 2000;
    private static final ArrayMap<Long, Animal> ANIMALS_SERVICE_DATA =
            AnimalsServiceApiEndPoint.loadPersistenceAnimals();

    @Override
    public void getAnimals(final LoadAnimalsCallBack loadAnimalsCallBack) {

        List<Animal> animals = new ArrayList<>(ANIMALS_SERVICE_DATA.values());
        loadAnimalsCallBack.onAnimalsLoaded(animals);
        //Latencia
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        }, SERVICE_LATENCY_IN_MILLIS);
    }

    @Override
    public void getAnimal(final Long animalId, final LoadAnimalCallBack animalCallBack) {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Animal animal = ANIMALS_SERVICE_DATA.get(animalId);
                animalCallBack.onLoadedAnimal(animal);
            }
        }, SERVICE_LATENCY_IN_MILLIS);
    }

    @Override
    public void saveAnimal(Animal animal) {
        ANIMALS_SERVICE_DATA.put(animal.getId(), animal);
    }
}
