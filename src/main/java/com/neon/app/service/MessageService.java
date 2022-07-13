package com.neon.app.service;

import com.neon.app.dto.MessageDTO;
import com.neon.app.dto.ReportDTO;
import java.time.LocalDate;

/**
 * @author invzbl3 on 7/8/2022
 * @project neonApp
 */
public interface MessageService {

    ReportDTO getAllMetrics();

    ReportDTO getMetricsByDate(LocalDate date);

    void saveAllMessages(MessageDTO messageDTO);

    int totalNumberOfProcessedJSONFiles();

    int totalNumberOfRows();

    int totalNumberOfCalls();

    int totalNumberOfMessages();

    int totalNumberOfDifferentOriginCountryCodes();

    int totalNumberOfDifferentDestinationCountryCodes();
}