package models;

import java.util.Arrays;

/**
 * Created by TriplePi on 14.05.2017.
 */
public class Collocation {
    boolean player;
    Stone[][] stones;
    private static Collocation collocationForAll;
    int blackCount;
    int whiteCount;
    int actCount;
    int[] lastStone;


    public Collocation() {
        player = false;
        stones = new Stone[15][15];
        blackCount = 0;
        whiteCount = 0;
        actCount = 0;
    }

    public static void restart() {
        collocationForAll = new Collocation();
    }

    public boolean addStone(int x, int y) {
        if (stones[x][y] != null)
            return false;
//        int[] coords = check(x, y);
//        if (coords == null) {
//            System.out.println(player + " is loser");
//            return false;
//        }
        actCount++;
        stones[x][y] = new Stone(player);
        lastStone = new int[2];
        lastStone[0] = x;
        lastStone[1] = y;
        if (getPlayer())
            whiteCount++;
        else blackCount++;
        int check = check();
        if (check == -1) {
            System.out.println(player + " is loser");
            invertPlayer();
            return false;
        }
        if (check == 2 || check == -2)
            System.out.println("winner" + check);
        invertPlayer();
        return true;
    }

    public int check() {
        int x = lastStone[0];
        int y = lastStone[1];
//        System.out.println(actCount);
//        System.out.print(Math.abs(x - 7) + " ");
//        System.out.println(Math.abs(y - 7));

        if (actCount == 1 && (x != 7 || y != 7) && !getPlayer())
            return -1;
        if (actCount == 2 && !(Math.abs(x - 7) <= 1 && Math.abs(y - 7) <= 1))
            return -1;
        if (actCount == 3 && (Math.abs(x - 7) > 2 || Math.abs(y - 7) > 2) && !getPlayer())
            return -1;
        int[] directions = get8Directions(x, y, getStone(lastStone).colour);
        int lt = directions[0];
        int t = directions[1];
        int rt = directions[2];
        int r = directions[3];
        int rb = directions[4];
        int b = directions[5];
        int lb = directions[6];
        int l = directions[7];
        if (getStone(lastStone).colour) {
            if (t + b == 4 || l + r == 4 || lt + rb == 4 || lb + rt == 4) {
                System.out.println("wtf");
                return 2;
            }
        } else {
            System.out.println("fakse check");
            if (t + b == 4 || l + r == 4 || lt + rb == 4 || lb + rt == 4)
                return -2;
            if (t + b == 5 || l + r == 5 || lt + rb == 5 || lb + rt == 5)
                return -1;
            if(l==1 && t ==1 && b==1 && r==1)
                return -1;
            if(lb==1 && lt ==1 && rb==1 && rt==1)
                return -1;
            int max = 0;
            for (int i = 0; i < 7; i++)
                for (int j = i + 1; j < 8; j++)
                    if (directions[i] + directions[j] > max) {
                        max = directions[i] + directions[j];
                    }
            System.out.println("max" + max);
            if (max >= 4 && max % 2 == 0)
                return -1;
//        if (!getStone(new int[]{x, y}).colour)
//            if (checkOnLongSequence(new int[]{x, y}) || checkOn3x3(new int[]{x, y}))
//                return true;
            return 0;
        }
        return 0;
    }

    public static Collocation getCollocation() {
        if (collocationForAll == null) {
            collocationForAll = new Collocation();
        }
        return collocationForAll;
    }

    public boolean getPlayer() {
        return player;
    }

    public void invertPlayer() {
        this.player = !this.player;
    }

