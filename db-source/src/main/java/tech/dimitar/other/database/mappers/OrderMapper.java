package tech.dimitar.other.database.mappers;

import tech.dimitar.other.database.entities.OrderEntity;
import tech.dimitar.other.query.model.Order;

public final class OrderMapper {
    public static OrderEntity toEntity(final Order order) {
        return new OrderEntity(order.getOrderId(),  order.getProductId(), order.getOrderStatus());
    }

    public static Order toDTO(final OrderEntity entity) {
        return new Order(entity.getOrderId(), entity.getProductId(), entity.getOrderStatus());
    }
}
