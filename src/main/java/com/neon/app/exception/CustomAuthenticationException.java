package com.neon.app.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author invzbl3 on 7/11/2022
 * @project neonApp
 */
public class CustomAuthenticationException extends AuthenticationException {

    private final String msg;

    public CustomAuthenticationException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }
}