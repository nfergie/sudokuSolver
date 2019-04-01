import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.*;

public class sudokuSolver {

    public static void main(String[] args){
        if(args.length > 0){
            try{
                //open and read file
                File f = new File(args[0]);
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));

                //information goes into a 2d array grid
                int[][] grid = new int[9][9];

                for(int i =0; i < 9; i++){
                    String line = reader.readLine();
                    int col = 0;
                    for(int j = 0; j< line.length(); j++){
                        char c = line.charAt(j);
                        if(c != ','){
                            grid[i][col] = Integer.parseInt(String.valueOf(c));
                            col++;
                        }
                    }
                }

                //start threads
                Column c = new Column(grid);
                Row r = new Row(grid);
                Square s = new Square(grid);
                Thread t1 = new Thread(c);
                Thread t2 = new Thread(r);
                Thread t3 = new Thread(s);
                t1.start();
                t2.start();
                t3.start();
                try{
                    t1.join();
                    t2.join();
                    t3.join();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                ArrayList<Location> l = s.getErrors();
                for(Location locs : l){
                    System.out.println(locs.col + ", " + locs.row);
                }

            }catch (IOException e){
                e.printStackTrace();
            }
        }else{
            System.out.println("System requires input file");
        }
    }
}
