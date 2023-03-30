package org.example.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class BrokerService {
    @JmsListener(destination = "J2OS", containerFactory = "JMS_Container")
    public void j2osListener(String message) {
        System.out.println("J2OS: " + message);
    }

    @JmsListener(destination = "RIEMP", containerFactory = "JMS_Container")
    public void riempListener(String message) {
        System.out.println("RIEMP: " + message);
    }
}
