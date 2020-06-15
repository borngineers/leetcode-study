import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b);                                     // double 변수 1개 출력하는 예제
//System.out.println(g);                                     // char 변수 1개 출력하는 예제
//System.out.println(var);                             // 문자열 1개 출력하는 예제
//System.out.println(AB);                                // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
 
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    public static int[][] checkArr;
    //public static List<Entity> entityList;
     
    public static void main(String args[]) throws Exception
    {
        /*
           아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
           여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
           이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
           따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
           단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
         */
        //System.setIn(new FileInputStream(".\\res\\sample.txt"));
         
        /*
           표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
         */
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        /*
           여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
        */
 
        sc.nextLine();
         
        //각 테스트 케이스의 첫째 줄에는 구역의 한 변에 있는 셀의 개수 N, 격리 시간 M, 미생물 군집의 개수 K가 순서대로 주어지며, 
        //다음 K줄에 걸쳐서 미생물 군집 K개의 정보가 주어진다.
        //각 군집의 정보는 세로 위치, 가로 위치, 미생물 수, 이동 방향 순
        for(int test_case = 1; test_case <= T; test_case++)
        {
             
            /////////////////////////////////////////////////////////////////////////////////////////////
            /*
                 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
             */
            /////////////////////////////////////////////////////////////////////////////////////////////
             
            String standard = sc.nextLine();
            String[] standardList = standard.split(" ");
             
            int celCnt = Integer.parseInt(standardList[0]);
            int maxTime = Integer.parseInt(standardList[1]);
            int entityCnt = Integer.parseInt(standardList[2]);
             
            List<Entity> entityList = new ArrayList<Entity>();
             
            for(int i=0; i<entityCnt; i++) {
                String entityValue = sc.nextLine();
                String[] entityValues = entityValue.split(" ");
                 
                Entity entity = new Entity();
                entity.row = Integer.parseInt(entityValues[0]);
                entity.col = Integer.parseInt(entityValues[1]);
                entity.cnt = Integer.parseInt(entityValues[2]);
                entity.direct = Integer.parseInt(entityValues[3]);
                         
                entityList.add(entity);
            }
             
            for(int i=0; i<maxTime; i++) {
                //함수 호출
                checkArr = new int[celCnt][celCnt];
                moveEntity(entityList, celCnt, checkArr);
            }
             
            int totalCnt = 0;
             
            for(Entity entity : entityList) {
                totalCnt += entity.cnt;
            }
             
            System.out.println("#"+test_case+" "+totalCnt);
             
 
        }
    }
     
    public static void moveEntity(List<Entity> entityList, int celCnt, int[][] checkArr) {
         
        List<Entity> resultList = new ArrayList<Entity>();
 
        //상: 1, 하: 2, 좌: 3, 우: 4
        for(Entity entity : entityList) {
             
            if(entity.cnt <= 0) {
                continue;
            }
             
            if(entity.direct == 1) {
                entity.row = entity.row-1;
            } 
            if(entity.direct == 2) {
                entity.row = entity.row+1;
            }
            if(entity.direct == 3) {
                entity.col = entity.col-1;          
            }
            if(entity.direct == 4) {
                entity.col = entity.col+1;  
            }
             
            if(entity.col == 0 || entity.col == celCnt - 1 ||
                    entity.row == 0 || entity.row == celCnt - 1) {
                 
                entity.cnt = (int) Math.floor(entity.cnt / 2);
                 
                if( entity.cnt <= 0) {
                    continue;
                }
                 
                if((entity.direct % 2) == 1) {
                    entity.direct = entity.direct + 1;
                } else {
                    entity.direct = entity.direct -1;
                }
                 
                checkArr[entity.col][entity.row] = entity.cnt;
                resultList.add(entity);
                 
            } else {
                if(checkArr[entity.col][entity.row] != 0) {
                    //존재하면
                    checkArr[entity.col][entity.row] += entity.cnt;
                     
                    for(Entity check : resultList) {
                        if(check.row == entity.row && check.col == entity.col &&
                                check.cnt < entity.cnt) {
                            check.direct = entity.direct;
                            check.cnt = entity.cnt;
                        }
                    }
                     
                } else {
                    //존재하지 않으면
                    checkArr[entity.col][entity.row] = entity.cnt;
                    resultList.add(entity);
                }
            }
             
             
        }
         
        entityList.clear();
         
        for(Entity entity : resultList) {
            entity.cnt = checkArr[entity.col][entity.row];
             
            entityList.add(entity);
        }
    }
}
 
class Entity {
    int row;
    int col;
    int cnt;
    int direct;
}