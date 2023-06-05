package com.petfinder.controller;

import com.petfinder.pojo.Localisation;
import com.petfinder.pojo.Utilisateur;
import com.petfinder.pojo.Ville;
import com.petfinder.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UtilisateurController {

    @Autowired
    UtilisateurService utilisateurService;

    @RequestMapping("/adduser")
    @ResponseBody
    public int addUtilisateur(Utilisateur utilisateur, String villeId, int cpVille, String rueLocalisation) {

        Localisation localisation = new Localisation();
        localisation.setCpLocalisation(cpVille);
        localisation.setVilleLocalisation(villeId);
        localisation.setRueLocalisation(rueLocalisation);

        return utilisateurService.addUtilisateur(utilisateur, localisation);
    }

    @RequestMapping("/login")
    @ResponseBody
    public Utilisateur logIn(String email, String pwd, HttpSession session){

        Utilisateur utilisateur = utilisateurService.logIn(email,pwd);
        if(utilisateur == null){

            utilisateur = new Utilisateur();
            utilisateur.setNomUtilisateur("empty");
        }
        return utilisateur;
    }

    @RequestMapping("/userdelete")
    @ResponseBody
    public int deleteUtilisateur(String email,String pwd){

        return utilisateurService.deleteUtilisateur(email,pwd);
    }

    @RequestMapping("/userupdate")
    @ResponseBody
    public int userUpdate(Utilisateur utilisateur, String villeId, int cpVille, String rueLocalisation){

        Localisation localisation = new Localisation(villeId,cpVille,rueLocalisation);
        return utilisateurService.updateUtilisateur(utilisateur,localisation);
    }

}
