package com.suhael.spring.cloud.kinesis.producer.api;

import com.suhael.spring.cloud.kinesis.producer.model.EventMessage;
import com.suhael.spring.cloud.kinesis.producer.publisher.SnsPublisher;
import com.suhael.spring.cloud.kinesis.producer.publisher.SqsPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    SqsPublisher sqsPublisher;

    @Autowired
    SnsPublisher snsPublisher;

    @RequestMapping(
            path = "/sqs/publish",
            method = RequestMethod.GET)
    public void triggerSqsPublish(@RequestParam String foo) {

        sqsPublisher.send(new EventMessage(foo));

    }

    @RequestMapping(
            path = "/sns/publish",
            method = RequestMethod.GET)
    public void triggerSnsPublish(@RequestParam String foo) {

        snsPublisher.send(new EventMessage(foo));

    }
}
