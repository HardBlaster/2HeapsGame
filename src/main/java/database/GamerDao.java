package database;

import java.util.List;

import com.google.inject.persist.Transactional;

public class GamerDao extends GenericJpaDao<Gamer> {

    public GamerDao() {
        super(Gamer.class);
    }


    /*@Transactional
    public List<Gamer> listOf(String name, String type) {
        return entityManager.createQuery("SELECT t FROM Gamer t WHERE t.name ="+name+" and t.type="+type, Gamer.class).getResultList();
    }*/

}