package ru.sprincloud.common;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Section {
    private String title;
    @Singular
    private List<Exercise> exercises;
}
