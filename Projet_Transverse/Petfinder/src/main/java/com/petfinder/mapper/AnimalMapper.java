package com.petfinder.mapper;

import com.petfinder.pojo.Animal;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnimalMapper {

    int addAnimal(Animal animal);

    int updateAnimal(Animal animal);

    List<Animal> getAnimal(@Param("etat") String etat);
}
