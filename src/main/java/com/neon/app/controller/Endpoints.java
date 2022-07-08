package com.neon.app.controller;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author invzbl3 on 7/8/2022
 * @project neonApp
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Endpoints {
    public static final String PUT_ALL_MESSAGES = "/messages";
    public static final String GET_ALL_METRICS = "/metrics";
    public static final String GET_ALL_TIMESTAMPS = "/metrics/YYMMDD";
}