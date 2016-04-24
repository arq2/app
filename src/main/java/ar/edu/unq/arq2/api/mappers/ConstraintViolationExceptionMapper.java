package ar.edu.unq.arq2.api.mappers;

import ar.edu.unq.arq2.api.Envelop;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
    @Override
    public Response toResponse(ConstraintViolationException exception) {
        StringBuilder stringBuilder = new StringBuilder("Validation error: ");
        exception.getConstraintViolations().stream().forEach(e -> stringBuilder.append(e.getMessage()).append(", "));
        stringBuilder.replace(stringBuilder.lastIndexOf(", "), stringBuilder.length(), "");
        return Response.status(400).entity(Envelop.newEnvelop().error(new Envelop.ErrorMessage(stringBuilder.toString())).build()).build();
    }
}
