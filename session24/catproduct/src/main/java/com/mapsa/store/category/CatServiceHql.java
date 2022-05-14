package com.mapsa.store.category;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class CatServiceHql {


   // private SessionFactory sessionFactory;

   private Session session;

    @Autowired
    public CatServiceHql(EntityManagerFactory factory) {
        if(factory.unwrap(SessionFactory.class) == null){
            throw new NullPointerException("factory is not a hibernate factory");
        }
        this.session = factory.unwrap(SessionFactory.class).openSession();
    }

    public void save(Category category){

        Transaction tx1 = session.beginTransaction();
        long id1 = (Long) session.save(category);
        System.out.println("2. pet save called with transaction, id="+id1);
        System.out.println("3. Before committing save transaction");
        session.flush();
        tx1.commit();
        System.out.println("4. After committing save transaction");

    }

     public void update(Category category){


        Transaction tx1 = session.beginTransaction();
         session.update(category);
        System.out.println("2. pet update called with transaction, id=");
        System.out.println("3. Before committing save transaction");
        tx1.commit();
        System.out.println("4. After committing save transaction");

    }


  public void delete(Category category){


      Transaction tx1 = session.beginTransaction();

      // session.merge(pet);
        session.remove(category);
      tx1.commit();
        System.out.println("1. pet delete called with transaction, id=");

    }




  public List<Category> getAll(){

      String hql = "FROM Category p ";

      Query query = session.createQuery(hql);
      List<Category> results = query.list();

        System.out.println("2. pet delete called with transaction, id=");
        System.out.println("3. Before committing save transaction");

        System.out.println("4. After committing save transaction");

        return results;

    }

    //HQL Named Parameters
  public List<Category> getAllWithName(String title){

      String hql = "FROM Category where title= :title";
      Query query = session.createQuery(hql);
      query.setParameter("title",title);

      List<Category> results = query.list();



        return results;

    }

//hql paiging
public List<Category> getAllWithPaging(){

      String hql = "FROM Category";
      Query query = session.createQuery(hql);
      query.setFirstResult(1);
      query.setMaxResults(5);
      List<Category> results = query.list();



        return results;

    }



//hql NamedQuery
public List<Category> getAllWithNamedQuery1(){

      Query query = session.getNamedQuery("cat.findAll");
      List<Category> results = query.list();
        return results;
    }





//hql NamedQuery
public List<Category> getAllWithNamedQuery2(String title){


      Query query = session.getNamedQuery("cat.findByName");
query.setParameter("title",title);
      List<Category> results = query.list();

        return results;

    }











}
