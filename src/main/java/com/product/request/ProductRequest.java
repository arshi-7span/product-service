package com.product.request;

import com.product.annotation.impl.ValidateProductRequest;

@ValidateProductRequest
public record ProductRequest(String id, String name, String description, double price, double quantity) { }
