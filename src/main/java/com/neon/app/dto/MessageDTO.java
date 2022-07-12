package com.neon.app.dto;

import com.neon.app.enumeration.MessageStatus;
import com.neon.app.enumeration.MessageType;
import com.neon.app.enumeration.StatusCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.time.OffsetDateTime;

/**
 * @author invzbl3 on 7/8/2022
 * @project neonApp
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO implements Serializable {

    private MessageType messageType;

    private OffsetDateTime timestamp; // LocalDateTime // Timestamp

    private long origin;

    private long destination;

    private int duration;

    private StatusCode statusCode;

    private String statusDescription;

    private String messageContent;

    private MessageStatus messageStatus;
}