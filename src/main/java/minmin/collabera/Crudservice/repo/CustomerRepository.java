package minmin.collabera.Crudservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import minmin.collabera.Crudservice.model.Customers;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Long> {

}
