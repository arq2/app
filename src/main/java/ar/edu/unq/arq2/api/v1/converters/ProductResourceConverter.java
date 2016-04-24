package ar.edu.unq.arq2.api.v1.converters;

import ar.edu.unq.arq2.api.v1.resources.ProductResource;
import ar.edu.unq.arq2.entities.Product;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

import static ar.edu.unq.arq2.api.v1.resources.ProductResource.newProductResource;
import static java.util.stream.Collectors.toList;

@ApplicationScoped
public class ProductResourceConverter {
    public ProductResource convert(Product product){
        return newProductResource()
                .id(product.getId())
                .description(product.getDescription())
                .value(product.getValue())
                .name(product.getName())
                .build();
    }

    public List convert(List<Product> products){
        return products.stream().map(this::convert).collect(toList());
    }
}
