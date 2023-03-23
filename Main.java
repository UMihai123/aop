import java.util.Scanner;
public class Main {
    public static void main(String args[]) {
        PrintOptions();
    }

    private static Controller _controller;

    static{
        Student.setCurrentId(0);
        Subject.setCurrentId(0);
        School.setCurrentId(0);
        Teacher.setCurrentId(0);
        ClassBookPage.setCurrentId(0);
        Class.setCurrentId(0);
        Location.setCurrentId(0);
    }

    public static void PrintOptions(){
        System.out.println("*********************");
        System.out.println("****   Welcome   ****");
        System.out.println("*********************\n");

        System.out.println("Type out what command you want to execute:");
        System.out.println("1. Create a school(CreateSchool).");
        System.out.println("2. Select which school you want to work with(SelectSchool).");
        System.out.println("3. Exit the application(Exit).");

        Scanner sc = new Scanner(System.in);

        String option;

        while(true){
            option = sc.nextLine();

            switch (option) {
                case "CreateSchool":
                    System.out.println("Test CreateSchool");
                    _controller.CreateSchool();
                    break;
                case "SelectSchool":
                    System.out.println("Test SelectSchool");
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
