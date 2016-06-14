package com.origin.ueliton.bulltrail.model;

import android.support.annotation.Nullable;

import com.google.common.base.Objects;
import com.origin.ueliton.bulltrail.util.StringUtil;

import java.util.Date;
import java.util.UUID;

/**
 * Created by ueliton on 02/04/16.
 */

public class Animal{

    public Long id;

    public String registerNumber;

    @Nullable
    public String name;

    @Nullable
    public Date birthDate;

    @Nullable
    public String race;

    @Nullable
    public String coat;

    @Nullable
    public String father;

    @Nullable
    public String mother;

    @Nullable
    public String ethnicity;

    @Nullable
    public Integer weight;

    @Nullable
    private String imagePath;

    @Nullable
    private Integer age;

    public Animal(@Nullable  String name,
                  String registerNumber,
                  @Nullable Date birthDate,
                  @Nullable String race,
                  @Nullable String coat,
                  @Nullable String father,
                  @Nullable String mother,
                  @Nullable String ethnicity,
                  @Nullable Integer weight,
                  @Nullable Integer age,
                  @Nullable String imagePath) {

        this.id = Long.valueOf(UUID.randomUUID().toString());
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (id != null ? !id.equals(animal.id) : animal.id != null) return false;
        if (registerNumber != null ? !registerNumber.equals(animal.registerNumber) : animal.registerNumber != null)
            return false;
        if (name != null ? !name.equals(animal.name) : animal.name != null) return false;
        if (birthDate != null ? !birthDate.equals(animal.birthDate) : animal.birthDate != null)
            return false;
        if (race != null ? !race.equals(animal.race) : animal.race != null) return false;
        if (coat != null ? !coat.equals(animal.coat) : animal.coat != null) return false;
        if (father != null ? !father.equals(animal.father) : animal.father != null) return false;
        if (mother != null ? !mother.equals(animal.mother) : animal.mother != null) return false;
        if (ethnicity != null ? !ethnicity.equals(animal.ethnicity) : animal.ethnicity != null)
            return false;
        if (weight != null ? !weight.equals(animal.weight) : animal.weight != null) return false;
        if (imagePath != null ? !imagePath.equals(animal.imagePath) : animal.imagePath != null)
            return false;
        return age != null ? age.equals(animal.age) : animal.age == null;

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id,
                registerNumber,
                name,
                race,
                coat,
                father,
                mother,
                ethnicity,
                weight,
                imagePath,
                age);
    }
}
