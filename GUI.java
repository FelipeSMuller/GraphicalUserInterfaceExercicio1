package praticandoGUI;

//contêm os imports necessários referentes aos componentes gráficos usados no programa.

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

/*
 a palavra extends (herança) informa que a classe GuiLogin vai utilizar todos

os recursos da classe JFrame, porém terá outras características próprias, definidas em seu méto-
do construtor, no caso o método GuiLogin*/

public class GUI extends JFrame {

	/*
	 * contêm a declaração de diferentes componentes visuais utilizados na
	 * aplicação.
	 */

	private JTextField tfLogin;

	private JLabel lbSenha;

	private JLabel lbLogin;

	private JButton btnLogar;

	private JButton btnCancelar;

	private JPasswordField pfSenha;

	private static GUI frame;

	public GUI() {

		/*
		 * contêm a implementação do método construtor, que invoca dois métodos inter-
		 * nos: inicializarComponentes e definirEventos, Eles serão usados para definir,
		 * respectivamente,
		 * 
		 * as características visuais dos componentes gráficos e os eventos envolvidos
		 * neles. Os eventos definem as funcionalidades para cada componente visual
		 * (como, por exemplo, o que acontecerá ao clicarmos em cima do botão).
		 * 
		 */
		inicializarComponentes();

		definirEventos();
	}

	private void inicializarComponentes() {

		/*
		 * define o título “Login no Sistema” por meio do método setTitle. Essa frase
		 * aparecerá na barra de título do frame (à janela do programa).
		 * 
		 */
		setTitle("JAVA");

		/*
		 * define a coordenada de posicionamento e as dimensões do frame. Os dois
		 * primeiros va- lores dizem respeito à posição da tela (x,y) a partir da qual o
		 * frame será desenhado. Os dois últi- mos valores se referem ao tamanho do
		 * frame (largura e altura) em pixels por polegada. O método
		 * 
		 * setBounds aceita quatro parâmetros (posição esquerda que o componente aparece
		 * na tela, posi- ção superior que o componente aparece na tela, largura do
		 * componente, altura do componente),
		 * 
		 * resumindo (x, y, largura, altura).
		 */
		setBounds(0, 0, 250, 200);

		/*
		 * define como “nulo” o gerenciador de layout a ser usado no frame por meio do
		 * método setLayout. um frame (e outros componentes) podem usar diferentes tipos
		 * de gerenciadores de layout, uma maneira de definir o posicionamento físico
		 * dos componentes no frame. Ao definir o layout como nulo, temos maior
		 * liberdade em posicionar os componentes.
		 */

		setLayout(null);

		/*
		 * contêm a declaração e criação dos objetos tfLogin e pfSenha. O número 5,
		 * defini- do entre parênteses, diz respeito ao comprimento das caixas de texto.
		 */
		tfLogin = new JTextField(5);

		pfSenha = new JPasswordField(5);

		lbSenha = new JLabel("Senha: ");

		lbLogin = new JLabel("Login: ");

		btnLogar = new JButton("Logar");

		btnCancelar = new JButton("Cancelar");

		/*
		 * definem o posicionamento e o tamanho que cada um dos componentes gráficos
		 * ocupará no frame.
		 */
		tfLogin.setBounds(100, 30, 120, 25);

		lbLogin.setBounds(30, 30, 80, 25);

		lbSenha.setBounds(30, 75, 80, 25);

		pfSenha.setBounds(100, 75, 120, 25);

		btnLogar.setBounds(20, 120, 100, 25);

		btnCancelar.setBounds(125, 120, 100, 25);

		/*
		 * todos os componentes gráficos são adicionados ao frame. De forma similar a um
		 * quebra-cabeças, é necessário montar as peças. Nessas linhas, cada uma das
		 * peças (componentes) é adicionada ao frame, na posição e tamanho definidos
		 * anteriormente.
		 */

		add(tfLogin);

		add(pfSenha);

		add(lbSenha);

		add(lbLogin);

		add(btnLogar);

		add(btnCancelar);
	}

