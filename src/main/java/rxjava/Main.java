package rxjava;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Main {

    public static int a=5,b=10;
    public static void main(String[] args) throws Exception {
        List<Match> matches = getmatchesfromcsv();
        List<Delivery> deliveries = getdeliveriesfromcsv();

        learningPath();
      //  matchesPlayedPerYear(matches);


     //     Flowable.just("Hello","World").subscribe(System.out::println);
        try {
            Thread.sleep(30000);
        } catch (Exception e){

        }
    }

    private static void learningPath() {

        String[] arr = {"Abc","Bcd","Cde","Def","Efg"};
        List<String> stringList=Arrays.asList(arr);

        Observable<String> stringObservable=Observable.fromIterable(stringList);
//        ConnectableObservable<String> stringConnectableObservable = stringObservable.publish();
//        stringObservable.map(String::length)
//                        .subscribe(System.out::println);
     //   Observable.error(new Exception("Error")).subscribe(System.out::println,Throwable::printStackTrace,()->System.out.println("done"));
//        stringObservable.subscribe(s -> System.out.println("obeserver 1 : "+s));
//        stringObservable.subscribe(s -> System.out.println("obeserver 2 : "+s));

//        stringConnectableObservable.connect();

        Observable<Integer> integerObservable = Observable.defer(()->Observable.range(a,b));
//        integerObservable.subscribe(System.out::println);
//        a=15;
//        b=16;
//        integerObservable.subscribe(System.out::println);


    }

    private static void matchesPlayedPerYear(List<Match> matches) {


        Observable.fromIterable(matches).observeOn(Schedulers.computation())
                .groupBy(Match::getSeason)
                //.flatMap(gr->gr.count().map(count->new Pair<>(gr.getKey(),count)))
                .subscribe(System.out::println);

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
        final int ID=0;
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

}
