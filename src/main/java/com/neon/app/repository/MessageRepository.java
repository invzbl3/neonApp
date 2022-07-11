package com.neon.app.repository;

import com.neon.app.dto.ReportDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author invzbl3 on 7/9/2022
 * @project neonApp
 */
@Repository
public interface MessageRepository extends JdbcTemplate<ReportDTO, ...> {

/*    // total number of calls
    @Query(value = "SELECT COUNT(message_type) FROM messages WHERE message_type = 'CALL'")
    int totalNumberOfCalls();

    // total number of messages
    //@Query(value = "SELECT COUNT(message_type) FROM messages WHERE message_type = 'MSG'")
    @Query(value = "SELECT COUNT(ALL message_type) FROM messages WHERE message_type = 'MSG'")
    int totalNumberOfMessages();

    // total number of different origin country codes (https://en.wikipedia.org/wiki/MSISDN)
    @Query(value = "SELECT COUNT(DISTINCT SUBSTRING(origin, 1, 2)) FROM messages")
    int totalNumberOfDifferentOriginCountryCodes();

    // Total number of different destination country codes
    @Query(countQuery = "SELECT COUNT(DISTINCT SUBSTRING(destination, 1, 2)) FROM messages")
    int totalNumberOfDifferentDestinationCountryCodes();*/
}