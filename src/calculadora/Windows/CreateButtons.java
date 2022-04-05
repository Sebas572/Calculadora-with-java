package calculadora.Windows;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class CreateButtons {
	private String name;
	private Integer x0, y0, x1, y1;
	
	public static Integer[] margin = {0, 0};
	 
	public JButton Button;
	
	public CreateButtons(String name, Integer x0, Integer y0, Integer x1, Integer y1) {
		this.name = name;
		this.x0 = x0;
		this.y0 = y0;
		this.x1 = x1;
		this.y1 = y1;
		
		create();
	}
	
	public CreateButtons(String name, Integer x0, Integer y0, Integer xy1) {
		this.name = name;
		this.x0 = x0;
		this.y0 = y0;
		this.x1 = xy1;
		this.y1 = xy1;
		
		create();
	}

	public CreateButtons(String name, Integer x0, Integer y0) {
		this.name = name;
		this.x0 = x0;
		this.y0 = y0;
		this.x1 = 70;
		this.y1 = 70;
		
		create();
	}
	
	public void create() {
		this.Button = new JButton((String) this.name);	//create button that has Boton as text
		this.Button.setFont(new Font("Arial", Font.BOLD, 18));	//letter format
		this.Button.setForeground(Color.decode("#E5F1FF"));	//Font color
		this.Button.setBackground(Color.decode("#4D9DFF"));	//Background color
		this.Button.setBorder(new LineBorder(Color.decode("#4D6380"), 5));	//Set borders
		this.Button.setBounds(this.x0 + CreateButtons.margin[0], this.y0 + CreateButtons.margin[1], this.x1, this.y1);	//Dimension
		this.Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton) e.getSource();
				boolean findSimbols = ( (btn.getText().equals("+")) || (btn.getText().equals("-")) || (btn.getText().equals("*")) || (btn.getText().equals("/")) );
				
				if(btn.getText().equals("=")) {
					Result();
				}else if((findSimbols) && (!JVJFrame.view.getText().equals(""))) {
					insertSimbols(btn);
				}else if(btn.getText().equals("DEL")) {
					JVJFrame.view.setText(DELCharacter());
				}else if(btn.getText().equals("AC")) {
					JVJFrame.view.setText("");
				}else if(!findSimbols) {
					insertNumbers(btn);
				}
			}
		});
	}
	
	public String DELCharacter() {
		String writing = "";
		for(Integer i = 0; i <= JVJFrame.view.getText().length()-2; i++) {
			writing += JVJFrame.view.getText().charAt(i);
		}
		return writing;
	}
	
	public void Result() {
		if(JVJFrame.Calcular() != null) {
			JVJFrame.view.setText(JVJFrame.Calcular());
			JVJFrame.setSimbolo("");
		}
	}
	
	public void insertSimbols(JButton btn) {
		if(JVJFrame.Calcular() != null) {JVJFrame.view.setText(JVJFrame.Calcular());}
		String letter = String.valueOf(JVJFrame.view.getText().charAt(JVJFrame.view.getText().length()-1));
		
		if((letter.equals("+")) || (letter.equals("-")) || (letter.equals("*")) || (letter.equals("/"))) {
			JVJFrame.view.setText(DELCharacter() + btn.getText());
		}else {
			JVJFrame.view.setText(JVJFrame.view.getText() + btn.getText());
		}
		
		JVJFrame.setSimbolo(btn.getText());
	}
	
	public void insertNumbers(JButton btn) {
		String text = JVJFrame.view.getText() + btn.getText();
		
		if(JVJFrame.view.getText().equals("Inf")) {
			JVJFrame.view.setText(btn.getText());
		}else {
			JVJFrame.view.setText(text);
		}
	}
}