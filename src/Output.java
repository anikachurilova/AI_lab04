import java.util.ArrayList;

public class Output {
    public static final int POPULATION_SIZE = 9;
    public static final double MUTATION_RATE = 0.1;
    public static final double CROSSOVER_RATE = 0.9;
    public static final int TOURNAMENT_SELECTION_SIZE = 3;
    public static final int NUMB_OF_ELITE_SCHEDULES = 1;
    private int scheduleNumb = 0;
    private int classNumb = 1;
    private Input input;

    public static void main(String[] args) {
        Output output = new Output();
        output.input = new Input();
        int generationNumber = 0;
        output.printAvailableData();
        System.out.println("> Generation # "+generationNumber);
        System.out.print("  Schedule # |                                           ");
        System.out.print("Slots [group,subj,room,teacher,period-time]       ");
        System.out.println( "                                  | Fitness | Conflicts");
        System.out.print("-----------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(output.input);
        Population population = new Population(Output.POPULATION_SIZE, output.input).sortByFitness();
        population.getSchedules().forEach(schedule -> System.out.println("       "+output.scheduleNumb++ +
                "     | "+ schedule + " | " +
                String.format("%.5f",schedule.getFitness()) +
                " | "+schedule.getNumbOfConflicts()));
        output.printScheduleAsTable(population.getSchedules().get(0), generationNumber);
        output.classNumb = 1;
        while (population.getSchedules().get(0).getFitness() != 1.0) {
            System.out.println("> Generation # "+ ++generationNumber);
            System.out.print("  Schedule # |                                           ");
            System.out.print("Slots [group,subj,room,teacher,period-time]       ");
            System.out.println("                                  | Fitness | Conflicts");
            System.out.print("-----------------------------------------------------------------------------------");
            System.out.println("-------------------------------------------------------------------------------------");
            population = geneticAlgorithm.evolve(population).sortByFitness();
            output.scheduleNumb = 0;
            population.getSchedules().forEach(schedule -> System.out.println("       "+output.scheduleNumb++ +
                    "     | "+ schedule + " | " +
                    String.format("%.5f",schedule.getFitness()) +
                    " | "+schedule.getNumbOfConflicts()));
            output.printScheduleAsTable(population.getSchedules().get(0), generationNumber);
            output.classNumb = 1;
        }
    }

    private Slot getSlot(ArrayList<Slot> slots, PeriodTime time, StudentGroup group){
        for(int i = 0; i < slots.size(); i++){
            if(slots.get(i).getGroup() == group &&  slots.get(i).getPeriodTime() == time){
                return slots.get(i);
            }
        }
        return null;
    }

    private void printScheduleAsTable(Schedule schedule, int generation) {

        ArrayList<Slot> slots = schedule.getSlots();
        System.out.print("\n                       ");
        System.out.println("Class # | Dept | Course (number, max # of students) | Room (Capacity) |   Instructor (Id)   |  Meeting Time (Id)");
        System.out.print("                       ");
        System.out.print("------------------------------------------------------");
        System.out.println("---------------------------------------------------------------");



        for(int i = 0; i < input.getGroups().size(); i++){
            StudentGroup currGroup = input.getGroups().get(i);
            System.out.println("Day     | 10:00 - 11:00 | 11:00 - 12:00 | 12:00 - 13:00 | 13:00 - 14:00 | 14:00 - 15:00 | 15:00 - 16:00 ");
            System.out.println("MN      | " + getSlot(slots,input.getPeriodTimes().get(0),currGroup) +" | " + getSlot(slots,input.getPeriodTimes().get(1),currGroup) +" | " + getSlot(slots,input.getPeriodTimes().get(2),currGroup) +" | " + getSlot(slots,input.getPeriodTimes().get(3),currGroup) +" | " + getSlot(slots,input.getPeriodTimes().get(4),currGroup) +" | " + getSlot(slots,input.getPeriodTimes().get(5),currGroup));
            System.out.println("TU      | " + getSlot(slots,input.getPeriodTimes().get(6),currGroup) +" | " + getSlot(slots,input.getPeriodTimes().get(7),currGroup) +" | " + getSlot(slots,input.getPeriodTimes().get(8),currGroup) +" | " + getSlot(slots,input.getPeriodTimes().get(9),currGroup) +" | " + getSlot(slots,input.getPeriodTimes().get(10),currGroup) +" | " + getSlot(slots,input.getPeriodTimes().get(11),currGroup));
            System.out.println("WD      | " + getSlot(slots,input.getPeriodTimes().get(12),currGroup) +" | " + getSlot(slots,input.getPeriodTimes().get(13),currGroup) +" | " + getSlot(slots,input.getPeriodTimes().get(14),currGroup) +" | " + getSlot(slots,input.getPeriodTimes().get(15),currGroup) +" | " + getSlot(slots,input.getPeriodTimes().get(16),currGroup) +" | " + getSlot(slots,input.getPeriodTimes().get(17),currGroup));
            System.out.println("TH      | " + getSlot(slots,input.getPeriodTimes().get(18),currGroup) +" | " + getSlot(slots,input.getPeriodTimes().get(19),currGroup) +" | " + getSlot(slots,input.getPeriodTimes().get(20),currGroup) +" | " + getSlot(slots,input.getPeriodTimes().get(21),currGroup) +" | " + getSlot(slots,input.getPeriodTimes().get(22),currGroup) +" | " + getSlot(slots,input.getPeriodTimes().get(23),currGroup));
            System.out.println("FR      | " + getSlot(slots,input.getPeriodTimes().get(24),currGroup) +" | " + getSlot(slots,input.getPeriodTimes().get(25),currGroup) +" | " + getSlot(slots,input.getPeriodTimes().get(26),currGroup) +" | " + getSlot(slots,input.getPeriodTimes().get(27),currGroup) +" | " + getSlot(slots,input.getPeriodTimes().get(28),currGroup) +" | " + getSlot(slots,input.getPeriodTimes().get(29),currGroup));

            System.out.print("------------------------------------------------------");
            System.out.println("---------------------------------------------------------------");
        }


//        classes.forEach(x -> {
//            int majorIndex = data.getDepts().indexOf(x.getDept());
//            int coursesIndex = data.getCourses().indexOf(x.getCourse());
//            int roomsIndex = data.getRooms().indexOf(x.getRoom());
//            int instructorsIndex = data.getInstructors().indexOf(x.getInstructor());
//            int meetingTimeIndex = data.getMeetingTimes().indexOf(x.getMeetingTime());
//            System.out.print("                       ");
//            System.out.print(String.format("  %1$02d  ", classNumb) + "  | ");
//            System.out.print(String.format("%1$4s", data.getDepts().get(majorIndex).getName()) + " | ");
//            System.out.print(String.format("%1$21s", data.getCourses().get(coursesIndex).getName() +
//                    " ("+data.getCourses().get(coursesIndex).getNumber()+", "+
//                    x.getCourse().getMaxNumbOfStudents())+")             | ");
//            System.out.print(String.format("%1$10s", data.getRooms().get(roomsIndex).getNumber() +
//                    " ("+x.getRoom().getSeatingCapacity()) + ")     | ");
//            System.out.print(String.format("%1$15s", data.getInstructors().get(instructorsIndex).getName()+
//                    " ("+data.getInstructors().get(instructorsIndex).getId()+")") + "  | ");
//            System.out.println(data.getMeetingTimes().get(meetingTimeIndex).getTime()+
//                    " ("+data.getMeetingTimes().get(meetingTimeIndex).getId()+")");
//            classNumb++;
//        });
        if (schedule.getFitness() == 1) System.out.println("> Solution Found in "+ (generation + 1) +" generations");
        System.out.print("-----------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
    }
    private void printAvailableData() {
        System.out.println("Available Student Groups ==>");
        input.getGroups().forEach(x->System.out.println("name: "+x.getName()+", courses: "+x.getSubjects()));
        System.out.println("\nAvailable Subjects ==>");
        input.getSubjects().forEach(x->System.out.println("course #: "+x.getId()+", name: "+x.getName()+", type: "
                + x.getType()+", teachers: "+ x.getTeacher()));
        System.out.println("\nAvailable Rooms ==>");
        input.getRooms().forEach(x->System.out.println("room #: "+x.getNumber()+", capacity: "+x.getCapacity()));
        System.out.println("\nAvailable Teachers ==>");
        input.getTeachers().forEach(x->System.out.println("id: "+x.getId()+", name: "+x.getName()));
        System.out.println("\nAvailable Period Times ==>");
        input.getPeriodTimes().forEach(x->System.out.println("id: "+x.getId()+", Period Time: "+x.getTime()));
        System.out.print("-----------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
    }
}
