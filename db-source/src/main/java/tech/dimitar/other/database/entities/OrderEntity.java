package tech.dimitar.other.database.entities;

import lombok.*;
import tech.dimitar.other.query.model.OrderStatus;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderEntity {

    @Id
    private String orderId;

    private String productId;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

}
