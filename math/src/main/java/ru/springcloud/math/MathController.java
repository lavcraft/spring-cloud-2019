package ru.springcloud.math;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sprincloud.common.Exercise;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequiredArgsConstructor
public class MathController {
    private final MathProperties mathProperties;

    @GetMapping("/exercise/random")
    public List<Exercise> mathController(@RequestParam(defaultValue = "3") int amount) {
        int i = ThreadLocalRandom.current().nextInt(0, mathProperties.getMax());
        int j = ThreadLocalRandom.current().nextInt(0, mathProperties.getMax());
        return IntStream.range(0, amount)
                .mapToObj(value -> Exercise.builder()
                        .question(i + " + " + j + " = ?")
                        .answer("is " + i + j)
                        .build())
                .collect(Collectors.toList());

    }
}
