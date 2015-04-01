package teamui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.*;
import javax.swing.table.*;

import playerbl.MemberLogic;
import teambl.teamsManager;
import vo.teamVO;

public class teamDataAnalysis{
	JFrame frame = new JFrame("球队数据查询");
	JPanel panel = new JPanel();
	
	String[] team = {"球队名称","比赛场数","投篮命中数","投篮出手次数","三分命中数","三分出手数",
			"罚球命中数","罚球出手数","进攻篮板数","防守篮板数","篮板数","助攻数","抢断数","盖帽数","失误数",
			"犯规数","比赛得分","投篮命中率","三分命中率","罚球命中率","胜率","进攻回合","进攻效率","防守效率",
			"篮板效率","抢断效率","助攻率"};
//	private String[][] data = {};
	
	public void go(String n,Icon i) throws IOException{
		teamsManager t = new teamsManager();
		teamDataAnalysis td = new teamDataAnalysis();
		
		Object[][] data=t.getSingleTeamData(n);
		
		MyTableModel tableModel = new MyTableModel(data,team);
		TableRowSorter<MyTableModel> sorter = new TableRowSorter<MyTableModel>(tableModel);
		JTable table = new JTable(tableModel);
		JScrollPane jsp = new JScrollPane(table);
		table.setAutoCreateRowSorter(true); 
		table.setRowSorter(sorter); 
		table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
		
		JButton button = new JButton("返回");
		
		int wide = frame.getToolkit().getScreenSize().width;      //获取屏幕长宽
		int high = frame.getToolkit().getScreenSize().height;
		
		JLabel image = new JLabel(i);
		image.setBackground(Color.DARK_GRAY);
		panel.setLayout(new BorderLayout());
		panel.add(image,BorderLayout.CENTER);
		panel.add(button,BorderLayout.WEST);
		
		button.addActionListener(new returnListener());
		
		
		table.setFillsViewportHeight(true);
		frame.setSize(wide/2+100,high/2+200);
		frame.setLocation(wide/4,high/6);
		frame.setLayout(new BorderLayout());
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.add(jsp,BorderLayout.CENTER);
		frame.add(panel,BorderLayout.NORTH);
		frame.setVisible(true);
		
		
	}

	class returnListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			teams t = new teams();
			t.go();
			frame.dispose();
		}
	}
	
	class MyTableModel extends AbstractTableModel  { 
		MemberLogic ml=new MemberLogic();
	    private String[] columnNames ; 
	    
	    
	    private Object[][] data ;  
	    
	    public MyTableModel(Object[][] data,String[] columnNames) {
	        super();
	        this.data = data;
	        this.columnNames=columnNames;
	         
	    }
	 
	    public int getColumnCount() {  
	      return columnNames.length;  
	    }  
	  
	    public int getRowCount() {  
	      return data.length;  
	    }  
	    
	    
	    public String getColumnName(int col) {  
	      return columnNames[col];  
	    }  
	  
	    public Object getValueAt(int row, int col) {  
	      return data[row][col];  
	    }  
	 
	    public Class getColumnClass(int c) {  
	      return getValueAt(0, c).getClass();  
	    }  
	    
	    
	  }  
}
