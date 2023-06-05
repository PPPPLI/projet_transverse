package com.petfinder.mapper;

import com.petfinder.pojo.Utilisateur;
import org.apache.ibatis.annotations.Param;

public interface UtilisateurMapper {

    int addUtilisateur(Utilisateur utilisateur);

    Utilisateur selectUtilisateurById(@Param("emailUtilisateur") String emailUtilisateur);

    Utilisateur selectUtilisateurByEmailAndPwd(@Param("email") String email,  @Param("pwd") String pwd);

    Utilisateur selectUtilisateurByEmail(String email);

    int deleteUtilisateur(@Param("email")String email, @Param("pwd") String pwd);

    int updateUtilisateur(Utilisateur utilisateur);
}
