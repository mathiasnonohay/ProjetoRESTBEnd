package com.teste.apirestteste.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/apitest")
public class ListaResource {

	@GetMapping("listaReversa/lista={numeros}")
	public String[] listaReversa(@PathVariable String[] numeros) {
		int i = 0;
		int j = numeros.length - 1;

		while (i < j) {
			inverte(numeros, i, j);
			i++;
			j--;
		}

		return numeros;
	}
	/* http://localhost:8080/apitest/listaReversa/lista={21,285,25,24,12,87,86} */

	@GetMapping("imprimirImpares/lista={numeros}")
	public Integer[] imprimirImpares(@PathVariable Integer[] numeros) {
		Integer[] rImpar = impares(numeros);

		return rImpar;
	}
	/* http://localhost:8080/apitest/imprimirImpares/lista=1,2,3,4,5,6,7,8,9,10 */

	@GetMapping("imprimirPares/lista={numeros}")
	public Integer[] imprimirPares(@PathVariable Integer[] numeros) {
		Integer[] vPar = pares(numeros);

		return vPar;
	}
	/* http://localhost:8080/apitest/imprimirPares/lista=1,2,3,4,5,6,7,8,9,10 */

	@GetMapping("tamanho/palavra={palavra}")
	public Integer tamanhoPalavra(@PathVariable String palavra) {
		Integer tamanho = 0;
		tamanho = palavra.length();

		return tamanho;
	}
	/* http://localhost:8080/apitest/tamanho/palavra=desafio */

	@GetMapping("maiusculas/palavra={palavra}")
	public String maiusculaPalavra(@PathVariable String palavra) {
		palavra = palavra.toUpperCase();

		return palavra;
	}
	/* http://localhost:8080/apitest/maiusculas/palavra=desafio */

	@GetMapping("vogais/palavra={palavra}")
	public String vogaisPalavra(@PathVariable String palavra) {
		palavra = palavra.replaceAll("[qwrtypsdfghjklçzxcvbnmQWRTYPSDFGHJKLÇZXCVBNM]", "");

		return palavra;
	}

	@GetMapping("consoantes/palavra={palavra}")
	public String consPalavra(@PathVariable String palavra) {
		palavra = palavra.replaceAll("[aeiouAEIOU]", "");

		return palavra;
	}

	@GetMapping("nomeBiblio/nome={nome}")
	public String nomeBiblio(@PathVariable String nome) {
		nome = bibliografico(nome);

		return nome;
	}

	@GetMapping("saque/valor={valor}")
	public String saqueVal(@PathVariable Integer valor) {
		String resultSaq = totSaque(valor);

		return resultSaq;
	}

	/*---------------------funções ------------------------*/

	public static String totSaque(Integer valSaq) {
		Integer[] cedulas = { 5, 3 };
		String rSaque = "";
		String oSaque = "";
		Integer divNot = 0;
		Integer valDiv = 0;
		rSaque = "Saque R$" + valSaq + ": ";

		if (valSaq < 8) {
			return rSaque = "Saque R$" + valSaq + ": Valor mínimo para saque: R$8";

		}

		for (int i = 0; i < cedulas.length; i++) {
			if (valSaq > cedulas[i]) {
				divNot = valSaq / cedulas[i];
				valDiv = valSaq % cedulas[i];
				if (valDiv != 0 && valDiv < cedulas[i] && divNot > 1) {
					divNot--;
					if (divNot != 0) {
						valSaq = valSaq - (cedulas[i] * divNot);
						if (valSaq == 7) {
							valSaq = valSaq + cedulas[i];
							divNot--;
						}
						rSaque = rSaque + divNot + " notas de R$" + cedulas[i] + " ";
					}
				} else if (divNot != 0) {
					if (valSaq == 9 && i == 0) {
						divNot--;
					} else {
						rSaque = rSaque + divNot + " notas de R$" + cedulas[i] + " ";
					}
				}
			}
		}

		return rSaque;
	}

	public static String bibliografico(String aNome) {
		String sobrenome = "";
		int i = aNome.lastIndexOf(' ');
		sobrenome = aNome.substring(i + 1, aNome.length());
		aNome = aNome.replaceAll(sobrenome, "");
		sobrenome = sobrenome.toUpperCase();
		aNome = sobrenome + ", " + aNome;

		return aNome;
	}

	public static Integer[] impares(Integer[] num) {
		int tam = num.length - 1;
		int aux = auxArrImp(num, tam);

		Integer[] fImpar = new Integer[aux];
		aux = 0;

		for (int i = 0; i < tam; i++) {
			if (num[i] % 2 != 0) {
				fImpar[aux] = num[i];
				aux++;
			}
		}

		return fImpar;
	}

	public static Integer[] pares(Integer[] num) {
		int tam = num.length;
		int aux = auxArrPar(num);
		int temp = 0;

		Integer[] fPar = new Integer[aux];
		aux = 0;

		for (int i = 0; i < tam; i++) {
			temp = num[i];
			if (temp % 2 == 0) {
				fPar[aux] = temp;
				aux++;
			}
		}

		return fPar;
	}

	public static int auxArrImp(Integer[] b, int tam) {
		int a = 0;
		for (int i = 0; i < tam; i++) {
			if (b[i] % 2 != 0) {
				a++;
			}
		}
		return a;
	}

	public static int auxArrPar(Integer[] b) {
		int a = 0;
		for (int i = 0; i < b.length; i++) {
			if (b[i] % 2 == 0) {
				a++;
			}
		}
		return a;
	}

	public static void inverte(String[] a, int i, int j) {
		String temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
