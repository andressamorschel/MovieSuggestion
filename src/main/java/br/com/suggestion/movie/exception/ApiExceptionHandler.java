package br.com.suggestion.movie.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TemperatureNotFoundException.class)
    public ResponseEntity<?> handleTemperatureNotFoundException(TemperatureNotFoundException ex,
                                                                WebRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;

        var apiError = ApiError.builder()
                .detail(ex.getMessage())
                .status(status.value())
                .title(status.getReasonPhrase())
                .build();

        return handleExceptionInternal(ex, apiError, new HttpHeaders(),
                status, request);
    }

    @ExceptionHandler(ErrorSearchingMoviesException.class)
    public ResponseEntity<?> handleErrorSearchingMoviesException(ErrorSearchingMoviesException ex,
                                                                 WebRequest request){
        HttpStatus status = HttpStatus.BAD_GATEWAY;

        var apiError = ApiError.builder()
                .detail(ex.getMessage())
                .status(status.value())
                .title(status.getReasonPhrase())
                .build();

        return handleExceptionInternal(ex, apiError, new HttpHeaders(),
                status, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body,
                                                             HttpHeaders headers,
                                                             HttpStatus status,
                                                             WebRequest request) {


        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

}
