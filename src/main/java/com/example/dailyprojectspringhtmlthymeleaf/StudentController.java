package com.example.dailyprojectspringhtmlthymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    @RequestMapping("/new_student")
    public String newStudent(Model model) {
        model.addAttribute("grades", Grade.values());
        return "new_student";
    }

    @RequestMapping("/create_student")
    public String createStudent(@RequestParam(value="first_name") String first_name, @RequestParam(value="last_name") String last_name, @RequestParam(value="grade") Grade grade, Model model) {
        Student student = new Student();

        /* set student firstName, lastName and grade using the http request parameters */
        student.setFirstName(first_name);
        student.setLastName(last_name);
        student.setGrade(grade);

        /* add the student to the model that will be used by the view_student html file */
        model.addAttribute("student", student);

        return "view_student";
    }
}
