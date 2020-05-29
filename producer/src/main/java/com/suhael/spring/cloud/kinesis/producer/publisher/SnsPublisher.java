package com.suhael.spring.cloud.kinesis.producer.publisher;

import com.suhael.spring.cloud.kinesis.producer.model.EventMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class SnsPublisher {

    @Autowired
    private NotificationMessagingTemplate notificationMessagingTemplate;

    private String snsTopic = "test-topic";

    public void send(EventMessage msg) {
        this.notificationMessagingTemplate.sendNotification(snsTopic, msg, "subject");
    }

}
