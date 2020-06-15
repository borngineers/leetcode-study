class UndergroundSystem {
    HashMap<Integer, Station> userInfo = new HashMap<>();
    HashMap<String, CalcTime> stationInfo = new HashMap<>();

    public UndergroundSystem() {
        userInfo.clear();
        stationInfo.clear();
    }

    public void checkIn(int id, String stationName, int t) {
        userInfo.put(id, new Station(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Station checkInStation = userInfo.get(id);
        String stations = checkInStation.station + "-" + stationName;
        if (stationInfo.containsKey(stations)) {
            CalcTime calcTime = stationInfo.get(stations);
            calcTime.count++;
            calcTime.total += t - checkInStation.time;
        } else {
            stationInfo.put(stations, new CalcTime(t - checkInStation.time, 1));
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        CalcTime calcTime = stationInfo.get(startStation + "-" + endStation);
        return calcTime.total / calcTime.count;
    }

    class Station {
        String station = "";
        double time = 0;
        public Station(String station, double time) {
            this.station = station;
            this.time = time;
        }
    }

    class CalcTime {
        double total = 0;
        int count = 0;
        public CalcTime(double total, int count) {
            this.total = total;
            this.count = count;
        }
    }
}
