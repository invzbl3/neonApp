package com.neon.app.controller;

import com.neon.app.dto.MessageDTO;
import com.neon.app.service.impl.MessageServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PutMapping;
import java.net.URISyntaxException;
import java.util.List;
import static com.neon.app.controller.Endpoints.*;

/**
 * @author invzbl3 on 7/8/2022
 * @project neonApp
 */
public class MessageController {

    private final MessageServiceImpl messageService;

    public MessageController(MessageServiceImpl messageService) {
        this.messageService = messageService;
    }

    @PutMapping(PUT_ALL_MESSAGES)
    @Operation(summary = "Put all messages")
    public ResponseEntity<List<MessageDTO>> saveMessages() throws URISyntaxException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(messageService.saveAllMessages());
    }

    @GetMapping(GET_ALL_METRICS)
    @Operation(summary = "Get all metrics")
    public ResponseEntity<List<MessageDTO>> getAllMetrics() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(messageService.getAllMetrics());
    }

    @GetMapping(GET_ALL_TIMESTAMPS)
    @Operation(summary = "Get all timestamps")
    public ResponseEntity<List<MessageDTO>> getAllTimestamps() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(messageService.getAllTimestamps());
    }
}