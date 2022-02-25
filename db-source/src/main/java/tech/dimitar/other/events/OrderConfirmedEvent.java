package tech.dimitar.other.events;

import lombok.Data;

@Data
public class OrderConfirmedEvent {
    private final String orderId;
}