package com.petfinder.controller;

import com.petfinder.pojo.Feedback;
import com.petfinder.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    @RequestMapping("/feedback")
    @ResponseBody
    public int addFeedback(String nomUtilisateur,String mailUtilisateur,int telUtilisateur,String desciptionFeedback){


        Feedback feedback = new Feedback(nomUtilisateur,mailUtilisateur,telUtilisateur,desciptionFeedback);
        System.out.println(feedback);
        int result = feedbackService.addFeedback(feedback);

        return result;
    }
}
