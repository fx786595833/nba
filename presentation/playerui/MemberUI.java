package playerui;
import dataservice.MemberData;

import playerbl.MemberLogic;
import po.MemberPO;


import javax.swing.*;

import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.*;
import java.io.*;

import javax.swing.table.AbstractTableModel;  




public class MemberUI {
	 
	JComboBox position,league,subLeague,sortData;	
	String positions[]={"G","F","C"};
	String leagues[]={"E","W"};
	String subLeagues[]={};
	String sortDatas[]={"得分","篮板","助攻","得分/助攻/篮板","盖帽","抢断","犯规","失误","分钟","效率","投篮","三分","罚球","两双"};
	public void start()throws IOException{
		MemberLogic ml=new MemberLogic();
		Object[][] data=ml.poToList();
		String[] columnNames= { "球员名称", "所属球队", "参赛场数",  
	            "先发场数", "篮板数","助攻数","在场时间","投篮命中率","三分命中率","罚球命中率","进攻数","方守数","抢断数","盖帽数","失误数","犯规数","得分"
	            ,"效率","GmSc效率值","真实命中率","投篮效率","篮板率","进攻篮板率","防守篮板率","助攻率","抢断率","盖帽率","失误率","使用率"};
		MyTableModel model = new MyTableModel(data,columnNames);  
		TableRowSorter<MyTableModel> sorter = new TableRowSorter<MyTableModel>(model); 
		JTable table = new JTable(model);  
		table.setAutoCreateRowSorter(true); 
		table.setRowSorter(sorter); 
		table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
		
		JScrollPane scrollPane = new JScrollPane(table);  
	    table.setFillsViewportHeight(true);
		JFrame f=new JFrame();
		JPanel pl=new JPanel();
		JLabel l1=new JLabel("position");
		position=new JComboBox(positions);
		JLabel l2=new JLabel("league");
		league=new JComboBox(leagues);
		JLabel l3=new JLabel("subLeagues");
		league.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				  if (e.getStateChange()==ItemEvent.SELECTED){
					  String te=league.getSelectedItem().toString();
					  if(te.equals("E")){
						  String[] subList={"Southeast","Atlantic","Central"};
						  subLeague.removeAllItems();
							for(int i=0;i<subList.length;i++){
								subLeague.addItem(subList[i]);
							}
					  }
					  if(te.equals("W")){
						  String[] subList={"Southwest","Atlantic","Northwest","Pacific"};
						  subLeague.removeAllItems();
							for(int i=0;i<subList.length;i++){
								subLeague.addItem(subList[i]);
							}
					  }
					 
						
				
			}
			}
		});
		subLeague=new JComboBox(subLeagues);
		JLabel l4=new JLabel("sortData");
		sortData=new JComboBox(sortDatas);
		JButton b=new JButton("筛选");
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});;
		pl.add(l1);
		pl.add(position);
		pl.add(l2);
		pl.add(league);
		pl.add(l3);
		pl.add(subLeague);
		pl.add(l4);
		pl.add(sortData);
		pl.add(b);
		Container contentPane=f.getContentPane();
		scrollPane.setViewportView(table);
		contentPane.setLayout(new BorderLayout());
		contentPane.add(pl,BorderLayout.NORTH);
		contentPane.add(scrollPane,BorderLayout.CENTER);
		f.pack();
		f.setName("球员信息查询系统");
		f.setBounds(300,100,600,600);
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
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
