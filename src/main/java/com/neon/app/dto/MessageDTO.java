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
        this.message_type = messageDTO.getMessage_type();
        this.timestamp = messageDTO.getTimestamp();
        this.origin = messageDTO.getOrigin();
        this.destination = messageDTO.getDestination();
        this.duration = messageDTO.getDuration();
        this.status_code = messageDTO.getStatus_code();
        this.status_description = messageDTO.getStatus_description();
        this.message_content = messageDTO.getMessage_content();
        this.message_status = messageDTO.getMessage_status();
    }

    private MessageType message_type;

    private OffsetDateTime timestamp; // LocalDateTime // Timestamp

    private long origin;

    private long destination;

    private int duration;

    private StatusCode status_code;

    private String status_description;

    private String message_content;

    private MessageStatus message_status;
}