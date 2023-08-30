package com.cruddemomappings.entity.dao;

import com.cruddemomappings.entity.Instructor;

public interface AppDAO {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructor(int id);
}
