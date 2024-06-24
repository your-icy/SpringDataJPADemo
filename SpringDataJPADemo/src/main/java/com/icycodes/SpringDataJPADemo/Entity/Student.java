package com.icycodes.SpringDataJPADemo.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
@Table(name = "student_data", uniqueConstraints = {
        @UniqueConstraint(
                name = "email_id_unique",
                columnNames = "email_id"
        )
}
)
public class Student {

    @SequenceGenerator(name = "mySequence1", sequenceName = "mySequence1",
            allocationSize = 1)


    @Id
    @Column(name ="studentId", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySequence1")
    private Long studentId;

    @Column(name ="first_name", nullable = false )
//    @NotBlank(message = "kindly enter your last name")
    private String firstName;

    @Column(name ="last_name" ,nullable=false )
//    @NotBlank(message = "kindly enter your last name")
    private String lastName;


    @Column(name ="email_id", nullable = false)
    private String emailId;


    @Column(name ="phone_number" , nullable = false )
    private String phoneNumber;

/*

    @Column(name="guardian_name")
//    @NotBlank(message = "please enter a gurdian name")
    private String guardianName;

    @Column(name="guardian_email")
//    @NotBlank(message = "please enter an email id")
    private String guardianEmail;

    @Column(name="guardian_phone_number")
//    @Pattern(regexp="(^$|[0-9]{10})")
    private String guardianPhoneNumber;

 */

    @Embedded
    private Guardian guardian;
}
