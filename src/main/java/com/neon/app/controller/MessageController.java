package com.neon.app.controller;

import com.neon.app.dto.MessageDTO;
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

        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(messageService.saveAllMessages(messageDTO));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(GET_ALL_METRICS)
    @Operation(summary = "Get all metrics")
    public ResponseEntity<Integer> getAllMetrics() {

        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(messageService.getAllMetrics());
        } catch (Exception e) {
            return new ResponseEntity<>(0, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(GET_ALL_TIMESTAMPS)
    @Operation(summary = "Get all timestamps")
    public ResponseEntity<Integer> getAllTimestamps() {

        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(messageService.getAllTimestamps());
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}