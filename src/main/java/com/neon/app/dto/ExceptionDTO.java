package com.neon.app.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author invzbl3 on 7/11/2022
 * @project neonApp
 */
@Data
@NoArgsConstructor
public class ExceptionDTO {

    private String timestamp;

    private int status;

    private String error;

    private String message;

    private String path;
}