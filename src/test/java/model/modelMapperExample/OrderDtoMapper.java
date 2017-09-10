package model.modelMapperExample;

import core.base.Mapper;

public class OrderDtoMapper extends Mapper<Order, OrderDto> {
    @Override
    protected void internalForwardMap(Order source, OrderDto target) {
        propertyMapWithDefault(() -> source.getCustomer().getName().getFirstName(), (n) -> target.setCustomerFirstName(n), "undefinedCustomer");
        propertyMap(() -> source.getCustomer().getName().getLastName(), (n) -> target.setCustomerLastName(n));
        propertyMap(() -> source.getBillingAddress().getCity(), (n) -> target.setBillingCity(n));
        propertyMap(() -> source.getBillingAddress().getStreet(), (n) -> target.setBillingStreet(n));
    }

    @Override
    protected void internalBackwardMap(OrderDto source, Order target) {
        propertyMap(() -> source.getCustomerFirstName(), (n) -> target.getCustomer().getName().setFirstName(n));
        propertyMap(() -> source.getCustomerLastName(), (n) -> target.getCustomer().getName().setLastName(n));
        propertyMap(() -> source.getBillingCity(), (n) -> target.getBillingAddress().setCity(n));
        propertyMap(() -> source.getBillingStreet(), (n) -> target.getBillingAddress().setStreet(n));
    }
}
