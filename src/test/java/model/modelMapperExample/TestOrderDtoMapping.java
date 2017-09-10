package model.modelMapperExample;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestOrderDtoMapping {

    @Test
    public void test() {
        OrderDtoMapper mapper = new OrderDtoMapper();
        Order order = new Order(new Customer(new Name("name1", "name2")), new Address("street1", "city1"));
        OrderDto orderDto = mapper.map(order, OrderDto.class);
        assertEquals(order.getCustomer().getName().getFirstName(), orderDto.getCustomerFirstName());
        assertEquals(order.getCustomer().getName().getLastName(), orderDto.getCustomerLastName());
        assertEquals(order.getBillingAddress().getStreet(), orderDto.getBillingStreet());
        assertEquals(order.getBillingAddress().getCity(), orderDto.getBillingCity());
    }
}
