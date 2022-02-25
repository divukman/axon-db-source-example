package tech.dimitar.other.services;

import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;
import tech.dimitar.other.database.mappers.OrderMapper;
import tech.dimitar.other.database.repositories.OrderEntityRepository;
import tech.dimitar.other.events.OrderCreatedEvent;
import tech.dimitar.other.query.model.Order;
import tech.dimitar.other.query.queries.FindAllOrderedProductsQuery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrdersEventHandler {

    private final OrderEntityRepository orderEntityRepository;
    private final Map<String, Order> orders = new HashMap<>();

    @EventHandler
    public void on(OrderCreatedEvent event) {
        String orderId = event.getOrderId();
        orderEntityRepository.save(OrderMapper.toEntity(new Order(orderId, event.getProductId())));
    }

    @QueryHandler
    public List<Order> handle(FindAllOrderedProductsQuery query) {
       return orderEntityRepository.findAll().stream().map(el -> OrderMapper.toDTO(el)).collect(Collectors.toList());
    }

    // Event Handlers for OrderConfirmedEvent and OrderShippedEvent...
}