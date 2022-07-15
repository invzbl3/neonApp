package com.neon.app.service.impl;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoClients;
import com.neon.app.dto.MessageDTO;
import com.neon.app.dto.ReportDTO;
import com.neon.app.repository.MessageRepository;
import com.neon.app.service.MessageService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

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

    /* Get metrics by date */
    @Override
    public ReportDTO getAllMetrics(LocalDate date) {
        ReportDTO reportDTO = new ReportDTO();
        reportDTO.setTotalNumberOfRaws(totalNumberOfRows(date));
        reportDTO.setTotalNumberOfCalls(totalNumberOfCalls(date));
        reportDTO.setTotalNumberOfMessages(totalNumberOfMessages(date));
        reportDTO.setTotalNumberOfDifferentOriginCountryCodes(totalNumberOfDifferentOriginCountryCodes(date));
        reportDTO.setTotalNumberOfDifferentDestinationCountryCodes(totalNumberOfDifferentDestinationCountryCodes(date));
        return reportDTO;
    }

    /* Get all metrics */
    @Override
    public ReportDTO getAllMetrics() {
        ReportDTO reportDTO = new ReportDTO();
        reportDTO.setTotalNumberOfRaws(totalNumberOfRows());
        reportDTO.setTotalNumberOfCalls(totalNumberOfCalls());
        reportDTO.setTotalNumberOfMessages(totalNumberOfMessages());
        reportDTO.setTotalNumberOfDifferentOriginCountryCodes(totalNumberOfDifferentOriginCountryCodes());
        reportDTO.setTotalNumberOfDifferentDestinationCountryCodes(totalNumberOfDifferentDestinationCountryCodes());
        return reportDTO;
    }

    // ------------------------------------------------------------------------------------------------------------

    /* Total number of rows */
    @Override
    public int totalNumberOfRows(LocalDate date) {
        return messageRepository.totalNumberOfRows(date);
    }

    /* total number of calls */
    @Override
    public int totalNumberOfCalls(LocalDate date) {
        return messageRepository.totalNumberOfCalls(date);
    }

    /* Total number of messages */
    @Override
    public int totalNumberOfMessages(LocalDate date) {
        return messageRepository.totalNumberOfMessages(date);
    }

    /* Total number of different origin country codes (https://en.wikipedia.org/wiki/MSISDN) */
    @Override
    public int totalNumberOfDifferentOriginCountryCodes(LocalDate date) {
        return messageRepository.totalNumberOfDifferentOriginCountryCodes(date);
    }

    /* Total number of different destination country codes */
    @Override
    public int totalNumberOfDifferentDestinationCountryCodes(LocalDate date) {
        return messageRepository.totalNumberOfDifferentDestinationCountryCodes(date);
    }

    // ------------------------------------------------------------------------------------------------------------

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
}