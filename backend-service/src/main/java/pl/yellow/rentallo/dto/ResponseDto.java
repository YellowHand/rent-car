package pl.yellow.rentallo.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ResponseDto(LocalDateTime timestamp, int status, String error, String message, String path) {

}
