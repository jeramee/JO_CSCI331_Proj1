public class PCB_V2 {

    int size;
    Process_V2[] blocks;

    PCB_V2(int size) {
        this.size = size;
        this.blocks = new Process_V2[size];
        this.blocks[0] = new Process_V2(-1, 0);
    }

    /**
     * create a child process of process p
     * If process p does not exist, return error message "No such parent process"
     * If this process control block is full, return "No space for new process"
     * Return null if the creation is successful
     * @param p the process index of parent process
     */
    String create(int p) {
        if (this.blocks[p] == null) {
            return "No such parent process";
        }
        for (int i = 0; i < size; i++) {
            if (this.blocks[i] == null) {
                this.blocks[i] = new Process_V2(p, i);
                if (this.blocks[p].first_child == null) {
                    this.blocks[p].first_child = i;
                } else {
                    int child = this.blocks[p].first_child;
                    while (this.blocks[child].younger_sibling != null) {
                        child = this.blocks[child].younger_sibling;
                    }
                    this.blocks[child].younger_sibling = i;
                    this.blocks[i].older_sibling = child;
                }
                return null;
            }
        }
        return "No space for new process";
    }

    /**
     * destroy the process control block at index p
     */
    void destroy(int p) {
        if (this.blocks[p] != null) {
            Integer child = this.blocks[p].first_child;
            while (child != null) {
                Integer younger_sibling = this.blocks[child] != null ? this.blocks[child].younger_sibling : null;
                destroy(child);
                this.blocks[child] = null;
                child = younger_sibling;
            }
            this.blocks[p] = null;
        }
    }
}
