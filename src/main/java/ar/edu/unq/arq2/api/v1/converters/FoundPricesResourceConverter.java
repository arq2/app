package ar.edu.unq.arq2.api.v1.converters;


import ar.edu.unq.arq2.api.v1.resources.FoundPricesResource;
import ar.edu.unq.arq2.entities.FoundPrices;

import java.util.List;

import static ar.edu.unq.arq2.api.v1.resources.FoundPricesResource.newFoundPricesResource;
import static java.util.stream.Collectors.toList;

public class FoundPricesResourceConverter {

    public FoundPricesResource convert(FoundPrices foundPrices){
        return newFoundPricesResource()
                .id(foundPrices.getId())
                .product_id(foundPrices.getProduct_id())
                .shop_id(foundPrices.getShop_id())
                .price(foundPrices.getPrice())
                .datetime(foundPrices.getDatetime())
                .build();
    }

    public List convert(List<FoundPrices> foundPricesList){
        return foundPricesList.stream().map(this::convert).collect(toList());
    }
}
