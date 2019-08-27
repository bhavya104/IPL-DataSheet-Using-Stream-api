import java.io.*;
import com.opencsv.*;

import java.util.*;

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
				line+=", , , , ";
				String[] mat=line.split(COMMA_DELIMITER);
				
				//System.out.println(mat.length);
				if(mat.length>0) {
					
					Matches m = new Matches(Integer.parseInt(mat[0]),Integer.parseInt(mat[1]),mat[2],mat[3],mat[4],mat[5],
							mat[6],mat[7],mat[8],Integer.parseInt(mat[9]),mat[10],Integer.parseInt(mat[11]),
							Integer.parseInt(mat[12]),mat[13],mat[14],mat[15],mat[16],mat[17]);
					list.add(m);
				}
				
			}
			
			MatchesPlayedPerYear(list);
			
			System.out.println();System.out.println();System.out.println();
			
			MatchesWonByEachTeam(list);
			
			System.out.println();System.out.println();System.out.println();
			
			br = new BufferedReader(new FileReader("/home/kashish/Desktop/IPL/deliveries.csv"));
			
			br.readLine();
			ArrayList<Deliveries> stats = new ArrayList<>();
			while((line=br.readLine())!=null) {
				line+=", , ,";
				String[] delivery = line.split(COMMA_DELIMITER);
				
				if(delivery.length>0) {
					Deliveries d = new Deliveries(Integer.parseInt(delivery[0]), Integer.parseInt(delivery[1]), delivery[2], delivery[3], Integer.parseInt(delivery[4]),
							Integer.parseInt(delivery[5]),delivery[6], delivery[7], delivery[8], Integer.parseInt(delivery[9]), Integer.parseInt(delivery[10]),
							Integer.parseInt(delivery[11]), Integer.parseInt(delivery[12]), Integer.parseInt(delivery[13]), Integer.parseInt(delivery[14]),
							Integer.parseInt(delivery[15]), Integer.parseInt(delivery[16]), Integer.parseInt(delivery[17]), delivery[18], delivery[19], delivery[20]);
					stats.add(d);
				}
				
			}
			
			ExtraRunsConcededperTeam(list,stats);
			
			System.out.println();System.out.println();System.out.println();
			
			topEconomicalBowler(list,stats);
			
		//	for(int i=0;i<stats.size();i++)
			//	System.out.println(stats.get(i));
			
			
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

	private static void topEconomicalBowler(ArrayList<Matches> list, ArrayList<Deliveries> stats) {
		// TODO Auto-generated method stub
		int k=0,x=0;
		HashMap<String,Integer> economicalBowler = new HashMap<>();
		for(int i=0;i<list.size();i++) {
			
			if(list.get(i).getSeason()==2015) {
				for(int j=0;j<stats.size();j++) {
					
					if(list.get(i).getId()==stats.get(j).getMatchId()) {
						k++;
						if(economicalBowler.containsKey(stats.get(j).getBowler()))
							economicalBowler.put(stats.get(j).getBowler(), economicalBowler.get(stats.get(j).getBowler())+stats.get(j).getTotalRuns());
						else {
							economicalBowler.put(stats.get(j).getBowler(), stats.get(j).getTotalRuns());
							x++;
						}
					}
			
					
				}
				
			}
			
			
		}
		int max=0;
		String str = "";
		for (Map.Entry entry : economicalBowler.entrySet()) { 
             
			if(	(int)entry.getValue()>max) {
				max = (int)entry.getValue();
				str = (String)entry.getKey();
			}
			
        }
		
		System.out.println(str);
		
	}

	private static void ExtraRunsConcededperTeam(ArrayList<Matches> list, ArrayList<Deliveries> stats) {
		// TODO Auto-generated method stub
		//HashMap<Integer, ArrayList<Deliveries>> newStats = new HashMap<>();
		
		
		
		int k=0;
		HashMap<String,Integer> RunsConceded = new HashMap<>();
		for(int i=0;i<list.size();i++) {
			
			if(list.get(i).getSeason()==2016) {
				for(int j=0;j<stats.size();j++) {
					
					if(list.get(i).getId()==stats.get(j).getMatchId()) {
						if(RunsConceded.containsKey(stats.get(j).getBattingTeam()))
							RunsConceded.put(stats.get(j).getBattingTeam(), RunsConceded.get(stats.get(j).getBattingTeam())+stats.get(j).getExtraRuns());
						else
							RunsConceded.put(stats.get(j).getBattingTeam(), stats.get(j).getExtraRuns());
					}
					k++;
					
				}
			}
			k++;
			
		}
		
		for (Map.Entry entry : RunsConceded.entrySet()) { 
            System.out.println(entry.getKey() + " " + entry.getValue()); 
        }
		//System.out.println(k);
		
	}

	private static void MatchesWonByEachTeam(ArrayList<Matches> list) {
		// TODO Auto-generated method stub
		HashMap<String,Integer> MatchesWon = new HashMap<>();
		for (int i=0; i<list.size(); i++) {
			
			if(!MatchesWon.containsKey(list.get(i).getTeam1()))
				MatchesWon.put(list.get(i).getTeam1(), 0);
			if(!MatchesWon.containsKey(list.get(i).getTeam2()))
				MatchesWon.put(list.get(i).getTeam2(), 0);
			if(!list.get(i).getResult().equals("no result"))
				MatchesWon.put(list.get(i).getWinner(), MatchesWon.get(list.get(i).getWinner())+1);
			
		}
		for (Map.Entry entry : MatchesWon.entrySet()) { 
            System.out.println(entry.getKey() + " " + entry.getValue()); 
        }
		
	}

	private static void MatchesPlayedPerYear(ArrayList<Matches> list) {
		// TODO Auto-generated method stub
		HashMap<Integer,Integer> matchesPerYear = new HashMap<>();
		
		for (int i=0; i<list.size(); i++) {
			
			if(matchesPerYear.containsKey(list.get(i).getSeason()))
				matchesPerYear.put(list.get(i).getSeason(), matchesPerYear.get(list.get(i).getSeason())+1);
			else
				matchesPerYear.put(list.get(i).getSeason(), 1);
		}
		System.out.println("Matches played per year:");
		for (Map.Entry entry : matchesPerYear.entrySet()) { 
            System.out.println(entry.getKey() + " " + entry.getValue()); 
        }
		
	}
	
}
