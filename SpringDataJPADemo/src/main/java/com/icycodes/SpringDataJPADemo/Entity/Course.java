package com.icycodes.SpringDataJPADemo.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

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

    @SequenceGenerator(name = "mySequence2", sequenceName = "mySequence2",
            allocationSize = 1)

    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySequence2")
    private Long courseId;

    @Column(name = "course_title")
    @NotBlank(message = "Kindly enter a course")
    private String courseTitle;


    @Column(name = "course_credits")
    @NotBlank(message = "Kindly enter course credits")
    @Pattern(regexp="(^$|[0-9]{2})")
    @Range(min=0, max=12)
    private Integer credits;

}
