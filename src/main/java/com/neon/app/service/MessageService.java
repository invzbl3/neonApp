package com.neon.app.service;

import com.neon.app.dto.MessageDTO;
import com.neon.app.dto.ReportDTO;

/**
 * @author invzbl3 on 7/8/2022
 * @project neonApp
 */
public interface MessageService {

    void saveAllMessages(MessageDTO messageDTO);

    ReportDTO getAllMetrics();

    ReportDTO getMetricsByDate();

    int totalNumberOfRows();

    int totalNumberOfCalls();

    int totalNumberOfMessages();

    int totalNumberOfDifferentOriginCountryCodes();

    int totalNumberOfDifferentDestinationCountryCodes();
}