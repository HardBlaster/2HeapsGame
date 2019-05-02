package sample;

import com.google.inject.Guice;
import com.google.inject.Injector;

import guice.PersistenceModule;
import jpa.ScoreDao;

public class ScoreTest {

    public static void main(String[] args) 	{
        Injector injector = Guice.createInjector(new PersistenceModule("test"));
        ScoreDao scoredao = injector.getInstance(ScoreDao.class);

        Score score1 = Score.builder().player_name("test1").score(10).build();
        scoredao.persist(score1);
        /*Todo todo1 = Todo.builder()
                .description("Buy beer")
                .priority(Todo.Priority.NORMAL)
                .tags(Lists.newArrayList("shopping"))
                .build();
        System.out.println(todo1);

        Todo todo2 = Todo.builder()
                .description("Do homework")
                .priority(Todo.Priority.HIGH)
                .dueDate(LocalDate.now().plusWeeks(1))
                .tags(Lists.newArrayList("school", "programming"))
                .build();
        System.out.println(todo2);

        todoDao.persist(todo1);
        todoDao.persist(todo2);
        System.out.println(todo1);
        System.out.println(todo2);

        System.out.println("Unfinished tasks: " + todoDao.findUnfinished());
        System.out.println("High priority tasks: " + todoDao.findByPriority(Todo.Priority.HIGH));

        todoDao.remove(todo2);
        System.out.println("All tasks: " + todoDao.findAll());

        todo1.setDone(true);
        todoDao.update(todo1);
        System.out.println("All tasks: " + todoDao.findAll());*/
    }

}