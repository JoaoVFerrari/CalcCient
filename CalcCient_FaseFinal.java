package Calculadora;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import java.text.*;

public class CalcCient_FaseFinal extends JFrame implements ActionListener {

	// Vari�veis de controle
	double n1 = 0;
	double n2 = 0;
	String oper = "";

	JMenuBar mb = new JMenuBar();
	JMenu mArq = new JMenu("Arquivo");
	JMenu mTipo = new JMenu("Tipos");
	JMenuItem mSair = new JMenuItem("Sair");
	JMenuItem mNorm = new JMenuItem("Normal");
	JMenuItem mGeo = new JMenuItem("Geometria");
	JMenuItem mAlg = new JMenuItem("Algebra");

	// Elementos Gerais da Tela
	JTextField visor = new JTextField();
	JPanel pc = new JPanel(); // painel central
	JPanel pinf = new JPanel(); // painel inferior

	// Elementos do Painel Inferior
	JButton big = new JButton("=");
	JButton bel = new JButton("elev");

	// Elementos do Painel Normal
	JPanel pN = new JPanel();
	JButton b1 = new JButton("1");
	JButton b2 = new JButton("2");
	JButton b3 = new JButton("3");
	JButton b4 = new JButton("4");
	JButton b5 = new JButton("5");
	JButton b6 = new JButton("6");
	JButton b7 = new JButton("7");
	JButton b8 = new JButton("8");
	JButton b9 = new JButton("9");
	JButton b0 = new JButton("0");
	JButton bc = new JButton("C");
	JButton bpo = new JButton(".");
	JButton bma = new JButton("+");
	JButton bme = new JButton("-");
	JButton bve = new JButton("*");
	JButton bdi = new JButton("/");

	// Elementos do Painel de Geometria
	JPanel pG = new JPanel();
	JButton bsen = new JButton("Sen");
	JButton bcos = new JButton("Cos");
	JButton btan = new JButton("Tan");
	JButton bAsen = new JButton("ArcSen");
	JButton bAcos = new JButton("ArcCos");
	JButton bAtan = new JButton("ArcTan");

	// Elementos do Painel de �lgebra
	JPanel pA = new JPanel();
	JButton blog10 = new JButton("Log Base 10");
	JButton blogE = new JButton("Log Base e");
	JButton braiz = new JButton("Raiz Quad.");
	JButton bquad = new JButton("Ao Quad.");
	JButton bex = new JButton("e^x");

	public static void main(String[] args) {
		CalcCient_FaseFinal calc = new CalcCient_FaseFinal();
	}

