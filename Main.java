package org.example;

import java.util.*;
/**
 * Processes the 8 input numbers, removes them from the grid, and calculates winnings.
 */
public class Main {

    private static int processMoves(Scanner scanner, Map<Integer, int[]> numberPositionMap,
                                    List<Set<Integer>> rowSets, List<Set<Integer>> columnSets) {
        System.out.println("Enter 8 numbers to check:");
        Set<Integer> potentialWinningNumbers = new HashSet<>();
        int verticalWinCount = 0, horizontalWinCount = 0, totalWinnings = 0;

        for (int i = 0; i < 8; i++) {
            int number = scanner.nextInt();
            if (!numberPositionMap.containsKey(number)) continue; // Ignore numbers not in grid

            boolean isWinningMove = false;
            int row = numberPositionMap.get(number)[0];
            int col = numberPositionMap.get(number)[1];

            // Remove from row set
            rowSets.get(row).remove(number);
            if (rowSets.get(row).size() == 1) {
                potentialWinningNumbers.add(rowSets.get(row).iterator().next());
            } else if (rowSets.get(row).isEmpty()) {
                verticalWinCount++;
                isWinningMove = true;
            }

            // Remove from column set
            columnSets.get(col).remove(number);
            if (columnSets.get(col).size() == 1) {
                potentialWinningNumbers.add(columnSets.get(col).iterator().next());
            } else if (columnSets.get(col).isEmpty()) {
                horizontalWinCount++;
                isWinningMove = true;
            }

            if (isWinningMove) {
                potentialWinningNumbers.remove(number);
                int winAmount = calculateWinAmount(number, verticalWinCount, horizontalWinCount);
                System.out.println("🎉 Winning move! You earned " + winAmount + " points.");
                totalWinnings += winAmount;
            }

            if (!potentialWinningNumbers.isEmpty()) {
                System.out.print("⚠️ You are one step away from winning with these numbers: ");
                for (int num : potentialWinningNumbers) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }

        return totalWinnings;
    }


    /**
     * Calculates the win amount based on the current win counts.
     */
    private static int calculateWinAmount(int number, int verticalWinCount, int horizontalWinCount) {
        return (verticalWinCount == 0 || horizontalWinCount == 0) ? number : number * (verticalWinCount + horizontalWinCount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Initialize the 3x3 grid and supporting data structures
        int[][] grid = new int[3][3]; // 3x3 matrix for storing values
        Map<Integer, int[]> numberPositionMap = new HashMap<>(); // Stores (number -> {row, col})
        List<Set<Integer>> rowSets = new ArrayList<>(3); // Stores numbers in each row
        List<Set<Integer>> columnSets = new ArrayList<>(3); // Stores numbers in each column

        for (int i = 0; i < 3; i++) {
            rowSets.add(new HashSet<>());
            columnSets.add(new HashSet<>());
        }

        initializeGrid(scanner, grid, numberPositionMap, rowSets, columnSets); // Read grid input

        // Step 2: Process input numbers and determine winnings
        int totalWinnings = processMoves(scanner, numberPositionMap, rowSets, columnSets);

        // Step 3: Display final winnings
        System.out.println("Total winnings: " + totalWinnings);
        scanner.close();
    }

    /**
     * Reads the 3x3 grid values and initializes the supporting data structures.
     */
    private static void initializeGrid(Scanner scanner, int[][] grid, Map<Integer, int[]> numberPositionMap,
                                       List<Set<Integer>> rowSets, List<Set<Integer>> columnSets) {
        System.out.println("Enter the 3x3 grid values:");
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                grid[row][col] = scanner.nextInt();
                numberPositionMap.put(grid[row][col], new int[]{row, col});
                rowSets.get(row).add(grid[row][col]);
                columnSets.get(col).add(grid[row][col]);
            }
        }
    }
}
