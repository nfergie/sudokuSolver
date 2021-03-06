import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Column implements Runnable{
    private int [][] grid;
    private ArrayList<Location> errors;

    public Column(int [][] grid){
        this.grid = grid;
        errors = new ArrayList<>();
    }

    public ArrayList<Location> getErrors(){
        return errors;
    }

    public void run() {
        for(int j =0; j < 9; j++){
            System.out.println("Checking column " + (j+1));
            HashMap<Integer, ArrayList<Location>> locHash = new HashMap<>();
            for (int i = 0; i < 9; i++){
                if(locHash.containsKey(grid[i][j])){
                    ArrayList<Location> tList = locHash.get(grid[i][j]);
                    Location l = new Location(i, j);
                    tList.add(l);
                    locHash.put(grid[i][j], tList);
                }else{
                    ArrayList<Location> loc = new ArrayList<>();
                    loc.add(new Location(i, j));
                    locHash.put(grid[i][j], loc);
                }
            }
            for(ArrayList<Location> locs : locHash.values()){
                if(locs.size() >1 ){
                    errors.addAll(locs);
                }
            }
        }
    }
}
