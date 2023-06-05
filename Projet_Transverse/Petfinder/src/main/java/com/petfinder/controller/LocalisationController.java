package com.petfinder.controller;

import com.petfinder.pojo.Localisation;
import com.petfinder.service.LocalisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LocalisationController {

    @Autowired
    LocalisationService localisationService;

    @RequestMapping("/getLocalisation")
    @ResponseBody
    public Localisation getLocalisationById(int idLocalisation){

        return localisationService.selectLocalisationById(idLocalisation);
    }
}
