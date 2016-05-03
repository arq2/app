package ar.edu.unq.arq2.api.v1.converters;

import ar.edu.unq.arq2.api.v1.resources.FoundPriceResource;
import ar.edu.unq.arq2.entities.FoundPrice;

import static ar.edu.unq.arq2.entities.FoundPrice.newFoundPrices;

public class FoundPriceConverter {

    public FoundPrice convert(FoundPriceResource foundPriceResource){
        return newFoundPrices()
                .product_id(foundPriceResource.getProduct_id())
                .shop_id(foundPriceResource.getShop_id())
                .price(foundPriceResource.getPrice())
                .datetime(foundPriceResource.getDatetime())
                .build();
    }
}
