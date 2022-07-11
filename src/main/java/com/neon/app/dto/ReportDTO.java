package com.neon.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author invzbl3 on 7/10/2022
 * @project neonApp
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class ReportDTO implements Serializable {

    int totalNumberOfProcessedJSONFiles;

    int totalNumberOfRaws;

    int totalNumberOfCalls;

    int totalNumberOfMessages;

    int totalNumberOfDifferentOriginCountryCodes;

    int totalNumberOfDifferentDestinationCountryCodes;
}