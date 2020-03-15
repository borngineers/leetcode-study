package sw1952;

import java.io.*;
import java.util.*;

public class SwimmingPool {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        String format = "#%d %d";

        for (int test_case = 1; test_case <= T; test_case++) {
            int dayTicket = sc.nextInt();
            int monthOneTicket = sc.nextInt();
            int monthThreeTicket = sc.nextInt();
            int yearTicket = sc.nextInt();

            int[] years = new int[13];

            for (int i = 1; i <= 12; i++) {
                years[i] = sc.nextInt();
            }

            TicketCalculator ticketCalculator = TicketCalculator.create(dayTicket, monthOneTicket, monthThreeTicket, yearTicket, years);
            System.out.println(String.format(format, test_case, ticketCalculator.getSumMinMoney()));
        }
    }

    static class TicketCalculator {

        private static final int LAST_MONTH_OF_YEAR = 12;
        private final int dayTicket;
        private final int monthOneTicket;
        private final int monthThreeTicket;
        private final int yearTicket;
        private final List<Integer> moneys = new ArrayList<>();
        private final int[] years;

        private TicketCalculator(int dayTicket, int monthOneTicket, int monthThreeTicket, int yearTicket, int[] years) {
            this.dayTicket = dayTicket;
            this.monthOneTicket = monthOneTicket;
            this.monthThreeTicket = monthThreeTicket;
            this.yearTicket = yearTicket;
            this.years = years;
        }

        public static TicketCalculator create(int dayTicket, int monthOneTicket, int monthThreeTicket, int yearTicket, int[] years){
            return new TicketCalculator(dayTicket, monthOneTicket, monthThreeTicket, yearTicket, years);
        }

        public int getSumMinMoney() {
            moneys.add(yearTicket);
            process(moneys, 0, 1);
            Collections.sort(moneys);
            return moneys.get(0);
        }

        private void process(List<Integer> moneys, int sumMoney, int year) {
            if (year > LAST_MONTH_OF_YEAR) {
                moneys.add(sumMoney);
                return;
            }

            process(moneys, sumMoney + dayTicket * years[year], year + 1);
            process(moneys, sumMoney + monthOneTicket, year + 1);
            process(moneys, sumMoney + monthThreeTicket, year + 3);
        }
    }
}
