package utcn.ds.carshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import utcn.ds.carshop.model.User;

import java.math.BigDecimal;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);

    User findById(long userId);
}