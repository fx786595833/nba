package mainui;

import java.awt.event.*;

import javax.swing.*;

import userbl.User;
import vo.UserVO;

public class findpassword {
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	JTextField fieldID=new JTextField();
	JTextField fieldName=new JTextField();
	
	User controller=new User();
	
	public void go() {
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		frame.setTitle("找回密码");
		
		JLabel labelID=new JLabel("用户名",JLabel.RIGHT);
		JLabel labelName=new JLabel("姓名",JLabel.RIGHT);
		JButton buttonSure=new JButton("确认");
		
		frame.setSize(wide/3+200,high/3+100);
		frame.setLocation(wide/3,high/3);
		
		panel.setLayout(null);
		labelID.setBounds(150, 100, 50, 25);
		fieldID.setBounds(210,100,150,25);
		labelName.setBounds(150,135,50,25);
		fieldName.setBounds(210,135,150,25);
		buttonSure.setBounds(250,200,65,25);
		buttonSure.addActionListener(new sureListener());
		
		panel.add(labelName);
		panel.add(fieldName);
		panel.add(labelID);
		panel.add(fieldID);
		panel.add(buttonSure);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}

	class sureListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Long id=Long.parseLong(fieldID.getText());
			String name=fieldName.getText();
			UserVO user=controller.findUser(id);
			
			if((!user.getName().equals(name))||user.getId() == id){
				JOptionPane.showMessageDialog(null,"信息输入错误");
			}
			
			else{
				User u = new User();
				String result=u.getPassword(id, name);
				JOptionPane.showMessageDialog(null,"您的密码为\n"+result);
			}
		}
	}
}
