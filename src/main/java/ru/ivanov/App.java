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

            Director lizaKazakova = new Director("Liza Kazakova", 22);
            session.save(lizaKazakova);

            Movie movie = session.get(Movie.class, 5);
            movie.setDirector(lizaKazakova);

            session.save(movie);


            session.getTransaction().commit();
        }
    }
}
