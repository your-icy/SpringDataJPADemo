package com.icycodes.SpringDataJPADemo.Entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(
                name = "gurdian_name",
                column = @Column(name = "gurdian_name")
        ),
        @AttributeOverride(
                name = "gurdian_email",
                column = @Column(name = "gurdian_email")
        ),
        @AttributeOverride(
                name = "gurdian_phone_number",
                column = @Column(name = "gurdian_phone_number")
        )
})

public class Gurdian {

    @Column(name="gurdian_name")
    @NotBlank(message = "please enter a gurdian name")
    private String gurdianName;

    @Column(name="gurdian_email")
    @NotBlank(message = "please enter an email id")
    private String gurdianEmail;

    @Column(name="gurdian_phone_number")
    @Pattern(regexp="(^$|[0-9]{10})")
    private long gurdianPhoneNumber;
}
