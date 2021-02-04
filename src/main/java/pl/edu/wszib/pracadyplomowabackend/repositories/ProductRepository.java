package pl.edu.wszib.pracadyplomowabackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.wszib.pracadyplomowabackend.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
