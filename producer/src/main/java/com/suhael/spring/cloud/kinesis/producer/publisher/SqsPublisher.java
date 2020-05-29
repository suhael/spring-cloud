package com.suhael.spring.cloud.kinesis.producer.publisher;

import com.suhael.spring.cloud.kinesis.producer.model.EventMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class SqsPublisher {

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    @Value("${sqs.queue}")
    private String queue;

    public void send(EventMessage msg) {
        queueMessagingTemplate.convertAndSend(queue, msg);
    }

}
