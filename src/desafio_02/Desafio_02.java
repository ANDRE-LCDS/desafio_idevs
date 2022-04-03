package desafio_02;

import java.util.ArrayList;
import java.util.List;

public class Desafio_02 {

	public static void main(String[] args) {
		List<Integer> resultado = new ArrayList<Integer>();
		int atual = 0, proximo = 1;

		for (int y = 1; y < 10000; y++) {
			atual = numeroDeDivisores(y + 1);
			if (proximo == atual) {
				System.out.println(y);
				resultado.add(y);
			}
			proximo = atual;
		}

	}

	public static int numeroDeDivisores(int num) {
		int computa = 2;

		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				computa++;
			}
		}
		return computa;
	}
}
