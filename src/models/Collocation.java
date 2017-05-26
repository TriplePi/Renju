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
        if(stones[x][y]!=null)
            return false;
        int[] coords = check(x, y);
        if (coords == null) {
            System.out.println(player + " is loser");
            return false;
        }
        actCount++;
        stones[x][y] = new Stone(player);
        lastStone = new int[2];
        lastStone[0] = x;
        lastStone[1] = y;
        if (getPlayer())
            whiteCount++;
        else blackCount++;
        inverPlayer();
        return true;
    }

    public int[] check(int x, int y) {
        System.out.println(actCount);
        System.out.print(Math.abs(x - 7) + " ");
        System.out.println(Math.abs(y - 7));
        if (actCount == 0 && (x != 7 || y != 7) && !getPlayer())
            return null;
        if (actCount == 1 && (Math.abs(x - 7) != 1 || Math.abs(y - 7) != 1) && getPlayer())
            return null;
        if (actCount == 2 && (Math.abs(x - 7) > 2 || Math.abs(y - 7) > 2) && !getPlayer())
            return null;

        return new int[]{x, y};
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

    public void inverPlayer() {
        this.player = !this.player;
    }

    public void skip() {
        if (getPlayer() && whiteCount >= 3)
            inverPlayer();
        else if (blackCount >= 3)
            inverPlayer();
    }

    public int checkOnFoul() {
        int[] buffer = Arrays.copyOf(lastStone,2);
        while (getStone(step(buffer, "l")) != null) {
            buffer = step(buffer, "l");
        }
        return 0;
    }

    public boolean checkOnLongSequence(int[] coordinates){
        int[] buffer = Arrays.copyOf(coordinates,2);
        int count = 0;
        while (getStone(step(buffer, "l")) != null) {
            buffer = step(buffer, "l");
        }
        while (getStone(step(buffer,"r")).colour == getStone(coordinates).colour) {
            buffer = step(buffer, "r");
            count++;
        }
        if(count>4)
            return true;
        count = 0;
        while (getStone(step(buffer, "t")) != null) {
            buffer = step(buffer, "t");
        }
        while (getStone(step(buffer,"b")).colour == getStone(coordinates).colour) {
            buffer = step(buffer, "b");
            count++;
        }
        if(count>4)
            return true;
        while (getStone(step(buffer, "lb")) != null) {
            buffer = step(buffer, "lb");
        }
        while (getStone(step(buffer,"rt")).colour == getStone(coordinates).colour) {
            buffer = step(buffer, "rt");
            count++;
        }
        if(count>4)
            return true;
        while (getStone(step(buffer, "lt")) != null) {
            buffer = step(buffer, "lt");
        }
        while (getStone(step(buffer,"rb")).colour == getStone(coordinates).colour) {
            buffer = step(buffer, "rb");
            count++;
        }
        if(count>4)
            return true;
        return false;
    }



    private Stone getStone(int[] coord) {
        return stones[coord[0]][coord[1]];
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
