package com.petfinder.controller;

import com.petfinder.pojo.Animal;
import com.petfinder.pojo.Localisation;
import com.petfinder.pojo.Utilisateur;
import com.petfinder.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class AnimalController {

    @Autowired
    AnimalService animalService;

    @RequestMapping(value = "/animal", method = RequestMethod.POST)
    @ResponseBody
    public int addAnimal(@RequestParam("file") MultipartFile file, HttpSession session){

        int result = 0;
        String oldFileName = file.getOriginalFilename();
        String file_Path = "D:\\Java\\projet_transverse_vue\\src\\assets\\upload";

        if(file != null && oldFileName != null && oldFileName.length() >0){

            String newFileName = UUID.randomUUID() + oldFileName.substring(oldFileName.lastIndexOf('.'));

            File newFile = new File(file_Path+"\\"+newFileName);
            try {
                file.transferTo(newFile);
                Animal animal = new Animal();
                animal.setPhotoAnimal(newFileName);
                result = animalService.addAnimal(animal);


            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    @RequestMapping("/adddemande")
    @ResponseBody
    public int addDemande(
            @RequestParam("idAnimal") int idAnimal,
            @RequestParam("nomAnimal") String nomAnimal,
            @RequestParam("typeAnimal") String typeAnimal,
            @RequestParam("sexeAnimal") String sexeAnimal,
            @RequestParam("couleurAnimal") String couleurAnimal,
            @RequestParam("dateAnimal")  @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateAnimal,
            @RequestParam("etatAnimal") String etatAnimal,
            @RequestParam("descriptionAnimal") String descriptionAnimal,
            @RequestParam("raceAnimal") String raceAnimal,
            @RequestParam("nomVille") String nomVille,
            @RequestParam("cpVille") int cpVille,
            @RequestParam("rueVille") String rueVille,
            @RequestParam("emailUtilisateur") String emailUtilisateur
    ){

        Animal animal = new Animal();
        animal.setIdAnimal(idAnimal);
        animal.setNomAnimal(nomAnimal);
        animal.setTypeAnimal(typeAnimal);
        animal.setSexeAnimal(sexeAnimal);
        animal.setCouleurAnimal(couleurAnimal);
        animal.setDateAnimal(dateAnimal);
        animal.setEtatAnimal(etatAnimal);
        animal.setDescriptionAnimal(descriptionAnimal);
        animal.setRaceAnimal(raceAnimal);
        Localisation localisation = new Localisation();
        localisation.setVilleLocalisation(nomVille);
        localisation.setCpLocalisation(cpVille);
        localisation.setRueLocalisation(rueVille);
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setEmailUtilisateur(emailUtilisateur);
        animal.setLocalisation(localisation);
        animal.setUtilisateur(utilisateur);

        return animalService.updateAnimal(animal);
    }

    @RequestMapping("/getanimal")
    @ResponseBody
    public List<Animal> getAnimal(@RequestParam("etat") String etat){


        List<Animal> animals = animalService.getAnimal(etat);

        return animals;
    }
}
