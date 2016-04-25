package ar.edu.unq.arq2.api.v1.converters;


import ar.edu.unq.arq2.api.v1.resources.FoundPricesResource;
import ar.edu.unq.arq2.entities.FoundPrices;

import static ar.edu.unq.arq2.entities.FoundPrices.newFoundPrices;

public class FoundPricesConverter {


    public FoundPrices convert(FoundPricesResource foundPricesResource){
        return newFoundPrices()
                .product_id(foundPricesResource.getProduct_id())
                .shop_id(foundPricesResource.getShop_id())
                .price(foundPricesResource.getPrice())
                .datetime(foundPricesResource.getDatetime())
                .build();
    }
}
