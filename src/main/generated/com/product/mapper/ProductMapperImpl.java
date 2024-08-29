package com.product.mapper;

import com.product.entity.Product;
import com.product.request.ProductRequest;
import com.product.response.ProductResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-30T21:38:13+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product requestToEntity(ProductRequest request) {
        if ( request == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( request.id() );
        product.setName( request.name() );
        product.setDescription( request.description() );
        product.setPrice( request.price() );
        product.setQuantity( request.quantity() );

        return product;
    }

    @Override
    public ProductResponse entityToResponse(Product product) {
        if ( product == null ) {
            return null;
        }

        String id = null;
        String name = null;
        String description = null;
        double price = 0.0d;
        double quantity = 0.0d;

        id = product.getId();
        name = product.getName();
        description = product.getDescription();
        price = product.getPrice();
        quantity = product.getQuantity();

        ProductResponse productResponse = new ProductResponse( id, name, description, price, quantity );

        return productResponse;
    }

    @Override
    public List<ProductResponse> toResponse(List<Product> product) {
        if ( product == null ) {
            return null;
        }

        List<ProductResponse> list = new ArrayList<ProductResponse>( product.size() );
        for ( Product product1 : product ) {
            list.add( entityToResponse( product1 ) );
        }

        return list;
    }
}
