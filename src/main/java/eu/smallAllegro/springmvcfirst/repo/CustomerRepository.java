package eu.smallAllegro.springmvcfirst.repo;

import eu.smallAllegro.springmvcfirst.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
