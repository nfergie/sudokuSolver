import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.*;

public class sudokuSolver {

    public static void main(String[] args){
        if(args.length > 0){
            try{
                File f = new File(args[0]);
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));

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

            }catch (IOException e){
                e.printStackTrace();
            }
        }else{
            System.out.println("System requires input file");
        }
    }
}
