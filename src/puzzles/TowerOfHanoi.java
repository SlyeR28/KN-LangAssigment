package puzzles;

import player.Player;

import java.util.Scanner;

public class TowerOfHanoi implements Puzzles {

    @Override
    public boolean solve(Player player) {
        System.out.println("Welcome to the Tower of Hanoi challenge!");
        System.out.println("The goal is to move 3 disks from Tower A to Tower C.");
        System.out.println("Rules:");
        System.out.println("1. Only one disk can be moved at a time.");
        System.out.println(
                "2. Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack.");
        System.out.println("3. No disk may be placed on top of a smaller disk.");

        System.out.println("Enter 'start' to begin the simulation or 'skip' to bypass (mock solve).");
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("skip")) {
            System.out.println("You bypassed the puzzle.");
            return true;
        }

        int n = 3; // Number of disks
        solveHanoi(n, 'A', 'C', 'B');

        System.out.println("Puzzle Solved!");
        return true;
    }

    private void solveHanoi(int n, char fromRod, char toRod, char auxRod) {
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + fromRod + " to rod " + toRod);
            return;
        }
        solveHanoi(n - 1, fromRod, auxRod, toRod);
        System.out.println("Move disk " + n + " from rod " + fromRod + " to rod " + toRod);
        solveHanoi(n - 1, auxRod, toRod, fromRod);
    }
}
