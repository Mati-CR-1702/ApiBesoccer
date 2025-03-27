package com.app.exception;

import com.app.configs.LoggerConfig;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GlobalExceptionHandler implements ExceptionMapper<Exception> {

    private static final Logger LOGGER = Logger.getLogger(GlobalExceptionHandler.class);

    @Inject
    LoggerConfig loggerConfig;

    @Override
    public Response toResponse(Exception exception) {
        if (exception.getMessage() != null && exception.getMessage().contains("q/dev-ui")) {
            LOGGER.warn(loggerConfig.getDevUiExceptionMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        LOGGER.error(loggerConfig.getErrorMessage() + " " + loggerConfig.getUnhandledExceptionMessage(), exception);

        ErrorResponse errorResponse = new ErrorResponse(
                Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),
                loggerConfig.getUnhandledExceptionMessage()
        );

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(errorResponse)
                .build();
    }

    public static class ErrorResponse {
        private int statusCode;
        private String message;

        public ErrorResponse(int statusCode, String message) {
            this.statusCode = statusCode;
            this.message = message;
        }

        public int getStatusCode() {
            return statusCode;
        }

        public String getMessage() {
            return message;
        }
    }
}
