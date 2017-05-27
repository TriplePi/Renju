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
        if (check()) {
            System.out.println(player + " is loser");
            invertPlayer();
            return false;
        }
        invertPlayer();
        return true;
    }

    public boolean check() {
        int x = lastStone[0];
        int y = lastStone[1];
        System.out.println(actCount);
        System.out.print(Math.abs(x - 7) + " ");
        System.out.println(Math.abs(y - 7));
        if (actCount == 1 && (x != 7 || y != 7) && !getPlayer())
            return true;
        System.out.println(actCount);
        if (actCount == 2 && (Math.abs(x - 7) != 1 || Math.abs(y - 7) != 1) && getPlayer()) {
            System.out.println("wtf");
            return true;
        }
        if (actCount == 3 && (Math.abs(x - 7) > 2 || Math.abs(y - 7) > 2) && !getPlayer())
            return true;
        if (!getStone(new int[]{x, y}).colour)
            if (checkOnLongSequence(new int[]{x, y}) || checkOn3x3(new int[]{x, y}))
                return true;
        return false;
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

    public int checkOnFoul() {
        int[] buffer = Arrays.copyOf(lastStone, 2);
        while (getStone(step(buffer, "l")) != null) {
            buffer = step(buffer, "l");
        }
        return 0;
    }

    public boolean checkOnLongSequence(int[] coordinates) {
        int[] buffer = Arrays.copyOf(coordinates, 2);
        int count = 0;
        while (getStone(step(buffer, "l")) != null) {
            buffer = step(buffer, "l");
        }
        while (getStone(step(buffer, "r")) != null && getStone(coordinates) != null && getStone(step(buffer, "r")).colour == getStone(coordinates).colour) {
            buffer = step(buffer, "r");
            count++;
        }
        if (count > 4)
            return true;
        System.out.println("count " + count);
        count = 0;
        while (getStone(step(buffer, "t")) != null) {
            buffer = step(buffer, "t");
        }
        while (getStone(step(buffer, "b")) != null && getStone(coordinates) != null && getStone(step(buffer, "b")).colour == getStone(coordinates).colour) {
            buffer = step(buffer, "b");
            count++;
        }
        if (count > 4)
            return true;
        System.out.println("count " + count);
        count = 0;
        while (getStone(step(buffer, "lb")) != null) {
            buffer = step(buffer, "lb");
        }
        while (getStone(step(buffer, "rt")) != null && getStone(coordinates) != null && getStone(step(buffer, "rt")).colour == getStone(coordinates).colour) {
            buffer = step(buffer, "rt");
            count++;
        }
        if (count > 4)
            return true;
        System.out.println("count " + count);
        count = 0;
        while (getStone(step(buffer, "lt")) != null) {
            buffer = step(buffer, "lt");
        }
        while (getStone(step(buffer, "rb")) != null && getStone(coordinates) != null && getStone(step(buffer, "rb")).colour == getStone(coordinates).colour) {
            buffer = step(buffer, "rb");
            count++;
        }
        if (count > 4)
            return true;
        System.out.println("count " + count);
        return false;
    }

    public boolean checkOn3x3(int[] coordinates) {
        System.out.println("checkOn3x3");
        int[] buffer = Arrays.copyOf(coordinates, 2);
        int count = 0;
        int blockCount = 0;
        boolean firstFlag = false;
        boolean secondFlag = false;
        int rowCount = 0;
        while (getStone(step(buffer, "l")) != null) {
            buffer = step(buffer, "l");
        }
        if (getStone(step(buffer, "l")) != null && getStone(step(buffer, "l")).colour)
            firstFlag = true;
        while (getStone(step(buffer, "r")) != null && getStone(coordinates) != null && getStone(step(buffer, "r")).colour == getStone(coordinates).colour) {
            buffer = step(buffer, "r");
            count++;
        }
        if (getStone(step(buffer, "r")) != null && getStone(step(buffer, "r")).colour)
            secondFlag = true;
        if (count == 2) {
            rowCount++;
            if (firstFlag)
                blockCount++;
            if (secondFlag)
                blockCount++;
        }
        firstFlag = false;
        secondFlag = false;
        buffer = Arrays.copyOf(coordinates, 2);
        System.out.println("count " + count);
        count = 0;
        while (getStone(step(buffer, "t")) != null) {
            buffer = step(buffer, "t");
        }
        if (getStone(step(buffer, "t")) != null && getStone(step(buffer, "t")).colour)
            firstFlag = true;
        while (getStone(step(buffer, "b")) != null && getStone(coordinates) != null && getStone(step(buffer, "b")).colour == getStone(coordinates).colour) {
            buffer = step(buffer, "b");
            count++;
        }
        if (getStone(step(buffer, "b")) != null && getStone(step(buffer, "b")).colour)
            secondFlag = true;
        if (count == 2) {
            rowCount++;
            if (firstFlag)
                blockCount++;
            if (secondFlag)
                blockCount++;
        }
        firstFlag = false;
        secondFlag = false;
        buffer = Arrays.copyOf(coordinates, 2);
        System.out.println("count " + count);
        count = 0;
        while (getStone(step(buffer, "lb")) != null) {
            buffer = step(buffer, "lb");
        }
        if (getStone(step(buffer, "lb")) != null && getStone(step(buffer, "lb")).colour)
            firstFlag = true;
        while (getStone(step(buffer, "rt")) != null && getStone(coordinates) != null && getStone(step(buffer, "rt")).colour == getStone(coordinates).colour) {
            buffer = step(buffer, "rt");
            count++;
        }
        if (getStone(step(buffer, "rt")) != null && getStone(step(buffer, "rt")).colour)
            secondFlag = true;
        if (count == 2) {
            rowCount++;
            if (firstFlag)
                blockCount++;
            if (secondFlag)
                blockCount++;
        }
        firstFlag = false;
        secondFlag = false;
        buffer = Arrays.copyOf(coordinates, 2);
        System.out.println("count " + count);
        count = 0;
        while (getStone(step(buffer, "lt")) != null) {
            buffer = step(buffer, "lt");
        }
        if (getStone(step(buffer, "lt")) != null && getStone(step(buffer, "lt")).colour)
            firstFlag = true;
        while (getStone(step(buffer, "rb")) != null && getStone(coordinates) != null && getStone(step(buffer, "rb")).colour == getStone(coordinates).colour) {
            buffer = step(buffer, "rb");
            count++;
        }
        if (getStone(step(buffer, "rb")) != null && getStone(step(buffer, "rb")).colour)
            secondFlag = true;
        if (count == 2) {
            rowCount++;
            if (firstFlag)
                blockCount++;
            if (secondFlag)
                blockCount++;
        }
        System.out.println("count " + count);
        System.out.println(blockCount);
        System.out.println(rowCount);
        System.out.println(blockCount < 2 && rowCount > 1);
        return blockCount < 2 && rowCount > 1;
    }

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
}
