package calculadora.Windows;

//imports libs
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

//Create class and extends JFrame (javax.swing.JFrame) allowed to create interface graphs
public class JVJFrame extends JFrame {
	public static JTextField view = null;
	public static Integer[] margin = {10, 90};
	
	private static String simbolo = "";
	
	public static String getSimbolo() {
		return JVJFrame.simbolo;
	}
	
	public static void setSimbolo(String input) {
		JVJFrame.simbolo = input;
	}
	
	public JVJFrame() {
		System.out.println("Init app");
		this.setPreferredSize(new Dimension(320, 410));	//Screen size
		this.setTitle("Calculadora");	//App title
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	//Event on click closed
		this.setLocationRelativeTo(null);	//Location in screen center
		this.getContentPane().setBackground(Color.decode("#BCCFE6"));	//Background color
		this.setResizable(false);	//Screen resizable in boolean
		this.setLayout(null);	//Allows you to add items
		
		Interfaz();
		this.pack();
		this.setVisible(true); //set visibility in boolean
	}
	
	private void Interfaz() {
		view = new JTextField("");
		view.setBounds(10, 10, 305, 70);
		view.setFont(new Font("Arial", Font.PLAIN, 28));
		view.setBorder(new LineBorder(Color.decode("#4D6380"), 5));
		view.setEditable(false);
		this.add(view);
		
		Numers();	//Create number panel
	}
	
	private void Numers() {
		CreateButtons.margin = margin;
		
		Integer i = 9;
		
		for(Integer iy = 0; iy < 4; iy++) {
			for(Integer ix = 0; ix < 3; ix++) {
				CreateButtons btn = null;
				if(i > 0) {
					btn = new CreateButtons((String) "" + i, (Integer) 150 - (75 * ix), (Integer) 75 * iy);
				}else if(i == 0) {
					btn = new CreateButtons((String) "=", (Integer) 150 - (75 * ix), (Integer) 75 * iy);
				}else if(i == -1) {
					btn = new CreateButtons((String) "0", (Integer) 150 - (75 * ix), (Integer) 75 * iy);
				}else if(i == -2) {
					btn = new CreateButtons((String) ".", (Integer) 150 - (75 * ix), (Integer) 75 * iy);
				}
				JButton Button = (JButton) btn.Button;
				this.add(Button);
				i--;
			}
		}
		
		for(Integer i1 = 0; i1 <= 5; i1++) {
			CreateButtons btn = null;
			if(i1 == 0) {
				btn = new CreateButtons((String) "DEL", (Integer) (75 * 3), 50 * i1, 75, 45);
			}else if(i1 == 1) {
				btn = new CreateButtons((String) "AC", (Integer) (75 * 3), 50 * i1, 75, 45);
			}else if(i1 == 2) {
				btn = new CreateButtons((String) "+", (Integer) (75 * 3), 50 * i1, 75, 45);
			}else if(i1 == 3) {
				btn = new CreateButtons((String) "-", (Integer) (75 * 3), 50 * i1, 75, 45);
			}else if(i1 == 4) {
				btn = new CreateButtons((String) "*", (Integer) (75 * 3), 50 * i1, 75, 45);
			}else if(i1 == 5) {
				btn = new CreateButtons((String) "/", (Integer) (75 * 3), 50 * i1, 75, 45);
			}
			JButton Button = (JButton) btn.Button;
			this.add(Button);
		}
	}
	
	public static String Calcular() {
		if(!JVJFrame.simbolo.equals("")) {
			String text = JVJFrame.view.getText();
			System.out.println("Simbolo: " + "'" + JVJFrame.simbolo + "'");
			System.out.println("Input  : " + "'" + text + "'");
			try {
				String[] entry = text.split("\\" + JVJFrame.simbolo);
				String result = "";
				if(JVJFrame.simbolo.equals("+")) {
					result = String.valueOf(Double.valueOf(entry[0]) + Double.valueOf(entry[1]));
				}else if(JVJFrame.simbolo.equals("-")) {
					result = String.valueOf(Double.valueOf(entry[0]) - Double.valueOf(entry[1]));
				}else if(JVJFrame.simbolo.equals("*")) {
					result = String.valueOf(Double.valueOf(entry[0]) * Double.valueOf(entry[1]));
				}else if(JVJFrame.simbolo.equals("/")) {
					if(entry[1].equals("0")) {
						return "Inf";
					}else {
						result = String.valueOf(Double.valueOf(entry[0]) / Double.valueOf(entry[1]));
					}
				}
				
				String[] verific = result.split("\\.");
				if(verific[1].equals("0")) {
					return verific[0];
				}
				return result;
			}catch (Exception e) {
				System.out.println(
						"---------------------------------- \n" +
						"JVJFrame - Calcular: \n" + e + "\n" + 
						"---------------------------------- \n"
				);
			}
		}
		
		return null;
	}

}
