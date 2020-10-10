
import java.util.ArrayList;

public class Schedule {
    private ArrayList<Slot> slots;
    private boolean isFitnessChanged = true;
    private double fitness = -1;
    private int classNumb = 0;
    private int numbOfConflicts = 0;
    private Input input;
    public Input getInput() { return input; }
    public Schedule(Input data) {
        this.input = input;
        slots = new ArrayList<Slot>(input.getNumberOfClasses());
    }
    public Schedule initialize() {

        ArrayList<StudentGroup> allGroups = input.getGroups();
        for(int i = 0; i< allGroups.size(); i++){
            StudentGroup group = allGroups.get(i);
            for(int j = 0; j < group.getSubjects().size(); j++){
                Subject subject = group.getSubjects().get(j);
                for(int k = 0; k < subject.getTeacher().size(); k++){
                    Teacher teacher = subject.getTeacher().get(k);
                    Slot slot = new Slot(classNumb++, group, subject, teacher);
                    slot.setPeriodTime(input.getPeriodTimes().get((int)(input.getPeriodTimes().size()* Math.random())));
                    slot.setRoom(input.getRooms().get((int) (input.getRooms().size() * Math.random())));
                    slots.add(slot);
                }
            }
        }
//        new ArrayList<StudentGroup>(data.getDepts()).forEach(group -> {
//            group.getCourses().forEach(course -> {
//                Slot newSlot = new Slot(classNumb++, group, course, teacher);
//                newSlot.setPeriodTime(data.getMeetingTimes().get((int) (data.getMeetingTimes().size() * Math.random())));
//
//                newSlot.setRoom(data.getRooms().get((int) (data.getRooms().size() * Math.random())));
//                newSlot.setTeacher(course.getInstructors().get((int)(course.getTeacher().size() * Math.random())));
//                slots.add(newSlot);
//            });
//        });
        return this;
    }
    public int getNumbOfConflicts() { return numbOfConflicts; }
    public ArrayList<Slot> getSlots() {
        isFitnessChanged = true;
        return slots;
    }
    public double getFitness() {
        if (isFitnessChanged == true) {
            fitness = calculateFitness();
            isFitnessChanged = false;
        }
        return fitness;
    }
    private double calculateFitness() {
        numbOfConflicts = 0;
        slots.forEach(x -> {
            if ((x.getRoom().getCapacity() < 40) && (x.getSubject().getType().equals("L"))) numbOfConflicts++;
            slots.stream().filter(y -> slots.indexOf(y) >= slots.indexOf(x)).forEach(y -> {
                if (x.getPeriodTime() == y.getPeriodTime() && x.getId() != y.getId()) {
                    if (x.getRoom() == y.getRoom()) numbOfConflicts++;
                    if (x.getTeacher() == y.getTeacher()) numbOfConflicts++;
                }
            });
        });
        return 1/(double)(numbOfConflicts + 1);
    }
    public String toString() {
        String returnValue = new String();
        for (int x = 0; x < slots.size()-1; x++) returnValue += slots.get(x) + ",";
        returnValue += slots.get(slots.size()-1);
        return returnValue;
    }
}
