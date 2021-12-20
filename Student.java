package in.greatlearning.collegefest.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Integer id;

    private String name;

    private String country;

    private String department;

    public Student(String name, String country, String department) {
        this.name = name;
        this.country = country;
        this.department = department;
    }
}