	private void definirEventos() {

		/*
		 * adiciona o evento de ação ao botão btLogar e implementa o código referente a
		 * esse botão.
		 */

		btnLogar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				/*
				 * a caixa de senha pfTexto possui um método chamado getPassword que retorna um
				 * vetor de caracteres, referente à senha digitada pelo usuário. Esse vetor de
				 * caracteres está sendo
				 * 
				 * convertido em String por meio do método valueOf. Esse valor convertido está
				 * sendo armazenado na String “senha”. Isso se faz necessário para podermos
				 * comparar o que o usuário digitou com a senha
				 */

				String senha = String.valueOf(pfSenha.getPassword());

				/*
				 * realiza a comparação do que o usuário digitou na caixa de texto tfLogin com o
				 * conteúdo “java8”. Para pegar o conteúdo texto armazenado num JTextField é
				 * usado o método getText.
				 * 
				 * Para comparar um texto em Java deve ser usado o método equals. Além disso,
				 * compara também o
				 * 
				 * conteúdo armazenado na variável “senha” com “java8”. Dessa forma, o resultado
				 * do “if” será verdadeiro se tanto o login quanto a senha digitada forem iguais
				 * a “java8”;
				 */

				if (tfLogin.getText().equals("Java8") && senha.equals("Java8")) {

					/*
					 * esconde o frame por meio do método setVisible, que permite tornar visível
					 * (true) ou oculto (false) um determinado componente, aqui o frame da
					 * aplicação. Nesse caso, o objetivo é ocultar a tela de login caso o login e
					 * senha estejam corretos.
					 */
					frame.setVisible(false);

					/*
					 * caso contrário o usuário é informado de que os dados estão incorretos.
					 */
				} else {

					JOptionPane.showMessageDialog(null, "Os dados fornecidos estão incorretos", null,

							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnCancelar.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {

				System.exit(0);

			}
		});
	}

	public static void main(String[] args) {

		/* define um novo processo de execução */
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				/*
				 * cria o objeto “frame” a partir do construtor “GuiLogin”. Esse objeto recebe
				 * todas as características definidas no construtor, já citadas anteriormente,
				 * incluindo a inicialização dos componentes e a definição dos eventos.
				 */

				frame = new GUI();

				/*
				 * possui o método setDefaultCloseOperation, responsável por encerrar a
				 * aplicação quando a janela for fechada. A constante usada foi EXIT_ON_CLOSE.
				 * Outras constantes que podem ser usadas são: HIDE_ON_CLOSE (oculta a janela
				 * quando fechada), DO_NOTHING_ON_ CLOSE (não faz nada, apenas desativa o botão
				 * de encerramento) e DISPOSE_ON_CLOSE (a janela desaparece e os recursos usados
				 * pela classe são liberados).
				 */
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				/*
				 * cria um objeto chamado “tela” contendo as dimensões da tela. Essa dimensão
				 * varia em função da resolução gráfica usada no ambiente em que a aplicação
				 * está sendo executada.
				 */
				Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();

				/*
				 * define a localização em que o frame aparecerá na tela do monitor por meio do
				 * método setLocation, que recebe dois parâmetros (posicionamento em relação ao
				 * canto esquerdo, posicionamento em relação ao topo), isto é, cada valor define
				 * um ponto da coordenada x,y a partir da qual o frame aparecerá. É
				 * realizado um cálculo que leva em consideração o tamanho da tela e do frame
				 * ((largura da tela – largura do frame)/2,(altura da tela – altura do
				 * frame)/2). Isso permite centralizar o frame na tela, independentemente de seu
				 * tamanho.
				 */

				frame.setLocation((tela.width - frame.getSize().width) / 2, (tela.height - frame.getSize().height) / 2);

				/* torna o frame visível. */
				frame.setVisible(true);
			}
		});
	}
}
