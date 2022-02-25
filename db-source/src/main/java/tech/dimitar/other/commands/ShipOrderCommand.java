package tech.dimitar.other.commands;

import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
public class ShipOrderCommand {
    @TargetAggregateIdentifier
    private final String orderId;
}