package com.twilio.test.data.models;

import lombok.*;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="SMSModel")
public class SMSModel {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "message")
    private String message;

    @Column(name = "toPhoneNumber")
    private String toPhoneNumber;

    @Column(name = "fromPhoneNumber")
    private String fromPhoneNumber;

    @Column(name = "messageSentSuccess")
    private Boolean messageSentSuccess;
}