    public void skip() {
        if (getPlayer() && whiteCount >= 3)
            invertPlayer();
        else if (blackCount >= 3)
            invertPlayer();
    }

//    public int checkOnFoul() {
//        int[] buffer = Arrays.copyOf(lastStone, 2);
//        while (getStone(step(buffer, "l")) != null) {
//            buffer = step(buffer, "l");
//        }
//        return 0;
//    }

//    public boolean checkOnLongSequence(int[] coordinates) {
//        int[] buffer = Arrays.copyOf(coordinates, 2);
//        int count = 0;
//        while (getStone(step(buffer, "l")) != null) {
//            buffer = step(buffer, "l");
//        }
//        while (getStone(step(buffer, "r")) != null && getStone(coordinates) != null && getStone(step(buffer, "r")).colour == getStone(coordinates).colour) {
//            buffer = step(buffer, "r");
//            count++;
//        }
//        if (count > 4)
//            return true;
//        System.out.println("count " + count);
//        count = 0;
//        while (getStone(step(buffer, "t")) != null) {
//            buffer = step(buffer, "t");
//        }
//        while (getStone(step(buffer, "b")) != null && getStone(coordinates) != null && getStone(step(buffer, "b")).colour == getStone(coordinates).colour) {
//            buffer = step(buffer, "b");
//            count++;
//        }
//        if (count > 4)
//            return true;
//        System.out.println("count " + count);
//        count = 0;
//        while (getStone(step(buffer, "lb")) != null) {
//            buffer = step(buffer, "lb");
//        }
//        while (getStone(step(buffer, "rt")) != null && getStone(coordinates) != null && getStone(step(buffer, "rt")).colour == getStone(coordinates).colour) {
//            buffer = step(buffer, "rt");
//            count++;
//        }
//        if (count > 4)
//            return true;
//        System.out.println("count " + count);
//        count = 0;
//        while (getStone(step(buffer, "lt")) != null) {
//            buffer = step(buffer, "lt");
//        }
//        while (getStone(step(buffer, "rb")) != null && getStone(coordinates) != null && getStone(step(buffer, "rb")).colour == getStone(coordinates).colour) {
//            buffer = step(buffer, "rb");
//            count++;
//        }
//        if (count > 4)
//            return true;
//        System.out.println("count " + count);
//        return false;
//    }
//
//    public boolean checkOn3x3(int[] coordinates) {
//        System.out.println("checkOn3x3");
//        int[] buffer = Arrays.copyOf(coordinates, 2);
//        int count = 0;
//        int blockCount = 0;
//        boolean firstFlag = false;
//        boolean secondFlag = false;
//        int rowCount = 0;
//        while (getStone(step(buffer, "l")) != null) {
//            buffer = step(buffer, "l");
//        }
//        if (getStone(step(buffer, "l")) != null && getStone(step(buffer, "l")).colour)
//            firstFlag = true;
//        while (getStone(step(buffer, "r")) != null && getStone(coordinates) != null && getStone(step(buffer, "r")).colour == getStone(coordinates).colour) {
//            buffer = step(buffer, "r");
//            count++;
//        }
//        if (getStone(step(buffer, "r")) != null && getStone(step(buffer, "r")).colour)
//            secondFlag = true;
//        if (count == 2) {
//            rowCount++;
//            if (firstFlag)
//                blockCount++;
//            if (secondFlag)
//                blockCount++;
//        }
//        firstFlag = false;
//        secondFlag = false;
//        buffer = Arrays.copyOf(coordinates, 2);
//        System.out.println("count " + count);
//        count = 0;
//        while (getStone(step(buffer, "t")) != null) {
//            buffer = step(buffer, "t");
//        }
//        if (getStone(step(buffer, "t")) != null && getStone(step(buffer, "t")).colour)
//            firstFlag = true;
//        while (getStone(step(buffer, "b")) != null && getStone(coordinates) != null && getStone(step(buffer, "b")).colour == getStone(coordinates).colour) {
//            buffer = step(buffer, "b");
//            count++;
//        }
//        if (getStone(step(buffer, "b")) != null && getStone(step(buffer, "b")).colour)
//            secondFlag = true;
//        if (count == 2) {
//            rowCount++;
//            if (firstFlag)
//                blockCount++;
//            if (secondFlag)
//                blockCount++;
//        }
//        firstFlag = false;
//        secondFlag = false;
//        buffer = Arrays.copyOf(coordinates, 2);
//        System.out.println("count " + count);
//        count = 0;
//        while (getStone(step(buffer, "lb")) != null) {
//            buffer = step(buffer, "lb");
//        }
//        if (getStone(step(buffer, "lb")) != null && getStone(step(buffer, "lb")).colour)
//            firstFlag = true;
//        while (getStone(step(buffer, "rt")) != null && getStone(coordinates) != null && getStone(step(buffer, "rt")).colour == getStone(coordinates).colour) {
//            buffer = step(buffer, "rt");
//            count++;
//        }
//        if (getStone(step(buffer, "rt")) != null && getStone(step(buffer, "rt")).colour)
//            secondFlag = true;
//        if (count == 2) {
//            rowCount++;
//            if (firstFlag)
//                blockCount++;
//            if (secondFlag)
//                blockCount++;
//        }
//        firstFlag = false;
//        secondFlag = false;
//        buffer = Arrays.copyOf(coordinates, 2);
//        System.out.println("count " + count);
//        count = 0;
//        while (getStone(step(buffer, "lt")) != null) {
//            buffer = step(buffer, "lt");
//        }
//        if (getStone(step(buffer, "lt")) != null && getStone(step(buffer, "lt")).colour)
//            firstFlag = true;
//        while (getStone(step(buffer, "rb")) != null && getStone(coordinates) != null && getStone(step(buffer, "rb")).colour == getStone(coordinates).colour) {
//            buffer = step(buffer, "rb");
//            count++;
//        }
//        if (getStone(step(buffer, "rb")) != null && getStone(step(buffer, "rb")).colour)
//            secondFlag = true;
//        if (count == 2) {
//            rowCount++;
//            if (firstFlag)
//                blockCount++;
//            if (secondFlag)
//                blockCount++;
//        }
//        System.out.println("count " + count);
//        System.out.println(blockCount);
//        System.out.println(rowCount);
//        System.out.println(blockCount < 2 && rowCount > 1);
//        return blockCount < 2 && rowCount > 1;
//    }

