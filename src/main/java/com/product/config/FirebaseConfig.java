package com.product.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.product.ProductServiceApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.util.Objects;

@Configuration
public class FirebaseConfig {

    @Value("${firebase.collection-name}")
    private String collectionName;

    @Bean
    public CollectionReference firebaseCollection(){
        try{
            ClassLoader classLoader = ProductServiceApplication.class.getClassLoader();
            File file = new File(Objects.requireNonNull(classLoader.getResource("serviceAccountKey.json")).getFile());
            FileInputStream serviceAccount = new FileInputStream(file.getAbsoluteFile());

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseOptions options = new FirebaseOptions.Builder()
                        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                        .setDatabaseUrl("https://product-service.asia-south1.firebasedatabase.app")
                        .build();

                FirebaseApp.initializeApp(options);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        Firestore firestore =  FirestoreClient.getFirestore();
        return firestore.collection(collectionName);
    }
}
