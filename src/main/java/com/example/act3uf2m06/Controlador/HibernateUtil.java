package com.example.act3uf2m06.Controlador;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sF;

    static {
        try {
            Configuration config = new Configuration().configure();
            sF = config.buildSessionFactory();

        } catch (Throwable ex) {

            System.err.println("Error" + ex);

            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getsF() {
        return sF.getCurrentSession();
    }
}