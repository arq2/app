package ar.edu.unq.arq2.api.v1.converters;

import ar.edu.unq.arq2.api.v1.resources.ProductResource;
import ar.edu.unq.arq2.entities.Product;

import javax.enterprise.context.ApplicationScoped;

import static ar.edu.unq.arq2.entities.Product.newProduct;

@ApplicationScoped
public class ProductConverter {

    public Product convert(ProductResource productResource){
        return newProduct()
                .description(productResource.getDescription())
                .value(productResource.getValue())
                .name(productResource.getName())
                .build();
    }
}
