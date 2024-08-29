# product-service
This repository include endpoint for managing product data

## Prerequisites
1. **Crud operations :** Create, Read, Update, and Delete products.
2. **Firebase Integration :**  Product data is stored in a Firebase Firestore database.
3. **Validation :**  Request validation is handled using Jakarta Bean Validation.

## Prerequisites
Before running this workflow, ensure the following:
- Java 17 or higher
- Gradle
- Firebase account with a Firestore database
- Spring Boot 3.x
- `serviceAccountKey.json` file from your Firebase project (placed in the resources directory)
- `database collection name` add database collection name into application.yml


## Product API endpoint
-  `GET /products`: Retrieve a list of all products.

```
   curl --location 'http://localhost:8084/products'
```

-  `GET /products/{id}`: Retrieve details of a specific product by ID.

```
  curl --location 'http://localhost:8084/products/SPAcg50fEEg2mQwT2ATC'
```
-  `POST /products`: Create a new product.

```
  curl --location 'http://localhost:8084/products' \
--header 'Content-Type: application/json' \
--data '{
    "id":3,
    "name": "Test Product",
    "description": "test",
    "price": 1,
    "quantity": 1
}'
```

-  `PUT /products/{id}` : Update an existing product by.

```
  curl --location 'http://localhost:8084/products/SPAcg50fEEg2mQwT2ATC' \
--header 'Content-Type: application/json' \
--data '{
    "id":3,
    "name": "Test Product",
    "description": "test",
    "price": 1,
    "quantity": 1
}'
```
-  `DELETE /products`: Delete product by id

```
   curl --location 'http://localhost:8084/products'
```