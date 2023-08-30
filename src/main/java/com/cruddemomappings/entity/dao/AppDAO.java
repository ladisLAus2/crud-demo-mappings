package com.cruddemomappings.entity.dao;

import com.cruddemomappings.entity.Instructor;
import com.cruddemomappings.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructor(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);
}
