package Week_03;

public class Recursion {
    private final int MAX_LEVEL = 0;

    public static void main(String[] args) {

    }

    public void recursion(int level, int param){
        // terminator
        if (level > MAX_LEVEL) {
            // process result
            return;
        }

        // process current logic
        process(level, param);

        // drill down
        int newParam = param + 1;//example
        recursion(level + 1, newParam);

        // restore current status
    }

    private void process(int level, int param) {
    }

}
