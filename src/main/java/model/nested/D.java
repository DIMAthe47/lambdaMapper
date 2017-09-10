package model.nested;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.simple.B;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class D {
    private B b;
}
