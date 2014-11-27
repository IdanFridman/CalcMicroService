package com.idan.calcservice.facebook;

import org.apache.log4j.Logger;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by idan on 11/27/14.
 */

@Named
public class NotificationService {

    private Logger logger = Logger.getLogger(this.getClass().getName());


    @Inject
    Facebook facebook;

    @Inject
    private ConnectController connectController;


    FacebookTemplate facebookTemplate = new FacebookTemplate();

    String fbAppId = "984990358183439";
    String fbAppSecret = "b4d172681dd4a18019c91fad8ec08647";
    String userId = "100008487426259";

    FacebookConnectionFactory connectionFactory =
            new FacebookConnectionFactory("fbAppId", "fbAppSecret");


    public void sendNotification(String message) {


        String accessToken = fbAppId + '|' + fbAppSecret;
        String url = "https://graph.facebook.com/" + userId + "/notifications?access_token="+accessToken+"&template=blablabla";
        // String accessToken = connectionFactory.getOAuthOperations().authenticateClient().getAccessToken();


        logger.info("accessToken=" + accessToken);
              facebook.restOperations().postForLocation(url,null);



        String uri;
        RestTemplate restTemplate = new RestTemplate();

    }
}
