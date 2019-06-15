package ru.springboot;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ExamController {

    @PostMapping("/exam")
    public ExamResponse exam(@RequestBody Map<String, Integer> examSpec) {
        return new ExamResponse();
    }
}
