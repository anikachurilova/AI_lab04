import java.util.Arrays;
import java.util.Objects;

public class Subject {
    int id;
    String name;
    Teacher teacherLecture;
    Teacher[] teacherPractice;

    public Subject(int id, String name, Teacher teacherLecture, Teacher[] teacherPractice) {
        this.id = id;
        this.name = name;
        this.teacherLecture = teacherLecture;
        this.teacherPractice = teacherPractice;
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

    public Teacher getTeacherLecture() {
        return teacherLecture;
    }

    public void setTeacherLecture(Teacher teacherLecture) {
        this.teacherLecture = teacherLecture;
    }

    public Teacher[] getTeacherPractice() {
        return teacherPractice;
    }

    public void setTeacherPractice(Teacher[] teacherPractice) {
        this.teacherPractice = teacherPractice;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacherLecture=" + teacherLecture +
                ", teacherPractice=" + Arrays.toString(teacherPractice) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return id == subject.id &&
                Objects.equals(name, subject.name) &&
                Objects.equals(teacherLecture, subject.teacherLecture) &&
                Arrays.equals(teacherPractice, subject.teacherPractice);
    }


}
