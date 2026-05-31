package com.harshita.carmatchmaker.service;

import com.harshita.carmatchmaker.model.Car;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    private List<Car> cars = new ArrayList<>();

    @PostConstruct
    public void init() {
        cars.add(new Car(1L, "Tata", "Nexon", 900000, 17.5, 5, "SUV",
                "A tank-like build with top-tier safety, perfect for Indian roads but the engine could be punchier."));
        cars.add(new Car(2L, "Maruti Suzuki", "Swift", 650000, 22.3, 2, "Hatchback",
                "The ultimate city runabout. Incredible mileage and peppy engine, though safety takes a backseat."));
        cars.add(new Car(3L, "Hyundai", "Creta", 1100000, 16.8, 3, "SUV",
                "Feature-packed, smooth, and incredibly popular. Great for families looking for comfort and premium interiors."));
        cars.add(new Car(4L, "Tata", "Punch", 600000, 18.9, 5, "Micro SUV",
                "Brilliant packaging of safety and high ground clearance in a budget-friendly, compact size."));
        cars.add(new Car(5L, "Kia", "Seltos", 1090000, 16.5, 3, "SUV",
                "Stunning looks and loaded with tech. The automatic transmission is a breeze for city traffic."));
        cars.add(new Car(6L, "Mahindra", "XUV700", 1400000, 13.0, 5, "SUV",
                "A technological marvel from Mahindra. Powerful engines, ADAS features, and genuine 5-star safety."));
        cars.add(new Car(7L, "Honda", "City", 1180000, 18.4, 4, "Sedan",
                "The gold standard for executive sedans. Unmatched rear-seat comfort and a super refined i-VTEC engine."));
        cars.add(new Car(8L, "Maruti Suzuki", "Baleno", 660000, 22.9, 2, "Hatchback",
                "Spacious, incredibly fuel-efficient, and easy to maintain. A highly practical choice for daily commuting."));
        cars.add(new Car(9L, "Volkswagen", "Virtus", 1150000, 19.4, 5, "Sedan",
                "An absolute driver's delight. German engineering, fantastic handling, and impeccable safety standards."));
        cars.add(new Car(10L, "Toyota", "Innova Crysta", 1990000, 11.4, 4, "MUV",
                "Bulletproof reliability. If you have a large family and want to travel in comfort for the next 15 years, buy this."));
        cars.add(new Car(11L, "Hyundai", "i20", 700000, 20.0, 3, "Hatchback",
                "A premium hatchback that feels like a segment above. Great styling and very light controls for the city."));
        cars.add(new Car(12L, "Tata", "Harrier", 1540000, 14.6, 5, "SUV",
                "Massive road presence and excellent ride quality. Based on a Land Rover platform and it shows."));
        cars.add(new Car(13L, "Maruti Suzuki", "Brezza", 830000, 19.8, 4, "SUV",
                "A reliable, no-nonsense compact SUV. Good fuel economy, decent safety, and massive resale value."));
        cars.add(new Car(14L, "Skoda", "Kushaq", 1089000, 19.2, 5, "SUV",
                "Brilliant driving dynamics and a strong, safe build. The infotainment system and cabin feel very premium."));
        cars.add(new Car(15L, "Mahindra", "Thar", 1125000, 15.2, 4, "Off-Roader",
                "An absolute lifestyle statement. Unbeatable off-road capability, though the ride is bouncy in the city."));
    }

    public List<Car> getRecommendations(int maxBudget, String topPriority) {
        List<Car> filtered = cars.stream()
                .filter(car -> car.getPrice() <= maxBudget)
                .collect(Collectors.toList());

        if ("safety".equals(topPriority)) {
            filtered.sort(Comparator.comparingInt(Car::getSafetyRating).reversed());
        } else if ("mileage".equals(topPriority)) {
            filtered.sort(Comparator.comparingDouble(Car::getMileage).reversed());
        }

        return filtered.stream().limit(3).collect(Collectors.toList());
    }
}
