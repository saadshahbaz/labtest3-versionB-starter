import java.util.*;

public class Student implements AssignmentObserver {

    private String name;
    private Queue<Assignment> assignmentsToWorkOn;

    public Student(String name) {
        this.name = name;
        this.assignmentsToWorkOn = new PriorityQueue<>();
    }

    public Queue<Assignment> getAssignmentsToWorkOn() {
        return assignmentsToWorkOn;
    }

    public void doAnAssignment() {
        this.assignmentsToWorkOn.poll();
    }

}
