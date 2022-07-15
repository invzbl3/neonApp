package com.neon.app.controller;

import com.neon.app.dto.MessageDTO;
import com.neon.app.dto.ReportDTO;
import com.neon.app.service.impl.MessageServiceImpl;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import java.time.LocalDate;

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
    @PostMapping("/messages")
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
    public ReportDTO getAllMetrics() {
        return messageService.getAllMetrics();
    }

    /**
     * The service will have an HTTP endpoint (/metrics/YYMMDD) that returns a set of counters
     * related counters to the timestamps, represented by date YYMMDD
     */
    @GetMapping("/metrics/{date}")
    @Operation(summary = "Get all metrics by date")
    public ReportDTO getAllMetricsByDate(@PathVariable @DateTimeFormat(pattern = "YYMMDD") LocalDate date) {
        return messageService.getAllMetrics(date);
    }
}