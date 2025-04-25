package app.service.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import app.service.CalculoService;

@SpringBootTest
public class CalculoServiceTest {
	@Autowired
	CalculoService calculoService;

	@Test
	@DisplayName("Cena 01 - Testando o método somar com valores válidos")
	void cenario01() {
		List<Integer> lista = new ArrayList<>();
		lista.add(3);
		lista.add(5);
		lista.add(2);
		
		int resultadoEsperado = 10;
		int resultadoObtido = this.calculoService.soma(lista);
		
		assertEquals(resultadoEsperado, resultadoObtido);
	}
	

	@Test
	@DisplayName("Cena 02 - Testando o método somar com valores inválidos")
	void cenario02() {
		List<Integer> lista = new ArrayList<>();
		lista.add(3);
		lista.add(null);
		lista.add(2);
				
		assertThrows(Exception.class,() -> {
			this.calculoService.soma(lista);
		});
		
		
	}
	
	
	
	
	@Test
	@DisplayName("Cena 03 - Testar mediana com número par de elementos")
	void cenario03() {
		List<Integer> lista = new ArrayList<>();
		lista.add(3);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		
		assertEquals(3, this.calculoService.mediana(lista));
	}
	
	@Test
	@DisplayName("Cena 04 - Testar mediana com número ímpar de elementos")
	void cenario04() {
		List<Integer> lista = new ArrayList<>();
		lista.add(3);
		lista.add(2);
		lista.add(1);
		lista.add(9);
		lista.add(4);
		
		assertEquals(3, this.calculoService.mediana(lista));
	}
	
	
	@Test
	@DisplayName("Cena 05 - Testar mediana com número ímpar de elementos")
	void cenario05() {
		List<Integer> lista = new ArrayList<>();
		lista.add(8);
		lista.add(2);
		lista.add(1);
		lista.add(9);
		lista.add(39);
		lista.add(339);
		lista.add(4);
		
		assertEquals(8, this.calculoService.mediana(lista));
	}
	
	@Test
	@DisplayName("Cena 06 - Testar maior numero da lista") 
	void cenario06() {
		List <Integer> lista = new ArrayList <> ();
		lista.add(9);
		lista.add(4);
		lista.add(7);
		lista.add(3);
		lista.add(1);
		
		int maior = Collections.max(lista);
		System.out.println("Maior número da lista: " + maior);
		assertThat(maior).isEqualTo(9);
		
	}

	@Test
	@DisplayName("Cena 07 - Testar menor numero da lista") 
	void cenario07() {
		
		List <Integer> lista = new ArrayList <> ();
		lista.add(9);
		lista.add(4);
		lista.add(7);
		lista.add(3);
		lista.add(1);
	
	int menor = Collections.min(lista);
	System.out.println("Menor número da lista: " + menor);
	assertThat(menor).isEqualTo(1);
	
}
	@Test
	@DisplayName("Cena 08 - Testar numero total de elementos da lista")
	void cenario08() {
		
		List<Integer> lista = new ArrayList <> ();
		lista.add(19);
		lista.add(7);
		lista.add(89);
		lista.add(17);
		lista.add(72);
		
		
		System.out.println("Total de elementos da lista é: " + lista.size());
		assertEquals(5, lista.size());
	}
	
	@Test
	@DisplayName("Cena 09 - Testar qual é o numero da moda da lista")
	void cenario09() {
		List<Integer> lista = new ArrayList <> ();
		lista.add(3);
		lista.add(9);
		lista.add(9);
		lista.add(9);
		lista.add(3);
		lista.add(7);
		

		Integer resultadoModa = calculoService.moda(lista);
	    
	    System.out.println("Total da moda é: " + resultadoModa);
	    assertEquals(9, resultadoModa);

	}
	
	@Test
	@DisplayName("Cena 10 - Testando o método de multiplicaçao dos meus valores")
	void cenario10() {
		List<Integer> lista = new ArrayList<>();
		lista.add(3);
		lista.add(5);
		
		int resultadoEsperado = 15;
		int resultadoObtido = this.calculoService.multiplicacao(lista);
		
	    System.out.println("Total da multiplicação é: " + resultadoObtido);
		assertEquals(resultadoEsperado, resultadoObtido);
	}
	
	@Test
	@DisplayName("Cena 11 - Testando o método de divisao dos meus valores")
	void cenario11() {
		List<Integer> lista = new ArrayList<>();
		lista.add(50);
		lista.add(2);
		
		int resultadoEsperado = 25;
		int resultadoObtido = this.calculoService.divisao(lista);
		
	    System.out.println("Total da divisao é: " + resultadoObtido);
		assertEquals(resultadoEsperado, resultadoObtido);
	}
	
	@Test
	@DisplayName(" Cena 12 - Deve lançar excecao ao dividir por zero")
	void cenario12() {
	    List<Integer> lista = new ArrayList <> ();
	    lista.add(15);
	    lista.add(0);
	    
	    RuntimeException exception = assertThrows(RuntimeException.class, () -> {
	        calculoService.divisao(lista);
	    });

	    System.out.println("Erro: divisão por zero ");
	    assertEquals("Erro: divisão por zero", exception.getMessage());
	}
}