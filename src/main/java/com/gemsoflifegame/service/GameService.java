package com.gemsoflifegame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GameService {
    @Autowired
    private RestTemplate restTemplate;

    private final String API_URL = "https://www.random.org/integers/?num=4&min=0&max=7&col=1&base=10&format=plain";

    public int[] generateNumbers() {
        try {
            String response = restTemplate.getForObject(API_URL, String.class);
            if (response != null) {
                String[] numbers = response.split("\n");
                if (numbers.length == 4) {
                    return new int[]{
                            Integer.parseInt(numbers[0]),
                            Integer.parseInt(numbers[1]),
                            Integer.parseInt(numbers[2]),
                            Integer.parseInt(numbers[3])
                    };
                } else {
                    throw new RuntimeException("Unexpected number of values in response.");
                }
            } else {
                throw new RuntimeException("No response from the API");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error fetching numbers: " + e.getMessage(), e);
        }
    }
}

