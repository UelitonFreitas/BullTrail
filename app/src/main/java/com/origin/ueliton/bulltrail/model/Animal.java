package com.origin.ueliton.bulltrail.model;

import com.origin.ueliton.bulltrail.emptyObject.EmptyAnimal;
import com.origin.ueliton.bulltrail.migrations.AnimalMigration;
import com.origin.ueliton.bulltrail.util.StringUtil;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import se.emilsjolander.sprinkles.Model;
import se.emilsjolander.sprinkles.Query;
import se.emilsjolander.sprinkles.annotations.AutoIncrement;
import se.emilsjolander.sprinkles.annotations.Column;
import se.emilsjolander.sprinkles.annotations.Key;
import se.emilsjolander.sprinkles.annotations.Table;

/**
 * Created by ueliton on 02/04/16.
 */

public class Animal{

    public Long id;

    public String registerNumber;

    public String name;

    public Date birthDate;

    public String race;

    public String coat;

    public String father;

    public String mother;

    public String ethnicity;

    public Integer weight;
    private String imagePath;
    private Integer age;

    public Animal(String name, String registerNumber, Date birthDate, String race, String coat, String father, String mother, String ethnicity, Integer weight, Integer age, String imagePath) {
        this.name = name;
        this.registerNumber = registerNumber;
        this.birthDate = birthDate;
        this.race = race;
        this.coat = coat;
        this.father = father;
        this.mother = mother;
        this.ethnicity = ethnicity;
        this.weight = weight;
        this.age = age;
        this.imagePath = imagePath;
    }

    //    public static List<Animal> findAll() {
//
//        String query = "SELECT * FROM " + AnimalMigration.Attribute.TABLE_NAME;
//
//        List<Animal> animals = Query.many(Animal.class, query).get().asList();
//
//        if (animals == null)
//            return Collections.emptyList();
//
//        return animals;
//    }
//
//    public static Animal findById(long animalId) {
//
//        String query = "SELECT * FROM " + AnimalMigration.Attribute.TABLE_NAME +
//                "WHERE " + AnimalMigration.Attribute.ID + " = " + animalId;
//
//        return getOne(query);
//    }
//
//    private static Animal getOne(String query) {
//        Animal animal = Query.one(Animal.class, query).get();
//        return animal == null ? new EmptyAnimal() : animal;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getCoat() {
        return coat;
    }

    public void setCoat(String coat) {
        this.coat = coat;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getImagePath() {
        return imagePath;
    }

    public Integer getAge() {
        return age;
    }

    public boolean isEmpty() {
        return StringUtil.isEmpty(registerNumber);
    }
}
