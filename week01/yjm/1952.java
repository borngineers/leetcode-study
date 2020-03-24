import java.util.Scanner;

public class SWExpert1952 {
    /**
     * [수영장 이용계획]
     *
     * [예시]
     * 수영장에서 판매하는 1일 이용권, 1달 이용권, 3달 이용권, 1년 이용권의 요금은 각각 10원, 40원, 100원, 300원이다.
     *
     * [제약 사항]
     * 1. 시간 제한 : 최대 50개 테스트 케이스를 모두 통과하는 데 C/C++/Java 모두 3초
     * 2. 모든 종류의 이용권 요금은 10 이상 3,000 이하의 정수이다.
     * 3. 각 달의 이용 계획은 각 달의 마지막 일자보다 크지 않다.
     *
     * [입력]
     * 입력의 맨 첫 줄에는 총 테스트 케이스의 개수 T가 주어지고, 그 다음 줄부터 T개의 테스트 케이스가 주어진다.
     * 각 테스트 케이스의 첫 번째 줄에는 1일 이용권의 요금, 1달 이용권의 요금, 3달 이용권의 요금, 1년 이용권의 요금이 순서대로 한 칸씩 띄고 주어진다.
     * 그 다음 줄에는 1월부터 12월까지의 이용 계획이 주어진다.
     *
     * [출력]
     * 테스트 케이스 개수만큼 T개의 줄에 각각의 테스트 케이스에 대한 답을 출력한다.
     * 각 줄은 "#t"로 시작하고 공백을 하나 둔 다음 정답을 출력한다. (t는 1부터 시작하는 테스트 케이스의 번호이다)
     * 출력해야 할 정답은 이용 계획대로 수영장을 이용하는 경우 중 가장 적게 지출하는 비용이다.
     *
     * */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		int[] months = new int[12];
        CalcLowestPrice calcObject = CalcLowestPrice.getInstance();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int dayTicketPrice = sc.nextInt();
            int monthTicketPrice = sc.nextInt();
            int threeMonthTicketPrice = sc.nextInt();
            int yearTicketPrice = sc.nextInt();

            for (int i = 0; i < 12; i++) {
                months[i] = sc.nextInt();
            }

            CalcLowestPrice.getInstance().settingConditions(dayTicketPrice, monthTicketPrice, threeMonthTicketPrice, months);
            int lowestPrice = Math.min(yearTicketPrice, CalcLowestPrice.getInstance().calcPrice(0, 0));
            System.out.println(String.format("#%d %d", test_case, lowestPrice));
        }
    }


}

class CalcLowestPrice {
    public static CalcLowestPrice getInstance() {
        return SingletonHolder.INSTANCE;
    }
    private static final class SingletonHolder {
        private static final CalcLowestPrice INSTANCE = new CalcLowestPrice();
    }

    private int dayPrice, monthPrice, threeMonthPrice = 0;
    private int[] plans;
    public void settingConditions(int day, int month, int threeMonth, int[] plan) {
        dayPrice = day;
        monthPrice = month;
        threeMonthPrice = threeMonth;
        plans = plan;
    }

    public int calcPrice(int month, int sum) {
        if (month > 11) return sum;
        if (plans[month] == 0) return calcPrice(month + 1, sum);
        int dailySum = calcPrice(month + 1, sum + plans[month] * dayPrice);
        int monthlySum = calcPrice(month + 1, sum + monthPrice);
        int threeMonthlySum = calcPrice(month + 3, sum + threeMonthPrice);
        return Math.min(dailySum, Math.min(monthlySum, threeMonthlySum));
    }
}
