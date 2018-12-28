package Library;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class LoginVisit extends book{
    static ArrayList<book> Cart = new ArrayList<>();
    static File file = new File("users.txt");
    static Scanner scan = new Scanner(System.in);
    static book book = new book();
    private String username;
    private String password;

    public static void main(String[] args) {
        register();
    }
    public static void userCheck(){
        boolean check = false;
        try {
            System.out.println("Please enter your username");
            String username = scan.next();
            System.out.println("Please enter your password");
            String password = scan.next();
            BufferedReader br = new BufferedReader(new FileReader(file));
            String[] userArray;
            String[] infoArray = br.readLine().split("/");
            for (int i=0;i<infoArray.length;i++){
                userArray = infoArray[i].split("-");
                if (userArray[0].equals(username) && userArray[1].equals(password)){
                    System.out.println("Login Success");
                    check = true;
                    menu();
                }
                else
                {
                    System.out.println("There is no informations ");
                    System.out.println("Please enter again ");
                    register();
                }
            }
            if (!check){
                System.out.println("Wrong");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void register(){
        System.out.println("Please enter your username");
        String usersUsername = scan.next();
        System.out.println("Please enter your password");
        String usersPassword = scan.next();
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file,true));
            bw.write(usersUsername + "-" + usersPassword + "/");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        userCheck();
    }
    public static void viewLibrary(){
        book.getList();
    }
    public static void buyBook(){
        getList();
        System.out.println("Enter name what you wanna buy");
        String buyName = scan.next();
        for (book b:bList){
            if (b.getbName().equals(buyName)){
                Cart.add(b);
                System.out.println(b.getbName() + " is added your cart :))");
                menu();
            }
        }
        if (Cart.size() == 0){
            System.out.println("There is no book :(( ");
            menu();
        }
    }
    public static void menu(){
        System.out.println("*****************************");
        System.out.println(" 1 - View Library");
        System.out.println(" 2 - Buy book");
        System.out.println(" 3 - Finding Page");
        System.out.println(" 4 - Finding Author");
        System.out.println(" 5 - Finding Type");
        System.out.println(" 6 - Give star for us!");
        System.out.println(" 0 - EXIT");
        int selected = scan.nextInt();
        switch (selected){
            case 0:
                System.exit(0);
            case 1:
                viewLibrary();
            case 2:
                buyBook();
            case 3:
                extractingPage();
            case 4:
                extractingAuthor();
            case 5:
                extractingType();
            case 6:
                giveStar();
                default:
                    System.out.println("Wrong number");
                    menu();


        }
    }
    public static void extractingPage(){
        boolean findPage = false;
        System.out.println("Please enter your initial page");
        int initPage = scan.nextInt();
        System.out.println("Please enter your last page");
        int lastPage = scan.nextInt();
        for (book b:bList){
            if (b.getbPageNum()>initPage && b.getbPageNum()<lastPage){
                System.out.println(b.getbName());
                findPage = true;
                menu();
            }
        }
        if (!findPage){
            System.out.println("There is no book what you want");
            menu();
        }
    }
    public static void extractingAuthor(){
        boolean findAuthor = false;
        System.out.println("Please enter name of author what you want");
        String selectedAuthor = scan.next();
        for (book b:bList){
            if (b.getbAuthor().equals(selectedAuthor)){
                System.out.println("Name : " + b.getbName() + " Author : " + b.getbAuthor());
                findAuthor = true;
                menu();
            }
        }
        if (!findAuthor){
            System.out.println("There is no author in list");
            menu();
        }
    }
    public static void extractingType(){
        boolean findType = false;
        System.out.println("Please enter type of book what you want");
        String selectedType = scan.next();
        for (book b:bList){
            if (b.getbType().equals(selectedType)){
                System.out.println("Name : " + b.getbName() + " Type : " + b.getbType());
                findType = true;
                menu();
            }
        }
        if (!findType){
            System.out.println("There is no type in list");
            menu();
        }
    }
    public static void giveStar(){
        getList();
        System.out.println("Please select book if you wanna give star :))");
        String starName = scan.next();
        for (book b:bList){
            if (b.getbName().equals(starName)){
                System.out.println("Book's name : " + b.getbName());
                System.out.println("#########################");
                System.out.println("  * -> 1");
                System.out.println("  ** -> 2");
                System.out.println("  *** -> 3");
                System.out.println("  **** -> 4");
                System.out.println("  ***** -> 5");
                int star = scan.nextInt();
                switch (star){
                    case 1:
                        System.out.println("Thank you for one star :)");
                        try {
                            BufferedWriter bw2 = new BufferedWriter(new FileWriter("stars.txt"));
                            bw2.write(b.getbName() + " ->" + star);
                            bw2.newLine();
                            bw2.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        menu();
                    case 2:
                        System.out.println("Thank you for two stars :):)");
                        try {
                            BufferedWriter bw2 = new BufferedWriter(new FileWriter("stars.txt"));
                            bw2.write(b.getbName() + " ->" + star);
                            bw2.newLine();
                            bw2.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        menu();
                    case 3:
                        System.out.println("Thank you for threeee stars :):):)");
                        try {
                            BufferedWriter bw2 = new BufferedWriter(new FileWriter("stars.txt"));
                            bw2.write(b.getbName() + " ->" + star);
                            bw2.newLine();
                            bw2.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        menu();
                    case 4:
                        System.out.println("Thank you for fouurr stars :):):):)");
                        try {
                            BufferedWriter bw2 = new BufferedWriter(new FileWriter("stars.txt"));
                            bw2.write(b.getbName() + " ->" + star);
                            bw2.newLine();
                            bw2.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        menu();
                    case 5:
                        System.out.println("Thank you for fiiiveeeee stars :):):):):)");
                        try {
                            BufferedWriter bw2 = new BufferedWriter(new FileWriter("stars.txt"));
                            bw2.write(b.getbName() + " ->" + star);
                            bw2.newLine();
                            bw2.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        menu();
                    default:
                        System.out.println("Please enter 1-5 later");
                        menu();

                }
            }
        }

    }
}

