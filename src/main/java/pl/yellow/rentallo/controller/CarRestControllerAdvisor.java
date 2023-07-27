package pl.yellow.rentallo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.yellow.rentallo.dto.ResponseDto;
import pl.yellow.rentallo.exception.WrongCarIdException;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class CarRestControllerAdvisor {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(WrongCarIdException.class)
    public ResponseDto handleCarNotFoundException(WrongCarIdException exc) {
        String path = getCurrentRequestPath();


        return ResponseDto.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .error("Not found")
                .message(exc.getMessage())
                .path(path)
                .build();
    }

    private static String getCurrentRequestPath() {
        return ServletUriComponentsBuilder.fromCurrentRequest().build().getPath();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseDto handleBadRequest(MethodArgumentNotValidException exc) {
        String path = getCurrentRequestPath();

        return ResponseDto.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .path(path)
                .message(exc.getMessage())
                .build();
    }
}
