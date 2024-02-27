package com.roberto.kafkaexamples.kafka;

import com.roberto.kafkaexamples.dto.MessageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, MessageDTO> kafkaTemplate;

    private static final String MESSAGE_TOPIC_NAME = "kafka-message-example-v1";

    public void sendMessage(MessageDTO message) {
        kafkaTemplate.send(MESSAGE_TOPIC_NAME, message);
    }

}
