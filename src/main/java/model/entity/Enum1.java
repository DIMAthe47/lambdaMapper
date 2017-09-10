package model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Enum1 extends AbstractEntityWithLongId {
    public String name1;

    public Enum1(Long id, String name1) {
        super(id);
        this.name1 = name1;
    }
}
