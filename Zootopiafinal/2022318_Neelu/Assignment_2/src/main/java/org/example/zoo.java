package org.example;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.example.Discount.getDiscountPercentage;

public class zoo {
    public static Map<Integer, attractions> dictionary_arractions = new HashMap<>();
    public static Map<Integer, Animals> dictionary_animals = new HashMap<>();
    public static Map<String, Discount> dictionary_discounts = new HashMap<>();
    public static Map<Integer, Deals> dictionary_specialdeals = new HashMap<>();
    public static ArrayList feedback;
    public static ArrayList boughtics;

    //public static Map<Integer, attractions> dictionary_boughttics = new HashMap<>();
    public static Map<Integer, Register_visitor> dictionary_members = new HashMap<>();
    public int mem_id;
    static int n1 = 0;
    static int n2 = 0;
    static int n4 = 0;
    static int nv = 1;
    static int x = 1;
    static int n = 1;
    static int sd = 1;
    static int ixx = 0;


    public zoo() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Feedback> feedback = new ArrayList<>();
        ArrayList<boughttics> boughtics = new ArrayList<>();
        System.out.println("Welcome to ZOOtopia!");

        while (true) {

            System.out.println("1. Enter as Admin\n" +
                    "2. Enter as a Visitor\n" +
                    "3. View Special Deals\n");
            System.out.println("enter your choic");
            n = sc.nextInt();


            if (n == 1) {//ADMIN
                System.out.println("Enter Admin Username");
                sc.nextLine();//NEED TO ASK THIS
                String username = sc.nextLine();
                System.out.println("Enter Admin Userpassword");
                String pass = sc.nextLine();
                admin_login admin1 = new admin_login(username, pass);
                if (admin_login.Login_check()) {
                    System.out.println("Logged in successfully::");
                    int nn = 1;
                    while (nn != 8) {
                        System.out.println("Admin Menu:\n" +
                                "1. Manage Attractions\n" +
                                "2. Manage Animals\n" +
                                "3. Schedule Events\n" +
                                "4. Set Discounts\n" +
                                "5. Set Special Deal\n" +
                                "6. View Visitor Stats\n" +
                                "7. View Feedback\n" +
                                "8. Exit\n");

                        nn = sc.nextInt();
                        int x = 1;
                        if (nn == 1) {
                            while (x != 5) {
                                System.out.println("Manage Attractions:\n" +
                                        "1. Add Attraction\n" +
                                        "2. View Attractions\n" +
                                        "3. Modify Attraction\n" +
                                        "4. Remove Attraction\n" +
                                        "5. Exit\n");
                                x = sc.nextInt();

                                if (x == 1) { //add attractions
                                    System.out.println("enter attraction name::");
                                    sc.nextLine();
                                    String a1 = sc.nextLine();
                                    System.out.println("enter attraction discription::");
                                    String a2 = sc.nextLine();
                                    System.out.println("enter attraction price::");
                                    Double a3 = sc.nextDouble();
                                    attractions a = new attractions(a1, a2, a3);

                                    attractions.add_attractions(++n1, a);
                                    System.out.println("attraction added successfully");


                                }
                                if (x == 2) { //show attractions
                                    for (attractions i : dictionary_arractions.values()) {
                                        System.out.println("Attraction name:::" + i.getAttraction_name() + "\nAttraction_discription:::" + i.getAttraction_discription() + "\nPrice::" + i.getPrice());

                                    }
                                }
                                if (x == 3) {//error handling lagna hai{ and contaratin on key value otherwise nyi values add hojaegi Modify
                                    System.out.println("enter the attraction id::");
                                    sc.nextLine();
                                    int n2 = sc.nextInt();

                                    System.out.println("enter  new attraction name::");
                                    sc.nextLine();
                                    String a1 = sc.nextLine();
                                    System.out.println("enter new attraction discription::");
                                    String a2 = sc.nextLine();
                                    System.out.println("enter new attraction discription::");
                                    Double a3 = sc.nextDouble();
                                    attractions a = new attractions(a1, a2, a3);

                                    attractions.add_attractions(n2, a);
                                    System.out.println("attraction updated  successfully");

                                }
                                int n4 = 0;
                                if (x == 4) { //remove attractions and change their id ka .........................
                                    System.out.println("enter attraction id::");
                                    sc.nextLine();
                                    int remove_n = sc.nextInt();


                                    attractions.remove_attractions(remove_n);
                                    System.out.println("attraction removed successfully");
                                }


                            }
                        }

                        if (nn == 2) {//mamange animals
                            while (x != 4) {
                                System.out.println("Manage Animals:\n" +
                                        "1. Add Animal\n" +
                                        "2. Update Animal Details\n" +
                                        "3. Remove Animal\n" +
                                        "4. List animals\n" +
                                        "5. Exit\n" +
                                        "\n");
                                x = sc.nextInt();
                                if (x == 1) { // Add Animal
                                    System.out.println("Enter animal name:");
                                    String a1 = sc.nextLine();
                                    sc.nextLine();
                                    System.out.println("Enter animal type (Mammals, Amphibians, or Reptiles):");
                                    String a2 = sc.nextLine();
                                    sc.nextLine();
                                    System.out.println("Enter noise");
                                    String a3 = sc.nextLine();
                                    sc.nextLine();
                                    System.out.println("Enter history of the animal");
                                    String a4 = sc.nextLine();

                                    if ("Mammals".equals(a2)) {
                                        Mammals mammal = new Mammals(a1, a2, a3, a4);
                                        AnimalManager.addAnimal(mammal, ++n2);
                                        System.out.println("Animal added successfully");
                                    }
                                    if ("Amphibians".equals(a2)) {
                                        Amphibians amphibian = new Amphibians(a1, a2, a3, a4);
                                        AnimalManager.addAnimal(amphibian, ++n2);
                                        System.out.println("Animal added successfully");
                                    }
                                    if ("Reptiles".equals(a2)) {
                                        Reptiles reptile = new Reptiles(a1, a2, a3, a4);
                                        AnimalManager.addAnimal(reptile, ++n2);
                                        System.out.println("Animal added successfully");
                                    }

                                } else if (x == 2) { // Update Animal Details
                                    System.out.println("Enter the animal number to update:");
                                    int num = sc.nextInt();
                                    sc.nextLine(); // Consume the newline character.

                                    if (dictionary_animals.containsKey(num)) {
                                        System.out.println("Enter new name:");
                                        String newName = sc.nextLine();
                                        System.out.println("Enter new type:");
                                        String newType = sc.nextLine();
                                        sc.nextLine();
                                        System.out.println("Enter noise");
                                        String newnoise = sc.nextLine();
                                        sc.nextLine();
                                        System.out.println("Enter history of the animal");
                                        String newhis = sc.nextLine();

                                        AnimalManager.modifyAnimal(num, newName, newType, newnoise, newhis, dictionary_animals);
                                        System.out.println("Animal details updated successfully");
                                    } else {
                                        System.out.println("Animal not found with the given number.");
                                    }
                                } else if (x == 3) { // Remove Animal
                                    System.out.println("Enter the animal number to remove:");
                                    int removeNum = sc.nextInt();
                                    sc.nextLine();

                                    if (dictionary_animals.containsKey(removeNum)) {
                                        AnimalManager.removeAnimal(removeNum, dictionary_animals);
                                        System.out.println("Animal removed successfully");
                                    } else {
                                        System.out.println("Animal not found with the given number.");
                                    }
                                } else if (x == 4) { // List Animals
                                    AnimalManager.listAnimals();
                                } else { // Exit
                                    System.out.println("Exiting...");
                                    break;
                                }
                            }
                        }
                        if(nn==3){//on and off the events
                            System.out.println("enter attraction id");
                            int nm= sc.nextInt();
                            attractions attraction = dictionary_arractions.get(nm);
                            String sm=sc.nextLine();
                            if(sm.equals("off")){
                                attraction.turnOff();

                            }
                            else{
                                attraction.turnOn();



                            }

                        }


                        if (nn == 4) {//discounts
                            while (x != 4) {

                                System.out.println("\n" +
                                        "Set Discounts:\n" +
                                        "1. Add Discount\n" +
                                        "2. Modify Discount\n" +
                                        "3. Remove Discount\n" +
                                        "4. Exit\n");
                                x = sc.nextInt();
                                if (x == 1) { //add discounts
                                    System.out.println("enter discount percentage::");
                                    sc.nextLine();
                                    double a1 = sc.nextDouble();
                                    System.out.println("enter discount category//code::");
                                    String a2 = sc.nextLine();
                                    sc.nextLine();
                                    Discount a = new Discount(a1);

                                    Discount.add_discount(a2, a);
                                    System.out.println("discount added successfully");


                                }
                                if (x == 2) {//Modify discount

                                }
                                if (x == 3) {//remove discount
                                    System.out.println("enter discount id::");
                                    sc.nextLine();
                                    String remove_n = sc.nextLine();


                                    Discount.remove_discount(remove_n);
                                    System.out.println("discount removed successfully");


                                }
                                if (x == 3) {//modify


                                    System.out.println("enter  new discount percentage::");
                                    sc.nextLine();
                                    Double a1 = sc.nextDouble();
                                    System.out.println("enter new discount category::");
                                    String a2 = sc.nextLine();
                                    Discount a = new Discount(a1);

                                    Discount.add_discount(a2, a);
                                    System.out.println("discount updated  successfully");


                                }


                            }

                        }
                        if (nn == 5) {//SPECIAL DEALS
                            while (x != 5) {
                                System.out.println("Set Speacial_deals:\n" +
                                        "1. Add  Speacial_deals\n" +
                                        "2. Modify  Speacial_deals\n" +
                                        "3. Remove  Speacial_deals\n" +
                                        "4. show  Speacial_deals\n" +
                                        "5. Exit");
                                System.out.println("enter your choice:");
                                x = sc.nextInt();
                                if (x == 1) {//add speacl deals
                                    System.out.println("enter number of tickets");
                                    int no_tic = sc.nextInt();
                                    sc.nextLine();
                                    System.out.println("percent off ::");
                                    Double percent_off = sc.nextDouble();
                                    Deals d1 = new Deals(no_tic, percent_off);
                                    d1.add(sd++, d1);
                                    //dictionary_specialdeals.put(sd++,d1);
                                    System.out.println("Deals added successfully");


                                }
                                if (x == 2) {//remove specail deals
                                    System.out.println("enter the id of special deal to be removed");
                                    int rn = sc.nextInt();
                                    Deals d2 = dictionary_specialdeals.get(rn);
                                    d2.remove(rn);


                                }
                                if (x == 3) {
                                    System.out.println("enter number of modify tickets");
                                    int no_tic = sc.nextInt();
                                    sc.nextLine();
                                    System.out.println("percent off in modify ::");
                                    Double percent_off = sc.nextDouble();
                                    Deals d1 = new Deals(no_tic, percent_off);
                                    d1.add(sd++, d1);
                                    //dictionary_specialdeals.put(sd++,d1);
                                    System.out.println("Deals modified successfully");
                                }
                                if (x == 4) {//show deals
                                    Deals.showSpecialDeals();
                                }

                            }


                        }
                        if(nn==6){


                        }
                        if (nn == 7) {
                            System.out.println("enter feedback::");
                            String f = sc.nextLine();
                            Feedback f1 = new Feedback(f);
                        }
                    }
                } else {
                    System.out.println("Login credentials wrong");
                }
            }


            //VISITOR STARTS HERE...............................
            if (n == 2) {
                int y = 1; // Initialize y here

                while (y != 3) {
                    System.out.println("1. Register\n2. Login\n3. Exit");
                    System.out.println("Enter your choice:::");
                    y = sc.nextInt(); // Update the existing y


                    if (y == 1) {
                        System.out.println("Register member::");
                        System.out.println("Enter name::");
                        String name = sc.nextLine();
                        sc.nextLine();
                        System.out.println("Enter age::");
                        int age = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter number::");
                        int number = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter balance::");
                        int balance = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter email::");
                        String email = sc.nextLine();
                        sc.nextLine();
                        System.out.println("Enter password::");
                        String password = sc.nextLine();
//
                        Register_visitor v1 = new Register_visitor(name, age, number, balance, email, password);
                        Register_visitor.register_member(nv++, v1);
                    }
                    if (y == 2) {
                        System.out.print("enter your email::");
                        String email = sc.next();
                        sc.nextLine();
                        System.out.print("enter your password::");
                        String password = sc.nextLine();
                        sc.nextLine();

//                        System.out.println("email = " + email);
//                        System.out.println("password = " + password);
//                        visitor_login v=new visitor_login(email,password);
//                        for(Register_visitor i: dictionary_members.values()){
//                            System.out.println(i.getEmail()+"  "+i.getPassword());
//                        }

                        if (visitor_login.login_check(email, password)) {


                            System.out.println("Logged in successfully::");
                            System.out.println("enter your visitor id:");
                            int visitor_id = sc.nextInt();

                            int nv2 = 1;

                            while (nv2 != 9) {
                                System.out.println("Visitor Menu:\n" +
                                        "1. Explore the Zoo\n" +
                                        "2. Buy Membership\n" +
                                        "3. Buy Tickets\n" +
                                        "4. View Discounts\n" +
                                        "5. View Special Deals\n" +
                                        "6. Visit Animals\n" +
                                        "7. Visit Attractions\n" +
                                        "8. Leave Feedback\n" +
                                        "9. Log Out\n");
                                System.out.println("enter your choice");
                                nv2 = sc.nextInt();
                                if (nv2 == 1) {
                                    System.out.println(" Explore the Zoo");
                                    System.out.println("Explore the Zoo:\n" +
                                            "1. View Attractions\n" +
                                            "2. View Animals\n" +
                                            "3. Exit\n");
                                    System.out.println("enter your choice::");
                                    int z = sc.nextInt();
                                    if (z == 1) {
                                        System.out.println("View Attractions...........................");
                                        for (attractions i : dictionary_arractions.values()) {
                                            System.out.println("Attraction name:::" + i.getAttraction_name() + "\nAttraction_discription:::" + i.getAttraction_discription());

                                        }
                                    }
                                    if (z == 2) {
                                        System.out.println("View Animals.................");
                                        AnimalManager.listAnimals();


                                    }

                                }
                                if (nv2 == 2) {
                                    System.out.println(".......... \n" +
                                            "Buy Membership:\n" +
                                            "1. Basic Membership (₹20)\n" +
                                            "2. Premium Membership (₹50)\n" +
                                            "Enter your choice: 2\n");
                                    int c = sc.nextInt();
                                    if (c == 1) {
                                        System.out.println("Basic Membership (₹20)");
                                        Baisc_membership m1 = new Baisc_membership();
                                        System.out.println("enter your member id::");
                                        int ii = sc.nextInt();
                                        System.out.println("ENter discount coupon::");
                                        String coupon = sc.nextLine();
                                        double discountPercentage = getDiscountPercentage(coupon);
                                        m1.purchase_membership(ii, discountPercentage);
                                    }
                                    if (c == 2) {
                                        System.out.println("premium Membership (₹50)");
                                        Premium_Membership m2 = new Premium_Membership();
                                        System.out.println("enter your member id::");
                                        int ii = sc.nextInt();
                                        System.out.println("ENter discount coupon::");
                                        String coupon = sc.nextLine();
                                        double discountPercentage = getDiscountPercentage(coupon);
                                        m2.purchase_membership(ii, discountPercentage);
                                    }
                                }
                                if (nv2 == 3) {
                                    System.out.println("Buy attraction::");
                                    Double sum = 0.0;
                                    int num = 1;
                                    System.out.println("how many tickets you wanna buy");
                                    int tics = sc.nextInt();
                                    sc.nextLine();


                                    for (attractions i : dictionary_arractions.values()) {
                                        System.out.println(String.valueOf(num++) + ". Attraction name:::" + i.getAttraction_name() + ", Attraction Description:::" + i.getAttraction_discription() + ", Price:::" + i.getPrice());

                                    }
                                    while (tics > 0) {

                                        System.out.print("Enter your choice: ");
                                        int ch = sc.nextInt();
                                        sc.nextLine();

                                        for (int i : dictionary_arractions.keySet()) {
                                            if (ch == i) {
                                                attractions a1 = dictionary_arractions.get(i);


                                                //Register_visitor visitor =(dictionary_members.get(visitor_id));

                                                //Double Availabe_balance=visitor.getBalance();
                                                //double remaining_balance = (visitor.getBalance()-a1.getPrice());
                                                //visitor.setBalance(remaining_balance);
                                                //System.out.println("Remaining balance: " + remaining_balance);
                                                sum = sum + a1.getPrice();


                                            }

                                        }
                                        tics--;


                                    }
                                    for (Deals i : dictionary_specialdeals.values()) {
                                        attractions a1 = dictionary_arractions.get(i);
                                        Register_visitor visitor = (dictionary_members.get(visitor_id));
                                        if (i.getTickets_no() == tics) {
                                            Double remaining_balance = visitor.getBalance() - ((i.getPercent_off() / 100) * sum);
                                            visitor.setBalance(remaining_balance);
                                            System.out.println("Remaining balance: " + remaining_balance);
                                            System.out.println("bought the attarction");
                                            boughttics ab = new boughttics(ixx, a1);
                                            boughttics.addin(a1);
                                            ab.setNum(++ixx);


                                        } else {

                                            Double remaining_balance = visitor.getBalance() - sum;
                                            visitor.setBalance(remaining_balance);
                                            System.out.println("Remaining balance: " + remaining_balance);
                                            System.out.println("bought the attarction");
                                            boughttics.addin(a1);
                                            boughttics ab = new boughttics(ixx, a1);
                                            ab.setNum(++ixx);
                                        }
                                    }


                                }
                                if (nv2 == 4) {
                                    System.out.println("show discounts available");
                                    Discount.showDiscounts();
                                }
                                if (nv2 == 5) {//show deals
                                    Deals.showSpecialDeals();


                                }
                                if (nv2 == 6) {//visit animals

                                    System.out.println("enter animal number");
                                    int nuu = sc.nextInt();
                                    sc.nextLine();
                                    System.out.println("1.FEED the animal\n2.Read about the animal");
                                    if (nuu == 1) {
                                        AnimalManager.printAnimalNoise(nuu);

                                    } else {
                                        AnimalManager.printAnimalhistory(nuu);
                                    }


                                }
                                if (nv2 == 7) {//visit attractions
                                    for (attractions i : dictionary_arractions.values()) {
                                        System.out.println("Attraction name:::" + i.getAttraction_name() + "\nAttraction_discription:::" + i.getAttraction_discription() + "\nPrice::" + i.getPrice());

                                    }

                                    System.out.println("which attraction you wannna visist");
                                    int c = sc.nextInt();
                                    sc.nextLine();
                                    //if(boughtics.contains(dictionary_arractions.get(c))){
                                    //dictionary_arractions.get(c).getAttraction_discription();
                                    for (boughttics b : boughtics) {
                                        if (b.getA().getAttraction_name().equals(dictionary_arractions.get(c))) {
                                            b.setNum(b.getNum() - 1);
                                            System.out.println("welcome to "+dictionary_arractions.get(c));
                                        }


                                    }


                                }
                                if(nv2==8){//Feedback
                                    System.out.println("enter feedback");
                                    String sss= sc.nextLine();
                                    Feedback f1=new Feedback(sss);
                                    f1.give_feedback(f1);
                                }
                                if(nv2==9){
                                    System.out.println("logged out");
                                    break;
                                }

                            }


                        }


                    }
                }
            }
        }
    }


}






