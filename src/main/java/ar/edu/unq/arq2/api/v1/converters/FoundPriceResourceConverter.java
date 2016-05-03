package ar.edu.unq.arq2.api.v1.converters;

import ar.edu.unq.arq2.api.v1.resources.FoundPriceResource;
import ar.edu.unq.arq2.entities.FoundPrice;

import java.util.List;

import static ar.edu.unq.arq2.api.v1.resources.FoundPriceResource.newFoundPricesResource;
import static java.util.stream.Collectors.toList;

public class FoundPriceResourceConverter {

    public FoundPriceResource convert(FoundPrice foundPrice){
        return newFoundPricesResource()
                .id(foundPrice.getId())
                .product_id(foundPrice.getProduct_id())
                .shop_id(foundPrice.getShop_id())
                .price(foundPrice.getPrice())
                .datetime(foundPrice.getDatetime())
                .build();
    }

    public List<FoundPriceResource> convert(List<FoundPrice> foundPricesList){
        return foundPricesList.stream().map(this::convert).collect(toList());
    }
}
