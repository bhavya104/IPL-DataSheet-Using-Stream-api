import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String COMMA_DELIMITER = ",";
    private static final String MATCHESFILE = "csvfiles/matches.csv";
    private static final String DELIVERIESFILE = "csvfiles/deliveries.csv";

    public static void main(String[] args) throws Exception {
        List<Match> matches = getmatchesfromcsv();
        matchesPlayedPerYear(matches);
        matchesWonByEachTeam(matches);
        List<Delivery> deliveries = getdeliveriesfromcsv();
        extraRunsConcededPerTeam(matches, deliveries);
        topEconomicalBowler(matches, deliveries);
        countSixByEveryPlayer(deliveries);
    }

	private static void countSixByEveryPlayer(List<Delivery> deliveries) {
    	Map<String,Integer> countSixMap = new HashMap<>();
    	for(int i=0;i<deliveries.size();i++) {
    		if(!countSixMap.containsKey(deliveries.get(i).getBatsman()))
    			countSixMap.put(deliveries.get(i).getBatsman(),0);
			if(deliveries.get(i).getTotalRuns()>=6)
				countSixMap.put(deliveries.get(i).getBatsman(),countSixMap.get(deliveries.get(i).getBatsman())+1);
		}
		for (Map.Entry entry : countSixMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}

	private static List<Delivery> getdeliveriesfromcsv() throws IOException {
        FileReader fileReader = new FileReader(DELIVERIESFILE);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        bufferedReader.readLine();//skips the line
        List<Delivery> deliveries = new ArrayList<>();
        String deliveryInfo = "";

        while ((deliveryInfo = bufferedReader.readLine()) != null) {
            deliveryInfo += " , , , , , , ,";    //to  avoid exceptions
            String[] deliveryData = deliveryInfo.split(COMMA_DELIMITER);
            Delivery delivery = new Delivery();

            delivery.setMatchId(Integer.parseInt(deliveryData[Delivery.MATCH_ID]));
            delivery.setInning(Integer.parseInt(deliveryData[Delivery.INNING]));
            delivery.setBattingTeam(deliveryData[Delivery.BATTING_TEAM]);
            delivery.setBowlingTeam(deliveryData[Delivery.BOWLING_TEAM]);
            delivery.setOver(Integer.parseInt(deliveryData[Delivery.OVER]));
            delivery.setBall(Integer.parseInt(deliveryData[Delivery.BALL]));
            delivery.setBatsman(deliveryData[Delivery.BATSMAN]);
            delivery.setNonStriker(deliveryData[Delivery.NON_STRIKER]);
            delivery.setBowler(deliveryData[Delivery.BOWLER]);
            delivery.setIsSuperOver(Integer.parseInt(deliveryData[Delivery.IS_SUPER_OVER]));
            delivery.setWideRuns(Integer.parseInt(deliveryData[Delivery.WIDE_RUNS]));
            delivery.setByeRuns(Integer.parseInt(deliveryData[Delivery.BYE_RUNs]));
            delivery.setLegbyeRuns(Integer.parseInt(deliveryData[Delivery.LEGBYE_RUNS]));
            delivery.setNoballRuns(Integer.parseInt(deliveryData[Delivery.NOBALL_RUNS]));
            delivery.setPenaltyRuns(Integer.parseInt(deliveryData[Delivery.PENALTY_RUNS]));
            delivery.setBatsmanRuns(Integer.parseInt(deliveryData[Delivery.BATSMAN_RUNS]));
            delivery.setExtraRuns(Integer.parseInt(deliveryData[Delivery.EXTRA_RUNS]));
            delivery.setTotalRuns(Integer.parseInt(deliveryData[Delivery.TOTAL_RUNS]));
            delivery.setPlayerDismissed(deliveryData[Delivery.PLAYER_DISMISSED]);
            delivery.setDismissalKind(deliveryData[Delivery.DISMISSAL_KIND]);
            delivery.setFeilder(deliveryData[Delivery.FEILDER]);

            deliveries.add(delivery);
        }

        return deliveries;
    }

    private static List<Match> getmatchesfromcsv() throws IOException {
        FileReader fileReader = new FileReader(MATCHESFILE);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        bufferedReader.readLine();//skips the line
        List<Match> matches = new ArrayList<>();
        String matchInfo = "";

        while ((matchInfo = bufferedReader.readLine()) != null) {
            matchInfo += " ,";//to  avoid exceptions
            String[] matchData = matchInfo.split(COMMA_DELIMITER);
            Match match = new Match();

            match.setCity(matchData[Match.CITY]);
            match.setDate(matchData[Match.DATE]);
            match.setId(Integer.parseInt(matchData[Match.ID]));
            match.setResult(matchData[Match.RESULT]);
            match.setSeason(Integer.parseInt(matchData[Match.SEASON]));
            match.setTeam1(matchData[Match.TEAM1]);
            match.setTeam2(matchData[Match.TEAM2]);
            match.setDlApplied(Integer.parseInt(matchData[Match.DL_APPLIED]));
            match.setUmpire1(matchData[Match.UMPIRE1]);
            match.setUmpire2(matchData[Match.UMPIRE2]);
            match.setUmpire3(matchData[Match.UMPIRE3]);
            match.setVenue(matchData[Match.VENUE]);
            match.setWinner(matchData[Match.WINNER]);
            match.setPlayerOfMatch(matchData[Match.PLAYER_OF_MATCH]);
            match.setTossDecision(matchData[Match.TOSS_DECISION]);
            match.setTossWinner(matchData[Match.TOSS_WINNER]);
            match.setWinByRuns(Integer.parseInt(matchData[Match.WIN_BY_RUNS]));
            match.setWinByWickets(Integer.parseInt(matchData[Match.WIN_BY_WICKETS]));

            matches.add(match);
        }

        return matches;
    }

    private static void topEconomicalBowler(List<Match> matches, List<Delivery> deliveries) {
        // TODO Auto-generated method stub
        int year = 2015;
        Map<String, Bowler> economicalBowlersMap = new HashMap<>();
        for (int i = 0; i < matches.size(); i++) {
            if (matches.get(i).getSeason() == year) {
                for (int j = 0; j < deliveries.size(); j++) {
                    if (matches.get(i).getId() == deliveries.get(j).getMatchId()) {
                        if (economicalBowlersMap.containsKey(deliveries.get(j).getBowler())) {
                            economicalBowlersMap.get(deliveries.get(j).getBowler()).balls++;
                            economicalBowlersMap.get(deliveries.get(j).getBowler()).totalRuns +=
                                    deliveries.get(j).getTotalRuns();
                        } else {
                            economicalBowlersMap.put(deliveries.get(j).getBowler(), new Bowler());
                            economicalBowlersMap.get(deliveries.get(j).getBowler()).balls = 1;
                            economicalBowlersMap.get(deliveries.get(j).getBowler()).totalRuns =
                                    deliveries.get(j).getTotalRuns();
                        }
                    }
                }
            }
        }
        int minimumEconomy = Integer.MAX_VALUE;
        String topEconomicalBowler = "";
        for (Map.Entry entry : economicalBowlersMap.entrySet()) {
            Bowler bowler = (Bowler) entry.getValue();
            bowler.economy = bowler.totalRuns / bowler.balls;
            if (bowler.economy < minimumEconomy) {
                minimumEconomy = bowler.economy;
                topEconomicalBowler = (String) entry.getKey();
            }
        }
        System.out.println(topEconomicalBowler);
    }

    private static void extraRunsConcededPerTeam(List<Match> matches, List<Delivery> deliveries) {
        Map<String, Integer> RunsConceded = new HashMap<>();
        int year = 2016;
        for (int i = 0; i < matches.size(); i++) {
            if (matches.get(i).getSeason() == year) {
                for (int j = 0; j < deliveries.size(); j++) {
                    if (matches.get(i).getId() == deliveries.get(j).getMatchId()) {
                        if (RunsConceded.containsKey(deliveries.get(j).getBattingTeam())) {
                            RunsConceded.put(deliveries.get(j).getBattingTeam(), RunsConceded.get(deliveries.get(j)
                                    .getBattingTeam()) + deliveries.get(j).getExtraRuns());
                        } else
                            RunsConceded.put(deliveries.get(j).getBattingTeam(), deliveries.get(j).getExtraRuns());
                    }
                }
            }
        }
        System.out.println("Runs Conceded by each team:");
        for (Map.Entry entry : RunsConceded.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    private static void matchesWonByEachTeam(List<Match> matches) {
        Map<String, Integer> MatchesWonMap = new HashMap<>();
        for(int i = 0; i < matches.size(); i++) {
            if (!MatchesWonMap.containsKey(matches.get(i).getTeam1()))
                MatchesWonMap.put(matches.get(i).getTeam1(), 0);
            if (!MatchesWonMap.containsKey(matches.get(i).getTeam2()))
                MatchesWonMap.put(matches.get(i).getTeam2(), 0);
            if (!matches.get(i).getResult().equals("no result"))
                MatchesWonMap.put(matches.get(i).getWinner(), MatchesWonMap.get(matches.get(i).getWinner()) + 1);
        }
        System.out.println("Matches won by each team till now:");
        for (Map.Entry match : MatchesWonMap.entrySet()) {
            System.out.println(match.getKey() + " " + match.getValue());
        }
    }

    private static void matchesPlayedPerYear(List<Match> matches) {
        Map<Integer, Integer> matchesPerYearMap = new HashMap<>();
        for (int i = 0; i < matches.size(); i++) {
            if (matchesPerYearMap.containsKey(matches.get(i).getSeason()))
                matchesPerYearMap.put(matches.get(i).getSeason(), matchesPerYearMap.get(matches.get(i).getSeason()) + 1);
            else
                matchesPerYearMap.put(matches.get(i).getSeason(), 1);
        }
        System.out.println("Matches played per year:");
        for (Map.Entry entry : matchesPerYearMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}