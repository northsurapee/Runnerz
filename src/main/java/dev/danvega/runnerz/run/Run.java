package dev.danvega.runnerz.run;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.Duration;
import java.time.LocalDateTime;

// Data Layer - Model
// Record - which are a special kind of class, help to model plain data aggregates with less ceremony than normal classes.

public record Run(
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        @Positive
        Integer miles,
        Location location
) {

    public Run {
        if (!completedOn.isAfter(startedOn)) {
            throw new IllegalArgumentException("Completed On must be after Started On");
        }
    }

    public Duration getDuration() {
        return Duration.between(startedOn,completedOn);
    }

    public Integer getAvgPace() {
        return Math.toIntExact(getDuration().toMinutes() / miles);
    }

}
