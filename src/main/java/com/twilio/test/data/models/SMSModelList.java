package com.twilio.test.data.models;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SMSModelList {

    List<SMSModel> SMSModelList;
}