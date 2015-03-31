package mainui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import enumType.ResultMessage;
import userbl.*;
import vo.UserVO;

class Pic extends JPanel{
	
	public Pic(BorderLayout borderLayout) {
		super(borderLayout);
	}
	public void paintComponent(Graphics g){    //��ӱ���ͼƬ
		Image image1 = new ImageIcon("Blake Griffin.png").getImage();
		Image image2 = new ImageIcon("Kobe Bryant.png").getImage();
		g.drawImage(image1,0,-70,this);
		g.drawImage(image2,400,0,this);
	}
}

public class HomePage {
	JFrame frame = new JFrame("NBA����ƽ̨");
	Pic panel = new Pic(null);
	JTextField field = new JTextField();
	JPasswordField password = new JPasswordField();
	User user = new User();
 	
	public static void main(String[] args){
		HomePage a = new HomePage();
		a.go();
	}
	
	public void go(){	
		int wide = frame.getToolkit().getScreenSize().width;      //��ȡ��Ļ����
		int high = frame.getToolkit().getScreenSize().height;
		
		JLabel labelName = new JLabel("�û���",JLabel.RIGHT);
		labelName.setOpaque(false);                            //���ÿؼ�͸��
		JLabel labelPassword = new JLabel("����",JLabel.RIGHT);
		labelPassword.setOpaque(false);
		JButton buttonSure = new JButton("��½");
		buttonSure.addActionListener(new loginListener());
		JButton buttonRegister = new JButton("ע��");
		buttonRegister.addActionListener(new registerListener());
		JButton buttonFind = new JButton("��������");
		buttonFind.addActionListener(new findListener());
		JButton skip = new JButton("����");
		skip.addActionListener(new mainpageListener());
		
		frame.setSize(wide/2+100,high/2+200);
		frame.setLocation(wide/4,high/6);
		
		panel.setLayout(null);
		labelName.setBounds(250,220,50,25);
		field.setBounds(310,220,150,25);
		labelPassword.setBounds(250,270,50,25);
		password.setBounds(310,270,150,25);
		buttonSure.setBounds(350,320,65,25);
		buttonRegister.setBounds(500,220,90,25);
		buttonFind.setBounds(500,270,90,25);
		skip.setBounds(680,10,70,25);
		
		panel.add(labelName);
		panel.add(labelPassword);
		panel.add(password);
		panel.add(field);
		panel.add(buttonFind);
		panel.add(buttonRegister);
		panel.add(buttonSure);
		panel.add(skip);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class loginListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			long id = Long.parseLong(field.getText());
			String password2 = new String(password.getPassword());
			ResultMessage result = user.verify(id, password2);
			
			if(result == ResultMessage.Failure){
				JOptionPane.showMessageDialog(null,"�û����������������");
			}
			
			else{
				UserVO u = user.findUser(id);
				ChoosePage m = new ChoosePage();
				m.go(u.getName());
				frame.dispose();
			}
		}
	}
	
	class registerListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			register r = new register();
			r.go();
		}
	}
	
	class findListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			findpassword find = new findpassword();
			find.go();
		}
	}
	
	class mainpageListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			ChoosePage m = new ChoosePage();
			frame.dispose();
			m.go("");
		}
	}
}