package model.nested;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.simple.A;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class C {
    private A a;
}
