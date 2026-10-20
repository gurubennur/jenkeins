package com.example.demo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/api")
@Tag(name = "Demo API", description = "Simple endpoints for REST API testing")
public class GreetingController {

    @GetMapping("/greeting")
    @Operation(summary = "Get a greeting", description = "Returns a greeting for the supplied name.")
    public GreetingResponse greeting(
            @Parameter(description = "Name to greet", example = "Guruprasad")
            @RequestParam(defaultValue = "World") String name) {
        return new GreetingResponse("Hello, " + name + "!", Instant.now());
    }

    @GetMapping("/status")
    @Operation(summary = "Check API status", description = "Returns a simple status response.")
    public StatusResponse status() {
        return new StatusResponse("UP", "Spring Boot REST API is running");
    }

    public record GreetingResponse(String message, Instant timestamp) {
    }

    public record StatusResponse(String status, String message) {
    }
}
