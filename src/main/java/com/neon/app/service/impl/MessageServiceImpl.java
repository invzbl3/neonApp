package com.neon.app.service.impl;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoClients;
import com.neon.app.dto.MessageDTO;
import com.neon.app.dto.ReportDTO;
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

    //private final MongoCollection<JSONPObject> collection = database.getCollection("json", JSONPObject.class);
    private final MongoCollection<MessageDTO> collection = database.getCollection("collection", MessageDTO.class);

    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    /* The service will have an HTTP endpoint (/messages) which will process and save the JSON
    data to a database of your choice (mongo, postgre, mysql, (h2 with web console - bonus points
    for simplicity) */
    @Override
    public void saveAllMessages(MessageDTO messageDTO) {
        collection.insertOne(messageDTO);
    }

    // counters

    /* Total number of processed JSON files */

    /* Total number of rows */
    @Override
    public int totalNumberOfRows() {
        return messageRepository.totalNumberOfRows();
    }

    /* total number of calls */
    @Override
    public int totalNumberOfCalls() {
        return messageRepository.totalNumberOfCalls();
    }

    /* Total number of messages */
    @Override
    public int totalNumberOfMessages() {
        return messageRepository.totalNumberOfMessages();
    }

    /* Total number of different origin country codes (https://en.wikipedia.org/wiki/MSISDN) */
    @Override
    public int totalNumberOfDifferentOriginCountryCodes() {
        return messageRepository.totalNumberOfDifferentOriginCountryCodes();
    }

    /* Total number of different destination country codes */
    @Override
    public int totalNumberOfDifferentDestinationCountryCodes() {
        return messageRepository.totalNumberOfDifferentDestinationCountryCodes();
    }

    @Override
    public ReportDTO getMetricsByDate() {
        //...
    }
}