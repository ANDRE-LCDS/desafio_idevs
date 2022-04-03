package desafio_03;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

public class Desafio_03 {

	public static void main(String[] args) {
		List<Integer> Primos = new ArrayList<Integer>();
		List<Integer> NumerosSomados = new ArrayList<Integer>();

		int soma;
		int numero = 0;

		try {
			numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero"));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Número Inválido");
		}

		for (int i = 2; i <= numero; i++) {
			boolean primo = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					primo = false;
				}
			}

			if (primo) {
				Primos.add(i);
				soma = Primos.stream().parallel().reduce(0, (a, b) -> a + b);
				NumerosSomados.add(soma);

			}
		}

		List<Integer> PrimosSomados = Primos.stream().filter(item1 -> {
			return NumerosSomados.stream().filter(item2 -> new Integer(item2).equals(item1)).findAny().isPresent();
		}).collect(Collectors.toList());

		int posicao = PrimosSomados.size();
		Integer maiorPrimo = PrimosSomados.get(posicao - 1);

		JOptionPane.showMessageDialog(null, maiorPrimo, "Maior numero primo", JOptionPane.INFORMATION_MESSAGE);

	}

}
