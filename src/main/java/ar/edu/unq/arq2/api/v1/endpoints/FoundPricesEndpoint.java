package ar.edu.unq.arq2.api.v1.endpoints;

import ar.edu.unq.arq2.api.v1.converters.FoundPricesConverter;
import ar.edu.unq.arq2.api.v1.converters.FoundPricesResourceConverter;
import ar.edu.unq.arq2.entities.FoundPrices;
import ar.edu.unq.arq2.entities.FoundPricesRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static ar.edu.unq.arq2.api.Envelop.newEnvelop;
import static javax.ws.rs.core.Response.created;
import static javax.ws.rs.core.Response.ok;
import static javax.ws.rs.core.Response.status;

@Produces("application/json")
@Path("/v1/found_prices")
@ApplicationScoped
public class FoundPricesEndpoint {


    @Inject
    private FoundPricesRepository repository;

    @Inject
    private FoundPricesResourceConverter foundPricesResourceConverter;

    @Inject
    private FoundPricesConverter foundPricesConverter;

    @GET
    public Response findAll(){
        final List foundPricesList = repository.findAll();
        final List resources = foundPricesResourceConverter.convert(foundPricesList);
        return ok(newEnvelop().items(resources).build()).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") @NotNull String id){
        final FoundPrices foundPrices = repository.find(id);

        if(foundPrices == null){
            return status(404).build();
        }

        return ok(newEnvelop().item(foundPricesResourceConverter.convert(foundPrices)).build()).build();
    }

}
