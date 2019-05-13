/* $$ This file has been instrumented by Clover 4.3.1#20180921211537623 $$ */package database.jpa;

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
public class DBTools {public static class __CLR4_3_122jvm9ui1t{public static com_atlassian_clover.CoverageRecorder R;public static com_atlassian_clover.CloverProfile[] profiles = { };@java.lang.SuppressWarnings("unchecked") public static <I, T extends I> I lambdaInc(final int i,final T l,final int si){java.lang.reflect.InvocationHandler h=new java.lang.reflect.InvocationHandler(){public java.lang.Object invoke(java.lang.Object p,java.lang.reflect.Method m,java.lang.Object[] a) throws Throwable{R.inc(i);R.inc(si);try{return m.invoke(l,a);}catch(java.lang.reflect.InvocationTargetException e){throw e.getCause()!=null?e.getCause():new RuntimeException("Clover failed to invoke instrumented lambda",e);}}};return (I)java.lang.reflect.Proxy.newProxyInstance(l.getClass().getClassLoader(),l.getClass().getInterfaces(),h);}static{com_atlassian_clover.CoverageRecorder _R=null;try{com_atlassian_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___4_3_1();if(20180921211537623L!=com_atlassian_clover.CloverVersionInfo.getBuildStamp()){com_atlassian_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_atlassian_clover.Clover.l("[CLOVER] WARNING: Instr=4.3.1#20180921211537623,Runtime="+com_atlassian_clover.CloverVersionInfo.getReleaseNum()+"#"+com_atlassian_clover.CloverVersionInfo.getBuildStamp());}R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getRecorder("\u002f\u0068\u006f\u006d\u0065\u002f\u0062\u0061\u0062\u006c\u0061\u006e\u002f\u0044\u006f\u006b\u0075\u006d\u0065\u006e\u0074\u0075\u006d\u006f\u006b\u002f\u0073\u0077\u0065\u002f\u0050\u0072\u006f\u006a\u0065\u006b\u0074\u0032\u002e\u0030\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1557746165572L,8589935092L,48,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}public static final com_atlassian_clover.TestNameSniffer __CLR4_3_1_TEST_NAME_SNIFFER=com_atlassian_clover.TestNameSniffer.NULL_INSTANCE;

    /**
     * Constructor for manipulating the table created for {@link Gamer} entity.
     * @param tmp an instance of {@link Gamer} class.
     */
    public DBTools(Gamer tmp) {try{__CLR4_3_122jvm9ui1t.R.inc(2);
        __CLR4_3_122jvm9ui1t.R.inc(3);Injector injector = Guice.createInjector(new PersistenceModule("Gamer"));
        __CLR4_3_122jvm9ui1t.R.inc(4);gmd = injector.getInstance(GamerDao.class);
    }finally{__CLR4_3_122jvm9ui1t.R.flushNeeded();}}

    /**
     * Constructor for manipulating the table created for {@link SaveGame} entity.
     * @param tmp an instance of {@link SaveGame} class.
     */
    public DBTools(SaveGame tmp) {try{__CLR4_3_122jvm9ui1t.R.inc(5);
        __CLR4_3_122jvm9ui1t.R.inc(6);Injector injector = Guice.createInjector(new PersistenceModule("SaveGame"));
        __CLR4_3_122jvm9ui1t.R.inc(7);sgd = injector.getInstance(SaveGameDao.class);
    }finally{__CLR4_3_122jvm9ui1t.R.flushNeeded();}}

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
    public void addGamer(Gamer gamer) {try{__CLR4_3_122jvm9ui1t.R.inc(8);
        __CLR4_3_122jvm9ui1t.R.inc(9);List<Gamer> list=gmd.findAll();

        __CLR4_3_122jvm9ui1t.R.inc(10);for (Gamer g : list)
            {__CLR4_3_122jvm9ui1t.R.inc(11);if((((g.getName().equals(gamer.getName()))&&(__CLR4_3_122jvm9ui1t.R.iget(12)!=0|true))||(__CLR4_3_122jvm9ui1t.R.iget(13)==0&false)))
                {__CLR4_3_122jvm9ui1t.R.inc(14);pgamer = g;

        }}__CLR4_3_122jvm9ui1t.R.inc(15);if((((pgamer == null)&&(__CLR4_3_122jvm9ui1t.R.iget(16)!=0|true))||(__CLR4_3_122jvm9ui1t.R.iget(17)==0&false)))
            {__CLR4_3_122jvm9ui1t.R.inc(18);gmd.persist(gamer);
        }__CLR4_3_122jvm9ui1t.R.inc(19);pgamer = null;
    }finally{__CLR4_3_122jvm9ui1t.R.flushNeeded();}}

    /**
     * Updates the row in the database, which contains the data of player {@code gamer}.
     * @param gamer a {@link Gamer} object, which provides data of the player.
     */
    public void updateGamer(Gamer gamer) {try{__CLR4_3_122jvm9ui1t.R.inc(20);
        __CLR4_3_122jvm9ui1t.R.inc(21);List<Gamer> list=gmd.findAll();

        __CLR4_3_122jvm9ui1t.R.inc(22);for (Gamer g : list)
            {__CLR4_3_122jvm9ui1t.R.inc(23);if ((((g.getName().equals(gamer.getName()) )&&(__CLR4_3_122jvm9ui1t.R.iget(24)!=0|true))||(__CLR4_3_122jvm9ui1t.R.iget(25)==0&false)))
                {__CLR4_3_122jvm9ui1t.R.inc(26);pgamer =g;

            }}__CLR4_3_122jvm9ui1t.R.inc(27);pgamer.setScore(pgamer.getScore()+1);
            __CLR4_3_122jvm9ui1t.R.inc(28);gmd.update(pgamer);

        __CLR4_3_122jvm9ui1t.R.inc(29);pgamer = null;
    }finally{__CLR4_3_122jvm9ui1t.R.flushNeeded();}}

    /**
     * Inserts a row with the data representing the state of the game into the database.
     * @param sg a {@link SaveGame} object, which represents the state of the game.
     */
    public void saveGame(SaveGame sg) {try{__CLR4_3_122jvm9ui1t.R.inc(30);
        __CLR4_3_122jvm9ui1t.R.inc(31);sgd.persist(sg);
    }finally{__CLR4_3_122jvm9ui1t.R.flushNeeded();}}

    /**
     * Downloads and removes the row, which has the ID {@code ID}.
     * @param ID an int value, representing the ID of the row, which we will work with.
     * @return the game state, which has been selected to load.
     */
    public SaveGame loadGame(int ID) {try{__CLR4_3_122jvm9ui1t.R.inc(32);
        __CLR4_3_122jvm9ui1t.R.inc(33);SaveGame lg = new SaveGame();
        __CLR4_3_122jvm9ui1t.R.inc(34);List<SaveGame> list = sgd.findAll();

        __CLR4_3_122jvm9ui1t.R.inc(35);for(SaveGame sg : list)
            {__CLR4_3_122jvm9ui1t.R.inc(36);if((((sg.getId() == ID)&&(__CLR4_3_122jvm9ui1t.R.iget(37)!=0|true))||(__CLR4_3_122jvm9ui1t.R.iget(38)==0&false)))
                {__CLR4_3_122jvm9ui1t.R.inc(39);lg = sg;

        }}__CLR4_3_122jvm9ui1t.R.inc(40);sgd.remove(lg);

        __CLR4_3_122jvm9ui1t.R.inc(41);return lg;
    }finally{__CLR4_3_122jvm9ui1t.R.flushNeeded();}}

    /**
     * Selects the top 5 players from the database.
     * @return a list with the top 5 players ordered by the score in descending order.
     */
    public List<Gamer> getTopPlayers() {try{__CLR4_3_122jvm9ui1t.R.inc(42);
        __CLR4_3_122jvm9ui1t.R.inc(43);return gmd.findAll().stream().sorted(Comparator.comparingInt(Gamer::getScore).reversed()).limit(5).collect(Collectors.toList());
    }finally{__CLR4_3_122jvm9ui1t.R.flushNeeded();}}

    /**
     * Selects all the players from the database.
     * @return a list with all the players ordered by score in descending order.
     */
    public List<Gamer> getScoreboard() {try{__CLR4_3_122jvm9ui1t.R.inc(44);
        __CLR4_3_122jvm9ui1t.R.inc(45);return gmd.findAll().stream().sorted(Comparator.comparingInt(Gamer::getScore).reversed()).collect(Collectors.toList());
    }finally{__CLR4_3_122jvm9ui1t.R.flushNeeded();}}

    /**
     * Selects the saved games from the database.
     * @return a list with all the saved games.
     */
    public List<SaveGame> getSaves() {try{__CLR4_3_122jvm9ui1t.R.inc(46);
        __CLR4_3_122jvm9ui1t.R.inc(47);return new ArrayList<>(sgd.findAll());
    }finally{__CLR4_3_122jvm9ui1t.R.flushNeeded();}}

}