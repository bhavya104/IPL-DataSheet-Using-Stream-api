public class Delivery {
    public static final int MATCH_ID = 0;
    public static final int INNING = 1;
    public static final int BATTING_TEAM = 2;
    public static final int BOWLING_TEAM = 3;
    public static final int OVER = 4;
    public static final int BALL = 5;
    public static final int BATSMAN = 6;
    public static final int NON_STRIKER = 7;
    public static final int BOWLER = 8;
    public static final int IS_SUPER_OVER = 9;
    public static final int WIDE_RUNS = 10;
    public static final int BYE_RUNs = 11;
    public static final int LEGBYE_RUNS = 12;
    public static final int NOBALL_RUNS = 13;
    public static final int PENALTY_RUNS = 14;
    public static final int BATSMAN_RUNS = 15;
    public static final int EXTRA_RUNS = 16;
    public static final int TOTAL_RUNS = 17;
    public static final int PLAYER_DISMISSED = 18;
    public static final int DISMISSAL_KIND = 19;
    public static final int FEILDER = 20;

    private int matchId;
    private int inning;
    private int over;
    private int ball;
    private int isSuperOver;
    private int wideRuns;
    private int byeRuns;
    private int legbyeRuns;
    private int noballRuns;
    private int penaltyRuns;
    private int batsmanRuns;
    private int extraRuns;
    private int totalRuns;
    private String battingTeam;
    private String bowlingTeam;
    private String batsman;
    private String nonStriker;
    private String bowler;
    private String playerDismissed;
    private String dismissalKind;
    private String feilder;

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getInning() {
        return inning;
    }

    public void setInning(int inning) {
        this.inning = inning;
    }

    public int getOver() {
        return over;
    }

    public void setOver(int over) {
        this.over = over;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public int getIsSuperOver() { return isSuperOver; }

    public void setIsSuperOver(int isSuperOver) {
        this.isSuperOver = isSuperOver;
    }

    public int getWideRuns() {
        return wideRuns;
    }

    public void setWideRuns(int wideRuns) {
        this.wideRuns = wideRuns;
    }

    public int getByeRuns() {
        return byeRuns;
    }

    public void setByeRuns(int byeRuns) {
        this.byeRuns = byeRuns;
    }

    public int getLegbyeRuns() {
        return legbyeRuns;
    }

    public void setLegbyeRuns(int legbyeRuns) {
        this.legbyeRuns = legbyeRuns;
    }

    public int getNoballRuns() {
        return noballRuns;
    }

    public void setNoballRuns(int noballRuns) {
        this.noballRuns = noballRuns;
    }

    public int getPenaltyRuns() { return penaltyRuns; }

    public void setPenaltyRuns(int penaltyRuns) {
        this.penaltyRuns = penaltyRuns;
    }

    public int getBatsmanRuns() {
        return batsmanRuns;
    }

    public void setBatsmanRuns(int batsmanRuns) {
        this.batsmanRuns = batsmanRuns;
    }

    public int getExtraRuns() {
        return extraRuns;
    }

    public void setExtraRuns(int extraRuns) {
        this.extraRuns = extraRuns;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public void setTotalRuns(int totalRuns) {
        this.totalRuns = totalRuns;
    }

    public String getBattingTeam() {
        return battingTeam;
    }

    public void setBattingTeam(String battingTeam) {
        this.battingTeam = battingTeam;
    }

    public String getBowlingTeam() {
        return bowlingTeam;
    }

    public void setBowlingTeam(String bowlingTeam) {
        this.bowlingTeam = bowlingTeam;
    }

    public String getBatsman() {
        return batsman;
    }

    public void setBatsman(String batsman) {
        this.batsman = batsman;
    }

    public String getNonStriker() {
        return nonStriker;
    }

    public void setNonStriker(String nonStriker) {
        this.nonStriker = nonStriker;
    }

    public String getBowler() {
        return bowler;
    }

    public void setBowler(String bowler) {
        this.bowler = bowler;
    }

    public String getPlayerDismissed() {
        return playerDismissed;
    }

    public void setPlayerDismissed(String playerDismissed) {
        this.playerDismissed = playerDismissed;
    }

    public String getDismissalKind() {
        return dismissalKind;
    }

    public void setDismissalKind(String dismissalKind) {
        this.dismissalKind = dismissalKind;
    }

    public String getFeilder() {
        return feilder;
    }

    public void setFeilder(String feilder) {
        this.feilder = feilder;
    }
}