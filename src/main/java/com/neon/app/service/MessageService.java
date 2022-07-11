package com.neon.app.service;

import com.neon.app.dto.MessageDTO;
import java.util.List;

/**
 * @author invzbl3 on 7/8/2022
 * @project neonApp
 */
public interface MessageService {

    List<MessageDTO> saveAllMessages(MessageDTO messageDTO);

    int getAllMetrics();

    int getAllTimestamps();
}