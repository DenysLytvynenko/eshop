package com.eshop.store.controller.testgui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import java.util.Timer;
import java.util.TimerTask;

@Controller
public class WebSocketController {

    private Logger log = LoggerFactory.getLogger(WebSocketController.class);

    private final SimpMessageSendingOperations messagingTemplate;
    private Timer timer = new Timer();

    @Autowired
    public WebSocketController(SimpMessageSendingOperations messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/message")
    @SendTo("/server/message")
    public void getAndSendMessage(String message) {
        try {
            log.info("got message:{}", message);
            if(message.contains("timeout:")) {
                Long timeout = Long.valueOf(message.substring(message.indexOf("timeout:") + 8));
                log.info("scheduling timer task for timeout:{}", timeout);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        String answer = message + "::" + System.currentTimeMillis();
                        log.info("formed answer:{}", answer);
                        messagingTemplate.convertAndSend("/server/message", new Message(answer));
                    }
                }, timeout);
            } else {
                messagingTemplate.convertAndSend("/server/message", new Message("sync response:" + System.currentTimeMillis()));
            }
        } catch (Exception e) {
            log.error(String.valueOf(e));
        }
    }

}
