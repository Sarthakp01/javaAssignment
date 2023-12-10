import java.util.*;

public class PathToTarget {

    public void getPath(List<List<Integer>> location,int a, int b){

        for (List<Integer> drone : location) {
            List<List<Integer>> arr = new ArrayList<>();
            int p =drone.get(0);
            int q = drone.get(1);
            arr.add(Arrays.asList(p,q));
            while (a != p) {
                if (p < a) {
                    p++;
                    arr.add(Arrays.asList(p, q));
                } else {
                    p--;
                    arr.add(Arrays.asList(p, q));
                }

            }
            while (b != q) {
                if (q<b) {
                    q++;
                    arr.add(Arrays.asList(p,q));
                } else {
                    q--;
                    arr.add(Arrays.asList(p,q));
                }

            }
            System.out.println("Path for drone at " + drone +" to ["+a+","+b+"]" +" is: " + arr);
        }
    }


}
