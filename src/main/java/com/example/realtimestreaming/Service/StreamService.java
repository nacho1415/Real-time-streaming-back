package com.example.realtimestreaming.Service;

import com.example.realtimestreaming.Repository.StreamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StreamService {

    @Autowired
    StreamRepository streamRepository;


}
