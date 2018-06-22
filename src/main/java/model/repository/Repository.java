/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.repository;

import database.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author rafae
 */
public class Repository {

    protected Session session = null;
    protected Transaction transaction = null;

    protected void beginSession() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    protected void closeSession() {
        if (session != null) {
            session.close();
        }
    }

}
