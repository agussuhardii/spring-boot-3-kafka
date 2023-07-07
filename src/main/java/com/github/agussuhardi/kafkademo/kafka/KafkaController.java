package com.github.agussuhardi.kafkademo.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/kafka")
@Validated
@Slf4j
public class KafkaController {

    @Value("${kafka.config.topic.id}")
    private String topicId;

    private final KafkaTemplate<String, Map<String, Object>> kafkaTemplate;


    @PostMapping("send")
    public void send(@RequestBody Map<String, Object> map) {
        kafkaTemplate.send(topicId, map);
    }
}

