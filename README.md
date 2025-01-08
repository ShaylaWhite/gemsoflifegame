# Gems of Life Game

## Table of Contents
- [Overview](#overview)
- [Technologies Used](#technologies-used)
- [Life Lessons Integration](#life-lessons-integration)
- [Game Overview](#game-overview)
- [Running the Game](#running-the-game)
- [Game Rules](#game-rules)
- [Example Game Flow](#example-game-flow)
- [User Stories](#user-stories)
- [Code Structure](#code-structure)
- [Backend Skills Highlights](#backend-skills-highlights)
- [API Endpoints](#api-endpoints)
- [Creative Extensions](#creative-extensions)
- [Life Lessons Learned from Project](#life-lessons-learned-from-project)
- [License](#license)

## Overview
**Gems of Life** is a console-based guessing game that blends problem-solving and personal growth. Players guess a secret combination of four numbers within 10 attempts. Along the way, they collect gems based on their guesses and receive motivational life lessons tied to each attempt. This project is designed to highlight key backend skills while encouraging players to reflect on important life values.

## 🔧 Technologies Used
- **Java**: Core programming language for the game.
- **Spring Boot**: Backend framework for structure and service implementation, embracing MVC and OOP principles.
- **Maven**: For dependency management.
- **RestTemplate**: Simplifies HTTP communication.

## 🏅 Life Lessons Integration
This game integrates lessons inspired by values crucial for success in backend engineering and life:
- **Grit**: Persistence and passion in the face of challenges.
- **Self-Learning**: Commitment to continuous improvement.
- **Problem-Solving**: Analytical thinking and creativity.
- **Perseverance**: Staying resilient in adversity.
- **Passion**: Enthusiasm and dedication to learning and growth.
- **Belief in Yourself**: Confidence and motivation to succeed.
- **Adaptability**: Flexibility to pivot and embrace change.
- **Collaboration**: Effective teamwork and communication.

## 🧠 Core Backend Highlights
This project is designed to highlight backend engineering skills by focusing on:
- **Data Handling**: Efficiently managing game state, including secret combinations, guesses, and attempts, through robust data structures.
- **Logic Implementation**: Developing accurate algorithms for calculating correct numbers, positions, and determining game outcomes.
- **State Management:** Tracking user progress and integrating life lessons dynamically based on their gameplay.
- **Error Handling**: Anticipating invalid inputs and ensuring the game continues running smoothly without disruptions.
- **Scalability:** Using modular design principles for easy integration of additional features, such as hints or web-based APIs.

# 🎮 Game Overview

### 🛠️ How to Set Up
#### Prerequisites
- **Java**: Ensure JDK 8+ is installed.
- **Maven (optional)**: For building and managing dependencies.

#### Setup Instructions
1. Clone the repository:
   ```bash
   git clone https://github.com/ShaylaWhite/gemsoflifegame.git

2. Navigate to the project directory:
   ```bash
   cd gemsoflifegame

3. If using Maven, build the project:
      ```
    mvn clean install
 **Open the project in your preferred IDE (IntelliJ, Eclipse) or compile it using the terminal.**

### 🛠️ How to Run
- Using the Command Line
- Navigate to the src directory and locate the ConsoleUI class.
- Compile the program:
  
    ```
  java ConsoleUI.java
    ```
### 🛠️ Run the program
  ``` 
  java ConsoleUI
  ```
### Game Rules
- Guess a combination of 4 unique numbers between 0 and 7.
- You have 10 attempts to guess the correct combination.
- Earn "gems" for:
   1. Correct numbers.
   2. Correct positions.
- Receive a life lesson after every guess.


### Example Game Flow
```bash
===============================================
       Welcome to the Life Lessons Guessing Game!
===============================================
The secret combination consists of four different numbers, each between 0 and 7.
You have 10 attempts to guess the combination correctly.
===============================================

Enter your guess (4 numbers, space-separated): 2 3 4 5

Correct Numbers: 2, Correct Positions: 0

You earned gems for your guess: 2 gem(s) for 2 correct number(s).
===============================================
Life Lesson: "Don’t find fault, find a remedy."
===============================================

============== Guess History ==============

Guess: [2, 3, 4, 5] | Correct Numbers: 2 | Correct Positions: 0  
Life Lesson: 💎 Grit: "Success is not final, failure is not fatal: It is the courage to continue that counts."

You have 9 guesses left.
===============================================
```
## 📜 User Stories

- **As a player**, I want to guess a secret combination of numbers so that I can earn gems and reflect on life lessons.
- **As a player**, I want to see how many correct numbers and correct positions I have guessed, so I can improve my next guess.
- **As a player**, I want to receive a life lesson after each guess to motivate me and inspire personal growth.
- **As a player**, I want to know how many attempts I have left to guess the combination, so I can plan my strategy accordingly.

## 📂 Code Structure

The project is structured using **Model-View-Controller (MVC)** and **Object-Oriented Programming (OOP)** principles. Here’s how the code is organized:

### **Model-View-Controller (MVC)**

**Model** <-> (Service Layer) <-> **Controller** <-> **View**

### Model

The **Model** defines and manages the data structure of the application. It contains the game state, including the secret combination, guesses, and the player's progress.

- **Game**: Represents the game state and contains the logic for handling game operations, such as checking guesses and managing attempts.
  - Manages secret combination and game history.
  - Stores motivational gems and life lessons.
  - Contains methods to check the correctness of guesses.

- **Guess**: Represents a player's guess and compares it to the secret combination to calculate correct numbers and positions.
  - Tracks the user's guess history.
  - Provides feedback on the accuracy of each guess and includes motivational life lessons based on the guess performance.

### View

The **View** manages the interaction with the user (player).

- **ConsoleUI**: Displays prompts, feedback, and takes input from the user in the console interface.

### Controller

The **Controller** manages the flow of the game, updates the game state, and interacts with the view to display the results.

- **GameController**: Coordinates and controls routes, manages guesses, tracks attempts, and triggers motivational life lessons.
  - Exposes RESTful endpoints to external clients to:
    - Submit guesses.
    - Retrieve game statuses.
    - Start new games.

### Service Layer

The **Service Layer** encapsulates business logic, making the code modular, reusable, and maintainable.

- **GameService**: Handles the game lifecycle, business logic workflows, and external API interaction (fetching random numbers for secret combinations).
  - Manages game state, including starting a new game and fetching game data.
  - Handles API requests using RestTemplate to generate a secret combination.


### **Object-Oriented Programming (OOP)**

- **Encapsulation**: 
  The project uses encapsulation to group related data and methods into classes. For example, the `Game` class encapsulates the game state, and the `Guess` class encapsulates the logic for player guesses. This ensures that related functionalities are logically grouped, making the code easier to maintain and extend.

- **Abstraction**: 
  The internal workings of the game, like logic and state management, are abstracted into the `Game` and `Guess` classes. The `GameController` exposes a simplified interface for interacting with the game, allowing external clients to focus on high-level operations without needing to understand the complex inner workings.

- **Modularity**: 
  Each component (model, view, controller, service layer) is independent, making the code more manageable and easier to extend. For instance, the game state can be updated and extended without altering the game logic. This makes the project scalable as new features can be added without significant code changes.

- **Inheritance**: 
  Future features can be added by extending existing classes. For example, new types of guesses or game modes could be derived from the base `Guess` class, making the system more flexible and scalable. This also adheres to the DRY (Don’t Repeat Yourself) principle by allowing code reuse.

## 🤝 Backend Skills Demonstrated

This project demonstrates various backend development skills, highlighting your ability to design, implement, and maintain complex systems:

- **MVC Architecture**: The project uses the **Model-View-Controller** pattern to separate concerns, making the codebase more modular, maintainable, and scalable. This allows for better organization and cleaner code, where each component has a distinct responsibility.
  
- **OOP Principles**: The project is built with **Object-Oriented Programming** principles, making it modular and extensible. By using encapsulation, abstraction, inheritance, and polymorphism, the system can be easily extended and maintained.
  
- **State Management**: Game state (e.g., attempts, guesses) is efficiently managed within the `Game` model, allowing for real-time updates and interactions. This ensures that the state is always consistent and accessible across the application.

- **Life Lessons Integration**: Motivational feedback is delivered to players through the `LifeLesson` model, showcasing how technical logic can be combined with user engagement to create a more interactive and rewarding experience.

- **Dependency Management**: **Maven** is used to handle dependencies and build the project, demonstrating proficiency in project management tools. This ensures that external libraries and frameworks are properly managed and integrated into the project.


## API Endpoints

While this game is currently console-based, here’s an outline of how it could be transformed into a web-based API application. This demonstrates the flexibility of the current code structure and how easily it can be adapted to expose game functionality over HTTP.

### Proposed API Endpoints:

- **`GET /game/start`**: Starts a new game and generates a random secret combination.
- **`POST /game/guess`**: Submits a player’s guess and returns the result (correct numbers, positions, and life lesson).
- **`GET /game/status`**: Returns the current status of the game, including remaining attempts and guess history.

---

## Random Number API Integration

To generate a random secret number for the game, I decided to integrate an external API — [Random.org](https://www.random.org/) — which provides truly random numbers generated from atmospheric noise. This ensures that each game starts with a unique secret combination, which makes the gameplay experience fair and unpredictable.

### Code Snippet:

```java
// API URL to retrieve random numbers
private static final String API_URL = "https://www.random.org/integers";

// Number of digits to generate for the secret combination
private static final int NUMBERS_TO_GENERATE = 4;

// Minimum and maximum values for the generated numbers
private static final int MIN_VALUE = 0;
private static final int MAX_VALUE = 7;

// RestTemplate used for making HTTP requests
private final RestTemplate restTemplate;

// Holds the current game instance
private Game currentGame;
```

### Constructor Explanation

The constructor initializes the `RestTemplate` for making HTTP requests. `RestTemplate` is part of Spring's framework and is a powerful tool to simplify the process of interacting with web services.

```java
public GameService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
}

```
### Starting a New Game
The startNewGame() method is responsible for calling the Random.org API to retrieve a random number combination. It then initializes the game with this secret combination.
```
public Game startNewGame() {
    URI uri = URI.create(String.format("%s?num=%d&min=%d&max=%d&col=1&base=10&format=plain&rnd=new",
            API_URL, NUMBERS_TO_GENERATE, MIN_VALUE, MAX_VALUE));

    String response = restTemplate.getForObject(uri, String.class);

    if (response == null || response.trim().isEmpty()) {
        throw new IllegalStateException("Failed to retrieve valid secret combination from Random.org API.");
    }

    int[] secretCombination = Arrays.stream(response.split("\n"))
            .mapToInt(Integer::parseInt)
            .toArray();

    currentGame = new Game(secretCombination);

    return currentGame;
}
```

## Key Decisions
- **API Integration:**
I used the Random.org to generate the secret combination as recommended as it provides high-quality randomness based on atmospheric noise, which is much better than relying on pseudo-random number generators that are commonly used in programming. This ensures that each game is unique and offers a fair, unpredictable experience.

Why Random.org?: Using a trusted external API like Random.org allows for true randomness, which ensures fairness in game outcomes. The API is reliable, and its integration is straightforward using Spring's RestTemplate.

- **Separation of Concerns:**
By separating the game logic (like generating the secret combination) into the GameService class, I’ve ensured that the controller’s responsibilities are kept minimal and focused on HTTP request handling.

Why is this important?: This separation of concerns allows for better maintainability and scalability. It makes it easier to swap out the random number generation logic in the future if needed without affecting the rest of the codebase.

- **Error Handling:**
The game checks if the API response is valid and throws an exception if the data retrieval fails. This ensures that the game doesn’t proceed with invalid or empty data.

Why is this important?: Proper error handling ensures that users are informed if something goes wrong, such as the random number generation failing, rather than continuing with incorrect game data.

- **Extensibility:**
This code is designed to easily integrate into a larger web-based application. For example, I can add an HTTP controller (using @RestController in Spring Boot) to expose the endpoints for starting the game, submitting guesses, and checking the game status.

Why is this important?: Extending the functionality to a web application makes the game more accessible and interactive, allowing users to play through a browser or client-side application.

## 🚀 Creative Extensions

### 1. **Hints System**
   - **Description**: Provide players with hints after a set number of failed attempts.
   - **How it works**: A hint could reveal one correct number in the secret combination or provide a clue related to the life lesson of the round.

### 2. **Earned Gems & Rewards**
   - **Description**: Players earn gems based on their performance, such as the number of correct guesses or how many attempts they used.
   - **How it works**: These gems could be used to unlock new life lessons, motivational quotes, or game features to keep players engaged.

### 3. **Review Core Life Lessons**
   - **Description**: After each game or set of guesses, players can review the life lessons they’ve earned throughout their gameplay.
   - **How it works**: Display a summary of the life lessons, reinforcing the motivational messages as players progress.

## 📖 Lessons Learned from the Project

Developing **Gems of Life** was an incredible journey that tested and sharpened my technical and personal skills. This project taught me lessons that go beyond coding, mirroring the core values of perseverance, adaptability, and self-belief that are essential in both backend engineering and life.

### Challenges and Resilience

#### Technical Hurdles:
I encountered Maven installation issues, which tested my patience and problem-solving skills. By seeking out resources and troubleshooting systematically, I gained confidence in navigating technical hurdles.

#### Managing Circular Dependencies:
Circular dependencies, a common challenge in backend development, sharpened my ability to design modular and maintainable code.

#### Adapting to Constraints:
When my original plan to create a web-based UI proved infeasible due to time constraints, I pivoted to a console-based interface. This taught me the value of flexibility and focusing on delivering a functional product within the given timeframe.

### Personal Growth

#### Grit and Perseverance:
Completing this project reinforced the importance of grit. Just like the gems of wisdom players earn in the game, every obstacle I faced during development provided an opportunity to grow and refine my skills.

#### Balancing Ambition with Realism:
While I initially envisioned features like user authentication and CRUD functionality, I realized the importance of prioritizing a fully functional game within the scope of my resources.

#### Belief in Myself:
Through this process, I discovered the power of faith—both in my technical abilities and in the impact of telling my story. By stepping out on faith, I applied to LinkedIn's REACH program, which resonates deeply with the values embodied in this game. It was a decision fueled by the lessons I learned: to believe in myself, remain persistent, and embrace every challenge as an opportunity for growth.

This project is a testament to the synergy between technical problem-solving and personal development. It’s not just a game—it’s a reflection of the perseverance and passion required to navigate both code and life.

### GitHub Attempts:
Here are my previous verisons of **Gems of Life**:
- [Life Gems](#)
- [Gems of Life Game](#)

## License
This project is licensed under the MIT License. See the LICENSE file for details.



