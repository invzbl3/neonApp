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

    ReportDTO getAllMetrics(LocalDate date);

    void saveAllMessages(MessageDTO messageDTO);

    int totalNumberOfRows();

    int totalNumberOfCalls();

    int totalNumberOfMessages();

    int totalNumberOfDifferentOriginCountryCodes();

    int totalNumberOfDifferentDestinationCountryCodes();

    int totalNumberOfRows(LocalDate date);

    int totalNumberOfCalls(LocalDate date);

    int totalNumberOfMessages(LocalDate date);

    int totalNumberOfDifferentOriginCountryCodes(LocalDate date);

    int totalNumberOfDifferentDestinationCountryCodes(LocalDate date);
}