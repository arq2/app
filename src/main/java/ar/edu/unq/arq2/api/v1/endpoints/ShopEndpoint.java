package ar.edu.unq.arq2.api.v1.endpoints;

import ar.edu.unq.arq2.api.v1.converters.ShopConverter;
import ar.edu.unq.arq2.api.v1.converters.ShopResourceConverter;
import ar.edu.unq.arq2.api.v1.resources.Paging;
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

import static ar.edu.unq.arq2.api.Envelop.item;
import static ar.edu.unq.arq2.api.PaginatedResponse.paginate;
import static javax.ws.rs.core.Response.*;

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


    private int LIMIT = 50;

    private int OFFSET = 0;

    private int validarLimit(Integer limit){
        if(limit > this.LIMIT || limit <=0 || limit == null)
            return this.LIMIT;

        return limit;
    }

    private int validarOffset(Integer offset){

        if( offset <0 || offset == null)
            return this.OFFSET;

        return offset;

    }

    @GET
    public Response findAll(@QueryParam("offset") Integer offset, @QueryParam("limit") Integer limit) {
        int nuevolimit = validarLimit(limit);

        int nuevoOffset =validarOffset(offset);
        Long count = repository.count();
        List<Shop> shops = repository.findAll(nuevoOffset, nuevolimit);
        List<ShopResource> resources = shopResourceConverter.convert(shops);
        return ok(paginate(resources, new Paging(nuevoOffset, nuevolimit, count))).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") @NotNull String id){
        final Shop shop = repository.find(id);

        if(shop == null){
            return status(404).build();
        }

        return ok(item(shopResourceConverter.convert(shop))).build();
    }

    @POST
    public Response create(@NotNull @Valid ShopResource shopResource) throws URISyntaxException {
        Shop shop = repository.save(shopConverter.convert(shopResource));
        return created(new URI("/api/v1/shops/" + shop.getId())).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@NotNull @Valid ShopResource shopResource, @PathParam("id") @NotNull  String id) throws URISyntaxException {
        Shop shop = repository.update(id, shopConverter.convert(shopResource));
        return ok(item(shopResourceConverter.convert(shop))).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") @NotNull  String id) throws URISyntaxException {
        Shop shop = repository.delete(id);

        if(shop == null){
            return status(404).build();
        }

        return ok(item(shopResourceConverter.convert(shop))).build();
    }
}
