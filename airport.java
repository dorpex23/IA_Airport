package ai_trabalho3;

import java.util.*;
import java.lang.*;

class Time{
	int hour;
	int minute;
	
	Time (int h, int m){
		hour   = h;
		minute = m;
	}
	
	Time (Time t){
		hour=t.hour;
		minute=t.minute;
	}
	
	//True if t2 > t1 by at least 40 min
	public static boolean timeCompare(Time t2, Time t1){
		if(t1 != null && t2 != null) {
			//System.out.println("t1 is " + t1.hour + ":" + t1.minute);
			//System.out.println("t2 is " + t2.hour + ":" + t2.minute);
			//System.out.println();
			if(t2.hour == t1.hour){
				if(t2.minute - t1.minute >= 40)
					return true;
				else
					return false;
			}else if(t2.hour > t1.hour){
				if( ( (t2.hour - (1 + t1.hour)) * 60 + t2.minute + 60 - t1.minute) >= 40)
					return true;
				else
					return false;
				
			}
		}
		return false;
	}
}

class Flights{
	String destination;
	Time dep;
	Time arr;
	String id;
	String[] days;
	
	Flights(Flights n){
		if(n != null) {
			destination = n.destination;
			dep = new Time(n.dep);
			arr = new Time(n.arr);
			id = n.id;
			days = new String[n.days.length];
			for(int c=0 ; c<n.days.length;c++)
				days[c]=n.days[c];
		}
			
	}
	
	Flights(String des,int dHour,int dMinute,int aHour,int aMinute,String f_id,String[] d){
		destination = des;
		dep = new Time(dHour,dMinute);
		arr  = new Time(aHour,aMinute);
		id   = f_id;
		days = d;
	}
	
