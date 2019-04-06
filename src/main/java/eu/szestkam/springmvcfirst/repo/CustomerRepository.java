package eu.szestkam.springmvcfirst.repo;

import eu.szestkam.springmvcfirst.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
