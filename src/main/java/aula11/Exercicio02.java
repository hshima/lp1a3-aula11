package aula11;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * Faça um programa com Java Swing onde o usuário informa uma temperatura e o
 * tipo de conversão que deseja realizar. Com base nesses dados, o programa deve
 * realizar o cálculo e apresentar a temperatura convertida através de uma caixa
 * de mensagem. As operações devem ser realizadas ao selecionar o RadioButton,
 * ou seja, não deve existir um botão para disparar a operação. Seguem fórmulas
 * de conversão e o protótipo do formulário:
 * 
 * @author shima
 *
 */
@SuppressWarnings("serial")
public class Exercicio02 extends JFrame {
	private JLabel lbTitle, lbTemperatura;
	private JTextField tfTemperatura;
	private ButtonGroup bgOperacoes;
	private static final String values[] = { "Celsius para Fahreinheit", "Fahreinheit para Celsius",
			"Celsius para Kelvin", "Kelvin para Celsius", "Fahreinheit para Kelvin", "Kelvin para Fahreinheit" };
	private JRadioButton rbOptions[];
	private JButton btCalcular;
	private Container cp;

	public Exercicio02() throws HeadlessException {
		lbTitle = new JLabel("Exercicio 2");
		lbTemperatura = new JLabel("Temperatura");
		tfTemperatura = new JTextField("");
		btCalcular = new JButton("Calcular");
		rbOptions = new JRadioButton[values.length];
		bgOperacoes = new ButtonGroup();

		// JFrame
		setTitle("Exercicio 2");
		setSize(500, 450);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// modificando atributos do Container
		lbTitle.setFont(new Font("Roboto", Font.BOLD, 19));
		cp = getContentPane();
		cp.setLayout(null);
		cp.setBackground(new Color(180, 205, 205));

		// Componentes de interface
		lbTemperatura.setBounds(20, 40, 100, 25);
		tfTemperatura.setBounds(120, 40, 360, 25);
		Integer posicao[] = {100, 90, 300, 25};
		for (int i = 0; i < rbOptions.length; i++) {
			
			rbOptions[i] = new JRadioButton(values[i]);
			rbOptions[i].setBackground(new Color(180, 205, 205));
			rbOptions[i].setBounds(posicao[0], posicao[1], posicao[2], posicao[3]);
			posicao[1] += 25;
			bgOperacoes.add(rbOptions[i]);
		}
		rbOptions[0].setSelected(true);
		btCalcular.setBounds(360, 120, 100, 25);

		// Incluindo os módulos
		cp.add(lbTemperatura);
		cp.add(tfTemperatura);
		for (JRadioButton jRadioButton : rbOptions) {
			cp.add(jRadioButton);
		}
		cp.add(btCalcular);

		for (JRadioButton jRadioButton : rbOptions) {
			jRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btCalcularAction();
				}
			});
		}
		
//		btCalcular.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				btCalcularAction();
//			}
//		});

	}

	private void btCalcularAction() {
		String op = null;
		for (JRadioButton box : rbOptions) {
			if (box.isSelected())
				op = box.getText();
		}

		JOptionPane.showMessageDialog(this, "Calculo: " + operation(op), "Resposta", JOptionPane.INFORMATION_MESSAGE);
	}

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

}
