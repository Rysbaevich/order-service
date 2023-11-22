package kg.orderservice.dto.response;

import org.springframework.http.HttpStatus;

public record SimpleResponse (
        HttpStatus httpStatus,
        String message
){
}
