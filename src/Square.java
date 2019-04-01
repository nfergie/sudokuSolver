import java.util.ArrayList;
import java.util.HashMap;

public class Square implements Runnable{
    private int [][] grid;
    private ArrayList<Location> errors;

    public Square(int [][] grid){
        this.grid = grid;
        errors = new ArrayList<>();
    }

    public ArrayList<Location> getErrors(){
        return errors;
    }

    public void run() {
        for(int n= 0; n< 3; n++){
            for(int m =0; m < 3; m++){
                HashMap<Integer, ArrayList<Location>> locHash = new HashMap<>();
                for (int i = 0; i < 3; i++){
                    int ni = 3* m + i;
                    for(int j = 0; j < 3; j++){
                        int nj = 3*n + j;
                        if(locHash.containsKey(grid[ni][nj])){
                            ArrayList<Location> tList = locHash.get(grid[ni][nj]);
                            Location l = new Location(ni, nj);
                            tList.add(l);
                            locHash.put(grid[ni][nj], tList);
                        }else{
                            ArrayList<Location> loc = new ArrayList<>();
                            loc.add(new Location(ni, nj));
                            locHash.put(grid[ni][nj], loc);
                        }
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
}
