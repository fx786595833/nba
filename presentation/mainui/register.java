package mainui;

import java.awt.event.*;

import javax.swing.*;

import userbl.User;
import enumType.ResultMessage;

public class register {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	
	JTextField fieldName = new JTextField();
	JTextField fieldID = new JTextField();
	JPasswordField password = new JPasswordField();
	JPasswordField passwordConfirm = new JPasswordField();
	
	public void go() {
		int wide = frame.getToolkit().getScreenSize().width;
		int high = frame.getToolkit().getScreenSize().height;
		
		frame.setTitle("����ע��");
		
		JLabel labelName = new JLabel("����",JLabel.RIGHT);
		JLabel IDName = new JLabel("ID",JLabel.RIGHT);
		JLabel labelPassword = new JLabel("����",JLabel.RIGHT);
		JLabel labelPasswAgain = new JLabel("ȷ������",JLabel.RIGHT);
		JButton buttonSure = new JButton("ȷ��");
		JButton buttonCancel = new JButton("ȡ��");
		
		buttonSure.addActionListener(new sureListener());
		buttonCancel.addActionListener(new cancelListener());
		
		frame.setSize(wide/3+200,high/3+100);
		frame.setLocation(wide/3,high/3);
		
		panel.setLayout(null);
		labelName.setBounds(200,80,70,25);
		fieldName.setBounds(275,80,150,25);
		IDName.setBounds(200,110,70,25);
		fieldID.setBounds(275,110,150,25);
		labelPassword.setBounds(200,140,70,25);
		password.setBounds(275,140,150,25);
		labelPasswAgain.setBounds(200,170,70,25);
		passwordConfirm.setBounds(275,170,150,25);
		buttonCancel.setBounds(280,200,65,25);
		buttonSure.setBounds(360,200,65,25);
		
		panel.add(labelName);
		panel.add(fieldName);
		panel.add(fieldID);
		panel.add(IDName);
		panel.add(password);
		panel.add(labelPassword);
		panel.add(labelPasswAgain);
		panel.add(passwordConfirm);
		panel.add(buttonSure);
		panel.add(buttonCancel);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}

	class sureListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			User user = new User();
			
			if(!new String(password.getPassword()).equals(new String(passwordConfirm.getPassword()))){
				JOptionPane.showMessageDialog(null,"��ȷ����������" );
			}
			
			else{
				ResultMessage result = user.register(fieldName.getText(), password.getPassword().toString());
				if(result == ResultMessage.Success){
					JOptionPane.showMessageDialog(null,"������ɹ�" );
					frame.dispose();
				}
				
				else{
					JOptionPane.showMessageDialog(null,"����ʧ��" );
				}
			}
		}
	}
	
	class cancelListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			frame.dispose();
		}
	}
}
