public class Matches{
	
	private int id;
	private int season;
	private String city;
	private String date;
	private String team1;
	private String team2;
	private String toss_winner;
	private String toss_decision;
	private String result;
	private int dl_applied;
	private String winner;
	private int win_by_runs;
	private int win_by_wickets;
	private String player_of_match;
	private String venue;
	private String umpire1;
	private String umpire2;
	private String umpire3;

	
	Matches(int Id, int Season,String City,String Date,String Team1,String Team2,
			String Toss_winner,String Toss_decision,String Result,int Dl_applied,
			String Winner,int Win_by_runs,int Win_by_wickets,String Player_of_match,
			String Venue,String Umpire1,String Umpire2,String Umpire3){
		
		this.id=Id;
		this.season=Season;
		this.city=City;
		this.date=Date;
		this.team1=Team1;
		this.team2=Team2;
		this.toss_winner=Toss_winner;
		this.toss_decision=Toss_decision;
		this.result=Result;
		this.dl_applied=Dl_applied;
		this.winner=Winner;
		this.win_by_runs=Win_by_runs;
		this.win_by_wickets=Win_by_wickets;
		this.player_of_match=Player_of_match;
		this.venue=Venue;
		this.umpire1=Umpire1;
		this.umpire2=Umpire2;
		this.umpire3=Umpire3;
		
		
	}
	
	int getId() {
		return this.id;
	}
	
	int getSeason() {
		return this.season;
	}
	
	String getCity() {
		return this.city;
	}

	String getDate() {
		return this.date;
	}

	String getTeam1() {
		return this.team1;
	}
	
	String getTeam2() {
		return this.team2;
	}

	String getTossWinner() {
		return this.toss_winner;
	}

	String getTossDecision() {
		return this.toss_decision;
	}

	String getResult() {
		return this.result;
	}

	int getDlApplied() {
		return this.dl_applied;
	}
	
	String getWinner() {
		return this.winner;
	}

	int getWinByWickets() {
		return this.win_by_wickets;
	}

	int getWinByRuns() {
		return this.getWinByRuns();
	}
	
	String getPlayerOfMatch() {
		return this.player_of_match;
	}
	
	String getVenue() {
		return this.venue;
	}
	
	String getUmpire1() {
		return this.umpire1;
	}
	
	String getUmpire2() {
		return this.umpire2;
	}
	
	String getUmpire3() {
		return this.umpire3;
	}
}