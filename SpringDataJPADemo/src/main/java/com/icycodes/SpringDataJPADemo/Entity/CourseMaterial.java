package com.icycodes.SpringDataJPADemo.Entity;

import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@ToString(exclude = "course")
@Table(name = "course_material")
public class CourseMaterial {


    @Id
    @Column(name = "course_material_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseMaterialId;

    @Column(name = "course_material_url", unique = true, nullable = false)
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(name = "course_id",referencedColumnName = "course_id",nullable = false)
    @NonNull
    private Course course;


}
