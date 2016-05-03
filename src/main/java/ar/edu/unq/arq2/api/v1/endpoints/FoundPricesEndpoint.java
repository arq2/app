package ar.edu.unq.arq2.api.v1.endpoints;

import ar.edu.unq.arq2.api.v1.converters.FoundPriceConverter;
import ar.edu.unq.arq2.api.v1.converters.FoundPriceResourceConverter;
import ar.edu.unq.arq2.api.v1.resources.FoundPriceResource;
import ar.edu.unq.arq2.api.v1.resources.Paging;
import ar.edu.unq.arq2.entities.FoundPrice;
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

import static ar.edu.unq.arq2.api.Envelop.item;
import static ar.edu.unq.arq2.api.PaginatedResponse.paginate;
import static javax.ws.rs.core.Response.*;

@Produces("application/json")
@Path("/v1/found_prices")
@ApplicationScoped
public class FoundPricesEndpoint {

    @Inject
    private FoundPricesRepository repository;

    @Inject
    private FoundPriceResourceConverter foundPriceResourceConverter;

    @Inject
    private FoundPriceConverter foundPriceConverter;

    @GET
    public Response findAll(@QueryParam("offset") int offset, @QueryParam("limit") int limit){
        Long count = repository.count();
        List<FoundPrice> foundPricesList = repository.findAll(offset, limit);
        List<FoundPriceResource> resources = foundPriceResourceConverter.convert(foundPricesList);
        return ok(paginate(resources, new Paging(offset, limit, count))).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") @NotNull String id){
        final FoundPrice foundPrice = repository.find(id);

        if(foundPrice == null){
            return status(404).build();
        }

        return ok(item(foundPriceResourceConverter.convert(foundPrice))).build();
    }

    @POST
    public Response create(@NotNull @Valid FoundPriceResource foundPriceResource) throws URISyntaxException {
        FoundPrice foundPrice = repository.save(foundPriceConverter.convert(foundPriceResource));
        return created(new URI("/api/v1/found_prices/" + foundPrice.getId())).build();
    }
}
