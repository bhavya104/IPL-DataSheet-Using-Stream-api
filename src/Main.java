import java.io.*;
import java.util.*;

public class  Main {
	private static final String COMMA_DELIMITER = ",";
	private static final String MATCHESFILE = "matches.csv";
	private static final String DELIVERIESFILE = "deliveries.csv";
	private static final String PATH = "/home/kashish/Desktop/IPL/";

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {

		List<Match> matches = getmatchesfromcsv();
		matchesplayedperyear(matches);
		matcheswonbyeachteam(matches);
		List<Delivery> deliveries = getdeliveriesfromcsv();
		extrarunsconcededperteam(matches,deliveries);
		topeconomicalbowler(matches,deliveries);

	}

	private static ArrayList<Delivery> getdeliveriesfromcsv() throws IOException {
		FileReader fileReader = new FileReader(PATH+DELIVERIESFILE);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		bufferedReader.readLine();//skips the line
		ArrayList<Delivery> deliveries = new ArrayList<>();
		String deliveryInfo = "";

		while ((deliveryInfo = bufferedReader.readLine())!=null){
			deliveryInfo+=" , , , , , , ,";
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

	private static ArrayList<Match> getmatchesfromcsv() throws IOException {
		FileReader fileReader = new FileReader(PATH+MATCHESFILE);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		bufferedReader.readLine();//skips the line
		ArrayList<Match> matches = new ArrayList<>();
		String matchInfo = "";

		while((matchInfo=bufferedReader.readLine()) !=null) {
			matchInfo+=" ,";
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

	private static void topeconomicalbowler(List<Match> matches, List<Delivery> deliveries) {
		// TODO Auto-generated method stub
		int year = 2015;
		HashMap<String,Bowler> economicalBowlers = new HashMap<>();
		for(int i=0;i<matches.size();i++) {
			if(matches.get(i).getSeason()==year) {
				for(int j=0;j<deliveries.size();j++) {
					if(matches.get(i).getId()==deliveries.get(j).getMatchId()) {
						if(economicalBowlers.containsKey(deliveries.get(j).getBowler())) {
							economicalBowlers.get(deliveries.get(j).getBowler()).balls++;
							economicalBowlers.get(deliveries.get(j).getBowler()).totalRuns +=
																					deliveries.get(j).getTotalRuns();
						} else {
							economicalBowlers.put(deliveries.get(j).getBowler(), new Bowler());
							economicalBowlers.get(deliveries.get(j).getBowler()).balls=1;
							economicalBowlers.get(deliveries.get(j).getBowler()).totalRuns =
																					deliveries.get(j).getTotalRuns();
						}
					}
				}
			}
		}
		int minEconomy=Integer.MAX_VALUE;
		String topEconomicalBowler = "";
		for (Map.Entry entry : economicalBowlers.entrySet()) {
			Bowler bowler = (Bowler)entry.getValue();
			bowler.economy = bowler.totalRuns/bowler.balls;
			if( bowler.economy	< minEconomy) {
				minEconomy = bowler.economy;
				topEconomicalBowler = (String)entry.getKey();
			}

        }

		System.out.println(topEconomicalBowler);

	}

	private static void extrarunsconcededperteam(List<Match> matches, List<Delivery> deliveries) {
		// TODO Auto-generated method stub
		HashMap<String,Integer> RunsConceded = new HashMap<>();
		int year = 2016;
		for(int i=0;i<matches.size();i++) {
			if(matches.get(i).getSeason()== year) {
				for(int j=0;j<deliveries.size();j++) {
					if(matches.get(i).getId()==deliveries.get(j).getMatchId()) {
						if(RunsConceded.containsKey(deliveries.get(j).getBattingTeam()))
							RunsConceded.put(deliveries.get(j).getBattingTeam(), RunsConceded.get(deliveries.get(j).getBattingTeam())+deliveries.get(j).getExtraRuns());
						else
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

	private static void matcheswonbyeachteam(List<Match> matches) {
		// TODO Auto-generated method stub
		HashMap<String,Integer> MatchesWon = new HashMap<>();
		for (int i=0; i<matches.size(); i++) {
			if(!MatchesWon.containsKey(matches.get(i).getTeam1()))
				MatchesWon.put(matches.get(i).getTeam1(), 0);
			if(!MatchesWon.containsKey(matches.get(i).getTeam2()))
				MatchesWon.put(matches.get(i).getTeam2(), 0);
			if(!matches.get(i).getResult().equals("no result"))
				MatchesWon.put(matches.get(i).getWinner(), MatchesWon.get(matches.get(i).getWinner())+1);
		}
		System.out.println("Matches won by each team till now:");
		for (Map.Entry match : MatchesWon.entrySet()) {
            System.out.println(match.getKey() + " " + match.getValue());
        }
	}

	private static void matchesplayedperyear(List<Match> matches) {
		// TODO Auto-generated method stub
		HashMap<Integer,Integer> matchesPerYear = new HashMap<>();
		for (int i=0; i<matches.size(); i++) {
			if(matchesPerYear.containsKey(matches.get(i).getSeason()))
				matchesPerYear.put(matches.get(i).getSeason(), matchesPerYear.get(matches.get(i).getSeason())+1);
			else
				matchesPerYear.put(matches.get(i).getSeason(), 1);
		}
		System.out.println("Matches played per year:");
		for (Map.Entry match : matchesPerYear.entrySet()) {
            System.out.println(match.getKey() + " " + match.getValue());
        }
	}
}
