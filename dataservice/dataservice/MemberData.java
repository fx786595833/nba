package dataservice;
import po.MemberPO;




import java.text.DecimalFormat;

import java.util.*;
import java.io.*;

public class MemberData {
		public static List<File> getFiles(String path){
		    File root = new File(path);
		    List<File> files = new ArrayList<File>();
		    if(!root.isDirectory()){
		        files.add(root);
		    }else{
		        File[] subFiles = root.listFiles();
		        for(File f : subFiles){
		            files.addAll(getFiles(f.getAbsolutePath()));
		        }    
		    }
		    return files;
		}//读取一个文件夹中的所有文件名
		
		public static ArrayList<String[]> getContentByLocalFile(File path) throws IOException {
			ArrayList<String[]> stringList=new ArrayList<String[]>();
			BufferedReader br=new BufferedReader(new FileReader(path));
			String a;
			while((a=br.readLine())!=null){
				String[] temp=a.split(";");
				stringList.add(temp);
			}
			br.close();
			return stringList;
	    }  //读取文本文件中的内容
		
		public static String passPosition(File file)throws IOException{
			String result=null;
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));  
			String a;
			int n=0;
			int forward=0,back=0;
			while((a=br.readLine())!=null){
				n++;
				if(n==6){
					for(int i=0;i<a.length();i++){
						if(a.charAt(i)=='║'){
							back=i;
						}
						if(a.charAt(i)=='│'){
							forward=i;
						}
						
					}
					result=a.substring(forward+1,back).trim();
				}
			}
			return result;
		}//从文件中读取球员位置
		
		public static int minuteToSecond(String temp){
			int result=0;
			String[] a=temp.split(":");
			result=Integer.parseInt(a[0])*60+Integer.parseInt(a[1]);
			return result;
		}//转换时间为单位秒
		
		public static ArrayList<MemberPO> toMemberList()throws IOException {
			ArrayList<MemberPO> memberList=new ArrayList<MemberPO>();
		    List<File> files = getFiles("players\\info");
		    for(File f : files){
		        MemberPO temp=new MemberPO();
		        temp.name=f.getName();
		        temp.position=passPosition(f);
		        memberList.add(temp);
		    }
		    files = getFiles("matches");
		    for(File f : files){
		    	int first=0,second=0;
		    	String firstTeam=null,secondTeam=null;
		    	ArrayList<String[]> dataList=new ArrayList<String[]>();
		        dataList=getContentByLocalFile(f);
		        for(int i=0;i<dataList.size();i++){
		        	if(dataList.get(i).length==1){
		        		firstTeam=dataList.get(i)[0];
		        		first=i;
		        		break;
		        	}
		        }
		        for(int i=first;i<dataList.size();i++){
		        	if(dataList.get(i).length==1){
		        		secondTeam=dataList.get(i)[0];
		        		second=i;
		        	}
		        }//得到文档的队伍名称以及位置
		        int firstRebounds=0;
		    	int firstOffensiveRebounds=0;
		    	int firstDefensiveRebounds=0;
		    	int firstShotHits=0;
		    	int firstShots=0;
		    	int firstTwoShots=0;
		    	int firstPenaltyShots=0;
		    	int firstMistakes=0;
		    	int firstOffenceTimes=0;
		        for(int i=first+1;i<second+1;i++){
		        	String t[]=dataList.get(i);
		        	if(t.length>16){
		        	firstRebounds+=Integer.parseInt(t[11]);
		        	firstDefensiveRebounds+=Integer.parseInt(t[10]);
		        	firstOffensiveRebounds+=Integer.parseInt(t[9]);
		        	firstShotHits+=Integer.parseInt(t[3]);
		        	firstShots+=Integer.parseInt(t[4]);
		        	firstTwoShots+=Integer.parseInt(t[4])-Integer.parseInt(t[6]);
		        	firstPenaltyShots+=Integer.parseInt(t[8]);
		        	firstMistakes+=Integer.parseInt(t[15]);
		        	firstOffenceTimes+=Integer.parseInt(t[4])+Integer.parseInt(t[16])+Integer.parseInt(t[12]);
		        	}
		        	
		        
		        }
		        int secondRebounds=0;
		    	int secondOffensiveRebounds=0;
		    	int secondDefensiveRebounds=0;
		    	int secondShotHits=0;
		    	int secondShots=0;
		    	int secondTwoShots=0;
		    	int secondPenaltyShots=0;
		    	int secondMistakes=0;
		    	int secondOffenceTimes=0;
		    	for(int i=second+1;i<dataList.size();i++){
		        	String t[]=dataList.get(i);
		        	secondRebounds+=Integer.parseInt(t[11]);
		        	secondDefensiveRebounds+=Integer.parseInt(t[10]);
		        	secondOffensiveRebounds+=Integer.parseInt(t[9]);
		        	secondShotHits+=Integer.parseInt(t[3]);
		        	secondShots+=Integer.parseInt(t[4]);
		        	secondTwoShots+=Integer.parseInt(t[4])-Integer.parseInt(t[6]);
		        	secondPenaltyShots+=Integer.parseInt(t[8]);
		        	secondMistakes+=Integer.parseInt(t[15]);
		        	secondOffenceTimes+=Integer.parseInt(t[4])+Integer.parseInt(t[16])+Integer.parseInt(t[12]);
		        	
		        
		        }
		        for(int i=first+1;i<second+1;i++){
		        	String t[]=dataList.get(i);
		        	if(t.length>2){
		        		if(t[2].equals("None")){
		        			t[2]="0:0";
		        		}
		        	}
		        	for(int j=0;j<memberList.size();j++){
		        		MemberPO tem=memberList.get(j);
		        		if(tem.name.equals(t[0])){
		        			if(t[1].equals("F")||t[1].equals("G")||t[1].equals("C")){
		        				tem.firstMatches+=1;
		        			}
		        			tem.inMatches+=1;
		        			tem.onTime+=minuteToSecond(t[2]);
		        			tem.shotHits+=Integer.parseInt(t[3]);
		        			tem.shots+=Integer.parseInt(t[4]);
		        			tem.threeShotHits+=Integer.parseInt(t[5]);
		        			tem.threeShots+=Integer.parseInt(t[6]);
		        			tem.penaltyShotHits+=Integer.parseInt(t[7]);
		        			tem.penaltyShots+=Integer.parseInt(t[8]);
		        			tem.offensiveRebounds+=Integer.parseInt(t[9]);
		        			tem.defensiveRebounds+=Integer.parseInt(t[10]);
		        			tem.rebounds+=Integer.parseInt(t[11]);
		        			tem.assists+=Integer.parseInt(t[12]);
		        			tem.steals+=Integer.parseInt(t[13]);
		        			tem.blockShots+=Integer.parseInt(t[14]);
		        			tem.mistakes+=Integer.parseInt(t[15]);
		        			tem.fouls+=Integer.parseInt(t[16]);
		        			tem.scores+=Integer.parseInt(t[17]);
		        			tem.team=firstTeam;
		        			tem.bothRebounds+=firstRebounds+secondRebounds;
		        			tem.bothDefensiveRebounds+=firstDefensiveRebounds+secondDefensiveRebounds;
		        			tem.bothOffensiveRebounds+=firstOffensiveRebounds+secondOffensiveRebounds;
		        			tem.teamShotHits+=firstShotHits;
		        			tem.teamShots+=firstShots;
		        			tem.oppositeTwoShots+=secondTwoShots;
		        			tem.teamPenaltyShots+=firstPenaltyShots;
		        			tem.teamMistakes+=firstMistakes;
		        			tem.oppositeOffenceTimes+=secondOffenceTimes;
		        			
		        		}
		        		memberList.remove(j);
		        		memberList.add(j,tem);
		        	}
		        }
		        for(int i=second+1;i<dataList.size();i++){
		        	String t[]=dataList.get(i);
		        	if(t.length>2){
		        		if(t[2].equals("None")){
		        			t[2]="0:0";
		        		}
		        	}
		        	for(int j=0;j<memberList.size();j++){
		        		MemberPO tem=memberList.get(j);
		        		if(tem.name.equals(t[0])){
		        			if(t[1].equals("F")||t[1].equals("G")||t[1].equals("C")){
		        				tem.firstMatches+=1;
		        			}
		        			tem.inMatches+=1;
		        			tem.onTime+=minuteToSecond(t[2]);
		        			tem.shotHits+=Integer.parseInt(t[3]);
		        			tem.shots+=Integer.parseInt(t[4]);
		        			tem.threeShotHits+=Integer.parseInt(t[5]);
		        			tem.threeShots+=Integer.parseInt(t[6]);
		        			tem.penaltyShotHits+=Integer.parseInt(t[7]);
		        			tem.penaltyShots+=Integer.parseInt(t[8]);
		        			tem.offensiveRebounds+=Integer.parseInt(t[9]);
		        			tem.defensiveRebounds+=Integer.parseInt(t[10]);
		        			tem.rebounds+=Integer.parseInt(t[11]);
		        			tem.assists+=Integer.parseInt(t[12]);
		        			tem.steals+=Integer.parseInt(t[13]);
		        			tem.blockShots+=Integer.parseInt(t[14]);
		        			tem.mistakes+=Integer.parseInt(t[15]);
		        			tem.fouls+=Integer.parseInt(t[16]);
		        			tem.scores+=Integer.parseInt(t[17]);
		        			tem.team=secondTeam;
		        			tem.bothRebounds+=secondRebounds+firstRebounds;
		        			tem.bothDefensiveRebounds+=firstDefensiveRebounds+secondDefensiveRebounds;
		        			tem.bothOffensiveRebounds+=firstOffensiveRebounds+secondOffensiveRebounds;
		        			tem.teamShotHits+=secondShotHits;
		        			tem.teamShots+=secondShots;
		        			tem.oppositeTwoShots+=firstTwoShots;
		        			tem.teamPenaltyShots+=secondPenaltyShots;
		        			tem.teamMistakes+=secondMistakes;
		        			tem.oppositeOffenceTimes+=firstOffenceTimes;
		        		}
		        		memberList.remove(j);
		        		memberList.add(j,tem);
		        	}
		        }//使球员得到基础属性
		        
		    }
		    ArrayList<String[]> teamList=new ArrayList<String[]>();
		    BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("teams\\teams"),"UTF-8"));  
			String a;
			int n=0;
			while((a=br.readLine())!=null){
				n++;
				if((n>=2)&&(n<=31))
				{
					a=a.substring(1,a.length()-1);
					String[] te=a.split("│");
					for(int i=0;i<te.length;i++){
						te[i]=te[i].trim();
					}
					teamList.add(te);
					}
			}
		    for(int i=0;i<memberList.size();i++){
		    	MemberPO temp=memberList.get(i);
		    	for(String[] data:teamList){
		    		if(temp.team!=null&&temp.team.equals(data[1])){
		    			temp.league=data[3];
		    			temp.subLeague=data[4];
		    		}
		    	}
		    	memberList.remove(i);
		    	memberList.add(i,temp);
		    	
		    }
		   
		    return memberList;
		   
		}
		
		
		
		
		
		
	
	

}
