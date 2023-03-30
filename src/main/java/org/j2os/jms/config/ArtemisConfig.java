package org.j2os.jms.config;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.JMSException;
/*
    Bahador, Amirsam
 */
@Configuration
public class ArtemisConfig {
    @Value("${org.j2os.jms.artemis.username}")
    private String username;
    @Value("${org.j2os.jms.artemis.password}")
    private String password;
    @Value("${org.j2os.jms.artemis.broker}")
    private String broker;

    @Bean
    ActiveMQConnectionFactory getConnectionFactory() throws JMSException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(broker);
        connectionFactory.setUser(username);
        connectionFactory.setPassword(password);
        return connectionFactory;
    }

    @Bean
    JmsTemplate getJMSTemplate() throws JMSException {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(getConnectionFactory());
        return jmsTemplate;
    }

    @Bean
    DefaultJmsListenerContainerFactory JMS_Container() throws JMSException {
        DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
        defaultJmsListenerContainerFactory.setConnectionFactory(getConnectionFactory());
        return defaultJmsListenerContainerFactory;
    }
}