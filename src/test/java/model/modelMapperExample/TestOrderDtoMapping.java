package model.modelMapperExample;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestOrderDtoMapping {

    @Test
    public void testMapForward() {
        OrderDtoMapper mapper = new OrderDtoMapper();
        Order order = new Order(new Customer(new Name("name1", "name2")), new Address("street1", "city1"));
        OrderDto orderDto = mapper.mapForward(order, OrderDto.class);
        assertEquals(order.getCustomer().getName().getFirstName(), orderDto.getCustomerFirstName());
        assertEquals(order.getCustomer().getName().getLastName(), orderDto.getCustomerLastName());
        assertEquals(order.getBillingAddress().getStreet(), orderDto.getBillingStreet());
        assertEquals(order.getBillingAddress().getCity(), orderDto.getBillingCity());
    }

    @Test
    public void testMapForwardWithNullName() {
        OrderDtoMapper mapper = new OrderDtoMapper();
        Order order = new Order(new Customer(null), new Address("street1", "city1"));
        OrderDto orderDto = mapper.mapForward(order, OrderDto.class);
        assertEquals("undefinedCustomer", orderDto.getCustomerFirstName());
        assertEquals(null, orderDto.getCustomerLastName());
        assertEquals(order.getBillingAddress().getStreet(), orderDto.getBillingStreet());
        assertEquals(order.getBillingAddress().getCity(), orderDto.getBillingCity());
    }

    @Test
    public void testMapBackward() {
        OrderDtoMapper mapper = new OrderDtoMapper();
        OrderDto orderDto = new OrderDto("name1", "name2", "street1", "city1");
        Order order=mapper.mapBackward(orderDto,Order.class);
        assertEquals(order.getCustomer().getName().getFirstName(), orderDto.getCustomerFirstName());
        assertEquals(order.getCustomer().getName().getLastName(), orderDto.getCustomerLastName());
        assertEquals(order.getBillingAddress().getStreet(), orderDto.getBillingStreet());
        assertEquals(order.getBillingAddress().getCity(), orderDto.getBillingCity());
    }
}
