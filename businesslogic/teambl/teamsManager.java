package teambl;

import java.io.*;
import java.util.ArrayList;

import vo.teamVO;

public class teamsManager {
	static ArrayList<teamVO> list = new ArrayList<teamVO>();

	/*public ArrayList<teamVO> getAllTeamData() throws IOException{
		teams t = new teams();
		list.clear();
		
		for(NBAteams a:NBAteams.values()){			
			list.add(new teamVO(a.toString(),0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0.0,0.0,0.0,0.0,0,0.0,0.0,0.0,0.0,0.0));
		}
		
		File dir = new File("e:\\大二下\\软工三\\迭代一数据\\matches");
		File[] f = dir.listFiles();
		
		t.gainGames(f);
		t.gainOthers(f);
		t.gainWinP(f);
		
		return list;
	}*/
	
	public ArrayList<teamVO> getSingleTeamData(String team) throws IOException{
		teamsManager t = new teamsManager();
		list.clear();
		
		for(int i=0;i<82;i++){			
			list.add(new teamVO(team,82,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0.0,0.0,0.0,0.0,0,0.0,0.0,0.0,0.0,0.0,0.0));
		}
		
		File dir = new File("e:\\大二下\\软工三\\迭代一数据\\matches");
		File[] f = dir.listFiles();
		
		t.gainShoot(f,team);
		t.gainP();
		t.gainWinP(f,team);
		t.gainAttackRound(f,team);
	//	t.sort(list,5,0);
		
		return list;
	}

	/*public void sort(ArrayList<teamVO> l, int position, int i) {
		ArrayList<teamVO> result = new ArrayList<teamVO>();
		
	}*/

	private void gainAttackRound(File[] f,String team) throws IOException {
		int number = 0;
		for(int k=0;k<f.length;k++){
			FileReader file = new FileReader(f[k].getAbsolutePath());
			BufferedReader bf = new BufferedReader(file);
			String s = null;
			
			s = bf.readLine();
			String[] temp = s.split("-|;");
			
			int offenseScore = 0;
			int defenseScore = 0;
			
			if(temp[2].equals(team)||temp[3].equals(team)){
				if(temp[2].equals(team)){
					offenseScore = Integer.parseInt(temp[4]);
					defenseScore = Integer.parseInt(temp[5]);
				}
				else{
					offenseScore = Integer.parseInt(temp[5]);
					defenseScore = Integer.parseInt(temp[4]);
				}
				
				s = bf.readLine();
				
				int target = 0;
				int defenseRebound = 0;
				int offenseRebound = 0;
				
				int opponentGoalAttempt = 0;
				int opponentFreeThrow = 0;
				int opponentOffenseRebound = 0;
				int opponentDefenseRebound = 0;
				int opponentGoal = 0;
				int opponentError = 0;
			
				while((s = bf.readLine()) != null){
					String[] x = s.split(";");
					
					if(x.length==1){
						if(x[0].equals(team)){
							target=1;
						}
						else
							target=0;
						continue;
					}
					
					int rebound = Integer.parseInt(x[10]);
					
					
					if(target == 0){
						defenseRebound += rebound;
						opponentGoalAttempt += Integer.parseInt(x[4]);
						opponentFreeThrow += Integer.parseInt(x[8]);
						opponentOffenseRebound += Integer.parseInt(x[9]);
						opponentGoal += Integer.parseInt(x[3]);
						opponentError += Integer.parseInt(x[15]);
					}
					else if(target == 1){
						opponentDefenseRebound += Integer.parseInt(x[10]);
					}
				}
				
				int goal = list.get(number).getfieldGoalAttempt();
				int freeThrow = list.get(number).getFreeThrowAttempt();
				int attackRebound = list.get(number).getOffenseRebound();

				int fail = list.get(number).getfieldGoalAttempt()-list.get(number).getfreeGoalMade();
				int error = list.get(number).getError();

				int attackRound = (int) (goal+0.4*freeThrow-1.07*(attackRebound/(attackRebound+defenseRebound)*fail)+
						1.07*error);
				
				int defenseRound = (int) (opponentGoalAttempt+0.4*opponentFreeThrow-
						1.07*(opponentOffenseRebound/(opponentOffenseRebound+opponentDefenseRebound)*
						(opponentGoalAttempt-opponentGoal))+1.07*opponentError);
				
				double OE = (double) offenseScore/attackRound;
				double DE = (double) defenseScore/defenseRound;
				double ORE = (double) attackRebound/(attackRebound+defenseRebound);
				double DRE = (double) opponentOffenseRebound/(opponentOffenseRebound+
						opponentDefenseRebound);
				double SE = (double) list.get(number).getSteal()/defenseRound;
				double AE = (double) list.get(number).getAssist()/attackRound;
				OE = ((int) (OE*1000))/1000.0;
				DE = ((int) (DE*1000))/1000.0;
				ORE = ((int) (ORE*1000))/1000.0;
				DRE = ((int) (DRE*1000))/1000.0;
				SE = ((int) (SE*1000))/1000.0;
				AE = ((int) (AE*1000))/1000.0;
				
				list.get(number).setAttackRound(attackRound);
				list.get(number).setOE(OE);
				list.get(number).setDE(DE);
				list.get(number).setORE(ORE);
				list.get(number).setDRE(DRE);
				list.get(number).setSE(SE);
				list.get(number).setAE(AE);
				number++;
			}
		}
	}

