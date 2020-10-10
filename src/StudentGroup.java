import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class StudentGroup {
    public String name;
    public ArrayList<Pair<Subject, Integer>> subjects;

    public StudentGroup(String name, ArrayList<Pair<Subject, Integer>> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Pair<Subject, Integer>> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Pair<Subject, Integer>> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "StudentGroup{" +
                "name='" + name + '\'' +
                ", subjects=" + subjects +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentGroup that = (StudentGroup) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(subjects, that.subjects);
    }

}
