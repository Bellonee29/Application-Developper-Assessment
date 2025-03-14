package org.waysTech.KafkaImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    @KafkaListener(topics = "iot-data", groupId = "group_id")
    public void consume(String message) {
        logger.info("Consuming message: {}", message);
    }
}