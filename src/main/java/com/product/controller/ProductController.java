package com.product.controller;

import com.product.entity.Product;
import com.product.enums.ResultCode;
import com.product.handler.ProductHandler;
import com.product.request.ProductRequest;
import com.product.response.BaseResponse;
import com.product.response.ProductResponse;
import com.product.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

@RestController("/")
@CrossOrigin("*")
public class ProductController {

    private final ProductHandler productHandler;
    private final MessageSource messageSource;

    public ProductController(final ProductHandler productHandler,final MessageSource messageSource) {
        this.productHandler = productHandler;
        this.messageSource = messageSource;
    }

    @PostMapping
    public BaseResponse<ProductResponse> save(@RequestBody @Valid ProductRequest request){
        return new BaseResponse<>(
                ResultCode.SUCCESS.getValue(),
                messageSource.getMessage("api.success.response", new String[] {}, Locale.getDefault()),
                productHandler.saveProduct(request));
    }

    @GetMapping
    public BaseResponse<List<ProductResponse>> getAllProduct(){
        return new BaseResponse<>(
                ResultCode.SUCCESS.getValue(),
                messageSource.getMessage("api.success.response", new String[] {}, Locale.getDefault()),
                productHandler.getAllProduct());
    }

    @GetMapping(value = "{id}")
    public BaseResponse<ProductResponse> get(@PathVariable(name = "id") String id){
        return new BaseResponse<>(
                ResultCode.SUCCESS.getValue(),
                messageSource.getMessage("api.success.response", new String[] {}, Locale.getDefault()),
                productHandler.getProduct(id));
    }

    @PutMapping(value = "{id}")
    public BaseResponse<ProductResponse> update(@RequestBody ProductRequest request){
        return new BaseResponse<>(
                ResultCode.SUCCESS.getValue(),
                messageSource.getMessage("api.success.response", new String[] {}, Locale.getDefault()),
                productHandler.update(request));
    }

    @DeleteMapping(value = "{id}")
    public BaseResponse<String> delete(@PathVariable(name = "id") String id){
        productHandler.delete(id);
        return new BaseResponse<>(
                ResultCode.SUCCESS.getValue(),
                messageSource.getMessage("api.success.response", new String[] {}, Locale.getDefault()));
    }

}
