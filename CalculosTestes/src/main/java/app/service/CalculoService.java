package app.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dto.Entrada;
import app.entity.Calculo;
import app.repository.CalculoRepository;

@Service
public class CalculoService {

	@Autowired
	private CalculoRepository calculoRepository;

	public Calculo calcular(Entrada entrada) {

		Calculo calculo = new Calculo();
		calculo.setLista(entrada.getLista());
		calculo.setSoma(this.soma(entrada.getLista()));
		calculo.setMedia(this.media(entrada.getLista()));
		calculo.setMediana(this.mediana(entrada.getLista()));
		calculo.setModa (this.moda(entrada.getLista()));

		return calculo;

	}


	public int soma(List<Integer> lista) {
		int soma = 0;
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i) == null)
				throw new RuntimeException("dslçfjakd");
			else
				soma += lista.get(i);
		}
		return soma;
	}


	public double media(List<Integer> lista) {
		return this.soma(lista) / lista.size();
	}


	public double mediana(List<Integer> lista) {
		if (lista == null || lista.isEmpty()) {
	        throw new IllegalArgumentException("A lista não pode ser nula ou vazia");
	    }
		
		Collections.sort(lista);

	    if (lista.size() % 2 == 1) { //ÍMPAR
	        return lista.get(lista.size() / 2);
	    } else {
	        int meio1 = lista.get(lista.size() / 2 - 1);
	        int meio2 = lista.get(lista.size() / 2);
	        return (meio1 + meio2) / 2;
	    }
	}

	  public Integer moda(List<Integer> lista) {
	        if (lista == null || lista.isEmpty()) {
	            throw new IllegalArgumentException("A lista não pode ser nula ou vazia");
	        }

	        Map<Integer, Integer> frequencias = new HashMap<>();
	        for (Integer numero : lista) {
	            frequencias.put(numero, frequencias.getOrDefault(numero, 0) + 1);
	        }

	        int moda = lista.get(0);
	        int maxFreq = 0;

	        for (Map.Entry<Integer, Integer> entry : frequencias.entrySet()) {
	            if (entry.getValue() > maxFreq) {
	                moda = entry.getKey();
	                maxFreq = entry.getValue();
	            }
	        }
	        return moda;
	    }
	  public int multiplicacao (List<Integer> lista) {
			int multiplicacao = 1;
			for (int i = 0; i < lista.size(); i++) {
				if(lista.get(i) == null)
					throw new RuntimeException("erro na multiplicacao");
				else
					multiplicacao *= lista.get(i);
			}
			return multiplicacao;
		}
	  public int divisao (List<Integer> lista) {
		  int divisao = lista.get(0);  // Inicializando com o primeiro elemento da lista
		    for (int i = 1; i < lista.size(); i++) {  
		        if (lista.get(i) == null) {
		            throw new RuntimeException("Erro: valor nulo na lista");
		        } else if (lista.get(i) == 0) {
		            throw new RuntimeException("Erro: divisão por zero");
		        } else {
		            divisao /= lista.get(i);  
		        }
		    }
		    return divisao;
	  }
}