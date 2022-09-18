package com.testProject.ws.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    CourseRepository cr;

    public CourseService(CourseRepository cr) {
        this.cr = cr;
    }

    public void save(Course course) {
        cr.save(course);
    }

    public List<Course> getCourses() {
        return cr.findAll();
    }
}
