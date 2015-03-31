package teamui;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;

import javax.swing.*;

class Pical extends JPanel{
	public Pical(BorderLayout borderLayout) {
		super(borderLayout);
	}
}

public class teams {
	JFrame frame = new JFrame("球队数据查询");
	Pical panel = new Pical(null);
	ArrayList<JButton> list = new ArrayList<JButton>();
	
	public void go(){
		int wide = frame.getToolkit().getScreenSize().width;      //获取屏幕长宽
		int high = frame.getToolkit().getScreenSize().height;
		
		createButton();
		
		frame.setSize(wide/2+100,high/2+200);
		frame.setLocation(wide/4,high/6);
		
		panel.setLayout(null);
		for(int i=0;i<list.size();i++){
			list.get(i).setBounds(i%7*100+10,i/7*100+10,100,100);
			list.get(i).addActionListener(new teamListener());
		}
		
		for(int i=0;i<list.size();i++){
			panel.add(list.get(i));
		}
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void createButton() {
		JButton atl = new JButton(new ImageIcon("atl.png"));
		atl.setToolTipText("ATL");
		list.add(atl);
		JButton bkn = new JButton(new ImageIcon("bkn.png"));
		bkn.setToolTipText("BKN");
		list.add(bkn);
		JButton bos = new JButton(new ImageIcon("bos.png"));
		bos.setToolTipText("BOS");
		list.add(bos);
		JButton cha = new JButton(new ImageIcon("cha.png"));
		cha.setToolTipText("CHA");
		list.add(cha);
		JButton chi = new JButton(new ImageIcon("chi.png"));
		chi.setToolTipText("CHI");
		list.add(chi);
		JButton cle = new JButton(new ImageIcon("cle.png"));
		cle.setToolTipText("CLE");
		list.add(cle);
		JButton dal = new JButton(new ImageIcon("dal.png"));
		dal.setToolTipText("DAL");
		list.add(dal);
		JButton den = new JButton(new ImageIcon("den.png"));
		den.setToolTipText("DEN");
		list.add(den);
		JButton det = new JButton(new ImageIcon("det.png"));
		det.setToolTipText("DET");
		list.add(det);
		JButton gsw = new JButton(new ImageIcon("gsw.png"));
		gsw.setToolTipText("GSW");
		list.add(gsw);
		JButton hou = new JButton(new ImageIcon("hou.png"));
		hou.setToolTipText("HOU");
		list.add(hou);
		JButton ind = new JButton(new ImageIcon("ind.png"));
		ind.setToolTipText("IND");
		list.add(ind);
		JButton lac = new JButton(new ImageIcon("lac.png"));
		lac.setToolTipText("LAC");
		list.add(lac);
		JButton lal = new JButton(new ImageIcon("lal.png"));
		lal.setToolTipText("LAL");
		list.add(lal);
		JButton mem = new JButton(new ImageIcon("mem.png"));
		mem.setToolTipText("MEM");
		list.add(mem);
		JButton mia = new JButton(new ImageIcon("mia.png"));
		mia.setToolTipText("MIA");
		list.add(mia);
		JButton mil = new JButton(new ImageIcon("mil.png"));
		mil.setToolTipText("MIL");
		list.add(mil);
		JButton min = new JButton(new ImageIcon("min.png"));
		min.setToolTipText("MIN");
		list.add(min);
		JButton nop = new JButton(new ImageIcon("nop.png"));
		nop.setToolTipText("NOP");
		list.add(nop);
		JButton nyk = new JButton(new ImageIcon("nyk.png"));
		nyk.setToolTipText("NYK");
		list.add(nyk);
		JButton okc = new JButton(new ImageIcon("okc.png"));
		okc.setToolTipText("OKC");
		list.add(okc);
		JButton orl = new JButton(new ImageIcon("orl.png"));
		orl.setToolTipText("ORL");
		list.add(orl);
		JButton phi = new JButton(new ImageIcon("phi.png"));
		phi.setToolTipText("PHI");
		list.add(phi);
		JButton phx = new JButton(new ImageIcon("phx.png"));
		phx.setToolTipText("PHX");
		list.add(phx);
		JButton por = new JButton(new ImageIcon("por.png"));
		por.setToolTipText("POR");
		list.add(por);
		JButton sac = new JButton(new ImageIcon("sac.png"));
		sac.setToolTipText("SAC");
		list.add(sac);
		JButton sas = new JButton(new ImageIcon("sas.png"));
		sas.setToolTipText("SAS");
		list.add(sas);
		JButton tor = new JButton(new ImageIcon("tor.png"));
		tor.setToolTipText("TOR");
		list.add(tor);
		JButton uta = new JButton(new ImageIcon("uta.png"));
		uta.setToolTipText("UTA");
		list.add(uta);
		JButton was = new JButton(new ImageIcon("was.png"));
		was.setToolTipText("WAS");
		list.add(was);
	}
	
	class teamListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton temp = (JButton) e.getSource();
			String name = temp.getToolTipText();
			Icon picture = temp.getIcon();
			teamDataAnalysis t = new teamDataAnalysis();
			try {
				t.go(name,picture);
			} catch (IOException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			frame.dispose();
		}
	}
}
