package ar.edu.unq.arq2.api;

import ar.edu.unq.arq2.util.ObjectMapperFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

@Provider
public class ObjectMapperResolver implements ContextResolver<ObjectMapper> {
    @Override
    public ObjectMapper getContext(Class<?> type) {
        return ObjectMapperFactory.get();
    }
}
