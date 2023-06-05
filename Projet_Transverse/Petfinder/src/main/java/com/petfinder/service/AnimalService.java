package com.petfinder.service;

import com.petfinder.pojo.Animal;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AnimalService {

    int addAnimal(Animal animal);

    int updateAnimal(Animal animal);

    List<Animal> getAnimal(String etat);
}
