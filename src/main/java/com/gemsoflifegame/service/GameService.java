package com.gemsoflifegame.service;

@Service
public class GameService {
    @Autowired
    private RestTemplate restTemplate;

    private final String API_URL = "https://www.random.org/integers/?num=4&min=0&max=7&col=1&base=10&format=plain";

    public int[] generateNumbers() {
        String response = restTemplate.getForObject(API_URL, String.class);
        String[] numbers = response.split("\n");
        return new int[]{Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]),
                Integer.parseInt(numbers[2]), Integer.parseInt(numbers[3])};
    }
}
}
