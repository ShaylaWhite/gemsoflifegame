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
  **Scalability:** Using modular design principles for easy integration of additional features, such as hints or web-based APIs.

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

- **Model**: Contains the logic for handling the game state, including the secret combination, guesses, and gems.
  - `Game`: Handles the game state, including attempts, secret combination, and gem collection.
  - `Guess`: Represents a player's guess and compares it to the secret combination to calculate correct numbers and positions.
  - `LifeLesson`: Contains the motivational life lessons associated with each guess.

- **View**: Manages the interaction with the user (player).
  - `ConsoleUI`: Displays prompts and feedback in the console, and takes input from the user.

- **Controller**: Manages the flow of the game, updates the game state, and interacts with the view to display the results.
  - `GameController`: Coordinates the game logic, manages guesses, tracks attempts, and triggers life lessons.

## 🤝 Backend Skills Demonstrated

This project demonstrates various backend development skills:

- **MVC Architecture**: The project uses the Model-View-Controller pattern to separate concerns and improve code maintainability.
- **OOP Principles**: The project is built with Object-Oriented Programming principles, making it modular and extensible.
- **State Management**: Game state (e.g., attempts, guesses) is efficiently managed within the `Game` model.
- **Life Lessons Integration**: Motivational feedback is delivered to players through the `LifeLesson` model, showcasing integration of both technical and personal growth aspects.
- **Dependency Management**: Maven is used to handle dependencies and build the project, demonstrating proficiency in project management tools.

## API Endpoints

While this game is currently console-based and does not expose traditional API endpoints, here’s an outline of how an API might look if this game were to be web-based:

- `GET /game/start`: Starts a new game and generates a random secret combination.
- `POST /game/guess`: Submits a player’s guess and returns the result (correct numbers, positions, and life lesson).
- `GET /game/status`: Returns the current status of the game, including remaining attempts and guess history.

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



