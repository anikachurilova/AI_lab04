import java.util.Arrays;
import java.util.Objects;

public class StudentGroup {
    public int id;
    public String name;
    public Pair<Subject, Integer>[] subjects;
    public int amountOfSubjects;

    public StudentGroup(int id, String name, int amountOfSubjects, Pair<Subject, Integer>[] subjects) {
        this.amountOfSubjects = amountOfSubjects;
        this.id = id;
        this.name = name;
        this.subjects = subjects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Pair<Subject, Integer>[] getSubjects() {
        return subjects;
    }

    public Pair<Subject, Integer> getSubject(int i) {
        return subjects[i];
    }

    public void setSubjects(Pair<Subject, Integer>[] subjects) {
        this.subjects = subjects;
    }

    public int getAmountOfSubjects() {
        return amountOfSubjects;
    }

    public void setAmountOfSubjects(int amountOfSubjects) {
        this.amountOfSubjects = amountOfSubjects;
    }

    @Override
    public String toString() {
        return "StudentGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subjects=" + Arrays.toString(subjects) +
                ", amountOfSubjects=" + amountOfSubjects +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentGroup that = (StudentGroup) o;
        return id == that.id &&
                amountOfSubjects == that.amountOfSubjects &&
                Objects.equals(name, that.name) &&
                Arrays.equals(subjects, that.subjects);
    }

}
