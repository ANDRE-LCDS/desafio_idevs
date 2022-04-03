package desafio_01;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Desafio_01 {

	private static final Exception NullPointerException = null;

	public static void main(String[] args) throws Exception {

		String soma = null;

		soma = JOptionPane.showInputDialog(null, "DIGITE UMA PALAVRA");

		Pattern pattern = Pattern.compile("[0-9]");
		Matcher match = pattern.matcher(soma);
		if (match.find()) {
			JOptionPane.showMessageDialog(null, "Número Inválido");
			throw NullPointerException;
		}

		Map<Character, Integer> letraComValor = MapLetraEValor.getLetraEValor();

		int valorFinal = calcularValorDaPalavra(soma, letraComValor);
		JOptionPane.showMessageDialog(null, valorFinal, "A PALAVRA VALE :", JOptionPane.INFORMATION_MESSAGE);

	}

	private static int calcularValorDaPalavra(String palavra, Map<Character, Integer> letraEValor) {
		int valorFinal = 0;
		for (char caractere : palavra.toCharArray()) {
			if (isCaractereEncontrado(letraEValor, caractere))
				valorFinal += getValorCaractere(letraEValor, caractere);
		}
		return valorFinal;
	}

	private static Integer getValorCaractere(Map<Character, Integer> letraEValor, char caractere) {
		return letraEValor.get(caractere);

	}

	private static boolean isCaractereEncontrado(Map<Character, Integer> letraEValor, char caractere) {
		return getValorCaractere(letraEValor, caractere) != null;
	}

}
