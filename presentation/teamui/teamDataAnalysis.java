package teamui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.*;

import teambl.teamsManager;
import vo.teamVO;

public class teamDataAnalysis{
	JFrame frame = new JFrame("������ݲ�ѯ");
	JPanel panel = new JPanel();
	
	String[] team = {"�������","��������","Ͷ��������","Ͷ�����ִ���","����������","���ֳ�����",
			"����������","���������","����������","����������","������","������","������","��ñ��","ʧ����",
			"������","�����÷�","Ͷ��������","����������","����������","ʤ��","�����غ�","����Ч��","����Ч��",
			"����Ч��","����Ч��","������"};
//	private String[][] data = {};
	DefaultTableModel tableModel = new DefaultTableModel(0,28);
	JTable table = new JTable(tableModel);
	JScrollPane jsp = new JScrollPane(table);
	JButton button = new JButton("����");
	
	public void go(String n,Icon i) throws IOException{
		teamsManager t = new teamsManager();
		teamDataAnalysis td = new teamDataAnalysis();
		
		int wide = frame.getToolkit().getScreenSize().width;      //��ȡ��Ļ����
		int high = frame.getToolkit().getScreenSize().height;
		
		JLabel image = new JLabel(i);
		image.setBackground(Color.DARK_GRAY);
		panel.setLayout(new BorderLayout());
		panel.add(image,BorderLayout.CENTER);
		panel.add(button,BorderLayout.WEST);
		
		button.addActionListener(new returnListener());
		
		tableModel.setColumnIdentifiers(team);
		frame.setSize(wide,high);
		frame.setLayout(new BorderLayout());
		frame.setResizable(false);
		frame.setLocation(0,0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ArrayList<teamVO> list = t.getSingleTeamData(n);
		for(int i1=0;i1<list.size();i1++){
			String[] temp = new String[28];
			temp = td.getRow(list.get(i1));
			tableModel.insertRow(i1, temp);
		} 
		
		frame.add(jsp,BorderLayout.CENTER);
		frame.add(panel,BorderLayout.NORTH);
		frame.setVisible(true);
		
		
	}

	private String[] getRow(teamVO t) {
		String[] temp = new String[28];
		temp[0] = t.getName();
		temp[1] = t.getGames()+"";
		temp[2] = t.getfreeGoalMade()+"";
		temp[3] = t.getfieldGoalAttempt()+"";
		temp[4] = t.getNumberOfThreeGoalMade()+"";
		temp[5] = t.getNumberOfThreeGoalAttempt()+"";
		temp[6] = t.getFreeThrowMade()+"";
		temp[7] = t.getFreeThrowAttempt()+"";
		temp[8] = t.getOffenseRebound()+"";
		temp[9] = t.getDefenseRebound()+"";
		temp[10] = t.getRebound()+"";
		temp[11] = t.getAssist()+"";
		temp[12] = t.getSteal()+"";
		temp[13] = t.getBlockShot()+"";
		temp[14] = t.getError()+"";
		temp[15] = t.getFoul()+"";
		temp[16] = t.getScore()+"";
		temp[17] = t.getFGP()+"";
		temp[18] = t.getTGP()+"";
		temp[19] = t.getFTP()+"";
		temp[20] = t.getWinP()+"";
		temp[21] = t.getAttackRound()+"";
		temp[22] = t.getOE()+"";
		temp[23] = t.getDE()+"";
		temp[24] = t.getORE()+"";
		temp[25] = t.getDRE()+"";
		temp[26] = t.getSE()+"";
		temp[27] = t.getAE()+"";
		
		return temp;
	}
	
	class returnListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			teams t = new teams();
			t.go();
			frame.dispose();
		}
	}
}
