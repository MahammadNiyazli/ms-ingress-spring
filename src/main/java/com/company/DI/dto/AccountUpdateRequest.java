package com.company.DI.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountUpdateRequest extends AccountSaveRequest{
    String specialistName;
    String specialistSurname;
}
