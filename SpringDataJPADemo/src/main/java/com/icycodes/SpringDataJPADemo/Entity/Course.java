package com.icycodes.SpringDataJPADemo.Entity;


import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "course_data", uniqueConstraints = {
        @UniqueConstraint(
                name = "title_unique",
                columnNames = "course_title"
        )
}
)
public class Course{

    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseId;
//
    @Column(name = "course_title" , nullable = false)
//    @NotBlank(message = "Kindly enter a course")
    private String courseTitle;


    @Column(name = "course_credits")
//    @NotBlank(message = "Kindly enter course credits")
//    @Pattern(regexp="(^$|[0-9]{2})")
//    @Range(min=0, max=12)
    private Integer credits;

    @OneToOne(
            mappedBy = "course",
            optional = false,
            orphanRemoval = true
    )
    @NonNull
    private CourseMaterial courseMaterial;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacher_id",
            nullable = false
    )
    @NonNull
    private Teacher teacher;

}
