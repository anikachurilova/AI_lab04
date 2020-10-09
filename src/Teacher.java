import java.util.Objects;

public class Teacher {
    int id;
    String name;
    Pair subject;
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
    public Pair getSubject() {
        return subject;
    }
    public void setSubject(String subject, String typeTeacher) {
        this.subject = new Pair(subject,typeTeacher);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return id == teacher.id &&
                Objects.equals(name, teacher.name) &&
                Objects.equals(subject, teacher.subject);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject=" + subject +
                '}';
    }
}
