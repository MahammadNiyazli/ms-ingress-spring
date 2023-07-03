package com.company.DI.dto.criteria;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PageCriteria {
    Integer page;
    Integer count;
}
