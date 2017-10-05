import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame implements ActionListener {

	int s=0;
	int num1,num2,result;
	String temp1,temp2="";
	boolean finish = false;
	private JPanel panel;
	private JTextField tfield;
	private JButton[] buttons;
	private String[] labels = {
			"7","8","9","/",
			"4","5","6","*",
			"1","2","3","-",
			"C","0","=","+",
	};
	
	
	public Calculator(){
		tfield = new JTextField(35);
		panel = new JPanel();
		tfield.setEnabled(false);
		
		setTitle("°è»ê±â");
		
		panel.setLayout(new GridLayout(0, 4, 3, 3));
		buttons = new JButton[16];
		int index = 0;
		
		for(int rows = 0; rows<4; rows++){
			for(int cols=0; cols<4; cols++){
				buttons[index] = new JButton(labels[index]);
				if(rows >=3)
				{
					if(cols ==0 || cols==2)
						buttons[index].setForeground(Color.orange);
					else if(cols ==1)
						buttons[index].setForeground(Color.black);
					else
						buttons[index].setForeground(Color.blue);
				}
				else if(cols >=3)
					buttons[index].setForeground(Color.blue);
				else
					buttons[index].setForeground(Color.black);
				panel.add(buttons[index]);
				index++;
			}
		}
		
		for(int i=0; i<16; i++)
		{
			buttons[i].addActionListener(this);
		}
		
		tfield.setForeground(Color.black);
		add(tfield, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		setVisible(true);
		
		pack();
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		String input =e.getActionCommand();
	
		if(input.equals("+")){
			num1 = num2;
			temp1 = "+";
			temp2 = "";
		}
		else if(input.equals("-")){
			num1 = num2;
			temp1 = "-";
			temp2 = "";
		}
		else if(input.equals("*")){
			num1 = num2;
			temp1 = "*";
			temp2 = "";
		}
		else if(input.equals("/")){
			num1 = num2;
			temp1 = "/";
			temp2 = "";
		}
		else if(input.equals("C")){
			temp2 = "";
			num2 = 0;
			num1 = 0;
		}
		else if(input.equals("=")){
			if(temp1.equals("+")){
				result = num1+num2;
				tfield.setText(String.valueOf(result));
				finish = true;
			}
			else if(temp1.equals("-")){
				result = num1-num2;
				tfield.setText(String.valueOf(result));
				finish = true;
			}
			else if(temp1.equals("*")){
				result = num1*num2;
				tfield.setText(String.valueOf(result));
				finish = true;
			}
			else if(temp1.equals("/")){
				result = num1/num2;
				tfield.setText(String.valueOf(result));
				finish = true;
			}
		}
		else{
			if(finish){
				tfield.setText("0");
				finish = false;
				num2 = 0;
				num1 = 0;
				temp2 ="";
			}
			temp2 += e.getActionCommand();
			System.out.println(temp2);
			tfield.setText(temp2);
			num2 = Integer.parseInt(temp2);
		}
	}
	
	public static void main(String[] args) {
		Calculator s = new Calculator();
	}

}
