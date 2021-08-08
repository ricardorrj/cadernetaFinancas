package com.ricardo.controlefinancas;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ricardo.controlefinancas.domain.Categoria;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}
	
	
	@Test
	public void teste01() {
		Categoria cat1 = new Categoria(null, "Categoria Teste");
			
		System.out.println(cat1);
	}


}
