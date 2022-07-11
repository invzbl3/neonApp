package com.neon.app.service.impl;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoClients;
import com.neon.app.dto.MessageDTO;
import com.neon.app.repository.MessageRepository;
import com.neon.app.service.MessageService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

/**
 * @author invzbl3 on 7/8/2022
 * @project neonApp
 */
@Service
public class MessageServiceImpl implements MessageService {

    private final MongoClient mongoClient = MongoClients.create("...");

    private final MongoDatabase database = mongoClient.getDatabase("mydb");

    private final MongoCollection<JSONPObject> collection = database.getCollection("json", JSONPObject.class);

    private final MessageRepository messageRepository;

    private final RestTemplate restTemplate;

    public MessageServiceImpl(MessageRepository messageRepository, RestTemplate restTemplate) {
        this.messageRepository = messageRepository;
        this.restTemplate = restTemplate;
    }

    /* The service will have an HTTP endpoint (/messages) which will process and save the JSON
    data to a database of your choice (mongo, postgre, mysql, (h2 with web console - bonus points
    for simplicity) */
    @Override
    public List<MessageDTO> saveAllMessages(MessageDTO messageDTO) {
        collection.save(messageDTO);
        JSONPObject jsonObject = collection.find().first();
    }

    /* The service will have an HTTP endpoint (/metrics) that returns a set of counters related
    counters for all messages ever processed */
    @Override
    public int getAllMetrics() {
        return messageRepository.setOfAllMessagesCounters();
    }

    /* The service will have an HTTP endpoint (/metrics/YYMMDD) that returns a set of counters
    related counters to the timestamps, represented by date YYMMDD */
    @Override
    public int getAllTimestamps() {
        return messageRepository.setOfTimestampsCounters();
    }
}