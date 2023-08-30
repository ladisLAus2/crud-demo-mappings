package com.cruddemomappings.entity.dao;


import com.cruddemomappings.entity.Instructor;
import com.cruddemomappings.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAOImplementaion implements AppDAO{

    private EntityManager entityManager;

    public AppDAOImplementaion(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructor(int id) {
        entityManager.remove(entityManager.find(Instructor.class,id));
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class,id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {

        InstructorDetail detail = entityManager.find(InstructorDetail.class,id);
        detail.getInstructor().setInstructorDetail(null);
        entityManager.remove(detail);
    }
}
