package com.petfinder.controller;

import com.petfinder.pojo.Ville;
import com.petfinder.service.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class VilleController {

    @Autowired
    VilleService villeService;

    @RequestMapping("/villes")
    @ResponseBody
    public List<Ville> selectAllVille(){

        return villeService.selectAllVille();
    }


    @RequestMapping("/villes/getCp")
    @ResponseBody
    public Ville selectVilleByName(String nomVille){

        return villeService.selectVilleByName(nomVille);
    }
}
