/**
 * classBuilder.java
 * @author Uriel Garcia
 * @author Andrew Nowinski
 * @author Alan Yee
 * @author Maninderjit Singh
 * CIS 22C
 */

import java.util.*;

import java.io.*;

public class CourseBuilder {

    public static void main(String[] args) throws FileNotFoundException {

        Hash<Classes> t = new Hash<Classes>(25);

        BST<Classes> tree = new BST<Classes>();

        BST<Classes> tree2 = new BST<Classes>();

        Scanner input = new Scanner(System.in);

        File text;

        String fileName;

        Scanner readIn;

        File outfile = new File("Print.txt");

        PrintWriter write = new PrintWriter(outfile);

        boolean cont = true;

        boolean subCont = true;

        System.out.println("Welcome to the Class Builder!");

        while(cont) {

            try {

                System.out.print("\nPlease enter a file name: ");

                fileName = input.next();

                text = new File(fileName);

                readIn = new Scanner(text);

                readFile(readIn, t, tree, tree2);

                System.out.println();

                while(subCont) {

                    System.out.print("***MENU*** "
                            + "\nSelect \"A\" to add data"
                            + "\nSelect \"D\" to delete data"
                            + "\nSelect \"S\" to search for data"
                            + "\nSelect \"L\" to list out the data"
                            + "\nSelect \"W\" to write out to a file"
                            + "\nSelect \"X\" to quit"
                            + "\n\nPlease enter your choice: ");

                    //CHOICE FOR SUBMENU
                    String choice = input.next();

                    //CHOICE TO EXIT
                    if(choice.equalsIgnoreCase("X")) {

                        cont = false;

                        subCont = false;

                        //CHOICE TO LIST
                    } else if(choice.equalsIgnoreCase("L")) {

                        boolean deci = true;

                        System.out.println("\nWould you like to sort the data by"
                                + "\n1. Unsorted"
                                + "\n2. Sorted by CRN"
                                + "\n3. Sorted by Rating");

                        System.out.print("\nPlease enter your choice: ");

                        while(deci) {

                            //CHOICE FOR L CHOICE
                            String lChoice = input.next();

                            if(lChoice.equalsIgnoreCase("1")) {

                                //PRINTED USING HASH TABLE
                                System.out.println("\nPrinting unsorted data...");
                                System.out.println();

                                //t.printTable();

                                t.print4Project();

                                deci = false;

                            } else if(lChoice.equalsIgnoreCase("2")) {

                                //PRINTED USING KEY 1
                                System.out.println("\nPrinting data sorted by CRN...");
                                System.out.println();

                                tree.inOrderPrint();

                                deci = false;

                            } else if(lChoice.equalsIgnoreCase("3")){       // NOT DONE

                                //PRINTED USING SECOND KEY
                                tree2.inOrderPrint();
                                deci = false;

                            } else {

                                System.out.print("\nInvalid choice. Please enter a valid choice: ");


                            }

                        }

                        //CHOICE TO WRITE OUT TO A FILE
                    } else if(choice.equalsIgnoreCase("W")) {

                        boolean deci2 = true;

                        System.out.println("\nHow would you liked the printed data to be sorted?"
                                + "\n1. Sorted by CRN"
                                + "\n2. Sorted by rating");
                        System.out.print("\nPlease enter your choice: ");
                        while(deci2) {

                            //CHOICE FOR L CHOICE
                            String lChoice2 = input.next();

                            if(lChoice2.equalsIgnoreCase("1")) {
                                System.out.println("\nPrinting data sorted by CRN...");
                                System.out.println();
                                write.print(tree.inOrderToString());
                                deci2 = false;
                            } else if(lChoice2.equalsIgnoreCase("2")) {
                                System.out.println("\nPrinting data sorted by rating...");
                                System.out.println();
                                write.print(tree2.inOrderToString());
                                deci2 = false;
                            } else {

                                System.out.print("\nInvalid choice. Please enter a valid choice: ");


                            }
                        }

                        //CHOICE TO ADD DATA
                    } else if(choice.equalsIgnoreCase("A")) {

                        String CRN, subject, course, time = "", prof, START, END = " ";

                        String days;

                        boolean momentOf, task = true;

                        double credit, rating;

                        System.out.print("\nEnter the CRN of the class: ");

                        CRN = input.next();

                        System.out.println(""); // new line

                        System.out.print("Enter the amount of credit: ");

                        credit = input.nextDouble();

                        System.out.println(""); // new line

                        System.out.print("Enter the subject: ");

                        subject = input.next();

                        System.out.println(""); // new line

                        input.nextLine();

                        System.out.print("Enter the course: ");

                        course = input.next();

                        System.out.println(""); // new line

                        input.nextLine();
                        System.out.print("Enter the days (MTWTHF): ");

                        days = input.nextLine();

                        System.out.println(""); // new line

                        System.out.print("Enter the start time with am/pm: ");
                        START = input.next();

                        momentOf = checkTime(START);

                        while(momentOf == false) {

                            System.out.println(""); // new line
                            System.out.print("Enter the start time with am/pm again: ");
                            START = input.next();
                            momentOf = checkTime(START);
                        }

                        System.out.println(""); // new line

                        System.out.print("Enter the end time with am/pm: ");

                        END = input.next();

                        momentOf = checkTime(END);

                        while(momentOf == false) {
                            System.out.println(""); // new line
                            System.out.print("Enter the end time with am/pm again: ");

                            END = input.next();

                            momentOf = checkTime(END);
                        }

                        time +=  START + "-" + END;

                        System.out.println(""); // new line;

                        input.nextLine();
                        System.out.print("Enter the name of the Professor: ");

                        prof = input.nextLine();

                        System.out.println(""); // new line

                        System.out.print("Enter the rating: ");

                        while (!input.hasNextDouble()) {

                            System.out.println("\n");

                            System.out.println("Error! Please enter a decimal not text!");

                            input.nextLine();

                            System.out.print("Enter the rating: ");

                            input.nextLine();

                        }

                        rating = input.nextDouble();

                        Classes newSchedule = new Classes(CRN, credit, subject, course, days, time, prof, rating);

                        t.insert(newSchedule);
                        tree.insert(newSchedule);
                        tree2.insert2(newSchedule);


                        //CHOICE TO DELETE DATA
                    } else if(choice.equalsIgnoreCase("D")) {

                        boolean search = true;

                        while(search) {

                            System.out.print("\nEnter the CRN of the class you would like to delete: ");

                            String delete = input.next();

                            Classes classes = new Classes();

                            classes.setCRN(delete);

                            boolean look = t.search(classes);

                            if(look) {

                                t.remove(classes);

                                tree.remove(classes);

                                tree2.remove(classes);

                                search = false;

                                System.out.println();

                            } else {

                                System.out.println("\nCRN is not found.");

                            }

                        }


                        //CHOICE TO SEARCH FOR DATA
                    } else if(choice.equalsIgnoreCase("S")) {
                        boolean trap = true;

                        while(trap){

                            System.out.print("\nDo you want to search by CRN or by Rating: ");

                            String decc = input.next();

                            if (decc.equalsIgnoreCase("CRN")) {

                                Search(t);

                                trap = false;

                            } else if (decc.equalsIgnoreCase("RATING")) {

                                //Search Using Second Key

                                Search2(tree2);

                                trap = false;

                            } else {

                                System.out.println("\nInvalid option. Please enter a valid option");

                            }

                        }

                    } else {

                        System.out.println("\nNot a valid option, please try again.\n");
                    }

                }

            } catch(FileNotFoundException e){

                System.out.print("\nInvalid file name.");

            }

        }

        System.out.println("\nGoodbye!");

        input.close();

        write.close();

    }

