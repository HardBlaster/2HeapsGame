package game;

import database.gamer.Gamer;
import database.jpa.DBTools;
import database.savegame.SaveGame;

import static game.Controller.*;

/**
 * Provides functions for manipulating the game state.
 */
class Game {
    /**
     * {@link Gamer} object created to work with player data.
     */
    private Gamer tmp_gs;
    /**
     * {@link SaveGame} object created to work with the data of the state of the game.
     */
    private SaveGame tmp_sg;
    /**
     * {@link DBTools} object created to manipulate the SaveGame table in the database.
     */
    private DBTools sg = new DBTools(tmp_sg);
    /**
     * {@link DBTools} object created to manipulate the Gamer table in the database.
     */
    private DBTools gs = new DBTools(tmp_gs);

    /**
     * Function which inserts the {@code SaveGame} object into the database.
     * @param player1 name of the first player.
     * @param player2 name of the second player.
     * @param rocks_in_heap1 amount of rock in the first heap.
     * @param rocks_in_heap2 amount of rock in the second heap.
     * @param player1_status status of the first gamer. Can be active if {@code player1} goes next or inactive otherwise.
     */
    void saveGame(String player1, String player2, int rocks_in_heap1, int rocks_in_heap2, boolean player1_status) {
        tmp_sg = new SaveGame();

        tmp_sg.setPlayer1(player1);
        tmp_sg.setPlayer2(player2);

        tmp_sg.setRocks1(rocks_in_heap1);
        tmp_sg.setRocks2(rocks_in_heap2);

        if(player1_status)
            tmp_sg.setActivePlayer(true);
        else
            tmp_sg.setActivePlayer(false);

        sg.saveGame(tmp_sg);
    }

    /**
     * Takes the given amount of rocks from the heap(s).
     * @param th_heap ID of the heap from which the player takes the rocks. In the case of both heaps is active
     *                this number can be anything, but 1 or 2.
     * @param num_of_rocks amount of rock the player wants to take.
     */
    void takeFromHeap(int th_heap, int num_of_rocks) {
        if(th_heap == 1)
            rocks1 -= num_of_rocks;
        else
        if(th_heap == 2)
            rocks2 -= num_of_rocks;
        else {
            rocks1 -= num_of_rocks;
            rocks2 -= num_of_rocks;
        }
    }

    /**
     * Decides if it is a winner situation or not.
     * @param rock1 amount of rocks in the first heap.
     * @param rock2 amount of rocks in the second heap.
     * @return a boolean value, {@code true} if winner situation, {@code false} if not winner situation.
     */
    boolean isWinSituation(int rock1, int rock2) {
        return rock1 == 0 && rock2 == 0;
    }

    /**
     * Ads {@code Gamer} object to the table with {@code addGamer(Gamer gamer)} function,
     * then updates the winner with {@code updateGamer(Gamer gamer)} function.
     * @param winner the name of the player, which won the game.
     * @param looser the name of the player, which lost the game.
     */
    void refreshGamer(String winner, String looser) {
        tmp_gs = new Gamer();

        tmp_gs.setName(winner);
        gs.addGamer(tmp_gs);
        gs.updateGamer(tmp_gs);

        tmp_gs = new Gamer();
        tmp_gs.setName(looser);
        gs.addGamer(tmp_gs);
    }

    /**
     * Loads in the game, which is given as a parameter.
     * @param selected the {@code SaveGame} object to load.
     */
    void loadSelectedGame(SaveGame selected) {
        Controller.playerID1 = selected.getPlayer1();
        Controller.playerID2 = selected.getPlayer2();
        rocks1 = selected.getRocks1();
        rocks2 = selected.getRocks2();
        if(selected.isActivePlayer()) {
            Controller.player1_status = true;
            Controller.player2_status = false;
        }
        else {
            Controller.player1_status = false;
            Controller.player2_status = true;
        }
    }
}