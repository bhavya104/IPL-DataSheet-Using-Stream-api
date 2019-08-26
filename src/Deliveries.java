public class Deliveries{
	
	private int match_Id;
	private int inning;
	private String batting_Team;
	private String bowling_Team;
	private int over;
	private int ball;
	private String batsman;
	private String non_Striker;
	private String bowler;
	private int is_Super_Over;
	private int wide_Runs;
	private int bye_Runs;
	private int legbye_Runs;
	private int noball_Runs;
	private int penalty_Runs;
	private int batsman_Runs;
	private int extra_Runs;
	private int total_Runs;
	private String player_Dismissed;
	private String dismissal_kind;
	private String feilder;
	
	Deliveries(int id,int innings,String batting_team,String bowling_team,int over,int ball,
			String batsman,String non_Striker,String bowler,int is_super_over,int wide_run,
			int bye_run,int legbye_run,int noball_runs,int penalty_runs,int batsman_run,
			int extras,int total,String playerDismissal,String Dismissal_kind,String feilder){
		
		this.match_Id = id;
		this.inning = innings;
		this.batting_Team=batting_team;
		this.bowling_Team=bowling_team;
		this.over=over;
		this.ball = ball;
		this.batsman = batsman;
		this.non_Striker = non_Striker;
		this.bowler = bowler;
		this.is_Super_Over=is_super_over;
		this.wide_Runs = wide_run;
		this.bye_Runs = bye_run;
		this.legbye_Runs = legbye_run;
		this.noball_Runs = noball_runs;
		this.penalty_Runs = penalty_runs;
		this.batsman_Runs = batsman_run;
		this.extra_Runs = extras;
		this.total_Runs = total;
		this.player_Dismissed = playerDismissal;
		this.dismissal_kind = Dismissal_kind;
		this.feilder = feilder;
		
		
		
	}
	
	int getMatchId() {
		return this.match_Id;
	}
	
	int getInning() {
		return this.inning;
	}
	
	String getBattingTeam() {
		return this.batting_Team;
	}
	
	String getBowlingTeam() {
		return this.bowling_Team;
	}

	int getOver() {
		return this.over;
	}
	
	int getBall() {
		return this.ball;
	}
	
	String getBatsman() {
		return this.batsman;
	}

	String getNonStriker() {
		return this.non_Striker;
	}
	
	String getBowler() {
		return this.bowler;
	}
	
	int getIsSuperOver() {
		return this.is_Super_Over;
	}
	
	int getWideRuns() {
		return this.wide_Runs;
	}
	
	int getByeRuns() {
		return this.bye_Runs;
	}
	
	int getLegByeRuns() {
		return this.legbye_Runs;
	}
	
	int getNoBallRuns() {
		return this.noball_Runs;
	}
	
	int getPenaltyRuns() {
		return this.penalty_Runs;
	}
	
	int getBatsmanRun() {
		return this.batsman_Runs;
	}
	
	int getExtraRuns() {
		return this.extra_Runs;
	}
	
	int getTotalRuns() {
		return this.total_Runs;
	}
	
	String getPlayerDismissed() {
		return this.player_Dismissed;
	}

	String getDismissalKind() {
		return this.dismissal_kind;
	}
	
	String getFielder() {
		return this.feilder;
	}
}