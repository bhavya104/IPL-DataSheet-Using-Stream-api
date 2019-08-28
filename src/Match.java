public class Match {
    public static final int ID=0;
    public static final int SEASON=1;
    public static final int CITY=2;
    public static final int DATE=3;
    public static final int TEAM1=4;
    public static final int TEAM2=5;
    public static final int TOSS_WINNER=6;
    public static final int TOSS_DECISION=7;
    public static final int RESULT=8;
    public static final int DL_APPLIED=9;
    public static final int WINNER=10;
    public static final int WIN_BY_RUNS=11;
    public static final int WIN_BY_WICKETS=12;
    public static final int PLAYER_OF_MATCH=13;
    public static final int VENUE=14;
    public static final int UMPIRE1=15;
    public static final int UMPIRE2=16;
    public static final int UMPIRE3=17;
    private int id;
    private int season;
    private int dlApplied;
    private int winByRuns;
    private int winByWickets;
    private String city;
    private String date;
    private String team1;
    private String team2;
    private String tossWinner;
    private String tossDecision;
    private String result;
    private String winner;
    private String playerOfMatch;
    private String venue;
    private String umpire1;
    private String umpire2;
    private String umpire3;

    Match(){}

    public void setId(int id) {
        this.id = id;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public void setDlApplied(int dlApplied) {
        this.dlApplied = dlApplied;
    }

    public void setWinByRuns(int winByRuns) {
        this.winByRuns = winByRuns;
    }

    public void setWinByWickets(int winByWickets) {
        this.winByWickets = winByWickets;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public void setTossWinner(String tossWinner) {
        this.tossWinner = tossWinner;
    }

    public void setTossDecision(String tossDecision) {
        this.tossDecision = tossDecision;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public void setPlayerOfMatch(String playerOfMatch) {
        this.playerOfMatch = playerOfMatch;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public void setUmpire1(String umpire1) {
        this.umpire1 = umpire1;
    }

    public void setUmpire2(String umpire2) {
        this.umpire2 = umpire2;
    }

    public void setUmpire3(String umpire3) {
        this.umpire3 = umpire3;
    }

	public int getId() {
		return id;
	}

	public int getSeason() {
		return season;
	}

	public int getDlApplied() {
		return dlApplied;
	}

	public int getWinByRuns() {
		return winByRuns;
	}

	public int getWinByWickets() {
		return winByWickets;
	}

	public String getCity() {
		return city;
	}

	public String getDate() {
		return date;
	}

	public String getTeam1() {
		return team1;
	}

	public String getTeam2() {
		return team2;
	}

	public String getTossWinner() {
		return tossWinner;
	}

	public String getTossDecision() {
		return tossDecision;
	}

	public String getResult() {
		return result;
	}

	public String getWinner() {
		return winner;
	}

	public String getPlayerOfMatch() {
		return playerOfMatch;
	}

	public String getVenue() {
		return venue;
	}

	public String getUmpire1() {
		return umpire1;
	}

	public String getUmpire2() {
		return umpire2;
	}

	public String getUmpire3() {
		return umpire3;
	}
}