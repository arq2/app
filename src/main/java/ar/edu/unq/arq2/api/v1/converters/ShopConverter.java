package ar.edu.unq.arq2.api.v1.converters;

import ar.edu.unq.arq2.api.v1.resources.ShopResource;
import ar.edu.unq.arq2.entities.Shop;

import javax.enterprise.context.ApplicationScoped;

import static ar.edu.unq.arq2.entities.Shop.newShop;

@ApplicationScoped
public class ShopConverter {

    public Shop convert(ShopResource shoptResource){
        return newShop()
                .name(shoptResource.getName())
                .latitude(shoptResource.getLatitude())
                .longitude(shoptResource.getLongitude())
                .location(shoptResource.getLocation())
                .address(shoptResource.getAddress())
                .build();
    }
}
