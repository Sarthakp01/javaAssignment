public class Monster {
    String monsterName;
    String eyeColor;
    String featherColor;
    String magicalAbilities;
    int size;
    int strength;
    int durability;
    String weakness;
    int aggressionLevel;

    public Monster(String monsterName,String eyeColor, String featherColor, String magicalAbilities, int size, int strength, int durability, String weakness, int aggressionLevel) {
        this.monsterName = monsterName;
        this.eyeColor = eyeColor;
        this.featherColor = featherColor;
        this.magicalAbilities = magicalAbilities;
        this.size = size;
        this.strength = strength;
        this.durability = durability;
        this.weakness = weakness;
        this.aggressionLevel = aggressionLevel;
    }

    public void printAbalities(){
        System.out.println("Monster name: "+ monsterName);
        System.out.println("Eye color: " +eyeColor);
        System.out.println("feather Color: "+featherColor);
        System.out.println("magical Abilities: " +magicalAbilities);
        System.out.println("size: " + size);
        System.out.println("strength: "+strength);
        System.out.println("durability: "+durability);
        System.out.println("weakness: "+weakness);
        System.out.println("aggression Level: "+aggressionLevel);
        System.out.println();
        System.out.println();
        System.out.println();
    }

}
