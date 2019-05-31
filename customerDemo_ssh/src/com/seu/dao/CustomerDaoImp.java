package com.seu.dao;

import com.seu.entity.Customer;
import com.seu.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CustomerDaoImp implements CustomerDao {
    @Override
    public void saveCustomer(Customer customer) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            session.save(customer);
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public List<Customer> findAllCustomer() {
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        try {
            sf = HibernateUtils.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();

            Criteria criteria = session.createCriteria(Customer.class);
            List<Customer> customerList = criteria.list();

            tx.commit();
            return customerList;
        } catch (Exception e) {
            tx.rollback();
        } finally {
            session.close();
        }
        return null;
    }
}

/*
* 如何使用Hibernate来访问数据库？
*
* 第一步：拷贝相关jar包
* 第二步：新建hibernate.cfg.xml配置文件，配置数据库相关信息
* 第三步：新建Customer.hbm.xml配置文件，将映射为表。
*
* 第四步：使用Hibernate提供的接口，实现对数据库的访问
*
* */