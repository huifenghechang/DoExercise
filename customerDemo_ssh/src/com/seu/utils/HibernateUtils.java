package com.seu.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    public static Configuration cfg = null;
    public static SessionFactory sessionFactory = null;

    //静态代码块
    static {
        cfg = new Configuration();
        cfg.configure();
        sessionFactory = cfg.buildSessionFactory();
    }

    public static Session getSessionObject(){
        return sessionFactory.getCurrentSession();
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

