package ar.edu.unq.arq2.api.v1.endpoints;


import ar.edu.unq.arq2.api.v1.converters.ShopConverter;
import ar.edu.unq.arq2.api.v1.converters.ShopResourceConverter;
import ar.edu.unq.arq2.api.v1.resources.ShopResource;
import ar.edu.unq.arq2.entities.Shop;
import ar.edu.unq.arq2.entities.ShopRepository;

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
@Path("/v1/shops")
@ApplicationScoped
public class ShopEndpoint {

    @Inject
    private ShopRepository repository;

    @Inject
    private ShopResourceConverter shopResourceConverter;

    @Inject
    private ShopConverter shopConverter;

    @GET
    public Response findAll(){
        final List products = repository.findAll();
        final List resources = shopResourceConverter.convert(products);
        return ok(newEnvelop().items(resources).build()).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") @NotNull String id){
        final Shop shop = repository.find(id);

        if(shop == null){
            return status(404).build();
        }

        return ok(newEnvelop().item(shopResourceConverter.convert(shop)).build()).build();
    }

    @POST
    public Response create(@NotNull @Valid ShopResource shopResource) throws URISyntaxException {
        Shop shop = repository.save(shopConverter.convert(shopResource));
        return created(new URI("/api/v1/products/" + shop.getId())).entity(newEnvelop().item(shopResourceConverter.convert(shop)).build()).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@NotNull @Valid ShopResource shopResource, @PathParam("id") @NotNull  String id) throws URISyntaxException {
        Shop shop = repository.update(id, shopConverter.convert(shopResource));
        return ok(newEnvelop().item(shopResourceConverter.convert(shop)).build()).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") @NotNull  String id) throws URISyntaxException {
        Shop shop = repository.delete(id);

        if(shop == null){
            return status(404).build();
        }

        return ok(newEnvelop().item(shopResourceConverter.convert(shop)).build()).build();
    }
}
