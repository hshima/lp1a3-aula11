package aula11;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * Faça um programa com Java Swing onde um cliente, ao realizar uma compra,
 * informa o valor do produto, se é um cliente com fidelidade, o estado onde
 * reside (SP, RJ, MG ou ES) e o tipo de postagem que deseja (Sedex ou Sedex
 * 10). Com base nesses dados e nas regras a seguir, o programa deve calcular o
 * valor do produto, o valor do frete e o valor total a ser pago e apresentá-los
 * separadamente em três labels localizados na parte direita do formulário.
 * Seguem regras de cálculo e o protótipo do formulário:
 * 
 * @author shima
 *
 */
@SuppressWarnings("serial")
public class Exercicio03 extends JFrame {

	private JLabel lbTitle, lbValorProduto, lbValorProduto2, lbValorFrete, lbValorTotal, lbUF;
	private JTextField tfValorProduto;
	
	private ButtonGroup bgOperacoes;
	private JRadioButton rbOptions[];
	private static final String rbValues[] = {"SP", "RJ", "MG", "ES"};
	
	private static final String cbValues[] = {"Sedex", "Sedex 10"};
	private JCheckBox cbClienteFidelidade;
	private JComboBox<String> ckClienteFidelidade;

	private JButton btCalcular;
	private Container cp;

	public Exercicio03() throws HeadlessException {
		lbTitle = new JLabel("Exercicio 3");
		lbValorProduto = new JLabel("Valor Produto");
		lbValorProduto2 = new JLabel("Valor Produto: ");
		lbValorFrete = new JLabel("Valor Frete: "); 
		lbValorTotal = new JLabel("Valor Total: ");
		lbUF = new JLabel("Estado");
		tfValorProduto = new JTextField("");
		btCalcular = new JButton("Calcular");
		rbOptions = new JRadioButton[cbValues.length];
		bgOperacoes = new ButtonGroup();
		ckClienteFidelidade = new JComboBox<String>(rbValues);
		cbClienteFidelidade = new JCheckBox("Cliente com Fidelidade");
		cp = new Container();

		// JFrame
		setTitle("Exercicio 3");
		setSize(500, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// modificando atributos do Container
		lbTitle.setFont(new Font("Roboto", Font.BOLD, 19));
	
		// Componentes de interface
		lbValorProduto.setBounds(20, 40, 100, 25);
		lbValorProduto2.setBounds(300, 40, 90, 25);
		lbValorFrete.setBounds(300, 80, 90, 25);
		lbValorTotal.setBounds(300, 120, 90, 25);
		tfValorProduto.setBounds(120, 40, 150, 25);
		cbClienteFidelidade.setBounds(20, 80, 250, 25);
		ckClienteFidelidade.setBounds(120, 120, 50, 25);
		lbUF.setBounds(20, 120, 60, 25);
		btCalcular.setBounds(360, 200, 100, 25);
		Integer posicao[] = {20, 150, 100, 25};
		
		for (int i = 0; i < rbOptions.length; i++) {
			rbOptions[i] = new JRadioButton(cbValues[i]);
			rbOptions[i].setBackground(new Color(180, 205, 205));
			rbOptions[i].setBounds(posicao[0], posicao[1], posicao[2], posicao[3]);
			posicao[1] += 25;
			bgOperacoes.add(rbOptions[i]);
		}
		rbOptions[0].setSelected(true);
		ckClienteFidelidade.setBackground(new Color(180, 205, 205));
		
		cp = getContentPane();
		cp.setLayout(null);
		cp.setBackground(new Color(180, 205, 205));
		
		// Incluindo os módulos
		cp.add(lbTitle);
		cp.add(lbValorProduto);
		cp.add(tfValorProduto);
		cp.add(lbUF);
		cp.add(ckClienteFidelidade);
		for (JRadioButton jRadioButton : rbOptions) {
			cp.add(jRadioButton);
		}
		cp.add(btCalcular);
		cp.add(cbClienteFidelidade);
		cp.add(lbValorProduto2);
		cp.add(lbValorFrete);
		cp.add(lbValorTotal);

		btCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btCalcularAction();
			}
		});

	}

	private void btCalcularAction() {
		String op = null;
		for (JRadioButton box : rbOptions) {
			if (box.isSelected())
				op = box.getText();
		}

		JOptionPane.showMessageDialog(this, "Calculo: ", "Resposta", JOptionPane.INFORMATION_MESSAGE);
	}
/*
	private String operation(String op) {
		String result = null;
		switch (op) {
			case "Celsius para Fahreinheit": {
				// °C * 1,8 + 32
				result = String.valueOf((Double.parseDouble(tfTemperatura.getText()) * 1.8) + 32);
				break;
			}
			case "Fahreinheit para Celsius": {
				// Fahrenheit para Celsius: (°F - 32) / 1,8
				result = String.valueOf((Double.parseDouble(tfTemperatura.getText()) - 32) / 1.8);
				break;
			}
			case "Celsius para Kelvin": {
				// Celsius para Kelvin: °C + 273,15
				result = String.valueOf(Double.parseDouble(tfTemperatura.getText()) + 273.15);
				break;
			}
			case "Kelvin para Celsius": {
				// Kelvin para Celsius: K – 273,15
				result = String.valueOf(Double.parseDouble(tfTemperatura.getText()) - 273.15);
				break;
			}
			case "Fahreinheit para Kelvin": {
				// Fahrenheit para Kelvin: (°F + 459,67) / 1,8
				result = String.valueOf((Double.parseDouble(tfTemperatura.getText()) + 459.67) / 1.8);
				break;
			}
			case "Kelvin para Fahreinheit": {
				// Kelvin para Fahrenheit: K * 1,8 – 459,67
				result = String.valueOf((Double.parseDouble(tfTemperatura.getText()) * 1.8) - 459.67);
				break;
			}
		}
		return result;
	}
*/
}
