import java.util.*;

class UndergroundSystem {

    Map<Integer, String> customers = new HashMap<>();
    Map<String, Integer> rangeCustomers = new HashMap<>(); // 역 위치, 인원수
    Map<String, Integer> averageCustomers = new HashMap<>();

    public UndergroundSystem() {

    }

    public void checkIn(int id, String stationName, int t) {
        customers.put(id, stationName + "-" + t);
    }

    public void checkOut(int id, String stationName, int t) {
        String start = customers.getOrDefault(id, "");
        if(start.length() == 0){
            return;
        }

        String[] elements = start.split("-");
        String range = elements[0] + "-" + stationName;
        rangeCustomers.put(range, rangeCustomers.getOrDefault(range, 0) + 1);

        int rangeTime = t - Integer.parseInt(elements[1]);
        averageCustomers.put(range, averageCustomers.getOrDefault(range, 0) + rangeTime);
    }

    public double getAverageTime(String startStation, String endStation) {
        final String range = startStation + "-" + endStation;
        return ((double)averageCustomers.get(range) / (double)rangeCustomers.get(range));
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
