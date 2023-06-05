package com.petfinder.service.impl;

import com.petfinder.mapper.DemandeMapper;
import com.petfinder.pojo.Demande;
import com.petfinder.service.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemandeServiceImpl implements DemandeService {

    @Autowired
    DemandeMapper demandeMapper;


    @Override
    public int addDemande(Demande demande) {

        return demandeMapper.addDemande(demande);
    }
}
