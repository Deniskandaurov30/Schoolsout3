package repository;


import model.Person;

import javax.persistence.EntityManager;
import java.util.List;

public class PersonRepository {

    public Person findUserByLogin(String login){
        EntityManager entityManager = EMFactory.getEMF().createEntityManager();
        return entityManager.find(Person.class, login);
    }

    public List<Person> getAllUsers(){
        EntityManager entityManager = EMFactory.getEMF().createEntityManager();
        List<Person> users= entityManager.createQuery("Select u From person u").getResultList();
        return users;

    }

    public List<Person> getAllActiveUsers(){
        EntityManager entityManager = EMFactory.getEMF().createEntityManager();
        List<Person> users= entityManager.createQuery("Select b From Person b Where b.active = true").getResultList();
        return users;

    }

    public void createUser (Person person){

        EntityManager entityManager = EMFactory.getEMF().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();


    }

    public void updateUser(Person person) {

        EntityManager entityManager = EMFactory.getEMF().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(person);
        entityManager.getTransaction().commit();
    }

    public void deleteUser (Person person){

        EntityManager entityManager = EMFactory.getEMF().createEntityManager();
        entityManager.getTransaction().begin();
        Person foundUser = entityManager.find(Person.class,person.getId());
        entityManager.remove(foundUser);
        entityManager.getTransaction().commit();
    }
}
