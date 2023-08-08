package com.company.account_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "account")
@Data
//@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @Column(name = "account_id")
    //@GeneratedValue (strategy = GenerationType.IDENTITY)
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "user_sequence"),
                    @Parameter(name = "initial_value", value = "100041"),
                    @Parameter(name = "increment_size", value = "2")
            }
    )
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "email_id")
    private String emailId;
    @Column(name = "phone_number")
    private Integer phoneNumber;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
}