	public CalcCient_FaseFinal() {

		// Montando os Menus
		mArq.add(mSair);
		mTipo.add(mNorm);
		mTipo.add(mGeo);
		mTipo.add(mAlg);
		mb.add(mArq);
		mb.add(mTipo);
		this.setJMenuBar(mb);

		this.setLayout(new BorderLayout(2, 2));

		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

		// definindo os layouts dos paineis que aparecer�o no centro
		// ..obs.: o comando abaixo deixar� um espa�o de 2 pixels entre as
		// partes
		pN.setLayout(new GridLayout(4, 4, 2, 2));
		pG.setLayout(new GridLayout(6, 1, 2, 2));
		pA.setLayout(new GridLayout(6, 1, 2, 2));

		// Acionando (ligando) os botoes do
		// ... do painel inferior
		big.addActionListener(this);
		bel.addActionListener(this);

		// Acionando (ligando) TODOS os botoes
		// ... do painel Normal
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b0.addActionListener(this);
		bpo.addActionListener(this);
		bma.addActionListener(this);
		bme.addActionListener(this);
		bve.addActionListener(this);
		bdi.addActionListener(this);
		bc.addActionListener(this);
		// ... do painel Geometrico
		bsen.addActionListener(this);
		bcos.addActionListener(this);
		btan.addActionListener(this);
		bAsen.addActionListener(this);
		bAcos.addActionListener(this);
		bAtan.addActionListener(this);
		// ... do painel Algebrico
		blog10.addActionListener(this);
		blogE.addActionListener(this);
		braiz.addActionListener(this);
		bquad.addActionListener(this);
		bex.addActionListener(this);

		// Acionando (ligando) todos os Itens de Menus
		mSair.addActionListener(this);
		mNorm.addActionListener(this);
		mGeo.addActionListener(this);
		mAlg.addActionListener(this);

		// definindo o layout do painel que aparecer� no sul
		// e..Inserindo os bot�es deste painel
		pinf.setLayout(new GridLayout(1, 2, 2, 2));
		pinf.add(bel);
		pinf.add(big);

		// Inserindo os botoes do painel de numeros (Normal)
		pN.add(b1);
		pN.add(b2);
		pN.add(b3);
		pN.add(bc);
		pN.add(b4);
		pN.add(b5);
		pN.add(b6);
		pN.add(bma);
		pN.add(b7);
		pN.add(b8);
		pN.add(b9);
		pN.add(bme);
		pN.add(b0);
		pN.add(bpo);
		pN.add(bve);
		pN.add(bdi);

		// Inserindo os botoes do painel de Geometria
		pG.add(bsen);
		pG.add(bcos);
		pG.add(btan);
		pG.add(bAsen);
		pG.add(bAcos);
		pG.add(bAtan);

		// Inserindo os botoes do painel de algebra
		pA.add(bquad);
		pA.add(braiz);
		pA.add(bex);
		pA.add(blog10);
		pA.add(blogE);

		// Configuracoes iniciais do Visor
		visor.setFont(new Font("Arial", Font.BOLD, 18)); // ..FONTE
		visor.setHorizontalAlignment(JTextField.RIGHT); // ..Alinhando � direita
		visor.setEditable(false); // ..Fechado para Edi��o

		// Definindo os paineis centrais de botoes
		pc.setLayout(new CardLayout());
		pc.add(pN, "pN");
		pc.add(pA, "pA");
		pc.add(pG, "pG");

		add(visor, BorderLayout.NORTH);
		add(pc, BorderLayout.CENTER);
		add(pinf, BorderLayout.SOUTH);

		this.setTitle("Calculadora Cientifica");
		this.setSize(250, 270);
		this.setLocationRelativeTo(null); // Centraliza na Tela
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		
		String val = "";
		String txt = "";
		double res = 0;

		Object obj = new Object();
		obj = e.getSource();

		txt = visor.getText();
		if (obj.equals(b1)) {
			val = "1";
			visor.setText(txt + val);
		} else if (obj.equals(b2)) {
			val = "2";
			visor.setText(txt + val);
		} else if (obj.equals(b3)) {
			val = "3";
			visor.setText(txt + val);
		} else if (obj.equals(b4)) {
			val = "4";
			visor.setText(txt + val);
		} else if (obj.equals(b5)) {
			val = "5";
			visor.setText(txt + val);
		} else if (obj.equals(b6)) {
			val = "6";
			visor.setText(txt + val);
		} else if (obj.equals(b7)) {
			val = "7";
			visor.setText(txt + val);
		} else if (obj.equals(b8)) {
			val = "8";
			visor.setText(txt + val);
		} else if (obj.equals(b9)) {
			val = "9";
			visor.setText(txt + val);
		} else if (obj.equals(b0)) {
			val = "0";
			visor.setText(txt + val);
		} else if (obj.equals(bma)) {
			n1 = Double.parseDouble(txt);
			oper = "+";
			visor.setText("");
		} else if (obj.equals(bme)) {
			n1 = Double.parseDouble(txt);
			oper = "-";
			visor.setText("");
		} else if (obj.equals(bve)) {
			n1 = Double.parseDouble(txt);
			oper = "*";
			visor.setText("");
		} else if (obj.equals(bdi)) {
			n1 = Double.parseDouble(txt);
			oper = "/";
			visor.setText("");
		} else if (obj.equals(bc)) {
			visor.setText("");
		} else if (obj.equals(bsen)) {
			n1 = Double.parseDouble(txt);
			res = Math.sin(Math.toRadians(n1));
			visor.setText(Double.toString(res));
		} else if (obj.equals(bAsen)) {
			n1 = Double.parseDouble(txt);
			res = Math.toDegrees(Math.asin(n1));
			visor.setText(Double.toString(res));
		} else if (obj.equals(bcos)) {
			n1 = Double.parseDouble(txt);
			res = Math.cos(Math.toRadians(n1));
			visor.setText(Double.toString(res));
		} else if (obj.equals(bAcos)) {
			n1 = Double.parseDouble(txt);
			res = Math.toDegrees(Math.acos(n1));
			visor.setText(Double.toString(res));
		} else if (obj.equals(btan)) {
			n1 = Double.parseDouble(txt);
			res = Math.tan(Math.toRadians(n1));
			visor.setText(Double.toString(res));
		} else if (obj.equals(bAtan)) {
			n1 = Double.parseDouble(txt);
			res = Math.toDegrees(Math.atan(n1));
			visor.setText(Double.toString(res));
		} else if (obj.equals(blog10)) {
			n1 = Double.parseDouble(txt);
			res = Math.log10(n1);
			visor.setText(Double.toString(res));
		} else if (obj.equals(blogE)) {
			n1 = Double.parseDouble(txt);
			res = Math.log(n1);
			visor.setText(Double.toString(res));
		} else if (obj.equals(braiz)) {
			n1 = Double.parseDouble(txt);
			res = Math.sqrt(n1);
			visor.setText(Double.toString(res));
		} else if (obj.equals(bquad)) {
			n1 = Double.parseDouble(txt);
			res = Math.pow(n1, 2);
			visor.setText(Double.toString(res));
		} else if (obj.equals(bex)) {
			n1 = Double.parseDouble(txt);
			res = Math.pow(n1, Math.E);
			visor.setText(Double.toString(res));
		} else if (obj.equals(bel)) {
			n1 = Double.parseDouble(txt);
			oper = "^";
			visor.setText("");
		} else if (obj.equals(big)) {
			n2 = Double.parseDouble(txt);
			if (oper == "+") {
				res = n1 + n2;
			} else if (oper == "-") {
				res = n1 - n2;
			} else if (oper == "*") {
				res = n1 * n2;
			} else if (oper == "/") {
				res = n1 / n2;
			} else if (oper == "^") {
				res = Math.pow(n1, n2);
			}
			visor.setText(Double.toString(res));
		} else if (obj.equals(mSair)) {
			System.exit(0);
		} else if (obj.equals(mNorm)) {
			this.trocarTela("pN");
		} else if (obj.equals(mGeo)) {
			this.trocarTela("pG");
		} else if (obj.equals(mAlg)) {
			this.trocarTela("pA");
		}
	}

	public void trocarTela(String tip) {
		CardLayout cl = (CardLayout) (pc.getLayout());
		cl.show(pc, tip);
	}

}
