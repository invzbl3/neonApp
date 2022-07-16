package com.neon.app.repository;

import com.neon.app.dto.ReportDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

/**
 * @author invzbl3 on 7/9/2022
 * @project neonApp
 */
@Repository
public interface MessageRepository extends JpaRepository<ReportDTO, Integer> {

    // total number of rows
    //@Query(value = "SELECT COUNT(message_type) FROM messages WHERE message_type = 'CALL' or 'MSG'", nativeQuery = true)
    @Query(value = "SELECT COUNT(*) FROM messages", nativeQuery = true)
    int totalNumberOfRows();

    // total number of calls
    @Query(value = "SELECT COUNT(message_type) FROM messages WHERE message_type = 'CALL'", nativeQuery = true)
    int totalNumberOfCalls();

    // total number of messages
    //@Query(value = "SELECT COUNT(message_type) FROM messages WHERE message_type = 'MSG'")
    @Query(value = "SELECT COUNT(ALL message_type) FROM messages WHERE message_type = 'MSG'", nativeQuery = true)
    int totalNumberOfMessages();

    // total number of different origin country codes (https://en.wikipedia.org/wiki/MSISDN)
    @Query(value = "SELECT COUNT(DISTINCT SUBSTRING(origin, 1, 2, 3)) FROM messages", nativeQuery = true)
    int totalNumberOfDifferentOriginCountryCodes();

    // Total number of different destination country codes
    @Query(countQuery = "SELECT COUNT(DISTINCT SUBSTRING(destination, 1, 2, 3)) FROM messages", nativeQuery = true)
    int totalNumberOfDifferentDestinationCountryCodes();

    // ------------------------------------------------------------------------------------------------------------

    // total number of rows
    //@Query(value = "SELECT COUNT(message_type) FROM messages WHERE message_type = 'CALL' or 'MSG'", nativeQuery = true)
    @Query(value = "SELECT COUNT(*) FROM messages", nativeQuery = true)
    int totalNumberOfRows(LocalDate date);

    // total number of calls
    @Query(value = "SELECT COUNT(message_type) FROM messages WHERE message_type = 'CALL'", nativeQuery = true)
    int totalNumberOfCalls(LocalDate date);

    // total number of messages
    //@Query(value = "SELECT COUNT(message_type) FROM messages WHERE message_type = 'MSG'")
    @Query(value = "SELECT COUNT(ALL message_type) FROM messages WHERE message_type = 'MSG'", nativeQuery = true)
    int totalNumberOfMessages(LocalDate date);

    // total number of different origin country codes (https://en.wikipedia.org/wiki/MSISDN)
    @Query(value = "SELECT COUNT(DISTINCT SUBSTRING(origin, 1, 2, 3)) FROM messages", nativeQuery = true)
    int totalNumberOfDifferentOriginCountryCodes(LocalDate date);

    // Total number of different destination country codes
    @Query(countQuery = "SELECT COUNT(DISTINCT SUBSTRING(destination, 1, 2, 3)) FROM messages", nativeQuery = true)
    int totalNumberOfDifferentDestinationCountryCodes(LocalDate date);
}