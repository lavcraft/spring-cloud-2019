package ru.springboot;

import lombok.*;
import lombok.experimental.Accessors;
import ru.sprincloud.common.Section;

import java.util.List;

@Data
@Builder
@Accessors(chain= true)
@NoArgsConstructor
@AllArgsConstructor
public class ExamResponse {
    @Singular
    private List<Section> sections;
}
