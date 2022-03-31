import java.time.LocalDate;

public class Assignment implements Comparable<Assignment> {
    private final String name;
    private LocalDate dueDate;

    public Assignment(String name, LocalDate dueDate) {
        this.name = name;
        this.dueDate = dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int compareTo(Assignment o) {
        return this.dueDate.compareTo(o.getDueDate());
    }
}
