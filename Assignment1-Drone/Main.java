import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter dimensions for grid separated by space: ");
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println();
        List<List<Integer>> location= new ArrayList<>();
        int i = 1;
        while (i<=4){
            System.out.println("Enter location for "+ i+"st drone separated by space: ");
            int a = sc.nextInt();
            int b = sc.nextInt();
            if ((a>=m) || (b>=n) || (a<0) || (b<0) ){
                System.out.println("invalid location enter again");
                continue;
            }
            location.add(Arrays.asList(a,b));
            i++;

        }
        System.out.println(location);
        System.out.println("Enter the target location for drones");
        int a = sc.nextInt();
        int b = sc.nextInt();
        PathToTarget path = new PathToTarget();
        path.getPath(location,a,b);
    }
}