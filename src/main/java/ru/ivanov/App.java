package ru.ivanov;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.ivanov.models.Director;
import ru.ivanov.models.Movie;

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


            Movie movie = session.get(Movie.class, 14);
            session.remove(movie);

            Director director = session.get(Director.class, 7);


            session.getTransaction().commit();
        }
    }
}
