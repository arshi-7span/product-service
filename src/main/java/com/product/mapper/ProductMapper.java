package com.product.mapper;

import com.product.entity.Product;
import com.product.request.ProductRequest;
import com.product.response.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {

    Product requestToEntity(ProductRequest request);

    ProductResponse entityToResponse(Product product);

    List<ProductResponse> toResponse(List<Product> product);
}
