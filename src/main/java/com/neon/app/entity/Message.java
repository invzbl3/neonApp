package com.neon.app.entity;

import com.neon.app.enumeration.MessageStatus;
import com.neon.app.enumeration.MessageType;
import com.neon.app.enumeration.StatusCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

/**
 * @author invzbl3 on 7/8/2022
 * @project neonApp
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "message_entity")
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Integer id;

    private MessageType messageType;

    private long timestamp; // LocalDateTime // Timestamp // OffsetDateTime

    private long origin;

    private long destination;

    private int duration;

    private StatusCode statusCode;

    private String statusDescription;

    private String messageContent;

    private MessageStatus messageStatus;
}