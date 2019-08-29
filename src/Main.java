import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        ArrayList li = Arrays.asList(1,2,3);
//        List<Match> matches = getmatchesfromcsv();
//        List<Delivery> deliveries = getdeliveriesfromcsv();
//
//        matchesPlayedPerYear(matches);
//        matchesWonByEachTeam(matches);
//        extraRunsConcededPerTeam(matches, deliveries);
//        topEconomicalBowler(matches, deliveries);
//        countSixByEveryPlayer(deliveries);
    }

    private static void countSixByEveryPlayer(List<Delivery> deliveries) {
        Map<String, Integer> countSixMap = new HashMap<>();
        for (int i = 0; i < deliveries.size(); i++) {
            if (!countSixMap.containsKey(deliveries.get(i).getBatsman()))
                countSixMap.put(deliveries.get(i).getBatsman(), 0);
            if (deliveries.get(i).getTotalRuns() >= 6)
                countSixMap.put(deliveries.get(i).getBatsman(), countSixMap.get(deliveries.get(i).getBatsman()) + 1);
        }
        for (Map.Entry entry : countSixMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    private static List<Delivery> getdeliveriesfromcsv() throws IOException {
        final int MATCH_ID = 0;
        final int INNING = 1;
        final int BATTING_TEAM = 2;
        final int BOWLING_TEAM = 3;
        final int OVER = 4;
        final int BALL = 5;
        final int BATSMAN = 6;
        final int NON_STRIKER = 7;
        final int BOWLER = 8;
        final int IS_SUPER_OVER = 9;
        final int WIDE_RUNS = 10;
        final int BYE_RUNs = 11;
        final int LEGBYE_RUNS = 12;
        final int NOBALL_RUNS = 13;
        final int PENALTY_RUNS = 14;
        final int BATSMAN_RUNS = 15;
        final int EXTRA_RUNS = 16;
        final int TOTAL_RUNS = 17;
        final int PLAYER_DISMISSED = 18;
        final int DISMISSAL_KIND = 19;
        final int FEILDER = 20;
        final String COMMA_DELIMITER = ",";
        final String DELIVERIESFILE = "csvfiles/deliveries.csv";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(DELIVERIESFILE));
        bufferedReader.readLine();//skips the line
        List<Delivery> deliveries = new ArrayList<>();
        String deliveryInfo = "";

        while ((deliveryInfo = bufferedReader.readLine()) != null) {
            deliveryInfo += " , , , , , , ,";    //to  avoid exceptions
            String[] deliveryData = deliveryInfo.split(COMMA_DELIMITER);
            Delivery delivery = new Delivery();

            delivery.setMatchId(Integer.parseInt(deliveryData[MATCH_ID]));
            delivery.setInning(Integer.parseInt(deliveryData[INNING]));
            delivery.setBattingTeam(deliveryData[BATTING_TEAM]);
            delivery.setBowlingTeam(deliveryData[BOWLING_TEAM]);
            delivery.setOver(Integer.parseInt(deliveryData[OVER]));
            delivery.setBall(Integer.parseInt(deliveryData[BALL]));
            delivery.setBatsman(deliveryData[BATSMAN]);
            delivery.setNonStriker(deliveryData[NON_STRIKER]);
            delivery.setBowler(deliveryData[BOWLER]);
            delivery.setIsSuperOver(Integer.parseInt(deliveryData[IS_SUPER_OVER]));
            delivery.setWideRuns(Integer.parseInt(deliveryData[WIDE_RUNS]));
            delivery.setByeRuns(Integer.parseInt(deliveryData[BYE_RUNs]));
            delivery.setLegbyeRuns(Integer.parseInt(deliveryData[LEGBYE_RUNS]));
            delivery.setNoballRuns(Integer.parseInt(deliveryData[NOBALL_RUNS]));
            delivery.setPenaltyRuns(Integer.parseInt(deliveryData[PENALTY_RUNS]));
            delivery.setBatsmanRuns(Integer.parseInt(deliveryData[BATSMAN_RUNS]));
            delivery.setExtraRuns(Integer.parseInt(deliveryData[EXTRA_RUNS]));
            delivery.setTotalRuns(Integer.parseInt(deliveryData[TOTAL_RUNS]));
            delivery.setPlayerDismissed(deliveryData[PLAYER_DISMISSED]);
            delivery.setDismissalKind(deliveryData[DISMISSAL_KIND]);
            delivery.setFeilder(deliveryData[FEILDER]);

            deliveries.add(delivery);
        }

        return deliveries;
    }

    private static List<Match> getmatchesfromcsv() throws IOException {final int ID=0;
        final int SEASON=1;
        final int CITY=2;
        final int DATE=3;
        final int TEAM1=4;
        final int TEAM2=5;
        final int TOSS_WINNER=6;
        final int TOSS_DECISION=7;
        final int RESULT=8;
        final int DL_APPLIED=9;
        final int WINNER=10;
        final int WIN_BY_RUNS=11;
        final int WIN_BY_WICKETS=12;
        final int PLAYER_OF_MATCH=13;
        final int VENUE=14;
        final int UMPIRE1=15;
        final int UMPIRE2=16;
        final int UMPIRE3=17;
        final String COMMA_DELIMITER = ",";
        final String MATCHESFILE = "csvfiles/matches.csv";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(MATCHESFILE));
        bufferedReader.readLine();//skips the line
        List<Match> matches = new ArrayList<>();
        String matchInfo = "";

        while ((matchInfo = bufferedReader.readLine()) != null) {
            matchInfo += " ,";//to  avoid exceptions
            String[] matchData = matchInfo.split(COMMA_DELIMITER);
            Match match = new Match();

            match.setCity(matchData[CITY]);
            match.setDate(matchData[DATE]);
            match.setId(Integer.parseInt(matchData[ID]));
            match.setResult(matchData[RESULT]);
            match.setSeason(Integer.parseInt(matchData[SEASON]));
            match.setTeam1(matchData[TEAM1]);
            match.setTeam2(matchData[TEAM2]);
            match.setDlApplied(Integer.parseInt(matchData[DL_APPLIED]));
            match.setUmpire1(matchData[UMPIRE1]);
            match.setUmpire2(matchData[UMPIRE2]);
            match.setUmpire3(matchData[UMPIRE3]);
            match.setVenue(matchData[VENUE]);
            match.setWinner(matchData[WINNER]);
            match.setPlayerOfMatch(matchData[PLAYER_OF_MATCH]);
            match.setTossDecision(matchData[TOSS_DECISION]);
            match.setTossWinner(matchData[TOSS_WINNER]);
            match.setWinByRuns(Integer.parseInt(matchData[WIN_BY_RUNS]));
            match.setWinByWickets(Integer.parseInt(matchData[WIN_BY_WICKETS]));

            matches.add(match);
        }

        return matches;
    }

    private static void topEconomicalBowler(List<Match> matches, List<Delivery> deliveries) {
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
                            economicalBowlersMap.get(deliveries.get(j).getBowler()).balls = 1.0;
                            economicalBowlersMap.get(deliveries.get(j).getBowler()).totalRuns =
                                    ((double)deliveries.get(j).getTotalRuns());
                        }
                    }
                }
            }
        }
        Double minimumEconomy = Double.MAX_VALUE;
        String topEconomicalBowler = "";
        for (Map.Entry entry : economicalBowlersMap.entrySet()) {
            Bowler bowler = (Bowler) entry.getValue();
            bowler.economy = bowler.totalRuns / bowler.balls*6;
            if (bowler.economy < minimumEconomy) {
                minimumEconomy = bowler.economy;
                topEconomicalBowler = (String) entry.getKey();
            }
        }
        System.out.println(topEconomicalBowler);
    }

    private static void extraRunsConcededPerTeam(List<Match> matches, List<Delivery> deliveries) {
        Map<String, Integer> runsConcededMap = new HashMap<>();
        int year = 2016;
        for (int i = 0; i < matches.size(); i++) {
            if (matches.get(i).getSeason() == year) {
                for (int j = 0; j < deliveries.size(); j++) {
                    if (matches.get(i).getId() == deliveries.get(j).getMatchId()) {
                        if (runsConcededMap.containsKey(deliveries.get(j).getBowlingTeam())) {
                            runsConcededMap.put(deliveries.get(j).getBowlingTeam(), runsConcededMap.get(deliveries.get(j)
                                    .getBowlingTeam()) + deliveries.get(j).getExtraRuns());
                        } else
                            runsConcededMap.put(deliveries.get(j).getBowlingTeam(), deliveries.get(j).getExtraRuns());
                    }
                }
            }
        }
        System.out.println("Runs Conceded by each team:");
        for (Map.Entry entry : runsConcededMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    private static void matchesWonByEachTeam(List<Match> matches) {
        Map<String, Integer> MatchesWonMap = new HashMap<>();
        for (int i = 0; i < matches.size(); i++) {
            if (!MatchesWonMap.containsKey(matches.get(i).getTeam1())) {
                MatchesWonMap.put(matches.get(i).getTeam1(), 0);
            }
            if (!MatchesWonMap.containsKey(matches.get(i).getTeam2())) {
                MatchesWonMap.put(matches.get(i).getTeam2(), 0);
            }
            if (!matches.get(i).getResult().equals("no result")) {
                MatchesWonMap.put(matches.get(i).getWinner(), MatchesWonMap.get(matches.get(i).getWinner()) + 1);
            }
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