    private Stone getStone(int[] coord) {
        Stone stone = null;
        try {
            stone = stones[coord[0]][coord[1]];
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
        return stone;
    }

    private int[] step(int[] old, String direction) {
        int[] newC = Arrays.copyOf(old, 2);
        switch (direction) {
            case "l":
                newC[0]--;
                break;
            case "t":
                newC[1]--;
                break;
            case "r":
                newC[0]++;
                break;
            case "b":
                newC[1]++;
                break;
            case "lt":
                newC[0]--;
                newC[1]--;
                break;
            case "lb":
                newC[0]--;
                newC[1]++;
                break;
            case "rt":
                newC[0]++;
                newC[1]--;
                break;
            case "rb":
                newC[0]++;
                newC[1]++;
                break;
        }
        return newC;
    }

    public int[] get8Directions(int i, int j, boolean activePlayer) {
        int ux = i - 1, uAnswer = 0;
        while (ux >= 0) {
            if (getStone(new int[]{ux, j}) != null && getStone(new int[]{ux, j}).colour == activePlayer) {
                uAnswer++;
            } else break;
            ux--;
        }

        int dx = i + 1, dAnswer = 0;
        while (dx < 15) {
            if (getStone(new int[]{dx, j}) != null && getStone(new int[]{dx, j}).colour == activePlayer) {
                dAnswer++;
            } else break;
            dx++;
        }

        int rx = j + 1, rAnswer = 0;
        while (rx < 15) {
            if (getStone(new int[]{i, rx}) != null && getStone(new int[]{i, rx}).colour == activePlayer) {
                rAnswer++;
            } else break;
            rx++;
        }

        int lx = j - 1, lAnswer = 0;
        while (lx >= 0) {
            if (getStone(new int[]{i, lx}) != null && getStone(new int[]{i, lx}).colour == activePlayer) {
                lAnswer++;
            } else break;
            lx--;
        }

        int ulx = i - 1, uly = j - 1;
        int ulAnswer = 0;
        while (ulx >= 0 && uly >= 0) {
            if (getStone(new int[]{ulx, uly}) != null && getStone(new int[]{ulx, uly}).colour == activePlayer) {
                ulAnswer++;
            } else break;
            ulx--;
            uly--;
        }
        int urx = i - 1, ury = j + 1;
        int urAnswer = 0;
        while (urx >= 0 && ury < 15) {
            if (getStone(new int[]{urx, ury}) != null && getStone(new int[]{urx, ury}).colour == activePlayer) {
                urAnswer++;
            } else break;
            urx--;
            ury++;
        }

        int dlx = i + 1, dly = j - 1;
        int dlAnswer = 0;
        while (dlx < 15 && dly >= 0) {
            if (getStone(new int[]{dlx, dly}) != null && getStone(new int[]{dlx, dly}).colour == activePlayer) {
                dlAnswer++;
            } else break;
            dlx++;
            dly--;
        }
        int drx = i + 1, dry = j + 1;
        int drAnswer = 0;
        while (drx < 15 && dry < 15) {
            if (getStone(new int[]{drx, dry}) != null && getStone(new int[]{drx, dry}).colour == activePlayer) {
                drAnswer++;
            } else break;
            drx++;
            dry++;
        }
        System.out.println(Arrays.toString(new int[]{ulAnswer, uAnswer, urAnswer, rAnswer, drAnswer, dAnswer, dlAnswer, lAnswer}));
        return new int[]{ulAnswer, uAnswer, urAnswer, rAnswer, drAnswer, dAnswer, dlAnswer, lAnswer};
    }
}
