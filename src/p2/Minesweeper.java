package p2;

import java.util.Arrays;

public class Minesweeper {
    public static int[][] grid={{0,-1,0},{-1,0,-1},{0,0,0}};

    public static void main(String[] args){
        for (int x=0;x<grid.length;x++){
            for (int y=0;y<grid.length;y++) {
                if (grid[x][y]==0) {
                    int[][] coords = {{x - 1, y - 1}, {x - 1, y}, {x - 1, y + 1}, {x, y - 1}, {x, y + 1}, {x + 1, y - 1}, {x + 1, y}, {x + 1, y + 1}};
                    for (int z = 0; z < coords.length; z++) {
                        try{
                            if (grid[coords[z][0]][coords[z][1]] == -1) {
                                grid[x][y] += 1;
                            }
                        }catch (Exception e) {
                            continue;
                        }
                    }
                }
            }
        }

        for (int x=0;x<grid.length;x++){
            System.out.println(Arrays.toString(grid[x]));
        }
    }
}
