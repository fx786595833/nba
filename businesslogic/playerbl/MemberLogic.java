package playerbl;
import po.MemberPO;

import dataservice.MemberData;
import java.util.*;
import java.io.*;

public class MemberLogic {
	public Object[][] poToList() throws IOException{
		MemberData md=new MemberData();
		ArrayList<MemberPO> memberList=new ArrayList<MemberPO>();
		memberList=md.toMemberList();
		Object[][] result=new Object[memberList.size()][29];
		for(int i=0;i<memberList.size();i++){
			MemberPO temp=memberList.get(i);
			result[i][0]=temp.name;
			result[i][1]=temp.team;
			result[i][2]=new Integer(temp.inMatches);
			result[i][3]=new Integer(temp.firstMatches);
			result[i][4]=new Integer(temp.rebounds);
			result[i][5]=new Integer(temp.assists);
			result[i][6]=new Integer(temp.onTime);
			result[i][7]=new Double(temp.getShotHitRate());
			result[i][8]=new Double(temp.getThreeShotHitRate());
			result[i][9]=new Double(temp.getPenaltyShotHitRate());
			result[i][10]=new Integer(temp.getOffenceTimes());
			result[i][11]=new Integer(temp.getDefenceTimes());
			result[i][12]=new Integer(temp.steals);
			result[i][13]=new Integer(temp.blockShots);
			result[i][14]=new Integer(temp.mistakes);
			result[i][15]=new Integer(temp.fouls);
			result[i][16]=new Integer(temp.scores);
			result[i][17]=new Integer(temp.getEfficiency());
			result[i][18]=new Double(temp.getGmScEfficiency());
			result[i][19]=new Double(temp.getTrueShotHitRate());
			result[i][20]=new Double(temp.getShotEfficiency());
			result[i][21]=new Double(temp.getReboundsRate());
			result[i][22]=new Double(temp.getOffensiveReboundsRate());
			result[i][23]=new Double(temp.getDefensiveReboundsRate());
			result[i][24]=new Double(temp.getAssistRate());
			result[i][25]=new Double(temp.getStealRate());
			result[i][26]=new Double(temp.getBlockShotRate());
			result[i][27]=new Double(temp.getMistakeRate());
			result[i][28]=new Double(temp.getUseRate());
		}
		return result;
	}
	
	public ArrayList<MemberPO> sortList(String position,String league,String subLeague)throws IOException{
		MemberData md=new MemberData();
		ArrayList<MemberPO> memberList=new ArrayList<MemberPO>();
		memberList=md.toMemberList();
		for(MemberPO temp:memberList){
			if(temp.team!=null&&temp.team.equals(position)){
				System.out.println(temp.name+" "+temp.team);
				
			}
		}
		return memberList;
		
	}
	
	
	
	

}