	private void gainP() {
		for(int k=0;k<list.size();k++){
			double FGP = (double) list.get(k).getfreeGoalMade()/list.get(k).getfieldGoalAttempt();
			double FTP = (double) list.get(k).getFreeThrowMade()/list.get(k).getFreeThrowAttempt();
			double TGP = (double) list.get(k).getNumberOfThreeGoalMade()/list.get(k).getNumberOfThreeGoalAttempt();
	
			FGP = ((int) (FGP*1000))/1000.0;
			FTP = ((int) (FTP*1000))/1000.0;
			TGP = ((int) (TGP*1000))/1000.0;
			
			list.get(k).setFGP(FGP);
			list.get(k).setFTP(FTP);
			list.get(k).setTGP(TGP);
		}
	}

/*	public static void main(String[] main) throws IOException{
		teams t = new teams();
		t.getSingleTeamData("CHA");
	}*/
	
	private void gainShoot(File[] f,String team) throws IOException {
		int number = 0;      //第几场标志
		for(int i=0;i<f.length;i++){
			FileReader file = new FileReader(f[i].getAbsolutePath());
			BufferedReader bf = new BufferedReader(file);
			String s = null;
			    
			s = bf.readLine();
			String[] temp = s.split("-|;");
			if(temp[2].equals(team)||temp[3].equals(team)){
				s = bf.readLine();
				
				int target = 0;
				while((s = bf.readLine()) != null){
					String[] x = s.split(";");
					
					if(x.length==1){
						if(x[0].equals(team)){
							target=1;
						}
						else
							target=0;
						continue;
					}
				
					int goal = Integer.parseInt(x[3]);
					int goalAttempt = Integer.parseInt(x[4]);
					int threeGoal = Integer.parseInt(x[5]);
					int threeAttempt = Integer.parseInt(x[6]);
					int freeThrow = Integer.parseInt(x[7]);
					int freeAttempt = Integer.parseInt(x[8]);
					int attackRebound = Integer.parseInt(x[9]);
					int defenseRebound = Integer.parseInt(x[10]);
					int rebound = Integer.parseInt(x[11]);
					int assist = Integer.parseInt(x[12]);
					int steal = Integer.parseInt(x[13]);
					int block = Integer.parseInt(x[14]);
					int error = Integer.parseInt(x[15]);
					int foul = Integer.parseInt(x[16]);
					int score = Integer.parseInt(x[17]);
					
					if(target==1){
						list.get(number).setfreeGoalMade(list.get(number).getfreeGoalMade()+
								goal);
						list.get(number).setfieldGoalAttempt(list.get(number).getfieldGoalAttempt()+goalAttempt);
						list.get(number).setNumberOfThreeGoalMade(list.get(number).getNumberOfThreeGoalMade()+threeGoal);
						list.get(number).setNumberOfThreeGoalAttempt(list.get(number).getNumberOfThreeGoalAttempt()+threeAttempt);
						list.get(number).setFreeThrowMade(list.get(number).getFreeThrowMade()+freeThrow);
						list.get(number).setFreeThrowAttempt(list.get(number).getFreeThrowAttempt()+freeAttempt);
						list.get(number).setOffenseRebound(list.get(number).getOffenseRebound()+attackRebound);
						list.get(number).setDefenseRebound(list.get(number).getDefenseRebound()+defenseRebound);
						list.get(number).setRebound(list.get(number).getRebound()+rebound);
						list.get(number).setAssist(list.get(number).getAssist()+assist);
						list.get(number).setSteal(list.get(number).getSteal()+steal);
						list.get(number).setBlockShot(list.get(number).getBlockShot()+block);
						list.get(number).setError(list.get(number).getError()+error);
						list.get(number).setFoul(list.get(number).getFoul()+foul);
						list.get(number).setScore(list.get(number).getScore()+score);
					}		
				}
				number++;
			}
		}
	}

