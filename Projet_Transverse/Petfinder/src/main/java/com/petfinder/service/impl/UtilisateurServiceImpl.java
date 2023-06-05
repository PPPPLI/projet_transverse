package com.petfinder.service.impl;

import com.petfinder.mapper.LocalisationMapper;
import com.petfinder.mapper.UtilisateurMapper;
import com.petfinder.pojo.Localisation;
import com.petfinder.pojo.Utilisateur;
import com.petfinder.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired
    UtilisateurMapper utilisateurMapper;
    @Autowired
    LocalisationMapper localisationMapper;

    @Override
    public int addUtilisateur(Utilisateur utilisateur, Localisation localisation) {

        Utilisateur utilisateur1 = selectUtilisateurById(utilisateur);

        if( utilisateur1 == null){

            localisationMapper.addLocalisation(localisation);
            utilisateur.setIdLocalisation(localisation);
            return utilisateurMapper.addUtilisateur(utilisateur);
        }

        return 0;
    }

    @Override
    public Utilisateur selectUtilisateurById(Utilisateur utilisateur) {

        return utilisateurMapper.selectUtilisateurById(utilisateur.getEmailUtilisateur());
    }

    @Override
    public Utilisateur logIn(String email, String pwd) {


        return utilisateurMapper.selectUtilisateurByEmailAndPwd(email,pwd);
    }

    @Override
    public int deleteUtilisateur(String email, String pwd) {

        return utilisateurMapper.deleteUtilisateur(email,pwd);
    }

    @Override
    public int updateUtilisateur(Utilisateur utilisateur, Localisation localisation) {

        Utilisateur utilisateur1 = utilisateurMapper.selectUtilisateurByEmail(utilisateur.getEmailUtilisateur());
        localisation.setIdLocalisation(utilisateur1.getLocalisation().getIdLocalisation());
        localisationMapper.updateLocalisationById(localisation);
        int result = utilisateurMapper.updateUtilisateur(utilisateur);
        if(result > 0){
            return localisation.getIdLocalisation();
        }
        return 0;
    }
}
