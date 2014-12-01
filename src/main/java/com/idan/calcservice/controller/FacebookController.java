package com.idan.calcservice.controller;

import com.idan.calcservice.facebook.NotificationService;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.inject.Inject;

/**
 * Created by idan on 11/27/14.
 */

@Controller
public class FacebookController {

    private Logger logger = Logger.getLogger(this.getClass().getName());


    @Inject
    private Facebook facebook;



    @Inject
    private NotificationService notificationService;


    @RequestMapping(value="/fbconnect" ,method= RequestMethod.GET)
    public String helloFacebook(Model model) {
        logger.info("fbconnect trigger");
        if (!facebook.isAuthorized()) {
            return "redirect:/connect/facebook";
        }

        model.addAttribute(facebook.userOperations().getUserProfile());
        PagedList<Post> homeFeed = facebook.feedOperations().getHomeFeed();
        model.addAttribute("feed", homeFeed);

        return "hello";
    }

    @RequestMapping(value="/fbnotification" ,method= RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void sendNotification(Model model) {
        logger.info("fbnotification trigger");
      //  if (!facebook.isAuthorized()) {
       //     return "redirect:/connect/facebook";
       // }
        notificationService.sendNotification("testing notification");
    }



}

