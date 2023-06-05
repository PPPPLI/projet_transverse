package com.petfinder.service.impl;

import com.petfinder.mapper.LocalisationMapper;
import com.petfinder.pojo.Localisation;
import com.petfinder.service.LocalisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalisationServiceImpl implements LocalisationService {

    @Autowired
    LocalisationMapper localisationMapper;

    @Override
    public int addLocalisation(Localisation localisation) {

        return localisationMapper.addLocalisation(localisation);
    }

    @Override
    public Localisation selectLocalisationById(int id) {

        return localisationMapper.selectLocalisationById(id);
    }
}
