package model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entity1Dto {
    private String a;
    private Long b;
    private Long enum1Id;
    private Long enum2Id;
}
