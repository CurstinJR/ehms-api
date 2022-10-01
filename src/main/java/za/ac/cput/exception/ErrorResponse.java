package za.ac.cput.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * @Author Curstin Rose - 220275408
 * ErrorResponse.java
 * 2022/10/01
 */
@AllArgsConstructor
@Builder
@Getter
public class ErrorResponse {
    private int statusCode;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime timestamp;
    private Object message;
    private String description;
}
