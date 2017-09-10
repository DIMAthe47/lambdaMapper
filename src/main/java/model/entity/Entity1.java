package model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entity1 {
    private String a;
    private Long b;
    private Enum1 enum1;
    private Enum2 enum2;
}
