package com.petfinder.service;

import com.petfinder.pojo.Localisation;

public interface LocalisationService {

    int addLocalisation(Localisation localisation);

    Localisation selectLocalisationById(int id);
}
