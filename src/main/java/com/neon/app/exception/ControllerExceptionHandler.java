package com.neon.app.exception;

import com.neon.app.dto.ExceptionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerMapping;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import io.jsonwebtoken.JwtException;

/**
 * @author invzbl3 on 7/10/2022
 * @project neonApp
 */
@RestControllerAdvice
public class ControllerExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @Autowired
    private HttpServletRequest request;

    @ExceptionHandler(CustomAuthenticationException.class)
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public ExceptionDTO customExceptionHandler(CustomAuthenticationException customException) {
        ControllerExceptionHandler.LOG.error(customException.getMessage());
        return this.initExceptionDTO(customException, customException.getMessage(), 401,
                "Bad Request");
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public ExceptionDTO accessDeniedException(AccessDeniedException exception) {
        ControllerExceptionHandler.LOG.error("unexpected error has happend ", exception);
        return this.initExceptionDTO(exception, exception.getMessage(), 401, "Unauthorized");
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(code = HttpStatus.FORBIDDEN)
    public ExceptionDTO authenticationException(AuthenticationException exception) {
        ControllerExceptionHandler.LOG.error("unexpected error has happend ", exception);
        return this.initExceptionDTO(exception, exception.getMessage(), 403, "Forbidden");
    }

    @ExceptionHandler(JwtException.class)
    @ResponseStatus(code = HttpStatus.FORBIDDEN)
    public ExceptionDTO jwtException(JwtException exception) {
        ControllerExceptionHandler.LOG.error("unexpected error has happend ", exception);
        return this.initExceptionDTO(exception, exception.getMessage(), 403, "Forbidden");
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ExceptionDTO maxUploadSizeExceededExceptionHandler(MaxUploadSizeExceededException e) {
        ControllerExceptionHandler.LOG.error("unexpected error has happend ", e.getCause());
        return this.initExceptionDTO(e, "Max Upload Size Exceeded", 400, "Bad Request");
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionDTO exception(Exception exception) {
        ControllerExceptionHandler.LOG.error("unexpected error has happend ", exception);
        return this.initExceptionDTO(exception, "Internal Error", 500, "Internal Server error");
    }

    private ExceptionDTO initExceptionDTO(Exception e, String message, int status, String error) {
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setTimestamp(LocalDateTime.now().toString());
        exceptionDTO.setStatus(status);
        exceptionDTO.setError(error);
        String path = (String) this.request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
        exceptionDTO.setPath(path);
        exceptionDTO.setMessage(message);
        return exceptionDTO;
    }
}