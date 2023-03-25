import java.util.Scanner;
public class Main {
    public static void main(String args[]) {
        PrintInitialOptions();
    }

    private static Controller _controller = new Controller();
    private static Scanner sc = new Scanner(System.in);
    private static String option;

    static{
        Student.setCurrentId(0);
        Subject.setCurrentId(0);
        School.setCurrentId(0);
        Teacher.setCurrentId(0);
        ClassBookPage.setCurrentId(0);
        Class.setCurrentId(0);
        Location.setCurrentId(0);
    }

    private static void PrintInitialOptions(){
        System.out.println("*********************");
        System.out.println("****   Welcome   ****");
        System.out.println("*********************\n");

        while(true){
            System.out.println("Type out what command you want to execute:");
            System.out.println("1. Select which school you want see(SelectSchool).");
            System.out.println("2. Add a new school(AddSchool).");
            System.out.println("3. Exit the application(Exit).");

            option = sc.nextLine();

            switch (option) {
                case "AddSchool":
                    _controller.CreateSchool();
                    break;
                case "SelectSchool":
                    _controller.ShowSchools();
                    break;
                case "Exit":
                    System.exit(0);
                    break;
                default:
                    System.out.println("This option doesn't exist, please enter a correct option.\n");
            }
        }
    }

    private static void PrintEnterSchool(){
        while(true){
            System.out.println("1. See all calsses(SeeClasses).");
            System.out.println("1. Add a new class(AddClass).");
            System.out.println("1. See all subjects(SeeSubjects).");
            System.out.println("4. Add a new subject(AddSubject)");

            option = sc.nextLine();

            switch (option) {
                case "SeeClasses":
                    _controller.CreateSchool();
                    break;
                case "SelectSchool":
                    _controller.ShowSchools();
                    break;
                case "Exit":
                    System.exit(0);
                    break;
                default:
                    System.out.println("This option doesn't exist, please enter a correct option.\n");
            }
        }
    }
}
