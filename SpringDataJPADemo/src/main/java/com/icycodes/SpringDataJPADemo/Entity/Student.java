package com.icycodes.SpringDataJPADemo.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "student_data", uniqueConstraints = {
        @UniqueConstraint(
                name = "email_id_unique",
                columnNames = "email_id"
        ),
        @UniqueConstraint(
                name = "phone_number_unique",
                columnNames = "phone_number"
        )
}
)
public class Student {

    @SequenceGenerator(name = "mySequence1", sequenceName = "mySequence1",
            allocationSize = 1)


    @Id
    @Column(name ="studentId" )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySequence1")
    private Long studentId;

    @Column(name ="first_name" )
    @NotBlank(message = "kindly enter your last name")
    private String firstName;

    @Column(name ="last_name" )
    @NotBlank(message = "kindly enter your last name")
    private String lastName;


    @Column(name ="email_id" )
    @Email(message = "Please enter a valid email")
    private String emailId;


    @Column(name ="phone_number" )
    @Pattern(regexp="(^$|[0-9]{10})")
    private Long phoneNumber;


    /*


    @Column(name="gurdian_name")
    @NotBlank(message = "please enter a gurdian name")
    private String gurdianName;

    @Column(name="gurdian_email")
    @NotBlank(message = "please enter an email id")
    private String gurdianEmail;

    @Column(name="gurdian_phone_number")
    @Pattern(regexp="(^$|[0-9]{10})")
    private Long gurdianPhoneNumber;



     */

    @Embedded
    private Gurdian gurdian;
}
