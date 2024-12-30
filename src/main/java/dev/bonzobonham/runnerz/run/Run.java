package dev.bonzobonham.runnerz.run;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

//Record: Class with data and accesors, inmutable, equals, hashcode, toString, all args constructor
public record Run(
    Integer id,
    @NotEmpty
    String title,
    LocalDateTime startedOn,
    LocalDateTime completedOn,
    @Positive
    double miles,
    Location location
) {
    
    public Run {
        if (!completedOn.isAfter(startedOn)) {
            throw new IllegalArgumentException("Run must be completed after it starts");
        }
    }

}
