package com.company.DI.dto.response.base;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BaseResponse <T>{
    int httpStatus;
    String message;
    T object;



    public  static <T> BaseResponse<T> success(T object){
        return of(200,"success", object);
    }

    public  static <T> BaseResponse<T> success(){
        return of(200,"success", null);
    }

    public static <T> BaseResponse<T> of(int httpStatus, String message, T object){
        return BaseResponse.<T>builder()
                .httpStatus(httpStatus)
                .message(message)
                .object(object)
                .build();
    }
}
