package database.savegame;

import database.jpa.GenericJpaDao;

/**
 * DAO class for the {@link SaveGame} entity.
 */
public class SaveGameDao extends GenericJpaDao<SaveGame> {

    public SaveGameDao() {
        super(SaveGame.class);
    }

}