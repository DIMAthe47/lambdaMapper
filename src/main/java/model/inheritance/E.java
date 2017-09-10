package model.inheritance;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class E extends EParent {
    private String e3;

    public E(String e1, String e2, String e3) {
        super(e1, e2);
        this.e3 = e3;
    }
}
