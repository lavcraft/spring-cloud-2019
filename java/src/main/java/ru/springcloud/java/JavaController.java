package ru.springcloud.java;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sprincloud.common.Exercise;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class JavaController {
    List<Exercise> db = new ArrayList<>();

    @PostConstruct
    public void init() {
        db.add(new Exercise("Latest version of java", "12.b13"));
        db.add(new Exercise("Сколько лет Джавке", "больше 20"));
        db.add(new Exercise("На что похожа Джава", "на Cobol"));
        db.add(new Exercise("Разница между Spring, String и Swing", "Да никакой"));
    }

    @GetMapping("/exercise/random")
    public List<Exercise> mathController(@RequestParam(defaultValue = "3") int amount) {
        int i = ThreadLocalRandom.current().nextInt(db.size());

        return IntStream.range(0, amount)
                .mapToObj(value -> db.get(value))
                .collect(Collectors.toList());
    }
}
