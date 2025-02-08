# Bingo-Slot-Game
# 🎰 Slot-Style 3x3 Matrix Game

## 📌 Overview

This is a **slot-style number marking game** played on a **3x3 matrix**. The goal is to randomly mark numbers, complete lines, and earn rewards. The game features **multipliers for connected lines**, strategic hints to guide the player, and a risk-reward system that keeps the game engaging.

## 🎮 Gameplay Mechanics

- The game is played on a **3x3 grid**:
  ```
  1   4   7  
  6   9   11  
  8   15  21  
  ```
- Each turn, a **random number** from the matrix is selected.
- If the number **is not marked**, it gets **marked**.
- The game continues until all numbers are marked.

## 💰 Winning Conditions

- Completing a **full row or column** grants **money equal to the last number** that completed it.
- If the new line **touches another previously completed line**, a **multiplier is applied**:

  **Win = (Number of connected lines) × (Last number used to complete the line)**
- Multiple lines can be completed in a single turn, increasing the reward potential.

## 🔥 Example Rounds

### Scenario 1: Simple Line Completion

1. **Spin: "4"** → Marked ✅  *(No win yet)*
2. **Spin: "7"** → Marked ✅ *(Still no full row)*
3. **Spin: "1"** → **Row completed!** → **Win: 1** 💰

### Scenario 2: Multiplier Bonus

1. **Spin: "6"** → Marked ✅ *(No win yet)*
2. **Spin: "9"** → Marked ✅ *(Still no full row)*
3. **Spin: "11"** → **Row completed!** → **Win: 11** 💰
4. **Spin: "21"** → **Row + Column completed!** → **Multiplier applied!** → **Win: 42** 🎉

### Hint System

- After every round, the game will display **possible numbers that can complete a line** and their respective **win amounts**.
- Example:
  - If **4 and 7** are marked, the game will suggest **"Mark 1 to complete the row"** and display the **potential win amount (1)**.
  - If **6 and 9** are marked, the game will suggest **"Mark 11 to complete the row"** and display the **potential win amount (11)**.
  - If **15 and 21** are marked, the game will suggest **"Mark 8 to complete the row"** and display the **potential win amount (8)**.

## 🚀 Features

- **Randomized number selection** each round.
- **3x3 slot-style gameplay mechanics.**
- **Line completion for winnings.**
- **Multiplier bonus for connected lines.**
- **Hint system to show possible winning numbers and their respective win amounts.**
- **Risk-reward system with strategic marking.**

## 🛠️ Installation & Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/slot-matrix-game.git
   ```
2. Navigate to the project directory:
   ```bash
   cd slot-matrix-game
   ```
3. Run the game (Java-based implementation):
   ```bash
   javac SlotGame.java
   java SlotGame
   ```

## 📜 License

This project is licensed under the **MIT License**.

## 🤝 Contributions

Feel free to submit **issues, feature requests, or pull requests** to improve the game!

