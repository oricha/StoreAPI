package com.kmuniz.storeapi.store_api.config;

import com.kmuniz.storeapi.store_api.domain.*;
import com.kmuniz.storeapi.store_api.repos.CarMakerRepository;
import com.kmuniz.storeapi.store_api.repos.CarModelRepository;
import com.kmuniz.storeapi.store_api.repos.CarVersionRepository;
import com.kmuniz.storeapi.store_api.repos.CategoryRepository;
import com.kmuniz.storeapi.store_api.repos.PartsRepository;
import com.kmuniz.storeapi.store_api.repos.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(
            CarMakerRepository carMakerRepository,
            CarModelRepository carModelRepository,
            CarVersionRepository carVersionRepository,
            CategoryRepository categoryRepository,
            PartsRepository partsRepository,
            UsersRepository usersRepository,
            PasswordEncoder passwordEncoder) {
        return args -> {
            // Initialize CarMakers
            if (carMakerRepository.count() == 0) {
                List<CarMaker> carMakers = Arrays.asList(
                    createCarMaker("Toyota"),
                    createCarMaker("Honda"),
                    createCarMaker("Ford"),
                    createCarMaker("Chevrolet")
                );
                carMakerRepository.saveAll(carMakers);
            }

            // Initialize CarModels
            if (carModelRepository.count() == 0) {
                CarMaker toyota = carMakerRepository.findByNameContainingIgnoreCase("Toyota").orElseThrow();
                CarMaker honda = carMakerRepository.findByNameContainingIgnoreCase("Honda").orElseThrow();
                
                List<CarModel> carModels = Arrays.asList(
                    createCarModel("Corolla", toyota),
                    createCarModel("Camry", toyota),
                    createCarModel("Civic", honda),
                    createCarModel("Accord", honda)
                );
                carModelRepository.saveAll(carModels);
            }

            // Initialize CarVersions
            if (carVersionRepository.count() == 0) {
                CarModel corolla = carModelRepository.findByName("Corolla").orElseThrow();
                CarModel civic = carModelRepository.findByName("Civic").orElseThrow();
                
                List<CarVersion> carVersions = Arrays.asList(
                    createCarVersion("Corolla LE", "2023", corolla.getCarMaker(), corolla),
                    createCarVersion("Corolla SE", "2023", corolla.getCarMaker(), corolla),
                    createCarVersion("Civic LX", "2023", civic.getCarMaker(), civic),
                    createCarVersion("Civic EX", "2023", civic.getCarMaker(), civic)
                );
                carVersionRepository.saveAll(carVersions);
            }

            // Initialize Categories
            if (categoryRepository.count() == 0) {
                List<Category> categories = Arrays.asList(
                    createCategory("Engine Parts"),
                    createCategory("Brake System"),
                    createCategory("Suspension"),
                    createCategory("Electrical")
                );
                categoryRepository.saveAll(categories);
            }

            // Initialize Parts
            if (partsRepository.count() == 0) {
                Category engineParts = categoryRepository.findByName("Engine Parts").orElseThrow();
                List<Parts> parts = Arrays.asList(
                    createPart("Spark Plug", "SP001", "High performance spark plug", 15.99, "Universal", engineParts.getId()),
                    createPart("Oil Filter", "OF001", "Premium oil filter", 12.99, "Universal", engineParts.getId())
                );
                partsRepository.saveAll(parts);
            }

            // Initialize Users
            if (usersRepository.count() == 0) {
                List<Users> users = Arrays.asList(
                    createUser("admin", "admin123", "Admin", "User", "admin@store.com", "ADMIN", passwordEncoder),
                    createUser("user", "user123", "Regular", "User", "user@store.com", "USER", passwordEncoder)
                );
                usersRepository.saveAll(users);
            }
        };
    }

    private CarMaker createCarMaker(String name) {
        CarMaker carMaker = new CarMaker();
        carMaker.setName(name);
        return carMaker;
    }

    private CarModel createCarModel(String name, CarMaker carMaker) {
        CarModel carModel = new CarModel();
        carModel.setName(name);
        carModel.setCarMaker(carMaker);
        return carModel;
    }

    private CarVersion createCarVersion(String name, String version, CarMaker carMaker, CarModel carModel) {
        CarVersion carVersion = new CarVersion();
        carVersion.setName(name);
        carVersion.setVersion(version);
        carVersion.setCarMaker(carMaker);
        carVersion.setCarModel(carModel);
        return carVersion;
    }

    private Category createCategory(String name) {
        Category category = new Category();
        category.setName(name);
        category.setPartCount(0);
        return category;
    }

    private Parts createPart(String name, String code, String description, Double price, String model, Integer categoryId) {
        Parts part = new Parts();
        part.setName(name);
        part.setCode(code);
        part.setDescription(description);
        part.setPrice(price);
        part.setModel(model);
        part.setCategoryId(categoryId.longValue());
        return part;
    }

    private Users createUser(String username, String password, String name, String surname, String email, String userType, PasswordEncoder passwordEncoder) {
        Users user = new Users();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setUserType(userType);
        user.setDateCreated(OffsetDateTime.now());
        return user;
    }
} 