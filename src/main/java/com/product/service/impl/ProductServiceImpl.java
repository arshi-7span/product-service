package com.product.service.impl;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.google.protobuf.Api;
import com.product.entity.Product;
import com.product.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Service
public class ProductServiceImpl implements ProductService {

    private final CollectionReference productCollection;

    public ProductServiceImpl(CollectionReference firebaseCollection) {
        this.productCollection = firebaseCollection;
    }

    @Override
    public Product save(Product product) {
       productCollection.document().set(product);
       return getProductById(productCollection.document(String.valueOf(product.getId())));
    }

    @Override
    public Product update(Product product) {
        productCollection.document(product.getId()).set(product);
        return getProductById(productCollection.document(String.valueOf(product.getId())));
    }

    @Override
    public Product getProductById(String id) {
        DocumentReference documentReference = productCollection.document(id);
       return getProductById(documentReference);
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        Iterable<DocumentReference> listDocuments = productCollection.listDocuments();

        for(DocumentReference documentReference:listDocuments){
              Product product = getProductById(documentReference);
              products.add(product);
        }

        return products;
    }

    @Override
    public void deleteProductById(String id) {
        productCollection.document(id).delete();
    }

    private Product getProductById(DocumentReference documentReference){
        try {
            ApiFuture<DocumentSnapshot> future = documentReference.get();
            DocumentSnapshot documentSnapshot = future.get();
            Product product;
            if(documentSnapshot.exists()){
                product = documentSnapshot.toObject(Product.class);
                product.setId(documentSnapshot.getId());
                return product;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
       return  null;
    }
}
