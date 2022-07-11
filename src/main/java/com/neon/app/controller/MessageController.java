package com.neon.app.controller;

import com.neon.app.dto.MessageDTO;
import com.neon.app.dto.ReportDTO;
import com.neon.app.service.impl.MessageServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.neon.app.controller.Endpoints.*;

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

    @PutMapping(PUT_ALL_MESSAGES)
    @Operation(summary = "Save all messages")
    public ResponseEntity<List<MessageDTO>> saveMessages(MessageDTO messageDTO) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(messageService.saveAllMessages(messageDTO));
    }

    @GetMapping(GET_ALL_METRICS)
    @Operation(summary = "Get all metrics")
    public ResponseEntity<ReportDTO> getAllMetrics() {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(messageService.getAllMetrics());
    }

    @GetMapping(GET_ALL_TIMESTAMPS)
    @Operation(summary = "Get all timestamps")
    public ResponseEntity<Integer> getAllTimestamps() {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(messageService.getAllTimestamps());
    }
}