    /**
     * Searches for the object inside of the hashtable
     * @param t the object that will be searched in the
     * hashtable
     */
    public static void Search(Hash<Classes> t) {

        String srch;

        boolean answer;
        Scanner input = new Scanner(System.in);

        System.out.println();

        System.out.print("Enter the CRN of the class: ");

        srch = input.next();

        Classes crnOnly = new Classes(srch, 0.0, "Default Subject", "Default Course"
                ,"Default Days", "Default", "Default Prof", 0.0);

        answer = t.search(crnOnly);

        if(answer != true) {

            System.out.println("Sorry this CRN does not exist in the database.");

        } else {

            System.out.println("\nHere is the class that the CRN belongs to:");

            t.printSpecificObject(crnOnly);

        }

    }


    /**
     * Searches for the object inside of the Binary Search Tree
     * @param tree2 an object that is meant to search for by the
     * second key which is the rating
     */
    public static void Search2(BST<Classes> tree2) {

        Double rating;

        boolean answer;
        Scanner input = new Scanner(System.in);

        System.out.println();

        System.out.print("Enter the Rating of the class: ");

        rating = input.nextDouble();

        Classes ratingOnly = new Classes("Default CRN", 0.0, "Default Subject", "Default Course"
                ,"Default Days", "Default", "Default Prof", rating);

        answer = tree2.search2(ratingOnly);

        if(answer != true) {

            System.out.println("\nSorry this rating does not exist in the database.");

        } else {

            System.out.println("\nHere is the class that the rating belongs to:");

            tree2.PrintRating(rating);

        }

    }

    /**
     * Reads the courses.txt file and adds the elements
     * to the HashTable, Binary Search Tree using the first key and the
     * second Binary Search Tree which uses the second key (rating)
     * @param input Scanner input that will read in the data
     * @param t the hashtable object that will insert the data
     * @param tree the binary search tree object that will insert the data
     * @param tree2 the second binary search tree object that will insert the data
     */
    public static void readFile(Scanner input, Hash<Classes> t, BST<Classes> tree, BST<Classes> tree2) {

        String Subject, Course, Days, Time, Prof, CRN;;

        double Rating, Credit;

        Classes schedule = new Classes();

        while(input.hasNextLine()) {

            CRN = input.next();

            Subject = input.next();

            Credit = input.nextDouble();

            Course = input.next();

            Days = input.next();

            Time = input.next();

            Prof = input.next();

            Prof += " " + input.next();

            Rating = input.nextDouble();

            schedule = new Classes(CRN, Credit, Subject, Course, Days, Time, Prof, Rating);

            t.insert(schedule);
            tree.insert(schedule);
            tree2.insert2(schedule);

        }

    }

    /**
     * Checks if the input has "am" or "pm" at the end
     * @param time is the input that holds the "am" or "pm"
     * @return true if the input has "am" or "pm" at the end
     */
    public static boolean checkTime(String time) {

        for(int i = 0; i < time.length() - 1; i++) {

            if ((time.charAt(i) == 'a') && (time.charAt(i + 1) == 'm')) {

                return true;
            } else if (((time.charAt(i) == 'p') && (time.charAt(i + 1) == 'm'))) {

                return true;
            }

        }

        return false;


    }


}


