import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        List<Monster> lst = new ArrayList<>();
        List<Monster> childMonsters = new ArrayList<>();
        System.out.println("Enter no of monsters");
        int ct = sc.nextInt();
        for(int i=0;i<ct;i++){
            System.out.println("Creating Monster number:"+(i+1));
            lst.add(makeMonster(sc));
            if(lst.size()>1){
                for(int j=0;j<lst.size()-1;j++){
                    Monster baby = babyMonster(lst.get(j),lst.get(lst.size()-1));
                    childMonsters.add(baby);
                    baby.printAbalities();

                }
            }
        }
        System.out.println(childMonsters.size() +" Child monsters created");
    }

    static Monster makeMonster(Scanner sc){

        System.out.println("Enter name for Monster");
        String monsterName = sc.next();

        System.out.println("Enter eye color for Monster");
        String eyeColor = sc.next();

        System.out.println("Enter feather color for Monster:");
        String featherColor = sc.next();

        System.out.println("Enter magical abilities for Monster:");
        String magicalAbilities = sc.next();

        System.out.println("Enter size of Monster (1-10):");
        int size = sc.nextInt();

        System.out.println("Enter strength of monster (1-10):");
        int strength = sc.nextInt();

        System.out.println("Enter durability of monster (1-10):");
        int durability = sc.nextInt();

        System.out.println("Enter weakness of Monster:");
        String weakness = sc.next();

        System.out.println("Enter aggression level if monster (1-10):");
        int aggressionLevel = sc.nextInt();

        return new Monster(monsterName,eyeColor, featherColor, magicalAbilities, size, strength, durability, weakness, aggressionLevel);

    }

    public static Monster babyMonster(Monster m1,Monster m2) throws Exception{
        Field[] trails = Monster.class.getDeclaredFields();
        Random random = new Random();
        Monster baby = new Monster("","","","",0,0,0,"",0);
        for(Field trail:trails){
            if(random.nextBoolean()){
                trail.set(baby,trail.get(m1));
            }
            else {
                trail.set(baby,trail.get(m2));
            }
        }
        baby.monsterName ="baby "+ m1.monsterName.substring(0,m1.monsterName.length()/2) + m2.monsterName.substring(m2.monsterName.length()/2);
        return baby;
    }

}