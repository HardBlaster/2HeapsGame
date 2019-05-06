package database;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.google.inject.Guice;
import com.google.inject.Injector;
import guice.PersistenceModule;


public class DBTools {

    public DBTools(Gamer tmp) {
        Injector injector = Guice.createInjector(new PersistenceModule("Gamer"));
        gmd = injector.getInstance(GamerDao.class);
    }


    public DBTools(SaveGame tmp) {
        Injector injector = Guice.createInjector(new PersistenceModule("SaveGame"));
        sgd = injector.getInstance(SaveGameDao.class);
    }

    private SaveGameDao sgd;
    private GamerDao gmd;
    private Gamer pgamer;

    public void addGamer(Gamer gamer) {
        List<Gamer> list=gmd.findAll();

        for (Gamer g : list)
            if(g.getName().equals(gamer.getName()))
                pgamer = g;

        if(pgamer == null)
            gmd.persist(gamer);

        pgamer = null;

    }

    public void updateGamer(Gamer gamer) {
        List<Gamer> list=gmd.findAll();

        for (Gamer g : list)
            if (g.getName().equals(gamer.getName()) )
                pgamer =g;

            pgamer.setScore(pgamer.getScore()+1);
            gmd.update(pgamer);

        pgamer = null;
    }

    public void saveGame(SaveGame sg) {
        sgd.persist(sg);
    }

    public SaveGame loadGame(int ID) {
        SaveGame lg = new SaveGame();
        List<SaveGame> list = sgd.findAll();

        for(SaveGame sg : list)
            if(sg.getId() == ID)
                lg = sg;

        sgd.remove(lg);

        return lg;
    }

    public List<Gamer> getTopPlayers() {
        return gmd.findAll().stream().sorted(Comparator.comparingInt(Gamer::getScore).reversed()).limit(5).collect(Collectors.toList());
    }

    public List<Gamer> getScoreboard() {
        return gmd.findAll().stream().sorted(Comparator.comparingInt(Gamer::getScore).reversed()).collect(Collectors.toList());
    }

}





