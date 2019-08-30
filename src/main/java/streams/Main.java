package streams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        List<Match> matches = getmatchesfromcsv();
        List<Delivery> deliveries = getdeliveriesfromcsv();

        matchesPlayedPerYear(matches);
        matchesWonByEachTeam(matches);
        countSixByEveryPlayer(deliveries);
        extraRunsConcededPerTeam(matches, deliveries);
        topEconomicalBowlers(matches, deliveries);
    }

    private static void topEconomicalBowlers(List<Match> matches, List<Delivery> deliveries) {

        matches.stream().filter(match -> match.getSeason() == 2015).flatMap(match -> deliveries.stream()
                .filter(delivery -> delivery.getMatchId() == match.getId()))
                .collect(Collectors.groupingBy(Delivery::getBowler,
                        Collectors.averagingDouble(delivery -> delivery.getTotalRuns())))
                .forEach((bowler, economy) -> System.out.println("Bowler :- " + bowler + "\t\tEconomy :- " + economy));

    }

    private static void extraRunsConcededPerTeam(List<Match> matches, List<Delivery> deliveries) {
        matches.stream().filter(match -> match.getSeason() == 2016).flatMap(match -> deliveries.stream()
                .filter(delivery -> delivery.getMatchId() == match.getId()))
                .collect(Collectors.groupingBy(Delivery::getBowlingTeam,
                        Collectors.summingInt(delivery -> delivery.getExtraRuns())))
                .forEach((team, runs) -> System.out.println("Team :- " + team + "\t\tRuns :- " + runs));
    }

    private static void countSixByEveryPlayer(List<Delivery> deliveries) {
        deliveries.stream().filter(delivery -> delivery.getTotalRuns() >= 6)
                .collect(Collectors.groupingBy(Delivery::getBatsman, Collectors.counting()))
                .forEach((Batsman, totalSixHits) ->
                        System.out.println("Team :- " + Batsman + "\t\tNo. of hits :- " + totalSixHits));
    }

    private static void matchesWonByEachTeam(List<Match> matches) {
        matches.stream().filter(match -> (!match.getResult().equals("no result")))
                .collect(Collectors.groupingBy(Match::getWinner, Collectors.counting()))
                .forEach((team, totalWins) ->
                        System.out.println("Team :- " + team + "\t\tNo. of wins :- " + totalWins));
    }

    private static void matchesPlayedPerYear(List<Match> matches) {
        matches.stream().collect(Collectors.groupingBy(Match::getSeason, Collectors.counting()))
                .forEach((season, totalMatches) ->
                        System.out.println("season :- " + season + "\t\tTotal Matches :- " + totalMatches));
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

    private static List<Match> getmatchesfromcsv() throws IOException {
        final int ID = 0;
        final int SEASON = 1;
        final int CITY = 2;
        final int DATE = 3;
        final int TEAM1 = 4;
        final int TEAM2 = 5;
        final int TOSS_WINNER = 6;
        final int TOSS_DECISION = 7;
        final int RESULT = 8;
        final int DL_APPLIED = 9;
        final int WINNER = 10;
        final int WIN_BY_RUNS = 11;
        final int WIN_BY_WICKETS = 12;
        final int PLAYER_OF_MATCH = 13;
        final int VENUE = 14;
        final int UMPIRE1 = 15;
        final int UMPIRE2 = 16;
        final int UMPIRE3 = 17;
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


}
