package model.modelMapperExample;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    String customerFirstName;
    String customerLastName;
    String billingStreet;
    String billingCity;
}
