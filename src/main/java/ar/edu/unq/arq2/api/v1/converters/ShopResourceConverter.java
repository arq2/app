package ar.edu.unq.arq2.api.v1.converters;

import ar.edu.unq.arq2.api.v1.resources.ShopResource;
import ar.edu.unq.arq2.entities.Shop;

import java.util.List;

import static ar.edu.unq.arq2.api.v1.resources.ShopResource.newShopResource;
import static java.util.stream.Collectors.toList;

public class ShopResourceConverter {

    public ShopResource convert(Shop shop){
        return newShopResource()
                .id(shop.getId())
                .name(shop.getName())
                .location(shop.getLocation())
                .longitude(shop.getLongitude())
                .latitude(shop.getLatitude())
                .address(shop.getAddress())
                .build();
    }

    public List<ShopResource> convert(List<Shop> shops){
        return shops.stream().map(this::convert).collect(toList());
    }
}
