package com.app.exception;

import com.app.configs.LoggerConfig;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import static io.quarkus.arc.impl.UncaughtExceptions.LOGGER;

@Provider
public class NotFoundExceptionHandler implements ExceptionMapper<NotFoundException> {

    @Context
    private ContainerRequestContext requestContext;

    @Inject
    LoggerConfig loggerConfig;

    @Override
    public Response toResponse(NotFoundException exception) {
        // Obtener la ruta solicitada
        String path = requestContext.getUriInfo().getPath();

        // Excluir rutas internas de Quarkus (como /q/dev-ui)
        if (path.startsWith("q/") || path.startsWith("/q/")) {
            throw exception;
        }

        // Loguear la excepción
        LOGGER.warn(loggerConfig.getNotFoundMessage() + " Ruta no encontrada: " + path);

        // Manejar otras rutas no encontradas
        ErrorResponse errorResponse = new ErrorResponse(
                Response.Status.NOT_FOUND.getStatusCode(),
                loggerConfig.getNotFoundMessage()
        );

        return Response.status(Response.Status.NOT_FOUND)
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