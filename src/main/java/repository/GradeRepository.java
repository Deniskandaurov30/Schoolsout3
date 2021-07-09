package repository;

import model.Grade;
import model.User;

import javax.persistence.EntityManager;
import java.util.List;

public class GradeRepository {

    public Grade findGradeByLogin(String login){
        EntityManager entityManager = EMFactory.getEMF().createEntityManager();
        return entityManager.find(Grade.class, login);
    }

    public List<Grade> getAllGrades(){
        EntityManager entityManager = EMFactory.getEMF().createEntityManager();
        List<User> users= entityManager.createQuery("Select u From User u").getResultList();
        return getAllGrades();
    }

    public List<Grade> getAllActiveGrades(){
        EntityManager entityManager = EMFactory.getEMF().createEntityManager();
        List<Grade> grades= entityManager.createQuery("Select b From User b Where b.active = true").getResultList();
        return grades;

    }

    public void createGrade (Grade grade) {

        EntityManager entityManager = EMFactory.getEMF().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(grade);
        entityManager.getTransaction().commit();
    }

    public void updateGrade(Grade grade) {

        EntityManager entityManager = EMFactory.getEMF().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(grade);
        entityManager.getTransaction().commit();
    }

    public void deleteGrade (Grade grade){

        EntityManager entityManager = EMFactory.getEMF().createEntityManager();
        entityManager.getTransaction().begin();
        User foundUser = entityManager.find(User.class,grade.getGradeValue());
        entityManager.remove(foundUser);
        entityManager.getTransaction().commit();
    }




}
