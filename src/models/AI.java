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
            int[] resp = new int[]{6 + random.nextInt(2), 6 + random.nextInt(2)};
            while (Arrays.equals(resp,new int[]{7,7}))
                resp = new int[]{6 + random.nextInt(2), 6 + random.nextInt(2)};
            return resp;
        }
        Collocation collocation = Collocation.getCollocation();
        int[] response = new int[2];
        response[0] = random.nextInt(15);
        response[1] = random.nextInt(15);
        Collocation copy = new Collocation(Collocation.getCollocation());
        int max = 0;
        for (int i = 0; i < 15; i++)
            for (int j = 0; j < 15; j++)
                if (copy.stones[i][j] != null) {
                    if (copy.stones[i][j].colour) {
                        int[] currentDirections = copy.get8Directions(i, j, true);
                        for (int k = 0; k < 8; k++) {
                            if (currentDirections[k] >= max) {
                                max = currentDirections[k];
                                int x = k == 0 ? i + 1 : k == 1 ? i + 1 : k == 2 ? i + 1 : k == 3 ? i : k == 4 ? i - 1 : k == 5 ? i - 1 : k == 6 ? i - 1 : i;
                                int y = k == 0 ? j + 1 : k == 1 ? j : k == 2 ? j - 1 : k == 3 ? j - 1 : k == 4 ? j - 1 : k == 5 ? j : k == 6 ? j + 1 : j + 1;
                                x = x > 14 ? 14 : x < 0 ? 0 : x;
                                y = y > 14 ? 14 : y < 0 ? 0 : y;
                                if (copy.stones[x][y] == null)
                                    response = new int[]{x, y};
                            }
                        }
                    } else {
                        int[] currentDirections = copy.get8Directions(i, j, false);
                        for (int k = 0; k < 8; k++) {
                            if (currentDirections[k] >= 3) {
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

        response[0] = response[0] > 14 ? 14 : response[0] < 0 ? 0 : response[0];
        response[1] = response[1] > 14 ? 14 : response[1] < 0 ? 0 : response[1];
        if (collocation.stones[response[0]][response[1]] == null && (collocation.check(response[0], response[1]))){
            return response;
        }
        else return null;
    }
}
