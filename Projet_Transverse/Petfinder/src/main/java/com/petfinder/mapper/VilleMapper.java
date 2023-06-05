package com.petfinder.mapper;


import com.petfinder.pojo.Ville;

import java.util.List;

public interface VilleMapper {

    List<Ville> selectAllVille();

    Ville selectVilleByName(String nomVille);
}
