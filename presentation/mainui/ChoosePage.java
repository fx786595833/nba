package mainui;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import org.apache.batik.transcoder.TranscoderException;

import playerui.MemberUI;
import teamui.teams;

class Pica extends JPanel{
	
	public Pica(BorderLayout borderLayout) {
		super(borderLayout);
	}
	public void paintComponent(Graphics g){    //��ӱ���ͼƬ
		Image image1 = new ImageIcon("Jordan.jpg").getImage();
		g.drawImage(image1,0,30,this);
	}
}

public class ChoosePage {
	JFrame frame = new JFrame("NBA���ݲ�ѯƽ̨");
	Pica panel = new Pica(null);

	public void go(String name) {
		int wide = frame.getToolkit().getScreenSize().width;      //��ȡ��Ļ����
		int high = frame.getToolkit().getScreenSize().height;
		JButton team = new JButton("��ѯ���");
		team.addActionListener(new teamListener());
		JButton player = new JButton("��ѯ��Ա");
		player.addActionListener(new playerListener());
		JButton match = new JButton("��ѯ����");
		match.addActionListener(new matchListener());
		
		JLabel label = new JLabel(name+",��ӭ�㣡",JLabel.RIGHT);
		label.setOpaque(false);
		
		frame.setSize(wide/2+100,high/2+200);
		frame.setLocation(wide/4,high/6);
	
		panel.setLayout(null);
		label.setBounds(680,10,70,25);
		team.setBounds(310,220,150,25);
		player.setBounds(310,260,150,25);
		match.setBounds(310,300,150,25);
		
		panel.add(label);
		panel.add(team);
		panel.add(player);
		panel.add(match);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}

	class teamListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			teams t = new teams();
			frame.dispose();
			t.go();
		}
	}
	
	class playerListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			MemberUI m = new MemberUI();
			try {
				m.start();
			} catch (IOException e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}
		}
	}
	
	class matchListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
		}
	}
}
