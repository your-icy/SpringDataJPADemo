package com.icycodes.SpringDataJPADemo.Entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(
                name = "guardianName",
                column = @Column(name = "guardian_name")
        ),
        @AttributeOverride(
                name = "guardianEmail",
                column = @Column(name = "guardian_email")
        ),
        @AttributeOverride(
                name = "guardianPhoneNumber",
                column = @Column(name = "guardian_phone_number")
        )
})
@Embeddable
public class Guardian {

    @Column(name="guardian_name" , nullable = false)
    @NonNull
//    @NotBlank(message = "please enter a gurdian name")
    private String name;

    @Column(name="guardian_email", nullable = false)
    @NonNull
//    @NotBlank(message = "please enter an email id")
    private String email;

    @Column(name="guardian_phone_number" , nullable = false)
    @NonNull
//    @Pattern(regexp="(^$|[0-9]{10})")
    private String phoneNumber;

}
