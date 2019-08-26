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
