package br.com.alura.escola.dominio.aluno;

import br.com.alura.escola.dominio.aluno.exceptions.NumeroMaximoDeTelefones;
import org.junit.jupiter.api.Test;

import br.com.alura.escola.dominio.aluno.Telefone;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TelefoneTest {

	@Test
	void naoDeveriaCriarTelefoneComDDDsInvalidos() {
		assertThrows(IllegalArgumentException.class,
				() -> new Telefone(null, "123456789"));
		
		assertThrows(IllegalArgumentException.class,
				() -> new Telefone("", "123456789"));
		
		assertThrows(IllegalArgumentException.class,
				() -> new Telefone("1", "123456789"));
	}

	@Test
	void naoDeveriaCriarTelefoneComNumerosInvalidos() {
		assertThrows(IllegalArgumentException.class,
				() -> new Telefone("11", null));
		
		assertThrows(IllegalArgumentException.class,
				() -> new Telefone("11", ""));
		
		assertThrows(IllegalArgumentException.class,
				() -> new Telefone("11", "123"));
	}

	@Test
	void deveriaPermitirCriarTelefoneComDDDENumeroValidos() {
		String ddd = "11";
		String numero = "123456789";
		Telefone telefone = new Telefone(ddd, numero);
		assertEquals(ddd, telefone.getDdd());
		assertEquals(numero, telefone.getNumero());
	}

	@Test
	void naoDeveriaPermirtirCriarMaisDeDoisTelefones() throws NumeroMaximoDeTelefones {
		String ddd = "79";
		String ddd2 = "11";
		String ddd3 = "11";
		String numero = "123456789";
		String numero2 = "987654321";
		String numero3 = "124578963";
		Aluno aluno = new Aluno(null, "kaio", null);
		aluno.adicionarTelefone(ddd2, numero2);
		aluno.adicionarTelefone(ddd, numero);

		assertThrows(NumeroMaximoDeTelefones.class, () -> {
			aluno.adicionarTelefone(ddd3, numero3);
		});
	}
}
