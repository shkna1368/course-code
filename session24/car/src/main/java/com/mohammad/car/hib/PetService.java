package com.mohammad.car.hib;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class PetService {


   // private SessionFactory sessionFactory;

   private Session session;

    @Autowired
    public PetService(EntityManagerFactory factory) {
        if(factory.unwrap(SessionFactory.class) == null){
            throw new NullPointerException("factory is not a hibernate factory");
        }
        this.session = factory.unwrap(SessionFactory.class).openSession();
    }

    public void save(Pet pet){

        Transaction tx1 = session.beginTransaction();
        long id1 = (Long) session.save(pet);
        System.out.println("2. pet save called with transaction, id="+id1);
        System.out.println("3. Before committing save transaction");
        session.flush();
        tx1.commit();
        System.out.println("4. After committing save transaction");

    }

     public void update(Pet pet){


        Transaction tx1 = session.beginTransaction();
         session.update(pet);
        System.out.println("2. pet update called with transaction, id=");
        System.out.println("3. Before committing save transaction");
        tx1.commit();
        System.out.println("4. After committing save transaction");

    }


  public void delete(Pet pet){


      Transaction tx1 = session.beginTransaction();

      // session.merge(pet);
        session.remove(pet);
      tx1.commit();
        System.out.println("1. pet delete called with transaction, id=");

    }




  public List<Pet> getAll(){

      String hql = "FROM Pet p ";

      Query query = session.createQuery(hql);
      List<Pet> results = query.list();

        System.out.println("2. pet delete called with transaction, id=");
        System.out.println("3. Before committing save transaction");

        System.out.println("4. After committing save transaction");

        return results;

    }

    //HQL Named Parameters
  public List<Pet> getAllWithName(String title){

      String hql = "FROM Pet where title= :title";
      Query query = session.createQuery(hql);
      query.setParameter("title",title);

      List<Pet> results = query.list();



        return results;

    }

//hql paiging
public List<Pet> getAllWithPaging(){

      String hql = "FROM Pet";
      Query query = session.createQuery(hql);
      query.setFirstResult(1);
      query.setMaxResults(10);
      List<Pet> results = query.list();



        return results;

    }



//hql NamedQuery
public List<Pet> getAllWithNamedQuery1(){

      Query query = session.getNamedQuery("pet.findAll");
      List<Pet> results = query.list();
        return results;
    }





//hql NamedQuery
public List<Pet> getAllWithNamedQuery2(String title){


      Query query = session.getNamedQuery("pet.findByName");
query.setParameter("title",title);
      List<Pet> results = query.list();

        return results;

    }











}
