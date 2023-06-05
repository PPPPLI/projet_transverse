package com.petfinder.mapper;

import com.petfinder.pojo.Feedback;
import com.petfinder.pojo.Utilisateur;

import java.util.List;

public interface FeedbackMapper {

    int addFeedback(Feedback feedback);

    List<Utilisateur> selectUtilisateurById(Utilisateur utilisateur);
}
