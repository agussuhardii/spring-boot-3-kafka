package com.github.agussuhardi.kafkademo.kafka.listeners;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductListener {

    @KafkaListener(groupId = "${kafka.config.group.id}", topics = "${kafka.config.topic.id}")
    public void newProductListener(Map<String, Object> map) {
        log.info("Get request from Front " + map.toString());

    }
}