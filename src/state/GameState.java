package state;

import Game.GameManager;

public interface GameState {

    void handleState(GameManager gameManager);
}