	public static void fillFlights(Node n) {
		String days[];
		switch(n.place) {
		case "porto":
			n.f_list= new Flights[1];
			
			days = new String[] { "mo" , "tu" , "we" };
			n.f_list[0]=  new Flights("lisboa",9,40,10,50,"voo1",days);
			break;
			
		case "lisboa":
			n.f_list= new Flights[1];
			
			days = new String[] { "mo" , "tu"};
			n.f_list[0]=  new Flights("faro",11,30,14,50,"voo2",days);
			break;
			
		case "faro":
			n.f_list= new Flights[2];
			
			days = new String[] { "mo" };
			n.f_list[0]=  new Flights("braga",9,40,10,50,"voo3",days);

			days = new String[] { "sa" };
			n.f_list[1]=  new Flights("braga",13,40,14,50,"voo34",days);
			break;
			
		case "braga":
			n.f_list= new Flights[1];
			
			days = new String[] { "su"};
			n.f_list[0]=  new Flights("porto",9,40,10,50,"voo4",days);
			break;
			
		case "edinburgh":
			
			n.f_list= new Flights[3];
			
			days = new String[] { "mo" , "tu" , "we" , "th" , "fr" , "sa" , "su"};
			n.f_list[0]=  new Flights("london",9,40,10,50,"ba4733",days);
			
			days = new String[] { "mo" , "tu" , "we" , "th" , "fr" , "sa" , "su"};
			n.f_list[1]=  new Flights("london",13,40,14,50,"ba4773",days);
			
			days = new String[] { "mo" , "tu" , "we" , "th" , "fr" , "su"};
			n.f_list[2]=  new Flights("london",19,40,20,50,"ba4833",days);
			
			break;
			
		case "london":
			n.f_list= new Flights[9];
			
			days = new String[] { "mo" , "tu" , "we" , "th" , "fr" , "sa" , "su"};
			n.f_list[0]=  new Flights("edinburgh",9,40,10,50,"ba4732",days);
			
			days = new String[] { "mo" , "tu" , "we" , "th" , "fr" , "sa" , "su"};
			n.f_list[1]=  new Flights("edinburgh",11,40,12,50,"ba4752",days);
			
			days = new String[] { "mo" , "tu" , "we" , "th" , "fr" };
			n.f_list[2]=  new Flights("edinburgh",18,40,19,50,"ba4822",days);
			
			days = new String[] {"fr"};
			n.f_list[3]=  new Flights("ljubljana",13,20,16,20,"ju201",days);
						
			days = new String[] { "su"};
			n.f_list[4]=  new Flights("ljubljana",13,20,16,20,"ju213",days);
			
			days = new String[] { "mo" , "tu" , "we" , "th" , "fr" , "sa" , "su"};
			n.f_list[5]=  new Flights("zurich",9,10,11,45,"ba614",days);
						
			days = new String[] { "mo" , "tu" , "we" , "th" , "fr" , "sa" , "su"};
			n.f_list[6]=  new Flights("zurich",14,45,17,20,"sr805",days);
			
			days = new String[] { "mo" , "tu" , "we" , "th" , "fr" , "sa" , "su"};
			n.f_list[7]=  new Flights("milan",8,30,11,20,"ba510",days);
				
			days = new String[] { "mo" , "tu" , "we" , "th" , "fr" , "sa" , "su"};
			n.f_list[8]=  new Flights("milan",11,30,13,50,"az459",days);
			
			break;
			
		case "milan":
			n.f_list = new Flights[4];
			
			days = new String[] { "mo" , "tu" , "we" , "th" , "fr" , "sa" , "su"};
			n.f_list[0]=  new Flights("london",9,10,10,00,"az458",days);
			
		    days = new String[] { "mo" , "tu" , "we" , "th" , "fr" , "sa" , "su"};
			n.f_list[1]=  new Flights("london",12,20,13,10,"ba511",days);
			
			days = new String[] { "mo" , "tu" , "we" , "th" , "fr" , "sa" , "su"};
			n.f_list[2]=  new Flights("zurich",9,25,10,15,"sr621",days);
			
			days = new String[] { "mo" , "tu" , "we" , "th" , "fr" , "sa" , "su"};
			n.f_list[3]=  new Flights("zurich",12,45,13,35,"sr623",days);
			
			break;
			
		case "zurich":
			n.f_list = new Flights[4];
			
			days = new String[] {"tu", "th"};
			n.f_list[0]=  new Flights("ljubljana",13,30,14,40,"yu323",days);
						
			days = new String[] { "mo" , "tu" , "we" , "th" , "fr" , "sa" , "su"};
			n.f_list[1]=  new Flights("milan",7,55,8,45,"sr620",days);
			
			days = new String[] { "mo" , "tu" , "we" , "th" , "fr" , "sa" };
			n.f_list[2]=  new Flights("zurich",9,40,9,40,"ba613",days);
			
			days = new String[] { "mo" , "tu" , "we" , "th" , "fr" , "sa" , "su"};
			n.f_list[3]=  new Flights("london",16,10,16,55,"sr806",days);
			
			break;
			
		case "ljubljana": //dont know if thats how u spell it lel
			n.f_list = new Flights[3];
			
			days = new String[] { "fr"};
			n.f_list[0]=  new Flights("london",11,10,12,20,"yu200",days);			
			
			days = new String[] {"su"};
			n.f_list[1]=  new Flights("london",11,25,12,20,"yu212",days);
			
			days =  new String[] { "tu" ,"th" };
			n.f_list[2]=  new Flights("zurich",11,30,12,40,"ju322",days);
			
			break;
		}
		
	}
}
		

class Node{
	String place;
	int depth;
	Node father;
	Flights flightUsed;
	Flights[] f_list;
	String day;
	
	Node(String p, int d, Node f,Flights code){
		place  = p;
		depth  = d;
		father = f;
		if(code != null)
			flightUsed = new Flights(code);
		else
			flightUsed = null;
		Flights.fillFlights(this);
	}
	
	
}
class Routes{
	
