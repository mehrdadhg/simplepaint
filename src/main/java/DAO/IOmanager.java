package DAO;

import model.Shape;
import model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IOmanager {
    private static SessionFactory factory ;
    private static Session session;
    private static Transaction transaction;

    public static SessionFactory getFactory() {
        return factory;
    }

    public static Session getSession() {
        return session;
    }

    public static Transaction getTransaction() {
        return transaction;
    }

    public static void open(){
        try {
            factory = new Configuration().configure().buildSessionFactory();
            session = factory.openSession();
            transaction=session.beginTransaction();
        }catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public static void addUser(User emp) {
        try {
            session.save(emp);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void editUser(User emp) {
        try {
            session.update(emp);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void deleteUser(User emp) {
        try {
            session.delete(emp);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static  void deleteUser(int tid) {
        try {
            //session.createQuery("delete from model.User where id=:uid").setParameter("uid",tid).executeUpdate();
            session.delete(session.get(User.class, tid));
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static  ArrayList<Object> getShapes(int userID) {
        List list=null;
        ArrayList<Object> objects=new ArrayList<Object>();
        ArrayList<Shape> shapes=new ArrayList<Shape>();
        try {
            open();
            //user = session.get(User.class, id);
            Query query= session.createQuery("from model.Line where userID='" + userID + "'");
            list=query.list();
            query= session.createQuery("from model.Circle where userID='" + userID + "'");
            list.add(query.list());
             query= session.createQuery("from model.Rect where userID='" + userID + "'");
            list.add(query.list());
            for (int i = 0; i <list.size() ; i++) {
                objects.add(list.get(i));
            }
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return objects;
    }

    public static void insertShapes(ArrayList<Shape> shapes) {
        try {
            for (Shape shape:shapes) {
                session.save(shape);
            }
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static   User getUser(String uName) {
        User user = null;
        try {
            open();
            //user = session.get(User.class, id);
            Query query= session.createQuery("from model.User where uName='" + uName + "'");
           List list=query.list();
           user=(User) list.get(0);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }

}


