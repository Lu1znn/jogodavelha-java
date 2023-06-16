import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.*; //o asterisco diz que ja importa tudo de swing

public class JogoDaVelha extends JFrame {
	
	JButton[] bt = new JButton[9]; //criar um vetor de botões
	JLabel placar = new JLabel("Placar"); //criar um placar
	JLabel px = new JLabel("X 0");
	JLabel po = new JLabel("O 0");
	JButton novo = new JButton ("Novo Jogo");
	JButton zerar = new JButton ("Zerar Placar");
	int PX = 0;
	int PO = 0;
	boolean xo = false;
	boolean[] click = new boolean[9];
	
	public JogoDaVelha() {
		
		setVisible(true); //a janela criada será visivel
		setTitle("jogo da velha"); //título da janela
		setDefaultCloseOperation (3); //a operação da janela vai fechar quando apertamos no X e a execução vai parar
		setLayout(null); //deixar null para definir o layout
		setBounds (450,160,700,500); //tamanho da janela
		add(placar);
		add(px);
		add(po);
		add(novo);
		add(zerar);
		placar.setBounds(419,50,100,30);
		px.setBounds(400,75,100,30);
		po.setBounds(450,75,100,30); //aqui criamos as posições onde vai ficar o placar
		novo.setBounds(400,125,140,30);
		zerar.setBounds(400,160,140,30);
		novo.addActionListener(new java.awt.event.ActionListener () {
			@Override
			public void actionPerformed(ActionEvent ae) {
				limpar ();
		}
	});
		zerar.addActionListener(new java.awt.event.ActionListener () {
			@Override
			public void actionPerformed(ActionEvent ae) {
				PO = 0;
				PX = 0;
				atualizar();
		}
	});
		
		
		int cont = 0; //contadora
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				bt[cont] = new JButton();
				add(bt[cont]); // adicionando o elemento do botão
				bt[cont].setBounds((100 * i) + 50, (100 * j) +75, 95, 95); //definir posição do botão e tamanho
				bt[cont].setFont(new Font("Arial", Font.BOLD, 40)); //adicionar uma fonte
				cont++; //sempre que for executado o for, o ++ vai adicionar mais um
			}
		}
		for (int i = 0; i < 9; i++) {
			click[i] = false;
		}
		bt[0].addActionListener(new java.awt.event.ActionListener () {
				@Override
				public void actionPerformed(ActionEvent ae) {
					if (click[0] == false) {
						click[0] = true;
					mudar(bt[0]);
				}			
			}
		});
		bt[1].addActionListener(new java.awt.event.ActionListener () {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (click[1] == false) {
					click[1] = true;
				mudar(bt[1]);
			}			
		}
	});
		bt[2].addActionListener(new java.awt.event.ActionListener () {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (click[2] == false) {
					click[2] = true;
				mudar(bt[2]);
			}			
		}
	});
		bt[3].addActionListener(new java.awt.event.ActionListener () {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (click[3] == false) {
					click[3] = true;
				mudar(bt[3]);
			}			
		}
	});
		bt[4].addActionListener(new java.awt.event.ActionListener () {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (click[4] == false) {
					click[4] = true;
				mudar(bt[4]);
			}			
		}
	});
		bt[5].addActionListener(new java.awt.event.ActionListener () {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (click[5] == false) {
					click[5] = true;
				mudar(bt[5]);
			}			
		}
	});
		bt[6].addActionListener(new java.awt.event.ActionListener () {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (click[6] == false) {
					click[6] = true;
				mudar(bt[6]);
			}			
		}
	});
		bt[7].addActionListener(new java.awt.event.ActionListener () {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (click[7] == false) {
					click[7] = true;
				mudar(bt[7]);
			}			
		}
	});
		bt[8].addActionListener(new java.awt.event.ActionListener () {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (click[8] == false) {
					click[8] = true;
				mudar(bt[8]);
			}			
		}
	});
		
	}
	public void mudar (JButton btn) { //quando esse metodo for executado pela primeira vez, ele vai transformar o xo em true. Quando ele for executado pela segunda vez, vai transformar o xo em false. Ou seja, mudando de X para O, ou vice-versa.
		if(xo){
			btn.setText("O");
			xo = false;
		}else {
			btn.setText("X");
			xo = true;
		}
		ganhou (); //chamar o metodo para funcionar no jogo
	}
	public void atualizar () { //criamos o metodo para atualizar o placar
		px.setText("x " + PX);
		po.setText("o " + PO);
	}
	public void ganhou() { //aqui vamos definir a vitória, colocando todas as formas que podem vencer no jogo
		int cont = 0;
		for (int i = 0; i < 9; i++) {
			if(click[i] == true) {
				cont++; //aqui foi criado um for para caso o jogo seja empate, ou seja, se todos forem pressionados 9 botões foram pressionados.
			}
		}
		if((bt[0].getText() == "X" && bt[1].getText() == "X" && bt[2].getText() == "X")
				|| (bt[3].getText() == "X" && bt[4].getText() == "X" && bt[5].getText() == "X")
				|| (bt[6].getText() == "X" && bt[7].getText() == "X" && bt[8].getText() == "X")
				|| (bt[0].getText() == "X" && bt[3].getText() == "X" && bt[6].getText() == "X")
				|| (bt[1].getText() == "X" && bt[4].getText() == "X" && bt[7].getText() == "X")
				|| (bt[2].getText() == "X" && bt[5].getText() == "X" && bt[8].getText() == "X")
				|| (bt[0].getText() == "X" && bt[4].getText() == "X" && bt[8].getText() == "X")
				|| (bt[6].getText() == "X" && bt[4].getText() == "X" && bt[2].getText() == "X")) {
			JOptionPane.showMessageDialog(null, "X ganhou"); //exibir uma mensagem mostrando quem venceu
			PX++;
			atualizar(); //aqui colocamos o PX++ para dar 1 ponto no placar para quem venceu, e em seguida chamamos o atualizar.
			limpar ();
			
			
		}else if((bt[0].getText() == "O" && bt[1].getText() == "O" && bt[2].getText() == "O")
				|| (bt[3].getText() == "O" && bt[4].getText() == "O" && bt[5].getText() == "O")
				|| (bt[6].getText() == "O" && bt[7].getText() == "O" && bt[8].getText() == "O")
				|| (bt[0].getText() == "O" && bt[3].getText() == "O" && bt[6].getText() == "O")
				|| (bt[1].getText() == "O" && bt[4].getText() == "O" && bt[7].getText() == "O")
				|| (bt[2].getText() == "O" && bt[5].getText() == "O" && bt[8].getText() == "O")
				|| (bt[0].getText() == "O" && bt[4].getText() == "O" && bt[8].getText() == "O")
				|| (bt[6].getText() == "O" && bt[4].getText() == "O" && bt[2].getText() == "O")) {
			JOptionPane.showMessageDialog(null, "O ganhou");
			PO++;
			atualizar();
			limpar ();
		}else if (cont == 9){ //aqui se o contador for 9, como foi citado acima, vai dar empate.
			JOptionPane.showMessageDialog(null, "Empate");
			limpar ();
			
		}
	}
	
	public void limpar() {
		for (int i = 0; i < 9; i++) {
			bt[i].setText("");
			click[i] = false;
			xo = false;
		}
	}

	public static void main(String[] args) {
		new JogoDaVelha();

	}

}
