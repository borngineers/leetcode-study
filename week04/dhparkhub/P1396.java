package solved;

import java.util.HashMap;
import java.util.Map;

public class P1396 {

    class UndergroundSystem {
        public UndergroundSystem() {
            checkInMap = new HashMap<>();
            checkOutMap = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            checkInMap.put(id, new CheckInInfo(stationName, t));
        }

        public void checkOut(int id, String stationName, int t) {
            CheckInInfo checkInInfo = checkInMap.get(id);
            String checkOutKey = String.format("%s-%s", checkInInfo.stationName, stationName);
            if (!checkOutMap.containsKey(checkOutKey)) {
                checkOutMap.put(checkOutKey, new CheckOutInfo(t - checkInInfo.t, 1));
            } else {
                checkOutMap.get(checkOutKey).total += t - checkInInfo.t;
                checkOutMap.get(checkOutKey).count += 1;
            }
        }

        public double getAverageTime(String startStation, String endStation) {
            String checkOutKey = String.format("%s-%s", startStation, endStation);
            CheckOutInfo checkOutInfo = checkOutMap.get(checkOutKey);
            return (double) checkOutInfo.total / checkOutInfo.count;
        }

        class CheckInInfo {
            private String stationName;
            private int t;

            CheckInInfo(String stationName, int t) {
                this.stationName = stationName;
                this.t = t;
            }
        }

        class CheckOutInfo {
            private int total;
            private int count;

            CheckOutInfo(int total, int count) {
                this.total = total;
                this.count = count;
            }
        }

        private Map<Integer, CheckInInfo> checkInMap;
        private Map<String, CheckOutInfo> checkOutMap;
    }

}
