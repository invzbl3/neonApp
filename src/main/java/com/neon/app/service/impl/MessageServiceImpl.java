package com.neon.app.service.impl;

import com.neon.app.dto.MessageDTO;
import com.neon.app.service.MessageService;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author invzbl3 on 7/8/2022
 * @project neonApp
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Override
    public List<MessageDTO> saveAllMessages() {
    }

    @Override
    public List<MessageDTO> getAllMetrics() {
    }

    @Override
    public List<MessageDTO> getAllTimestamps() {
    }
}