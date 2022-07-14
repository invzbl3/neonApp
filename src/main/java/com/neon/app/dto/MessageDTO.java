package com.neon.app.dto;

import com.neon.app.enumeration.MessageStatus;
import com.neon.app.enumeration.MessageType;
import com.neon.app.enumeration.StatusCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author invzbl3 on 7/8/2022
 * @project neonApp
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {

    private MessageType messageType;

    private LocalDateTime timestamp; // long // Timestamp // OffsetDateTime // Instant

    private long origin;

    private long destination;

    private int duration;

    private StatusCode statusCode;

    private String statusDescription;

    private String messageContent;

    private MessageStatus messageStatus;
}