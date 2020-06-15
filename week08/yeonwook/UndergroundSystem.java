package test;

import java.util.HashMap;
import java.util.Map;

public class Aaaa {
	public static void main(String args[]) {
		
	}
}

class UndergroundSystem {
	
	private Map<Integer, Customer> checkInMap;
	private Map<String, Double> resultMap;
	private Map<String, Integer> resultCnt;

    public UndergroundSystem() {
    	checkInMap = new HashMap<Integer, Customer>();
    	resultMap = new HashMap<String, Double>();
    	resultCnt = new HashMap<String, Integer>();
    }
    
    public void checkIn(int id, String stationName, int t) {
    	
    	if(!checkInMap.containsKey(id)) {
    		Customer customer = new Customer(stationName, t);
    		checkInMap.put(id, customer);
    	} 
    	
    }
    
    public void checkOut(int id, String stationName, int t) {
    	
    	if(checkInMap.containsKey(id)) {
    		Customer customer = checkInMap.get(id);
    		
    		String station = customer.station + "-" + stationName;
    		double time = t - customer.time;
    		
    		if(resultMap.containsKey(station)) {
    			resultMap.put(station, resultMap.get(station) + time);
    			resultCnt.put(station, resultCnt.get(station)+1);
    		} else {
    			resultMap.put(station, time);
    			resultCnt.put(station, 1);
    		}
    		
    		checkInMap.remove(id);
    	}
    	
    }
    
    public double getAverageTime(String startStation, String endStation) {
    	
    	String station = startStation + "-" + endStation;
    	if(resultMap.containsKey(station)) {
    		return  resultMap.get(station) / resultCnt.get(station);
    	}
    	
    	return -1;
    }
}


class Customer {
	String station;
	double time;
	
	public Customer(String station, double time) {
		this.station = station;
		this.time = time;
	}
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */