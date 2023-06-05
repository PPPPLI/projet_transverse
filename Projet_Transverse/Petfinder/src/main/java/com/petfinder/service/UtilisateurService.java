package com.petfinder.service;

import com.petfinder.pojo.Localisation;
import com.petfinder.pojo.Utilisateur;
import org.apache.ibatis.annotations.Param;

public interface UtilisateurService {

    Utilisateur selectUtilisateurById(Utilisateur utilisateur);

    int addUtilisateur(Utilisateur utilisateur, Localisation localisation);

    Utilisateur logIn(String email,String pwd);

    int deleteUtilisateur(String email, String pwd);

    int updateUtilisateur(Utilisateur utilisateur, Localisation localisation);
}
