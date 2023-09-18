import java.util.*;

public class Process_V1 {

    // Declaring parent
    int parent;

    // Declaring array list
    ArrayList<Integer> children = new ArrayList<>();
    int id;

    // This process uses an array list.
    Process_V1(int parent, int id) {
        this.parent = parent;
        this.id = id;
    }
}