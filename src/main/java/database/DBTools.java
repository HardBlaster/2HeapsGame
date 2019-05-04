package database;

import java.util.List;

import com.google.inject.Guice;
import com.google.inject.Injector;
import game.Gamer;
import guice.PersistenceModule;


public class DBTools {

    public DBTools() {
        Injector injector = Guice.createInjector(new PersistenceModule("test"));
        gmd = injector.getInstance(GamerDao.class);
    }

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

}





