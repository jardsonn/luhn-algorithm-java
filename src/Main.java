
public class Main {
    public static void main(String[] args) {

        LuhnAlgorithm luhnAlgorithm = new LuhnAlgorithm("45879632154");
        System.out.println(luhnAlgorithm.isValid());
    }

}
