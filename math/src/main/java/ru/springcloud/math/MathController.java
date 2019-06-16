package ru.springcloud.math;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sprincloud.common.Exercise;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RefreshScope
public class MathController {
    @Value("${math.max}")
    private int max;

    @GetMapping("/exercise/random")
    public List<Exercise> mathController(@RequestParam(defaultValue = "3") int amount) {
        int i = getRandom();
        int j = getRandom();
        return IntStream.range(0, amount)
                .mapToObj(value -> Exercise.builder()
                        .question(i + " + " + j + " = ?")
                        .answer("is " + i + j)
                        .build())
                .collect(Collectors.toList());

    }

    private int getRandom() {
        return ThreadLocalRandom.current().nextInt(0, max);
    }
}
