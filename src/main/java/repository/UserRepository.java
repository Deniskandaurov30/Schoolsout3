package repository;

import model.User;

import javax.persistence.EntityManager;
import java.util.List;

public class UserRepository {

    public User findUserByLogin(String login){
        EntityManager entityManager = EMFactory.getEMF().createEntityManager();
        return entityManager.find(User.class, login);
    }

    public List<User> getAllUsers(){
        EntityManager entityManager = EMFactory.getEMF().createEntityManager();
        List<User> users= entityManager.createQuery("Select u From User u").getResultList();
        return users;

    }

    public List<User> getAllActiveUsers(){
        EntityManager entityManager = EMFactory.getEMF().createEntityManager();
        List<User> users= entityManager.createQuery("Select b From User b Where b.active = true").getResultList();
        return users;

    }

    public void createUser (User user){

        EntityManager entityManager = EMFactory.getEMF().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();


    }

    public void updateUser(User user) {

        EntityManager entityManager = EMFactory.getEMF().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
    }

    public void deleteUser (User user){

        EntityManager entityManager = EMFactory.getEMF().createEntityManager();
        entityManager.getTransaction().begin();
        User foundUser = entityManager.find(User.class,user.getLogin());
        entityManager.remove(foundUser);
        entityManager.getTransaction().commit();
    }
}
