package jpa;


import sample.Score;

public class ScoreDao extends GenericJpaDao<Score> {

    public ScoreDao() {
        super(Score.class);
    }

}