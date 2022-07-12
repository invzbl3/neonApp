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

    @PutMapping("/messages")
    @Operation(summary = "Save all messages")
    public ResponseEntity<List<MessageDTO>> saveMessages(MessageDTO messageDTO) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @GetMapping("/metrics")
    @Operation(summary = "Get all metrics")
    public ResponseEntity<ReportDTO> getAllMetrics() {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(messageService.getAllMetrics());
    }

    @GetMapping("/metrics/YYMMDD")
    @Operation(summary = "Get all timestamps")
    public ResponseEntity<Integer> getAllTimestamps() {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(messageService.getAllTimestamps());
    }
}