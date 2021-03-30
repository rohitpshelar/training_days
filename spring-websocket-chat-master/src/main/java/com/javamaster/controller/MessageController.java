package com.javamaster.controller;

import com.javamaster.model.MessageModel;
import com.javamaster.storage.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat/{to}")
    public void sendMessage(@DestinationVariable String to, MessageModel message) throws InterruptedException {
        System.out.println("handling send message: " + message + " to: " + to);
       String sender = message.getFromLogin();
        if(sender.contains("riomed")) {
        	message.setFromLogin("riomed");
        	System.out.println("Message send by " + sender);
        }
        
        boolean isExists = UserStorage.getInstance().getUsers().contains(to);
        if (isExists) {
            simpMessagingTemplate.convertAndSend("/topic/messages/" + to, message);
        }else {
        	MessageModel mm = new MessageModel();
        	mm.setFromLogin("riomed");
        	mm.setMessage("Support team is offline\n Please select :\n 1) to wait until we connect them\n 2)Drop your mobile or email so we can contact you");
        	simpMessagingTemplate.convertAndSend("/topic/messages/" + message.getFromLogin(), mm);
        	
        	Thread.sleep(4000);
        	MessageModel mmm = new MessageModel();
        	mmm.setFromLogin(message.getFromLogin());
        	mmm.setMessage("Ok");
        	simpMessagingTemplate.convertAndSend("/topic/messages/" + message.getFromLogin(), mmm);
        }
    }
}
