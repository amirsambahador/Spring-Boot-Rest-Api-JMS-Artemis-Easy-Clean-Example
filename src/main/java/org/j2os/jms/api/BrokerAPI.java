package org.j2os.jms.api;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/*
    Bahador, Amirsam
 */
@RestController
public class BrokerAPI {
    private int j2osCounter = 0;
    private int riempCounter = 0;
    private JmsTemplate jmsTemplate;

    public BrokerAPI(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @GetMapping("/send")
    public String send() {
        jmsTemplate.convertAndSend("J2OS", ++j2osCounter);
        jmsTemplate.convertAndSend("RIEMP", ++riempCounter);
        return "sent.";
    }


}
