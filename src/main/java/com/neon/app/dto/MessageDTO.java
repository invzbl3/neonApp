package com.neon.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.neon.app.enumeration.MessageStatus;
import com.neon.app.enumeration.MessageType;
import com.neon.app.enumeration.StatusCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.time.OffsetDateTime;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author invzbl3 on 7/8/2022
 * @project neonApp
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class MessageDTO implements Serializable {

    public MessageDTO(MessageDTO messageDTO) {
        this.messageType = messageDTO.getMessageType();
        this.timestamp = messageDTO.getTimestamp();
        this.origin = messageDTO.getOrigin();
        this.destination = messageDTO.getDestination();
        this.duration = messageDTO.getDuration();
        this.statusCode = messageDTO.getStatusCode();
        this.statusDescription = messageDTO.getStatusDescription();
        this.messageContent = messageDTO.getMessageContent();
        this.messageStatus = messageDTO.getMessageStatus();
    }

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