	private void gainWinP(File[] f,String t) throws IOException {
		for(int i=0;i<f.length;i++){
			FileReader file = new FileReader(f[i].getAbsolutePath());
			BufferedReader bf = new BufferedReader(file);
			String s = null;
			
			s=bf.readLine();
			String[] win = s.split(";");
			String[] teams = win[1].split("-");
			String[] scores = win[2].split("-");
			int first = Integer.parseInt(scores[0]);
			int second = Integer.parseInt(scores[1]);
			
			if(teams[0].equals(t)){
				if(first>second){
					for(int j=0;j<list.size();j++){
						list.get(j).setWinP(list.get(j).getWinP()+1.0);
					}
				}
			}
			
			else if(teams[1].equals(t)){
				if(first<second){
					for(int j=0;j<list.size();j++){
						list.get(j).setWinP(list.get(j).getWinP()+1.0);
					}
				}
			}
		}
		
		for(int i=0;i<list.size();i++){
			double p = list.get(i).getWinP()/82;
			p = ((int) (p*1000))/1000.0;
			list.get(i).setWinP(p);
		}
	}

	/*private void gainGames(File[] f) throws IOException{
		for(int i=0;i<f.length;i++){
			FileReader file = new FileReader(f[i].getAbsolutePath());
			BufferedReader bf = new BufferedReader(file);
			String s = null;
			
			s = bf.readLine();
			String[] troops = s.split(";|-");
		
			for(int j=0;j<list.size();j++){
				if(troops[2].equals(list.get(j).getName())){
					list.get(j).setGames(list.get(j).getGames()+1);
				}
			}
			
			for(int j=0;j<list.size();j++){
				if(troops[3].equals(list.get(j).getName())){
					list.get(j).setGames(list.get(j).getGames()+1);
				}
			}
		}
	}*/
	
	/*private void gainOthers(File[] f) throws IOException{
		for(int j=0;j<f.length;j++){
			FileReader file = new FileReader(f[j].getAbsolutePath());
			BufferedReader bf = new BufferedReader(file);
			String s = null;
			s=bf.readLine();
			s=bf.readLine();
		
			int i=0;
			
			while((s=bf.readLine())!=null){
				String[] temp = s.split(";");
				if(temp.length==1){
					for(i=0;i<list.size();i++){
						if(temp[0].equals(list.get(i).getName()))
							break;
					}
				}
				else{
					int goal = Integer.parseInt(temp[3]);
					int attempt = Integer.parseInt(temp[4]);
					int threeGoal = Integer.parseInt(temp[5]);
					int threeAttempt = Integer.parseInt(temp[6]);
					int freeThrow = Integer.parseInt(temp[7]);
					int freeAttempt = Integer.parseInt(temp[8]);
					int attackRebound = Integer.parseInt(temp[9]);
					int defenseRebound = Integer.parseInt(temp[10]);
					int rebound = Integer.parseInt(temp[11]);
					int assist = Integer.parseInt(temp[12]);
					int steal = Integer.parseInt(temp[13]);
					int block = Integer.parseInt(temp[14]);
					int error = Integer.parseInt(temp[15]);
					int foul = Integer.parseInt(temp[16]);
					int score = Integer.parseInt(temp[17]);
					
					
					list.get(i).setfreeGoalMade(list.get(i).getfreeGoalMade()+goal);
					list.get(i).setfieldGoalAttempt(list.get(i).getfieldGoalAttempt()+attempt);
					list.get(i).setNumberOfThreeGoalMade(list.get(i).getNumberOfThreeGoalMade()+threeGoal);
					list.get(i).setNumberOfThreeGoalAttempt(list.get(i).getNumberOfThreeGoalAttempt()+threeAttempt);
					list.get(i).setFreeThrowMade(list.get(i).getFreeThrowMade()+freeThrow);
					list.get(i).setFreeThrowAttempt(list.get(i).getFreeThrowAttempt()+freeAttempt);
					list.get(i).setAttackRound(list.get(i).getAttackRound()+attackRebound);
					list.get(i).setDefenseRebound(list.get(i).getDefenseRebound()+defenseRebound);
					list.get(i).setRebound(list.get(i).getRebound()+rebound);
					list.get(i).setAssist(list.get(i).getAssist()+assist);
					list.get(i).setSteal(list.get(i).getSteal()+steal);
					list.get(i).setBlockShot(list.get(i).getBlockShot()+block);
					list.get(i).setError(list.get(i).getError()+error);
					list.get(i).setFoul(list.get(i).getFoul()+foul);
					list.get(i).setScore(list.get(i).getScore()+score);
				}
			}
		}
		
		for(int k=0;k<list.size();k++){
			double FGP = (double) list.get(k).getfreeGoalMade()/list.get(k).getfieldGoalAttempt();
			double FTP = (double) list.get(k).getFreeThrowMade()/list.get(k).getFreeThrowAttempt();
			double TGP = (double) list.get(k).getNumberOfThreeGoalMade()/list.get(k).getNumberOfThreeGoalAttempt();
	
			FGP = ((int) (FGP*1000))/1000.0;
			FTP = ((int) (FTP*1000))/1000.0;
			TGP = ((int) (TGP*1000))/1000.0;
			
			list.get(k).setFGP(FGP);
			list.get(k).setFTP(FTP);
			list.get(k).setTGP(TGP);
		}
	}*/
}
