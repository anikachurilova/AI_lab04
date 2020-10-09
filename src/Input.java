import java.io.File;
import java.util.Scanner;

public class Input {

  //  public static StudentGroup[] studentgroup;
   // public static Teacher[] teacher;
    public static double crossoverrate = 1.0, mutationrate = 0.1;
    public static int nostudentgroup, noteacher;
    public static int hoursperday, daysperweek;

    public Input() {
     //   studentgroup = new StudentGroup[100];
      //  teacher =   new Teacher[100];
    }

public static void main(String[] args){
        takeinput();
}


    public static void takeinput()// takes input from file input.txt
    {
     try {
         File file = new File("input.txt");
         Scanner scanner = new Scanner(file);

         while (scanner.hasNextLine()){
             String line = scanner.nextLine();

             if(line.equalsIgnoreCase("daysPerWeek")){

             }
         }
//        try {
//            File file = new File("c:\\test\\input.txt");
//            // File file = new File(System.getProperty("user.dir") +
//            // "/input.txt");
//
//            Scanner scanner = new Scanner(file);
//
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//
//                // input student groups
//                if (line.equalsIgnoreCase("studentgroups")) {
//                    int i = 0, j;
//                    while (!(line = scanner.nextLine()).equalsIgnoreCase("teachers")) {
//                        studentgroup[i] = new StudentGroup();
//                        StringTokenizer st = new StringTokenizer(line, " ");
//                        studentgroup[i].id = i;
//                        studentgroup[i].name = st.nextToken();
//                        studentgroup[i].nosubject = 0;
//                        j = 0;
//                        while (st.hasMoreTokens()) {
//                            studentgroup[i].subject[j] = st.nextToken();
//                            studentgroup[i].hours[j++] = Integer.parseInt(st.nextToken());
//                            studentgroup[i].nosubject++;
//                        }
//                        i++;
//                    }
//                    nostudentgroup = i;
//                }
//
//                //input teachers
//                if (line.equalsIgnoreCase("teachers")) {
//                    int i = 0;
//                    while (!(line = scanner.nextLine()).equalsIgnoreCase("end")) {
//                        teacher[i] = new Teacher();
//                        StringTokenizer st = new StringTokenizer(line, " ");
//                        teacher[i].id = i;
//                        teacher[i].name = st.nextToken();
//                        teacher[i].subject = st.nextToken();
//
//                        i++;
//                    }
//                    noteacher = i;
//                }
//
//            }
//            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

     //   assignTeacher();

    }
}
