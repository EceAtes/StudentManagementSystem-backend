package com.testProject.ws.courses;

import com.testProject.ws.shared.ReturnMessage;
import com.testProject.ws.user.UserService;
import org.hibernate.boot.model.relational.Loggable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    //private static final Logger log = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    CourseService cs;

    @CrossOrigin
    @PostMapping("/courses")
    @ResponseStatus(HttpStatus.CREATED)
    public ReturnMessage createCourse(@RequestBody Course course){
        cs.save(course);
        return new ReturnMessage("Course created");
        //log.info(course.toString());
    }


    @GetMapping("/courses")
    List<Course> getCourses(){
        return cs.getCourses();
    }

}
