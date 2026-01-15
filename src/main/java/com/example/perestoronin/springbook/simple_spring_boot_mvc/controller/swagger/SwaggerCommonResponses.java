package com.example.perestoronin.springbook.simple_spring_boot_mvc.controller.swagger;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({ METHOD, TYPE })
@ApiResponse(responseCode = "400", content = {
        @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(
                        implementation = ProblemDetail.class)) })
@ApiResponse(responseCode = "403", content = {
        @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(
                        implementation = ProblemDetail.class)) })
@ApiResponse(responseCode = "404", content = {
        @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(
                        implementation = ProblemDetail.class)) })
public @interface SwaggerCommonResponses {

}
