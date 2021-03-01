package aula11;

import java.util.Scanner;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				System.out.println("Informe qual exercício será verificado?");
				Scanner s = new Scanner(System.in);
				switch(s.next()) {
				case "1": {
					new Exercicio01().setVisible(true);
					break;
				}
				case "2":{
					new Exercicio02().setVisible(true);
					break;
				}
				case "3":{
					new Exercicio03().setVisible(true);
					break;
				}
				case "4":{
					
					break;
				}
				}
			}
		});

	}

}
