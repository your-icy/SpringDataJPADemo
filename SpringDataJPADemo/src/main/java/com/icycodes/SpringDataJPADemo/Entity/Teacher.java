package com.icycodes.SpringDataJPADemo.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "teacher_data")
public class Teacher {

    @SequenceGenerator(name = "teacher_sequence", sequenceName = "teacher_sequence",
            allocationSize = 1)

    @Id
    @Column(name = "teacher_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_sequence")
    private Long teacherId;

    @Column(name = "teacher_first_name" , nullable = false )
    private String firstName;

    @Column(name = "teacher_last_name" , nullable = false)
    private String  lastName;

    /*

    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacher_id"
    )
    private List<Course> courses;


     */

}
