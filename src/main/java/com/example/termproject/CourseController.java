package com.example.termproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/course")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewUser (
            @RequestParam String courseName,
            @RequestParam Integer courseNumber,
            @RequestParam Integer capacity
    ) {
        Course course = new Course();
        course.setCourseName(courseName);
        course.setCourseNumber(courseNumber);
        course.setCapacity(capacity);
        courseRepository.save(course);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @GetMapping(path="/{Id}")
    public @ResponseBody Optional<Course> getSingleCourse(@PathVariable("Id") Integer Id) {
        return courseRepository.findById(Id);
    }
}
