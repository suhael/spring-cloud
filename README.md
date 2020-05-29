# spring-cloud

based on https://github.com/nylund/spring-aws-localstack

Setup topics, queues and subscriptions:
```
awslocal sqs create-queue --queue-name test-queue
awslocal sqs create-queue --queue-name test-queue-sns
awslocal sns create-topic --name test-topic
awslocal sns subscribe --topic-arn arn:aws:sns:eu-central-1:000000000000:test-topic --protocol sqs --notification-endpoint arn:aws:sqs:eu-central-1:queue:test-queue-sns
```
