package com.example.act3uf2m06.Model;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

public class Hibernate implements HibernateDao {
    private final SessionFactory sessionFactory;

    public Hibernate(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public List<Clients> getAll() {
        try (Session ss = sessionFactory.openSession()){

            List<Clients> clientes = ss.createQuery("SELECT c from Clients c", Clients.class).getResultList();
            ss.close();
            return clientes;
        }

    }

    @Override
    public Clients getById(int id) {

        try (Session ss = sessionFactory.openSession()){
            return ss.get(Clients.class, id);
        }

    }

    @Override
    public void save(Clients c) {
        Transaction ts;
        try (Session ss = sessionFactory.openSession()){
            ts=ss.beginTransaction();
            ss.persist(c);
            ts.commit();
        }
    }
    @Override
    public void delete(Clients c) {
        Transaction ts;
        try (Session ss = sessionFactory.openSession()){
            ts=ss.beginTransaction();

            ss.persist(c);
            ts.commit();
        }
    }
    @Override
    public void update(Clients c) {
        Transaction ts;
        try (Session ss = sessionFactory.openSession()){
             ts=ss.beginTransaction();

            ss.persist(c);
            ts.commit();
        }
    }


}