	public static boolean IsGoal(Node test, String goal){
		
		if(test.place.equals(goal))
			return true;
		else
			return false;
	}
	
	/*
	 * What are the available flights from Place1 to Place2 on Thursday?
	 * 
	 */
	
	public static boolean fliesInDay(Flights n,String d) {
		
		try {
			if(n.days[0].equals("alldays"))
				return true;
		}catch(NullPointerException err) {
			return false;
		}
		for(int c=0;c<n.days.length;c++) {
			if(n.days[c].equals(d))
				return true;
		}
		
		return false;
	}
	
	public static Node[] getSameDayDescendants(Node n,String d){
		
		Node[] desc = new Node[n.f_list.length];
		
		for(int c=0 ; c < n.f_list.length; c++) {
			
			if(fliesInDay(n.f_list[c],d)) {
				if(n.flightUsed == null || Time.timeCompare(n.f_list[c].dep,n.flightUsed.arr)) 
					desc[c] = new Node(n.f_list[c].destination,n.depth++,n,n.f_list[c]);
				
			}
		}
		return desc;
		
	}
	
	public static boolean SearchInStack(Stack<Node> st,Node n,Map<Node,Node> mp) {
		for (Map.Entry<Node, Node> entry : mp.entrySet()){
			if(entry.getValue().place.equals(n.place))
				return true;
		}
		
		for(Node obj : st) {
		   	if(obj.flightUsed.equals(n.flightUsed))
		   		return true;
		}
		
		return false;
	}
	
	public static void findRoute(String origin,String goal,String day){
		Node b = new Node(origin,0,null,null);
		
		Stack<Node> st = new Stack<Node>();
		Map<Node,Node> path = new HashMap<Node,Node>();
		
		st.push(b);
		Node n;
		Node[] d;
		while( !(st.empty())) {
			n = st.pop();
			//System.out.println("Popped => Place = " + n.place);
			//System.out.println("	   => Id 	 = " + n.flightUsed.id);
			if(IsGoal(n,goal)) {
				PrintMap(path,n);
			}else {
				d= getSameDayDescendants(n,day);
				for(int c=0 ; c<d.length; c++) {
					if ( d[c] != null && !SearchInStack(st,d[c],path) && availableInDay(day,d[c])) {
						//System.out.println("Pushed => Place = " + d[c].place);
						//System.out.println("	   => Id 	 = " + d[c].flightUsed.id);
						st.push(d[c]);
						path.put(d[c], n);
					}
					//------------------------------
					// TO LIMIT DEPTH - Add to the if statement: && d.desc[c].depth < k   | WHERE K IS THE DEPTH LIMIT
					//------------------------------	
					
				}
			}
			//System.out.println("_____________________________________________");
			
		}
		
		return;
		
	}
	
	public static boolean searchDays(String day,String[] arr) {
		for(int c=0;c<arr.length;c++) {
			if(arr[c].equals(day)) return true;
		}
		return false;
	}
	
	public static boolean availableInDay(String day,Node n) {
		
		int count=0;
		for(int c=0 ; c<n.f_list.length; c++) {
			
			if(!(searchDays(day, n.f_list[c].days))) {
				
				n.f_list[c]=null;
				count++;
			}
			
		}
		if(n.f_list.length == count)
			return false;
		else
			return true;
		
	}
	
	// Print the solution by going through the whole map	
	public static void PrintMap(Map<Node,Node> st,Node start) {
		
		
		ArrayList<String> out = new ArrayList<String>();
		String aux;
		Node curr = st.get(start);
		Node prev = start;
		while (curr != null) {
			aux = "In flight: " + prev.flightUsed.id + "\nFrom:      " + curr.place + "\nTo:        " + prev.place + "\nDeparting at " + prev.flightUsed.dep.hour + ":" + prev.flightUsed.dep.minute + "\nArriving at " + prev.flightUsed.arr.hour + ":" + prev.flightUsed.arr.minute + "\n";
			out.add(aux);
			prev = curr;
			curr = st.get(curr);
		}
		for(int c = out.size() - 1 ; c >= 0 ; c--){
			System.out.println(out.get(c));
		}
		System.out.println("__________________________________________________________________\n");
	}
	
