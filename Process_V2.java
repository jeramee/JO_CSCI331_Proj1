public class Process_V2 {

    // Declaring Hierarchy
    int parent;
    Integer first_child = null;
    Integer younger_sibling = null;
    Integer older_sibling = null;
    int id;

    // This process creation uses a hierarchical structure
    Process_V2(int parent, int id) {
        this.parent = parent;
        this.id = id;
    }
}
