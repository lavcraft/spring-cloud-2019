package ru.springboot;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.sprincloud.common.Exercise;
import ru.sprincloud.common.Section;

import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

@RestController
@RequiredArgsConstructor
public class ExamController {
    private final ExamProperties examProperties;
    private final RestTemplate   restTemplate;

    @PostMapping("/exam")
    public ExamResponse exam(@RequestBody Map<String, Integer> examSpec) {
        Map<String, String> urlMap = examProperties.getServiceNameToUrl();

        return new ExamResponse(examSpec.entrySet().stream()
                .map(entry -> Section.builder()
                        .title(entry.getKey())
                        .exercises(
                                asList(restTemplate.getForObject(
                                        urlMap.get(entry.getKey()) + "/exercise/random?amount=" + entry.getValue(),
                                        Exercise[].class))
                        )
                        .build()

                ).collect(Collectors.toList())
        );
    }
}