	/*
	 * I need to visit cities C1, C2 and C3, starting my flight in city S on Tuesday and
	 *	returning to S on Friday. In which sequence I should visit cities C1, C2 and C3 so
	 *	that I dont need to have more than one flight a day?
	 * 
	 */
	
	public static void threePlaces(String s,String c1,String c2,String c3) {
		int lPos=0;
		String[] usedDays = new String[7];
		
		String[] dest = new String[] {s,c1,c2,c3,s};
		int d_ID = 1;		
		Node b = new Node(s,0,null,null);
				
		Stack<Node> st = new Stack<Node>();
		Map<Node,Node> path = new HashMap<Node,Node>();
		
		st.push(b);
		Node n;
		ArrayList<Node> d;
		
		while( !(st.empty())) {
			n = st.pop();
			RenderArr(usedDays);
			//System.out.println("*Popped => Place = " + n.place);
			//if(n.flightUsed != null)
			//	System.out.println("        => Id 	 = " + n.flightUsed.id);
			//System.out.println("");
			//if(d_ID != 1) {
			//	usedDays[lPos] = n.day;
			//	lPos++;
			//}
			if(n.place.equals(c1)) {
				d_ID = 2;
			}else if(n.place.equals(c2)) {
				d_ID = 3;
			}else if(n.place.equals(c3)) {
				d_ID = 4;
			}

			if(n.place.equals(s) && d_ID == 4) {
				PrintMapWithDays(path,n);
			}else {
				
				d= getT_PlaceDescendants(n,dest[d_ID],path);
				for(int c=0 ; c < d.size(); c++) {
					
					if ( d.get(c) != null) {
						//System.out.println("Pushed => Place  = " + d.get(c).place);
						//System.out.println("	   => Id 	 = " + d.get(c).flightUsed.id);
						//System.out.println("	   => Day 	 = " + d.get(c).day);
						//System.out.println("");
						st.push(d.get(c));
						path.put(d.get(c), n);
					}
				}
			}
			
		}

		//System.out.println("=> No solution found");
		
		return;
		
		
	}
	
	public static ArrayList<Node> getT_PlaceDescendants(Node n,String destination,Map<Node,Node> usedDays){
		
		ArrayList<Node> desc = new ArrayList<Node>();
		
		for(int c=0 ; c < n.f_list.length; c++) {
			
			if(n.f_list[c].destination.equals(destination) ) {
				for(int d = 0 ; d < n.f_list[c].days.length ; d++) {
					if(!isInMap(n.f_list[c].days[d],usedDays,n)) {
						Node k = new Node(n.f_list[c].destination,n.depth++,n,n.f_list[c]);
						k.day = n.f_list[c].days[d];
						desc.add(k);
							
					}
					
				}			
				
			}
		}
		return desc;
		
	}
	
	public static boolean isInMap(String day,Map<Node,Node> mp , Node start) {
		
		Node curr = mp.get(start);
		if(start.day != null)
			if(start.day.equals(day))
				return true;
		while (curr != null) {
			if(curr.day != null)
				if(curr.day.equals(day))
					return true;
			curr = mp.get(curr);
		}
		return false;
	}
	
	public static void RenderArr(String[] arr) {
		for(int c = 0 ; c < arr.length ; c++) {
			if( arr[c] != null)
				System.out.print(arr[c] + " | ");
			
		}
		System.out.println();		
	}

