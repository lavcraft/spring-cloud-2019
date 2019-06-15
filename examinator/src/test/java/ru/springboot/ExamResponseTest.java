package ru.springboot;

import org.junit.jupiter.api.Test;
import ru.sprincloud.common.Section;

import static org.junit.Assert.*;

public class ExamResponseTest {
    @Test
    void name() {
        //when
        ExamResponse build = ExamResponse.builder()
                .section(new Section())
                .section(new Section())
                .section(new Section())
                .section(new Section())
                .section(new Section())
                .build();

        //then
//        build.getSections().size() == 5;


    }
}
