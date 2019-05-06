package database;

public class SaveGameDao extends GenericJpaDao<SaveGame> {

    public SaveGameDao() {
        super(SaveGame.class);
    }

}