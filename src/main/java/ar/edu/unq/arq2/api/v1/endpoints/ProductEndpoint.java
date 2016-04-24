package ar.edu.unq.arq2.api.v1.endpoints;

import ar.edu.unq.arq2.api.v1.converters.ProductConverter;
import ar.edu.unq.arq2.api.v1.converters.ProductResourceConverter;
import ar.edu.unq.arq2.api.v1.resources.ProductResource;
import ar.edu.unq.arq2.entities.Product;
import ar.edu.unq.arq2.entities.ProductRepository;

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
import static javax.ws.rs.core.Response.*;

@Produces("application/json")
@Path("/v1/products")
@ApplicationScoped
public class ProductEndpoint {
    @Inject
    private ProductRepository repository;

    @Inject
    private ProductResourceConverter productResourceConverter;

    @Inject
    private ProductConverter productConverter;

    @GET
    public Response findAll(){
        final List products = repository.findAll();
        final List resources = productResourceConverter.convert(products);
        return ok(newEnvelop().items(resources).build()).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") @NotNull  String id){
        final Product product = repository.find(id);

        if(product == null){
            return status(404).build();
        }

        return ok(newEnvelop().item(productResourceConverter.convert(product)).build()).build();
    }

    @POST
    public Response create(@NotNull @Valid ProductResource productResource) throws URISyntaxException {
        Product product = repository.save(productConverter.convert(productResource));
        return created(new URI("/api/v1/products/" + product.getId())).entity(newEnvelop().item(productResourceConverter.convert(product)).build()).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@NotNull @Valid ProductResource productResource, @PathParam("id") @NotNull  String id) throws URISyntaxException {
        Product product = repository.update(id, productConverter.convert(productResource));
        return ok(newEnvelop().item(productResourceConverter.convert(product)).build()).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") @NotNull  String id) throws URISyntaxException {
        Product product = repository.delete(id);

        if(product == null){
            return status(404).build();
        }

        return ok(newEnvelop().item(productResourceConverter.convert(product)).build()).build();
    }
}
