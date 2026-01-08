package puzzles;

import player.Player;

import java.util.Random;

public class MazePuzzle implements Puzzles {

    private static final int SIZE = 9;
    private int[][] maze =  new int[SIZE][SIZE];
    private int keyRow;
    private int keyCol;

    @Override
    public boolean solve(Player player) {
        generateMaze();
        placeKey();
        maze[SIZE - 1][SIZE - 1] = 3; // exit

        System.out.println("Maze Puzzle Started (9x9)");
        System.out.println("Rule: Reach the key first, then reach the exit (8,8)");

        boolean[][] visited = new boolean[SIZE][SIZE];

        if (!canReach(0, 0, keyRow, keyCol, visited)) {
            System.out.println("❌ Cannot reach the key.");
            return false;
        }

        visited = new boolean[SIZE][SIZE]; // reset visited

        if (!canReach(keyRow, keyCol, SIZE - 1, SIZE - 1, visited)) {
            System.out.println("❌ Cannot reach the exit after key.");
            return false;
        }

        System.out.println("🎉 Key collected and exit reached. Door unlocked!");
        return true;
    }

    private void generateMaze(){
        Random rand = new Random();
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                maze[i][j] = rand.nextInt(100)<70?1:0;
            }
        }
        maze[0][0] = 1;
        maze[SIZE-1][SIZE-1] = 1;
    }

    private void placeKey(){
        Random rand = new Random();
        do {
            keyRow = rand.nextInt(SIZE);
            keyCol = rand.nextInt(SIZE);
        } while (maze[keyRow][keyCol] == 0 || (keyRow == 0 && keyCol == 0));

        maze[keyRow][keyCol] = 2;
    }

    private boolean canReach(int sr, int sc, int tr, int tc, boolean[][] visited) {
        if (sr < 0 || sc < 0 || sr >= SIZE || sc >= SIZE ||
                maze[sr][sc] == 0 || visited[sr][sc]) {
            return false;
        }

        if (sr == tr && sc == tc) return true;

        visited[sr][sc] = true;

        return canReach(sr + 1, sc, tr, tc, visited) ||
                canReach(sr - 1, sc, tr, tc, visited) ||
                canReach(sr, sc + 1, tr, tc, visited) ||
                canReach(sr, sc - 1, tr, tc, visited);
    }
}
