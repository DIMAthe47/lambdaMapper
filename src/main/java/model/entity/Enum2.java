package model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Enum2 extends AbstractEntityWithLongId {
    public String name2;

    public Enum2(Long id, String name2) {
        super(id);
        this.name2 = name2;
    }
}
