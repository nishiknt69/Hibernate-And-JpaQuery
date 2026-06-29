package com.example.JPATutorial;

import com.example.JPATutorial.entities.Product;
import com.example.JPATutorial.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.security.PrivateKey;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaTutorialApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepository(){
		Product product = Product.builder()
				.sku("nestle234")
				.title("Nestle Chocolate")
				.price(BigDecimal.valueOf(123.45))
				.quantity(12)
				.build();

		Product savedProduct = productRepository.save(product);
		System.out.println(savedProduct);
	}

	@Test
	void getRepository(){
//		List<Product> entities = productRepository.findAll();

//		List<Product> entities = productRepository.findByTitleLike("%Choco%");
		Optional<Product> entities = productRepository.findByTitleAndPrice("Pepsi", BigDecimal.valueOf(14.4));
		System.out.println(entities);
	}

	@Test
	void getTitle(){
		List<Product> entities = productRepository.findByTitle("Pepsi");
		System.out.println(entities);
	}

	@Test
	void getProductAfterDate(){
		List<Product> entities = productRepository.findByCreatedAtAfter(
				LocalDateTime.of(2024, 1, 1, 0, 0, 0)
		);
		System.out.println(entities);
	}
}