	public static void PrintMapWithDays(Map<Node,Node> st,Node start) {
		
		ArrayList<String> out = new ArrayList<String>();
		String aux;
		Node curr = st.get(start);
		Node prev = start;
		while (curr != null) {
			aux = "In flight: " + prev.flightUsed.id + " on " + prev.day + "\nFrom:      " + curr.place + "\nTo:        " + prev.place + "\nDeparting at " + prev.flightUsed.dep.hour + ":" + prev.flightUsed.dep.minute + "\nArriving at " + prev.flightUsed.arr.hour + ":" + prev.flightUsed.arr.minute + "\n";
			out.add(aux);
			prev = curr;
			curr = st.get(curr);
		}
		for(int c = out.size() - 1 ; c >= 0 ; c--){
			System.out.println(out.get(c));
		}
		System.out.println("__________________________________________________________________\n");
	}

	/*
	 * In which days of the week there is a direct flight from Place1 to Place2?
	 * 
	 */
	
	public static void directFlights(String origin, String dest) {
        Node n = new Node(origin,0,null,null);
        List<String> d1 = new ArrayList<>(); // w/ duplicates
        Set<String> d2 = new HashSet<>();    // w/o duplicates

        for (int i = 0; i < n.f_list.length; i++) {
            if(n.f_list[i].destination.equalsIgnoreCase(dest)) {
                for (int j = 0; j < n.f_list[i].days.length; j++) {
                    d1.add(n.f_list[i].days[j]);
                }
            }
        }
        
        d2.addAll(d1);
        d1.clear();
        d1.addAll(d2);
        
        if(d1.isEmpty())
            System.out.println("No available direct flights.");

        else
            System.out.println("Direct flights: " + d1);
    }


}

public class airport {
	
	public static void main (String[] args) {
	
		Scanner in = new Scanner(System.in);
		int op = -1;
		String p1,p2,dayOfWeek;
		
		while(op != 4){
			
			System.out.println("\nWhat question needs to be answered?");
			System.out.println(" 1) In which days of the week there is a direct flight from Place1 to Place2?");
			System.out.println(" 2) What are the available flights from Place1 to Place2 on a given day of the week?");
			System.out.println(" 3) I need to visit cities C1, C2 and C3, starting my flight in city S on Tuesday and returning to S on Friday. In which sequence I should visit cities C1, C2 and C3 so that I don't need to have more than one flight a day?");
			System.out.println(" 4) Exit");
			System.out.print("\nOption: ");
			op = in.nextInt();
			System.out.println("\n");
			switch(op){
				case 1:
				
				System.out.print("  => Place 1: ");
				p1 = in.next();
				
				System.out.print("  => Place 2: ");
				p2 = in.next();
							
				Routes.directFlights(p1,p2);
				break;
				
				case 2:
					
				System.out.print("  => Place 1: ");
				p1 = in.next();
				
				System.out.print("  => Place 2: ");
				p2 = in.next();
				
				System.out.print("  => Day of the week (mo/tu/we/th/fr/sa/su): ");
				dayOfWeek = in.next();
				
				System.out.println();
				Routes.findRoute(p1,p2,dayOfWeek);
				break;
				
				case 3:
				
				String s,c1,c2,c3;
				
				System.out.print("  => City S: ");
				s = in.next();
				
				System.out.print("  => City C1: ");
				c1 = in.next();
				
				System.out.print("  => City C2: ");
				c2 = in.next();
				
				System.out.print("  => City C3: ");
				c3 = in.next();
							
				Routes.threePlaces(s,c1,c2,c3);
				break;
				
				
				case 4:
				break;
				
				default:
				System.out.println("	--INVALID OPTION--");
				
			}
		}
		/*System.out.println("De edinburgh para milan tuesday:\n");
		Routes.findRoute("edinburgh", "milan", "tu");
		System.out.println("\n\nDe london para milan wednsday:\n");
		Routes.findRoute("london", "milan", "we");
		System.out.println("PORTO -> LISBOA -> FARO -> BRAGA -> PORTO\n");
		Routes.threePlaces("porto", "lisboa", "faro", "braga");*/
		
	}
}
