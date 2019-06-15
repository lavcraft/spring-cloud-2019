package ru.sprincloud.common;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Section {
    @Singular
    private List<Exercise> exercises;
}
