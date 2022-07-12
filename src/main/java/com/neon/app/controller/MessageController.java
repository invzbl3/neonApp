package com.neon.app.controller;

import com.neon.app.dto.MessageDTO;
import com.neon.app.dto.ReportDTO;
import com.neon.app.service.impl.MessageServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author invzbl3 on 7/8/2022
 * @project neonApp
 */
@RestController
public class MessageController {

    private final MessageServiceImpl messageService;

    public MessageController(MessageServiceImpl messageService) {
        this.messageService = messageService;
    }

    /**
     * The service will have an HTTP endpoint (/messages) which will process and save the JSON
     * data to a database of your choice (mongo, postgre, mysql, (h2 with web console - bonus points
     * for simplicity))
     */
    @PutMapping("/messages")
    @Operation(summary = "Save all messages")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveMessages(MessageDTO messageDTO) {
        messageService.saveAllMessages(messageDTO);
    }

    /**
     * The service will have an HTTP endpoint (/metrics) that returns a set of counters related
     * counters for all messages ever processed
     */
    @GetMapping("/metrics")
    @Operation(summary = "Get all metrics")
    @ResponseStatus(HttpStatus.OK)
    public ReportDTO getAllMetrics() {
        return messageService.getAllMetrics();
    }

    /**
     * The service will have an HTTP endpoint (/metrics/YYMMDD) that returns a set of counters
     * related counters to the timestamps, represented by date YYMMDD
     */
    @GetMapping("/metrics/YYMMDD")
    @Operation(summary = "Get all timestamps")
    @ResponseStatus(HttpStatus.OK)
    public Integer getAllTimestamps() {
        return messageService.getAllTimestamps();
    }
}