public class Slot {
    private int id;
    private StudentGroup group;
    private Subject subject;
    private Teacher teacher;
    private PeriodTime periodTime;
    private Room room;
    public Slot(int id, StudentGroup group, Subject subject){
        this.id = id;
        this.subject = subject;
        this.group = group;
    }
    public void setInstructor(Teacher teacher) { this.teacher = teacher; }
    public void setMeetingTime(PeriodTime meetingTime) { this.periodTime = meetingTime; }
    public void setRoom(Room room){ this.room = room; }
    public int getId() { return id; }
    public StudentGroup getDept() { return group; }
    public Subject getCourse() { return subject; }
    public Teacher getInstructor() { return teacher; }
    public PeriodTime getMeetingTime() { return periodTime; }
    public Room getRoom() { return room; }
    public String toString() {
        return "["+group.getName()+","+subject.getName()+","+room.getNumber()+","+teacher.getId()+","+periodTime.getId() +"]";
    }
}
