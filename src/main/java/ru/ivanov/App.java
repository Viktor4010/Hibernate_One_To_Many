package ru.ivanov;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.ivanov.models.Director;
import ru.ivanov.models.Movie;

import java.util.ArrayList;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Director.class)
                .addAnnotatedClass(Movie.class)
                .buildSessionFactory();

             Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();

            Director director = session.get(Director.class, 2);
            Movie catchMeIfYouCan = new Movie(director, "Catch me if you can", 2002);
            Movie survival = new Movie(director, "Survival", 2020);

            session.save(catchMeIfYouCan);
            session.save(survival);

            ArrayList<Movie> movies = new ArrayList<>();
            movies.add(catchMeIfYouCan);
            movies.add(survival);

            director.setMovies(movies);



            session.getTransaction().commit();
        }
    }
}
