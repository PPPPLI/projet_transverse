package com.petfinder.service.impl;

import com.petfinder.mapper.FeedbackMapper;
import com.petfinder.pojo.Feedback;
import com.petfinder.pojo.Utilisateur;
import com.petfinder.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    FeedbackMapper feedbackMapper;

    @Override
    public int addFeedback(Feedback feedback) {

        int result = feedbackMapper.addFeedback(feedback);
        return result;
    }


}
