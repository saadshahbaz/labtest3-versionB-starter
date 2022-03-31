import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAll {
    private Course c;
    private Student alice;
    private Student bob;

    @BeforeEach
    public void initEach() {
        c = new Course();
        alice = new Student("Alice");
        bob = new Student("Bob");
    }

    @Test
    void test_add_assignment() {
        c.addObserver(alice);
        c.addNewAssignment("A1", LocalDate.of(2022, 3, 1));
        assertEquals(1, alice.getAssignmentsToWorkOn().size());
        assertEquals(LocalDate.of(2022, 3, 1), c.getAssignments().get("A1").getDueDate());
    }

    @Test
    void test_remove_assignment() {
        c.addObserver(alice);
        c.addNewAssignment("A1", LocalDate.of(2022, 3, 1));
        c.addNewAssignment("Quiz 1", LocalDate.of(2022, 2, 1));
        c.cancelAssignment("Quiz 1");
        assertEquals(1, alice.getAssignmentsToWorkOn().size());
        assertEquals(1, c.getAssignments().size());
        assertEquals(LocalDate.of(2022, 3, 1), c.getAssignments().get("A1").getDueDate());

    }


    @Test
    void test_change_due_date() {
        c.addObserver(alice);
        c.addNewAssignment("A1", LocalDate.of(2022, 3, 1));
        c.changeDueDate("A1", LocalDate.of(2022, 3, 5));
        assertEquals(LocalDate.of(2022, 3, 5), alice.getAssignmentsToWorkOn().peek().getDueDate());
        assertEquals(LocalDate.of(2022, 3, 5), c.getAssignments().get("A1").getDueDate());
    }

    @Test
    void test_work_on_assignment() {
        c.addObserver(alice);
        c.addNewAssignment("A2", LocalDate.of(2022, 3, 1));
        c.addNewAssignment("A1", LocalDate.of(2022, 2, 1));

        alice.doAnAssignment();

        assertEquals(1, alice.getAssignmentsToWorkOn().size());
        assertEquals(LocalDate.of(2022, 3, 1), alice.getAssignmentsToWorkOn().peek().getDueDate());
        assertEquals(2, c.getAssignments().size());
    }

    @Test
    void test_multiple_students() {
        c.addObserver(alice);
        c.addObserver(bob);
        c.addNewAssignment("A1", LocalDate.of(2022, 3, 1));
        bob.doAnAssignment();
        assertEquals(1, alice.getAssignmentsToWorkOn().size());
        assertEquals(0, bob.getAssignmentsToWorkOn().size());
    }

    @Test
    void test_multiple_students_2() {
        c.addObserver(alice);
        c.addNewAssignment("A1", LocalDate.of(2022, 3, 1));
        c.addObserver(bob);
        assertEquals(1, alice.getAssignmentsToWorkOn().size());
        assertEquals(0, bob.getAssignmentsToWorkOn().size());
    }
}
