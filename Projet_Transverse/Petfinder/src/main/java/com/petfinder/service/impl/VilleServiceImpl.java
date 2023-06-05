package com.petfinder.service.impl;

import com.petfinder.mapper.VilleMapper;
import com.petfinder.pojo.Ville;
import com.petfinder.service.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VilleServiceImpl implements VilleService {

    @Autowired
    VilleMapper villeMapper;

    @Override
    public List<Ville> selectAllVille() {

        return villeMapper.selectAllVille();
    }

    @Override
    public Ville selectVilleByName(String nomVille) {

        return villeMapper.selectVilleByName(nomVille);
    }
}
