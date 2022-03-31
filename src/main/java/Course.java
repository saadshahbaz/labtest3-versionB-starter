import java.time.LocalDate;
import java.util.Map;

public class Course {

    private Map<String, Assignment> assignments;

    public void addNewAssignment(String name, LocalDate dueDate) {

    }


    public void changeDueDate(String name, LocalDate newDueDate) {

    }

    public void cancelAssignment(String name){

    }

    public void addObserver(AssignmentObserver observer) {

    }

    public Map<String, Assignment> getAssignments() {
        // for simplicity, don't worry about leaking refereces here:)
        return assignments;
    }
}
