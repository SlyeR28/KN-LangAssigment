package state;

import Game.GameManager;
import puzzles.MazePuzzle;
import puzzles.TowerOfHanoi;

public class ExploringState implements GameState {
    @Override
    public void handleState(GameManager gameManager) {
        System.out.println("\nWhat would you like to do?");
        System.out.println("1. Show Inventory");
        System.out.println("2. Solve Puzzle (Enter the Maze)");
        System.out.println("3. Solve Tower of Hanoi");
        System.out.println("4. Quit");
        System.out.print("> ");

        String input = gameManager.getScanner().nextLine();

        switch (input) {
            case "1":
                gameManager.getPlayer().showInventory();
                break;
            case "2":
                System.out.println("You approach the massive door. It requires solving a maze...");
                MazePuzzle puzzle = new MazePuzzle();
                boolean solved = puzzle.solve(gameManager.getPlayer());
                if (solved) {
                    gameManager.changeState(new WinState());
                } else {
                    System.out.println("You failed the puzzle. Try again.");
                }
                break;
            case "3":
                System.out.println("You enter a room with three pillars...");
                TowerOfHanoi hanoi = new TowerOfHanoi();
                hanoi.solve(gameManager.getPlayer());
                // After solving, stay in exploring state logic or maybe grant an item?
                // For now, just a puzzle room to visit.
                break;
            case "4":
                gameManager.changeState(new ExitState());
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
    }
}
