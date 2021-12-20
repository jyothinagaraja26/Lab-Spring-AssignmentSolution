package in.greatlearning.collegefest.service;

import in.greatlearning.collegefest.entities.Student;
import in.greatlearning.collegefest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int theId) {
        return studentRepository.getById(theId);
    }

    @Override
    public void save(Student theStudent) {
        studentRepository.save(theStudent);

    }

    @Override
    public void deleteById(int theId) {

        studentRepository.deleteById(theId);
    }

}
