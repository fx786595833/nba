package vo;

public class teamVO {
	private String name;
	private int games;
	private int freeGoalMade;
	private int fieldGoalAttempt;
	private int numberOfThreeGoalMade;
	private int numberofThreeGoalAttempt;
	private int freeThrowMade;
	private int freeThrowAttempt;
	private int offenseRebound;
	private int defenseRebound;
	private int rebound;
	private int assist;
	private int steal;
	private int blockShot;
	private int error;
	private int foul;
	private int score;
	private double fieldGoalPercentage;
	private double threeGoalPercentage;
	private double freeThrowPercentage;
	private double winPercentage;
	private int AttackRound;
	private double offensiveEfficiency;
	private double defenseEfficiency;
	private double offenseReboundEfficiency;
	private double defenseReboundEfficiency;
	private double stealEfficiency;
	private double assistEfficiency;
	
	public teamVO(String n,int g,int fgm,int fga,int tgm,int tga,int ftm,int fta,int or,
			int dr,int r,int a,int s,int b,int e,int f,int sc,double fgp,double tgp,
			double ftp,double wp,int ar,double oe,double de,double ore,double dre,double se,double ae){
		super();
		this.name = n;
		this.games = g;
		this.freeGoalMade = fgm;
		this.fieldGoalAttempt = fga;
		this.numberOfThreeGoalMade = tgm;
		this.numberofThreeGoalAttempt = tga;
		this.freeThrowMade = ftm;
		this.freeThrowAttempt = fta;
		this.offenseRebound = or;
		this.defenseRebound = dr;
		this.rebound = r;
		this.assist = a;
		this.steal = s;
		this.blockShot = b;
		this.error = e;
		this.foul = f;
		this.score = sc;
		this.fieldGoalPercentage = fgp;
		this.threeGoalPercentage = tgp;
		this.freeThrowPercentage = ftp;
		this.winPercentage = wp;
		this.AttackRound = ar;
		this.offensiveEfficiency = oe;
		this.defenseEfficiency = de;
		this.offenseReboundEfficiency = ore;
		this.defenseReboundEfficiency = dre;
		this.stealEfficiency = se;
		this.assistEfficiency = ae;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String n){
		this.name = n;
	}
	
	public int getGames(){
		return games;
	}
	
	public void setGames(int g){
		this.games = g;
	}
	
	public int getfreeGoalMade(){
		return freeGoalMade;
	}
	
	public void setfreeGoalMade(int m){
		this.freeGoalMade = m;
	}
	
	public int getfieldGoalAttempt(){
		return fieldGoalAttempt;
	}
	
	public void setfieldGoalAttempt(int f){
		this.fieldGoalAttempt = f;
	}
	
	public int getNumberOfThreeGoalMade(){
		return numberOfThreeGoalMade;
	}
	
	public void setNumberOfThreeGoalMade(int g){
		this.numberOfThreeGoalMade = g;
	}
	
	public int getNumberOfThreeGoalAttempt(){
		return numberofThreeGoalAttempt;
	}
	
	public void setNumberOfThreeGoalAttempt(int n){
		this.numberofThreeGoalAttempt = n;
	}
	
	public int getFreeThrowMade(){
		return freeThrowMade;
	}
	
	public void setFreeThrowMade(int m){
		this.freeThrowMade = m;
	}
	
	public int getFreeThrowAttempt(){
		return freeThrowAttempt;
	}
	
	public void setFreeThrowAttempt(int t){
		this.freeThrowAttempt = t;
	}
	
	public int getOffenseRebound(){
		return offenseRebound;
	}
	
	public void setOffenseRebound(int r){
		this.offenseRebound = r;
	}
	
	public int getDefenseRebound(){
		return defenseRebound;
	}
	
	public void setDefenseRebound(int r){
		this.defenseRebound = r;
	}
	
	public int getRebound(){
		return rebound;
	}
	
	public void setRebound(int r){
		this.rebound = r;
	}
	
	public int getAssist(){
		return assist;
	}
	
	public void setAssist(int a){
		this.assist = a;
	}
	
	public int getSteal(){
		return steal;
	}
	
	public void setSteal(int s){
		this.steal = s;
	}
	
	public int getBlockShot(){
		return blockShot;
	}
	
	public void setBlockShot(int s){
		this.blockShot = s;
	}
	
	public int getError(){
		return error;
	}
	
	public void setError(int e){
		this.error = e;
	}
	
	public int getFoul(){
		return foul;
	}
	
	public void setFoul(int f){
		this.foul = f;
	}
	
	public int getScore(){
		return score;
	}
	
	public void setScore(int s){
		this.score = s;
	}
	
	public double getFGP(){
		return fieldGoalPercentage;
	}
	
	public void setFGP(double f){
		this.fieldGoalPercentage = f;
	}
	
	public double getTGP(){
		return threeGoalPercentage;
	}
	
	public void setTGP(double t){
		this.threeGoalPercentage = t;
	}
	
	public double getFTP(){
		return freeThrowPercentage;
	}
	
	public void setFTP(double f){
		this.freeThrowPercentage = f;
	}
	
	public double getWinP(){
		return winPercentage;
	}
	
	public void setWinP(double w){
		this.winPercentage = w;
	}
	
	public int getAttackRound(){
		return AttackRound;
	}
	
	public void setAttackRound(int attackRound){
		this.AttackRound = attackRound;
	}
	
	public double getOE(){
		return offensiveEfficiency;
	}
	
	public void setOE(double o){
		this.offensiveEfficiency = o;
	}
	
	public double getDE(){
		return defenseEfficiency;
	}
	
	public void setDE(double d){
		this.defenseEfficiency = d;
	}
	
	public double getORE(){
		return offenseReboundEfficiency;
	}
	
	public void setORE(double r){
		this.offenseReboundEfficiency = r;
	}

	public double getDRE(){
		return defenseReboundEfficiency;
	}
	
	public void setDRE(double d){
		this.defenseReboundEfficiency = d;
	}
	
	public double getSE(){
		return stealEfficiency;
	}
	
	public void setSE(double s){
		this.stealEfficiency = s;
	}
	
	public double getAE(){
		return assistEfficiency;
	}
	
	public void setAE(double a){
		this.assistEfficiency = a;
	}
}
