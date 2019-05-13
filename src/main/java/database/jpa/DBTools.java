package database.jpa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.google.inject.Guice;
import com.google.inject.Injector;
import database.gamer.Gamer;
import database.gamer.GamerDao;
import database.savegame.SaveGame;
import database.savegame.SaveGameDao;
import guice.PersistenceModule;

/**
 * Class providing functions for database manipulating.
 */
public class DBTools {

    /**
     * Constructor for manipulating the table created for {@link Gamer} entity.
     * @param tmp an instance of {@link Gamer} class.
     */
    public DBTools(Gamer tmp) {
        Injector injector = Guice.createInjector(new PersistenceModule("Gamer"));
        gmd = injector.getInstance(GamerDao.class);
    }

    /**
     * Constructor for manipulating the table created for {@link SaveGame} entity.
     * @param tmp an instance of {@link SaveGame} class.
     */
    public DBTools(SaveGame tmp) {
        Injector injector = Guice.createInjector(new PersistenceModule("SaveGame"));
        sgd = injector.getInstance(SaveGameDao.class);
    }

    /**
     * A {@link SaveGameDao} object.
     */
    private SaveGameDao sgd;
    /**
     * A {@link GamerDao} object.
     */
    private GamerDao gmd;
    /**
     * A {@link Gamer} object.
     */
    private Gamer pgamer;

    /**
     * Inserts a row with the data of the player into the database, if it is not present yet.
     * @param gamer a {@link Gamer} object, which provides data of the player.
     */
    public void addGamer(Gamer gamer) {
        List<Gamer> list=gmd.findAll();

        for (Gamer g : list)
            if(g.getName().equals(gamer.getName()))
                pgamer = g;

        if(pgamer == null)
            gmd.persist(gamer);
        pgamer = null;
    }

    /**
     * Updates the row in the database, which contains the data of player {@code gamer}.
     * @param gamer a {@link Gamer} object, which provides data of the player.
     */
    public void updateGamer(Gamer gamer) {
        List<Gamer> list=gmd.findAll();

        for (Gamer g : list)
            if (g.getName().equals(gamer.getName()) )
                pgamer =g;

            pgamer.setScore(pgamer.getScore()+1);
            gmd.update(pgamer);

        pgamer = null;
    }

    /**
     * Inserts a row with the data representing the state of the game into the database.
     * @param sg a {@link SaveGame} object, which represents the state of the game.
     */
    public void saveGame(SaveGame sg) {
        sgd.persist(sg);
    }

    /**
     * Downloads and removes the row, which has the ID {@code ID}.
     * @param ID an int value, representing the ID of the row, which we will work with.
     * @return the game state, which has been selected to load.
     */
    public SaveGame loadGame(int ID) {
        SaveGame lg = new SaveGame();
        List<SaveGame> list = sgd.findAll();

        for(SaveGame sg : list)
            if(sg.getId() == ID)
                lg = sg;

        sgd.remove(lg);

        return lg;
    }

    /**
     * Selects the top 5 players from the database.
     * @return a list with the top 5 players ordered by the score in descending order.
     */
    public List<Gamer> getTopPlayers() {
        return gmd.findAll().stream().sorted(Comparator.comparingInt(Gamer::getScore).reversed()).limit(5).collect(Collectors.toList());
    }

    /**
     * Selects all the players from the database.
     * @return a list with all the players ordered by score in descending order.
     */
    public List<Gamer> getScoreboard() {
        return gmd.findAll().stream().sorted(Comparator.comparingInt(Gamer::getScore).reversed()).collect(Collectors.toList());
    }

    /**
     * Selects the saved games from the database.
     * @return a list with all the saved games.
     */
    public List<SaveGame> getSaves() {
        return new ArrayList<>(sgd.findAll());
    }

}