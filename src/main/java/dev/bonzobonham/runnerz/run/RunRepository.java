package dev.bonzobonham.runnerz.run;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class RunRepository {

    private final List<Run> runs = new ArrayList<>();

    List<Run> findAll() {
        return runs;
    }

    Optional<Run> findById(String id) {
        return runs.stream()
                .filter(run -> run.id().equals(id))
                .findFirst();
    }

    void createRun(Run run) {
        runs.add(run);
    }

    void update(Run run, String id) {
        Optional<Run> existingRun = findById(id);
        if (existingRun.isPresent()) {
            runs.set(runs.indexOf(existingRun.get()), run);
        }
    }

    void delete(String id) {
        Optional<Run> existingRun = findById(id);
        existingRun.ifPresent(run -> runs.remove(run));
    }

    @PostConstruct
    private void init() {
        runs.add(new Run("1",
                "Morning Run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(30, ChronoUnit.MINUTES),
                5.0,
                Location.OUTDOOR));
        runs.add(new Run("2",
                "Evening Run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(30, ChronoUnit.MINUTES),
                5.0,
                Location.OUTDOOR));

    }
}
