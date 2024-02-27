package com.roberto.kafkaexamples.controller;

import com.roberto.kafkaexamples.dto.MessageDTO;
import com.roberto.kafkaexamples.kafka.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaProducer kafkaProducer;

    @PostMapping("/send-message")
    public ResponseEntity<MessageDTO> sendMessage(@RequestBody MessageDTO messageDTO) {

        messageDTO.setKey(UUID.randomUUID().toString());
        messageDTO.setTimestamp(LocalDateTime.now());

        kafkaProducer.sendMessage(messageDTO);

        return new ResponseEntity<>(messageDTO, HttpStatus.OK);
    }

}
