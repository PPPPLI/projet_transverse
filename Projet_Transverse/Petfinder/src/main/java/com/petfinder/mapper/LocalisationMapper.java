package com.petfinder.mapper;

import com.petfinder.pojo.Localisation;

public interface LocalisationMapper {

    int addLocalisation(Localisation localisation);

    Localisation selectLocalisationById(int id);

    int deleteLocalisationById(int id);

    int updateLocalisationById(Localisation localisation);
}
