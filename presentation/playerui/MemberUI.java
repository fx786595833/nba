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
	String sortDatas[]={"�÷�","����","����","�÷�/����/����","��ñ","����","����","ʧ��","����","Ч��","Ͷ��","����","����","��˫"};
	public void start()throws IOException{
		MemberLogic ml=new MemberLogic();
		Object[][] data=ml.poToList();
		String[] columnNames= { "��Ա����", "�������", "��������",  
	            "�ȷ�����", "������","������","�ڳ�ʱ��","Ͷ��������","����������","����������","������","������","������","��ñ��","ʧ����","������","�÷�"
	            ,"Ч��","GmScЧ��ֵ","��ʵ������","Ͷ��Ч��","������","����������","����������","������","������","��ñ��","ʧ����","ʹ����"};
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
		JButton b=new JButton("ɸѡ");
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
		f.setName("��Ա��Ϣ��ѯϵͳ");
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
