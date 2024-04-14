package com.example.realtimestreaming.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stream")
public class StreamController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @GetMapping("/{streamId}")
    public String getStreamDetail() {
        return "streamDetail.html";
    }

    @MessageMapping("/sendMessage/{projectId}")
    public void sendMessage(String message, @DestinationVariable String projectId) {
        System.out.println("받았는지 확인");
        String destination = "/stream/" + projectId;
        this.messagingTemplate.convertAndSend(destination, message);
    }

}