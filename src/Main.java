import java.io.*;
import com.opencsv.*;

import java.util.*;
class Matches{
	
	public int id;
	public int season;
	public String city;
	public String date;
	public String team1;
	public String team2;
	public String toss_winner;
	public String toss_decision;
	public String result;
	public int dl_applied;
	public String winner;
	public int win_by_runs;
	public int win_by_wickets;
	public String player_of_match;
	public String venue;
//	private String umpire1;
//	private String umpire2;
//	private String umpire3;
	
	Matches(int Id, int Season,String City,String Date,String Team1,String Team2,
			String Toss_winner,String Toss_decision,String Result,int Dl_applied,
			String Winner,int Win_by_runs,int Win_by_wickets,String Player_of_match,
			String Venue){
		
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
//		this.umpire1=Umpire1;
//		this.umpire2=Umpire2;
		//this.umpire3=Umpire3;
		
		
	}
	
}

public class Main {

	private static final String COMMA_DELIMITER = ",";
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws FileNotFoundException {
		
		String fileName = "matches.csv";
		FileReader file = new FileReader("/home/kashish/Desktop/IPL/" + fileName);
		
		BufferedReader br = null;
		try {
			String line = "";
			br = new BufferedReader(file);
			
			ArrayList<Matches> list= new ArrayList<>();
			
			br.readLine();//skipping line
			while((line=br.readLine())!=null) {
				
				String[] mat=line.split(COMMA_DELIMITER);
				if(mat.length>0) {
					
					Matches m = new Matches(Integer.parseInt(mat[0]),Integer.parseInt(mat[1]),mat[2],mat[3],mat[4],mat[5],
							mat[6],mat[7],mat[8],Integer.parseInt(mat[9]),mat[10],Integer.parseInt(mat[11]),
							Integer.parseInt(mat[12]),mat[13],mat[14]);
					list.add(m);
				}
				
			}
			
			MatchesPlayedPerYear(list);
			
			System.out.println();System.out.println();System.out.println();
			
			MatchesWonByEachTeam(list);
			
			System.out.println();System.out.println();System.out.println();
			br.close();
			
		}
		catch(Exception e) {
			System.out.print(e);
		}
		
		
		
		
		
		
		try {
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

	private static void MatchesWonByEachTeam(ArrayList<Matches> list) {
		// TODO Auto-generated method stub
		HashMap<String,Integer> MatchesWon = new HashMap<>();
		for (int i=0; i<list.size(); i++) {
			
			if(!MatchesWon.containsKey(list.get(i).team1))
				MatchesWon.put(list.get(i).team1, 0);
			if(!MatchesWon.containsKey(list.get(i).team2))
				MatchesWon.put(list.get(i).team2, 0);
			if(!list.get(i).result.equals("no result"))
				MatchesWon.put(list.get(i).winner, MatchesWon.get(list.get(i).winner)+1);
			
		}
		for (Map.Entry entry : MatchesWon.entrySet()) { 
            System.out.println(entry.getKey() + " " + entry.getValue()); 
        }
		
	}

	private static void MatchesPlayedPerYear(ArrayList<Matches> list) {
		// TODO Auto-generated method stub
		HashMap<Integer,Integer> matchesPerYear = new HashMap<>();
		
		for (int i=0; i<list.size(); i++) {
			
			if(matchesPerYear.containsKey(list.get(i).season))
				matchesPerYear.put(list.get(i).season, matchesPerYear.get(list.get(i).season)+1);
			else
				matchesPerYear.put(list.get(i).season, 1);
		}
		System.out.println("Matches played per year:");
		for (Map.Entry entry : matchesPerYear.entrySet()) { 
            System.out.println(entry.getKey() + " " + entry.getValue()); 
        }
		
	}
	
}
