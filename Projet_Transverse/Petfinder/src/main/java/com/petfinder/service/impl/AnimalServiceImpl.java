package com.petfinder.service.impl;

import com.petfinder.mapper.AnimalMapper;
import com.petfinder.mapper.DemandeMapper;
import com.petfinder.mapper.LocalisationMapper;
import com.petfinder.mapper.UtilisateurMapper;
import com.petfinder.pojo.Animal;
import com.petfinder.pojo.Demande;
import com.petfinder.pojo.Localisation;
import com.petfinder.pojo.Utilisateur;
import com.petfinder.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    AnimalMapper animalMapper;
    @Autowired
    LocalisationMapper localisationMapper;
    @Autowired
    DemandeMapper demandeMapper;
    @Autowired
    UtilisateurMapper utilisateurMapper;


    @Override
    public int addAnimal(Animal animal) {


        if(animalMapper.addAnimal(animal) > 0){

            return animal.getIdAnimal();
        }

        return 0;

    }


    @Override
    public int updateAnimal(Animal animal) {

        localisationMapper.addLocalisation(animal.getLocalisation());
        Utilisateur utilisateur = utilisateurMapper.selectUtilisateurByEmail(animal.getUtilisateur().getEmailUtilisateur());
        animal.setUtilisateur( utilisateur );
        animalMapper.updateAnimal(animal);
        Demande demande = new Demande();
        demande.setAnimal(animal);
        demande.setEtatDemande(animal.getEtatAnimal());
        demande.setDateCreationDemande(new Date());

        return demandeMapper.addDemande(demande);
    }

    @Override
    public List<Animal> getAnimal(String etat) {

        List<Animal> animals = animalMapper.getAnimal(etat);
        for (Animal animal : animals
        ){
            Localisation localisation = localisationMapper.selectLocalisationById(animal.getLocalisation().getIdLocalisation());
            animal.setLocalisation(localisation);
        }

        return animals;
    }


}
