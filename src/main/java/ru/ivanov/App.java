package ru.ivanov;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.ivanov.models.Director;
import ru.ivanov.models.Movie;

import java.util.ArrayList;
import java.util.Collections;

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

            Director viktorIvanov = new Director("Viktor Ivanov", 21);
            session.save(viktorIvanov);

            Movie movie = new Movie(viktorIvanov, "How to be a good programmer", 2030);
            session.save(movie);


            viktorIvanov.setMovies(new ArrayList<>(Collections.singletonList(movie)));



            session.getTransaction().commit();
        }
    }
}
