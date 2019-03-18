package com.pp.server.controller;

import com.pp.server.service.impl.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/msg")
public class MessageController {

    @Autowired
    private KafkaSender sender;

    @GetMapping("/send")
    public void sndMssage()
    {
        sender.send(1L);
    }
}
