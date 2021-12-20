package in.greatlearning.collegefest.controller;

import in.greatlearning.collegefest.entities.Student;
import in.greatlearning.collegefest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;



    // add mapping for "/list"

    @RequestMapping("/list")
    public String listStudents(Model theModel) {

        // get students from db
        List<Student> theStudents = studentService.findAll();

        // add to the spring model
        theModel.addAttribute("Student", theStudents);

        return "Student-list";
    }

    @RequestMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Student theStudent = new Student();

        theStudent.setId(0);
        theModel.addAttribute("Student", theStudent);

        return "Student-form";
    }

    @RequestMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("studentId") Integer theId,
                                    Model theModel) {

        // get the Book from the service
        Student theStudent = studentService.findById(theId);


        // set Book as a model attribute to pre-populate the form
        theModel.addAttribute("Student", theStudent);

        // send over to our form
        return "Student-form";
    }


    @PostMapping("/save")
    public String saveStudent(@RequestParam("id") Integer id,
                           @RequestParam("name") String name,@RequestParam("country") String country,@RequestParam("department") String department) {

        System.out.println(id);
        Student theStudent;
        if(id!=0)
        {
            theStudent =studentService.findById(id);
            theStudent.setName(name);
            theStudent.setCountry(country);
            theStudent.setDepartment(department);
        }
        else
            theStudent =new Student(name,country, department);
        // save the students
        studentService.save(theStudent);


        // use a redirect to prevent duplicate submissions
        return "redirect:/students/list";

    }


    @RequestMapping("/delete")
    public String delete(@RequestParam("studentId") Integer theId) {

        // delete the Student
        studentService.deleteById(theId);

        // redirect to /Student/list
        return "redirect:/students/list";
    }

    @RequestMapping(value = "/403")
    public ModelAndView accesssDenied(Principal user) {
        ModelAndView model = new ModelAndView();
        if (user != null) {
            model.addObject("msg", "Hi " + user.getName()
                    + ", you do not have permission to access this page!");
        } else {
            model.addObject("msg",
                    "You do not have permission to access this page!");
        }
        model.setViewName("403");
        return model;
    }


}