package com.roberto.kafkaexamples.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MessageDTO {

    private String key;
    private LocalDateTime timestamp;
    private String message;

}
