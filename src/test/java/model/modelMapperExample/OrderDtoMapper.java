package model.modelMapperExample;

import core.base.Mapper;

public class OrderDtoMapper extends Mapper<Order, OrderDto> {
    @Override
    protected void internalForwardMap(Order source, OrderDto target) {
        propertyMap(() -> source.getCustomer().getName().getFirstName(), (n) -> target.setCustomerFirstName(n));
        propertyMap(() -> source.getCustomer().getName().getLastName(), (n) -> target.setCustomerLastName(n));
        propertyMap(() -> source.getBillingAddress().getCity(), (n) -> target.setBillingCity(n));
        propertyMap(() -> source.getBillingAddress().getStreet(), (n) -> target.setBillingStreet(n));
    }

    @Override
    protected void internalBackwardMap(OrderDto source, Order target) {
    }
}
