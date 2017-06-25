package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class AI {
    Random random;
    public AI(){
        random = new Random();
    }

    public int[] calculate(){
        System.out.println("calculate");
        System.out.println(Collocation.getCollocation().actCount);
        if(Collocation.getCollocation().actCount==1) {
            int[] ans = new int[]{6 + random.nextInt(2), 6 + random.nextInt(2)};
            while (Arrays.equals(ans,new int[]{7,7}))
                ans = new int[]{6 + random.nextInt(2), 6 + random.nextInt(2)};
            return ans;
        }
        Collocation collocation = Collocation.getCollocation();
        int[] answer = new int[2];
        answer[0] = random.nextInt(15);
        answer[1] = random.nextInt(15);
        Collocation copy = new Collocation(Collocation.getCollocation());
        int max = 0;
        for (int i = 0; i < 15; i++)
            for (int j = 0; j < 15; j++)
                if (copy.stones[i][j] != null) {
                    if (copy.stones[i][j].colour) {
                        int[] currentWays = copy.get8Directions(i, j, true);
                        for (int k = 0; k < 8; k++) {
                            if (currentWays[k] >= max) {
                                max = currentWays[k];
                                int x = k == 0 ? i + 1 : k == 1 ? i + 1 : k == 2 ? i + 1 : k == 3 ? i : k == 4 ? i - 1 : k == 5 ? i - 1 : k == 6 ? i - 1 : i;
                                int y = k == 0 ? j + 1 : k == 1 ? j : k == 2 ? j - 1 : k == 3 ? j - 1 : k == 4 ? j - 1 : k == 5 ? j : k == 6 ? j + 1 : j + 1;
                                x = x > 14 ? 14 : x < 0 ? 0 : x;
                                y = y > 14 ? 14 : y < 0 ? 0 : y;
                                if (copy.stones[x][y] == null)
                                    answer = new int[]{x, y};
                            }
                        }
                    } else {
                        int[] currentWays = copy.get8Directions(i, j, false);
                        for (int k = 0; k < 8; k++) {
                            if (currentWays[k] >= 3) {
                                int x = k == 0 ? i + 1 : k == 1 ? i + 1 : k == 2 ? i + 1 : k == 3 ? i : k == 4 ? i - 1 : k == 5 ? i - 1 : k == 6 ? i - 1 : i;
                                int y = k == 0 ? j + 1 : k == 1 ? j : k == 2 ? j - 1 : k == 3 ? j - 1 : k == 4 ? j - 1 : k == 5 ? j : k == 6 ? j + 1 : j + 1;
                                x = x > 14 ? 14 : x < 0 ? 0 : x;
                                y = y > 14 ? 14 : y < 0 ? 0 : y;
                                if (copy.stones[x][y] == null)
                                    return new int[]{x, y};
                            }
                        }
                    }
                }

        answer[0] = answer[0] > 14 ? 14 : answer[0] < 0 ? 0 : answer[0];
        answer[1] = answer[1] > 14 ? 14 : answer[1] < 0 ? 0 : answer[1];
//        Collocation copy = new Collocation(collocation);
//        for (int i = 0; i < 15; i++)
//            for (int j = 0; j < 15; j++)
//                if (copy.stones[i][j]!=null && !copy.stones[i][j].colour) {
//                    int[] current = copy.get8Directions(i, j, false);
//                    int max = 0;
//                    for (int k = 0; k < 8; k++) {
//                        if (current[k] > max){
//                            max = current[max];
//                        }
//                    }
//                }
        System.out.println("preans "+Arrays.toString(answer));
        System.out.println(collocation.stones[answer[0]][answer[1]] == null );
        System.out.println(collocation.check(answer[0], answer[1]));
        System.out.println("wtfwtfwtf "+copy.check());
        if (collocation.stones[answer[0]][answer[1]] == null && (collocation.check(answer[0], answer[1]))){
            return answer;
        }
        else return null;
    }
}
