import java.util.*;

public class PCB_V1 {

    LinkedList<Process_V1> blocks;

    /**
     * create a child process of process p
     * If process p does not exist, return error message "No such parent process"
     * If this process control block is full, return "No space for new process"
     * Return null if the creation is successful
     * @param p the process index of parent process
     */
    PCB_V1(int size) {
        this.blocks = new LinkedList<>();
        this.blocks.addFirst(new Process_V1(-1, 0));
    }


    String create(int p) {
        if (p >= this.blocks.size()) {
            return "No space for new process";
        }
        Process_V1 parent = this.blocks.get(p);
        if (parent != null) {
            Process_V1 newProcess = new Process_V1(p, this.blocks.size());
            this.blocks.add(newProcess);
            parent.children.add(newProcess.id);
            return null;
        } else {
            return "No such parent process";
        }
    }

    /**
     * destroy the process control block at index p
     */
    void destroy(int p) {
        if (p < this.blocks.size()) {
            Process_V1 process = this.blocks.get(p);
            if (process != null) {
                for (int child : process.children) {
                    destroy(child);
                }
                this.blocks.remove(p);
            }
        }
    }
}
