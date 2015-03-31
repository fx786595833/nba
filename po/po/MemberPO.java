package po;

import java.io.File;
import java.text.DecimalFormat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MemberPO {
	DecimalFormat df = new DecimalFormat("#.00");
	DecimalFormat cf = new DecimalFormat("#.000");
	public String name;
	public String team;
	public String position;
	public String league;
	public String subLeague;
	public int inMatches;
	public int firstMatches;
	public int onTime;
	public int teamShotHits;
	public int teamShots;
	public int shotHits;
	public int shots;
	public int oppositeTwoShots;
	public int threeShotHits;
	public int threeShots;
	public int penaltyShotHits;
	public int penaltyShots;
	public int teamPenaltyShots;
	public int offensiveRebounds;
	public int defensiveRebounds;
	public int rebounds;
	public int bothRebounds;
	public int bothOffensiveRebounds;
	public int bothDefensiveRebounds;
	public int assists;
	public int steals;
	public int blockShots;
	public int mistakes;
	public int teamMistakes;
	public int fouls;
	public int scores;
	public int oppositeOffenceTimes;
	public double shotHitRate;
	
	public MemberPO(){
		name=null;
		team=null;
		position=null;
		league=null;
		subLeague=null;
		inMatches=0;
		firstMatches=0;
		onTime=0;
		teamShotHits=0;
		teamShots=0;
		shotHits=0;
		shots=0;
		oppositeTwoShots=0;
		threeShotHits=0;
		threeShots=0;
		penaltyShotHits=0;
		penaltyShots=0;
		teamPenaltyShots=0;
		offensiveRebounds=0;
		defensiveRebounds=0;
		rebounds=0;
		bothRebounds=0;
		bothOffensiveRebounds=0;
		bothDefensiveRebounds=0;
		assists=0;
		steals=0;
		blockShots=0;
		mistakes=0;
		teamMistakes=0;
		fouls=0;
		scores=0;
		oppositeOffenceTimes=0;
		shotHitRate=0.0;
		
	}
	public int getAllOnTime(){
		return 240*60*inMatches;
	}
	
	public double getShotHitRate(){
		 
		double result=0.00;
		if(shots!=0)
			result= shotHits/(shots*1.0);
		return Double.valueOf(df.format(result));
	}
	
	public double getThreeShotHitRate(){
		double result=0.0;
		if(threeShots!=0)
		result= threeShotHits/(threeShots*1.0);
		return Double.valueOf(df.format(result));

	}
	
	public double getPenaltyShotHitRate(){
		double result=0.0;
		if(penaltyShots!=0)
		result=penaltyShotHits/(penaltyShots*1.0);
		return Double.valueOf(df.format(result));
	}
	
	public int getOffenceTimes(){
		return shots+mistakes+assists;
	}
	
	public int getDefenceTimes(){
		return rebounds+steals+blockShots;
		
	}
	
	public int getEfficiency(){
		return scores+rebounds+assists+steals+blockShots-shots+shotHits-penaltyShots+penaltyShotHits-mistakes;
	}
	
	public double getGmScEfficiency(){
		return Double.valueOf(df.format(scores+0.4*shotHits-0.7*shots-0.4*(penaltyShots-penaltyShotHits)+0.7*offensiveRebounds+0.3*defensiveRebounds+steals+0.7*assists+0.7*blockShots-0.4*mistakes-fouls));
	}
	
	public double getTrueShotHitRate(){
		double result=0.00;
		if((shots+0.44*penaltyShots)!=0.00)
		result=scores/(2*(shots+0.44*penaltyShots));
		return Double.valueOf(df.format(result));
	}
	
	public double getShotEfficiency(){
		double result=0.00;
		if(shots!=0)
		result=(shotHits+0.5*threeShotHits)/shots;
		return Double.valueOf(df.format(result));
	}
	
	public double getReboundsRate(){
		double result=0.00;
		if(onTime!=0&&bothRebounds!=0)
		result=rebounds*(getAllOnTime()/5)/onTime/(bothRebounds*1.0);
		return Double.valueOf(df.format(result));
	}
	
	public double getOffensiveReboundsRate(){
		double result=0.00;
		if(onTime!=0&&bothOffensiveRebounds!=0)
		result=offensiveRebounds*(getAllOnTime()/5)/onTime/(bothOffensiveRebounds*1.0);
		return Double.valueOf(df.format(result));
	}
	
	public double getDefensiveReboundsRate(){
		double result=0.00;
		if(onTime!=0&&bothDefensiveRebounds!=0)
		result=defensiveRebounds*(getAllOnTime()/5)/onTime/(bothDefensiveRebounds*1.0);
		return Double.valueOf(df.format(result));
	}
	
	public double getAssistRate(){
		double result=0.00;
		if(onTime!=0&&(teamShotHits)!=0)
		result=assists/((onTime/((getAllOnTime()/5)*1.0))*(1.0*teamShotHits)-shotHits);
		return Double.valueOf(df.format(result));
	}
	
	public double getStealRate(){
		
		double result=0.00;
		if(onTime!=0&&oppositeOffenceTimes!=0)
		result=steals*(getAllOnTime()/5)/(onTime*1.0)/(oppositeOffenceTimes*1.0);
		return Double.valueOf(cf.format(result));
	}
	
	public double getBlockShotRate(){
		double result=0.00;
		if(onTime!=0&&oppositeTwoShots!=0)
		result=blockShots*(getAllOnTime()/5)/(onTime*1.0)/(oppositeTwoShots*1.0);
		return Double.valueOf(cf.format(result));
	}
	
	public double getMistakeRate(){
		double result=0.00;
		if(((shots-threeShots)+0.44*penaltyShots+mistakes)!=0.00)
		result=mistakes/((shots-threeShots)+0.44*penaltyShots+mistakes);
		return Double.valueOf(df.format(result));
	}
	
	public double getUseRate(){
		double result=0.00;
		if(onTime!=0)
		result=(shots+0.44*penaltyShots+mistakes)*(getAllOnTime()/5)/onTime/(teamShots+0.44*teamPenaltyShots+teamMistakes);
		return Double.valueOf(df.format(result));
	}
	

	
	
	

}
