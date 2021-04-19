package utcn.ds.carshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utcn.ds.carshop.model.Car;

import javax.transaction.Transactional;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    Car findById(long id);

    List<Car> findByTypeContainingIgnoreCase(String titleContaining);

    List<Car> findByYear(long year);

    List<Car> findByStatus(String status);
}
