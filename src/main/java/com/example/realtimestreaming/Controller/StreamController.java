package com.example.realtimestreaming.Controller;

import com.example.realtimestreaming.Dto.Request.Stream.SendChatReq;
import com.example.realtimestreaming.Service.StreamService;
import lombok.Data;
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

    @Autowired
    private StreamService streamService;

    @GetMapping("/{streamId}")
    public String getStreamDetail() {
        return "streamDetail.html";
    }

    @MessageMapping("/sendChat/{streamId}")
    public void sendChat(SendChatReq sendChatReq, @DestinationVariable("streamId") Long streamId) {
//        Long parsedStreamId = Long.parseLong(streamId);
        streamService.sendMessage(sendChatReq, streamId);
        String destination = "/stream/" + streamId;
        this.messagingTemplate.convertAndSend(destination, sendChatReq);
    }
}