package com.company.DI.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountSaveRequest {
     String accountNo;
     String currency;
     Long customerId;
}
