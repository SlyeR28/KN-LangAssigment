package room;

import puzzles.MazePuzzle;
import puzzles.Puzzles;


public class RoomFactory {

    public static Room createRoom(){
        Room room = new Room(
                "Maze Chamber" ,
                "A Strange room filled with moving walls"
        );

        Puzzles puzzles = new MazePuzzle();
        room.setPuzzle(puzzles);
        return room;
    }
}
