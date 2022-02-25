package tech.dimitar.other.database.repositories;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import tech.dimitar.other.database.entities.OrderEntity;

import java.util.List;

@Repository
public interface OrderEntityRepository extends CrudRepository<OrderEntity, String > {
    List<OrderEntity> findAll();
}
