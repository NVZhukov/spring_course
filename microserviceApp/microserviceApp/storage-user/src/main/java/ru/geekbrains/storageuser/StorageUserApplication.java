package ru.geekbrains.storageuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StorageUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(StorageUserApplication.class, args);
	}

}
