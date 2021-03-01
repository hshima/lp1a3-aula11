package aula11;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Faça um programa com Java Swing que recebe dois valores numéricos e uma
 * operação (adição, subtração, multiplicação, divisão, ou resto da divisão).
 * Com base nesses dados, o programa deve realizar o cálculo e apresentar o
 * resultado através de uma caixa de mensagem. O programa deve verificar se os
 * campos estão preenchidos com números antes de realizar o cálculo. A operação
 * de resto da divisão (%) deve permitir apenas números inteiros. Segue
 * protótipo do formulário:
 * 
 * @author shima
 *
 */
@SuppressWarnings("serial")
public class Exercicio01 extends JFrame {

	private JLabel lbTitle, lbValor01, lbValor02;
	private JTextField tfValor01, tfValor02;
	private JComboBox<String> cbOperacao;
	private static final String operations[] = { "+", "-", "*", "/", "%" };
	private JButton btCalcular;
	private JPanel panel;
	private Container cp;

	public Exercicio01() throws HeadlessException {
		lbTitle = new JLabel("Exercicio 1");
		lbValor01 = new JLabel("Valor 01");
		tfValor01 = new JTextField("");
		lbValor02 = new JLabel("Valor 02");
		tfValor02 = new JTextField("");
		cbOperacao = new JComboBox<String>(operations);
		btCalcular = new JButton("Calcular");

		// JFrame
		setTitle("Exercicio 1");
		setSize(500, 250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// modificando atributos do Container
		lbTitle.setFont(new Font("Roboto", Font.BOLD, 19));
		cp = getContentPane();
		cp.setLayout(null);
		cp.setBackground(new Color(180, 205, 205));

		// Componentes de interface
		lbValor01.setBounds(20, 40, 100, 25);
		tfValor01.setBounds(100, 40, 360, 25);
		lbValor02.setBounds(20, 70, 100, 25);
		tfValor02.setBounds(100, 70, 360, 25);
		cbOperacao.setBounds(300, 120, 50, 25);
		btCalcular.setBounds(360, 120, 100, 25);

		// Incluindo os módulos
		cp.add(lbValor01);
		cp.add(tfValor01);
		cp.add(lbValor02);
		cp.add(tfValor02);
		cp.add(cbOperacao);
		cp.add(btCalcular);

		cbOperacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbOperacaoAction();
			}
		});

		btCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btCalcularAction();
			}
		});

	}

	private void cbOperacaoAction() {
		tfValor01.setText("");
		tfValor02.setText("");
	}

	private void btCalcularAction() {
		JOptionPane.showMessageDialog(this,
				"Calculo: "
						+ operation(tfValor01.getText(), tfValor02.getText(), (String) cbOperacao.getSelectedItem()),
				"Resposta", JOptionPane.INFORMATION_MESSAGE);
	}

	private String operation(String v1, String v2, String op) {
		Double val1 = null;
		Double val2 = null;
		try {
			val1 = Double.parseDouble(v1);
			val2 = Double.parseDouble(v2);
		} catch (NumberFormatException e) {
			List<String> erros = new ArrayList<>();
			if (v1.isBlank() | v1 == null)
				erros.add("O campo Valor 01 está vazio!\n");
			if (v2.isBlank() | v2 == null)
				erros.add("O campo Valor 02 está vazio!\n");

			String err = "\n";
			for (String string : erros) {
				err.concat(string);
			}

			JOptionPane.showMessageDialog(this, "Problemas identificados: " + err, "Erro ao calcular",
					JOptionPane.INFORMATION_MESSAGE);
		}

		String result = null;
		switch (op) {
		case "+": {
			result = String.valueOf(val1 + val2);
			break;
		}
		case "-": {
			result = String.valueOf(val1 - val2);
			break;
		}
		case "*": {
			result = String.valueOf(val1 * val2);
			break;
		}
		case "/": {
			result = String.valueOf(val1 / val2);
			break;
		}
		case "%": {
			result = String.valueOf(Double.toString(val1 % val2));
			break;
		}
		default:
			break;
		}
		return result;
	}

}
