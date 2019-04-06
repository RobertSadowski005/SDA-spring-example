package eu.szestkam.springmvcfirst.repo;

import eu.szestkam.springmvcfirst.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    public Iterable<Product> findByDescriptionContaining(String description);
}
