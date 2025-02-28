package com.product.handler;

import com.product.entity.Product;
import com.product.mapper.ProductMapper;
import com.product.request.ProductRequest;
import com.product.response.ProductResponse;
import com.product.service.ProductService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductHandler {
    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductHandler(final ProductService productService, final ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    public ProductResponse saveProduct(ProductRequest request){
     Product product = productService.save(productMapper.requestToEntity(request));
     return productMapper.entityToResponse(product);
   }

    public ProductResponse update(ProductRequest request){
        Product product =  productService.update(productMapper.requestToEntity(request));
        return productMapper.entityToResponse(product);
    }

    public List<ProductResponse> getAllProduct(){
        return productMapper.toResponse(productService.getAllProducts());
    }

    public ProductResponse getProduct(String id){
        return productMapper.entityToResponse(productService.getProductById(id));
    }

    public void delete(String id){
        productService.deleteProductById(id);
    }

}
