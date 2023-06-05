package com.petfinder.service;

import com.petfinder.pojo.Ville;

import java.util.List;


public interface VilleService {

    List<Ville> selectAllVille();

    Ville selectVilleByName(String nomVille);
}
