package com.example.JPATutorial.repository;

import com.example.JPATutorial.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByTitle(String pepsi);

    List<Product> findByCreatedAtAfter(LocalDateTime after);

    List<Product> findByTitleLike(String title);

    @Query("select e from Product e where e.title=?1 and e.price=?2")
    Optional<Product> findByTitleAndPrice(String title, BigDecimal price);
}
