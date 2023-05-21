package view;

import dbConnection.DbConnection;
import models.*;
import models.ClassRoom;
import service.Controller;

import java.sql.Connection;
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
        ClassRoom.setCurrentId(0);
        Location.setCurrentId(0);
    }

    private static void PrintInitialOptions(){
        System.out.println("*********************");
        System.out.println("****   Welcome   ****");
        System.out.println("*********************\n");

        while(true){
            System.out.println("Type out what command you want to execute:");
            System.out.println("1. Select which school you want to visit(SelectSchool).");
            System.out.println("2. Add a new school(AddSchool).");
            System.out.println("3. Exit the application(Exit).");

            option = sc.nextLine();

            switch (option) {
                case "2":
                case "AddSchool":
                    _controller.CreateSchool();
                    break;
                case "1":
                case "SelectSchool":
                    _controller.ShowSchools();
                    System.out.println("Enter the number of the school you want.");
                    int op;
                    op = sc.nextInt();
                    sc.nextLine();
                    if(op > _controller.GetNrOfSchools() || op < 0)
                        System.out.println("There is no school with that number.");
                    else
                        PrintEnterSchool(op);
                    break;
                case "3":
                case "Exit":
                    System.exit(0);
                    break;
                default:
                    System.out.println("This option doesn't exist, please enter a correct option.\n");
            }
        }
    }

    private static void PrintEnterSchool(int schoolId) {
        while (true) {
            System.out.println("1. See all calsses(SeeClasses).");
            System.out.println("2. Add a new class(AddClass).");
            System.out.println("3. See all subjects(SeeSubjects).");
            System.out.println("4. Add a new subject(AddSubject)");
            System.out.println("5. Go back(Return)");

            option = sc.nextLine();

            switch (option) {
                case "1":
                case "SeeClasses":
                    _controller.ShowClasses(schoolId);
                    System.out.println("Enter which class you want to see.");
                    int op;
                    op = sc.nextInt();
                    sc.nextLine();
                    if(op > _controller.GetNrOfClasses() || op < 0)
                        System.out.println("There is no class with that number.");
                    else
                        PrintShowClasses(op);
                    break;
                case "2":
                case "AddClass":
                    _controller.CreateClass(schoolId);
                    break;
                case "3":
                case "SeeSubjects":
                    _controller.ShowSubjects(schoolId);
                    System.out.println("Enter which subject you want to see.");
                    int op1;
                    op1 = sc.nextInt();
                    sc.nextLine();
                    if(op1 > _controller.GetNrOfSubjects() || op1 < 0)
                        System.out.println("There is no subject with that number.");
                    else
                        PrintShowSubject(op1);
                    break;
                case "4":
                case "AddSubject":
                    _controller.CreateSubject(schoolId);
                    break;
                case "5":
                case "Return":
                    return;
                default:
                    System.out.println("This option doesn't exist, please enter a correct option.\n");
            }
        }
    }
    private static void PrintShowClasses(int classId){
        while(true){
            System.out.println("Type out what command you want to execute:");
            System.out.println("1. Show all students(ShowStudents).");
            System.out.println("2. Add a new student(AddStudent).");
            System.out.println("3. Go back(Return)");

            option = sc.nextLine();

            switch (option) {
                case "2":
                case "AddStudent":
                    _controller.CreateStudent(classId);
                    break;
                case "1":
                case "ShowStudent":
                    _controller.ShowStudents(classId);
                    System.out.println("Enter the number of the student you want.");
                    int op;
                    op = sc.nextInt();
                    sc.nextLine();
                    if(op > _controller.GetNrOfStudents() || op < 0)
                        System.out.println("There is no student with that number.");
                    else
                        PrintSeeClassBookPage(op);
                    break;
                case "3":
                case "Return":
                    return;
                default:
                    System.out.println("This option doesn't exist, please enter a correct option.\n");
            }
        }
    }

    private static void PrintShowSubject(int subjectId){
        while(true) {
            System.out.println("Type out what command you want to execute:");
            System.out.println("1. Show all teachers(ShowTeachers).");
            System.out.println("2. Add a new teacher(AddTeacher).");
            System.out.println("3. Go back(Return)");

            option = sc.nextLine();

            switch (option) {
                case "2":
                case "AddTeacher":
                    _controller.CreateTeachers(subjectId);
                    break;
                case "1":
                case "ShowTeachers":
                    _controller.ShowTeachers(subjectId);
                    break;
                case "3":
                case "Return":
                    return;
                default:
                    System.out.println("This option doesn't exist, please enter a correct option.\n");
            }
        }
    }

    private static void PrintSeeClassBookPage(int studentId){
        _controller.ShowClassBookPages(studentId);
    }
}
