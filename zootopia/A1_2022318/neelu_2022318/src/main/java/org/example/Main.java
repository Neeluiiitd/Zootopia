package org.example;

import java.sql.SQLOutput;
import java.util.*;

class Book {
    private String title, author;
    private static int nextId = 1;
    private int id, totalCopies, availableCopies;
    private boolean issued;

    public boolean isIssued() {
        return issued;
    }

    public void change_status(){
        if (issued) issued = false;
        else issued = true;
    }

    public int getId() {
        return id;
    }

    public Book(String title, String author, int totalCopies) {
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
        this.title = title;
        this.author = author;
        this.id = nextId++;
        this.issued = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void increaseAvailableCopies() {
        availableCopies++;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void decreaseAvailableCopies() {
        availableCopies--;
    }
}
class Member {
    private String name, phoneNumber;
    private static int nextId = 1;
    private int id, age;
    private List<Book> borrowedBooks = new ArrayList<>();

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public Member(String name, int age, String phoneNumber) {
        this.name = name;
        this.id = nextId++;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void removeBorrowedBook(Book book) {
        borrowedBooks.remove(book);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void addBorrowedBook(Book book) {
        borrowedBooks.add(book);
    }
}
class Library {
    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();

    public List<Book> getAllBooks() {
        return books;
    }

    public List<Member> getAllMembers() {
        return members;
    }

    public Member findMemberById(int memberId) {
        for (Member member : members) {
            if (member.getId() == memberId) {
                return member;
            }
        }
        return null;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book findBookById(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                return book;
            }
        }
        return new Book("title", "author", 0);
    }

    public void removeBook(int bookId) {
        Book bookToRemove = findBookById(bookId);
        if (bookToRemove != null) {
            books.remove(bookToRemove);
            System.out.println("Book Removed!");
        }else System.out.println("Book with " + bookId + "is not found.");
    }

    public void registerMember(Member member) {
        members.add(member);
    }

    public void removeMember(int memberId) {
        Member memberToRemove = findMemberById(memberId);
        if (memberToRemove != null) {
            members.remove(memberToRemove);
            System.out.println("Member removed successfully.");
        }else System.out.println("Member not found.");
    }

    public Member findMemberByPhoneNumber(String phoneNumber) {
        for (Member member : members) {
            if (member.getPhoneNumber().equals(phoneNumber)) {
                return member;
            }
        }
        return null;
    }
}

class Main {
    //    static Member member_list;
    static Library library = new Library();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Library Portal Initialized...");
        System.out.println("---------------------------------");

        while (true) {
            System.out.println("Main Menu:");
            System.out.println("1. Enter as a librarian");
            System.out.println("2. Enter as a member");
            System.out.println("3. Exit");
            System.out.println("---------------------------------");

            int input = scanner.nextInt();
            scanner.nextLine();

            if (input == 1) librarianMenu();
            else if (input == 2) memberMenu();
            else if (input == 3) {
                System.out.println("Exiting Library Portal.");
                break;
            } else System.out.println("Invalid choice. Please try again.");
        }
    }

    public static void librarianMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Librarian Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Register Member");
            System.out.println("4. Remove Member");
            System.out.println("5. List Available Books");
            System.out.println("6. List Members");
            System.out.println("7. Back to Main Menu");
            System.out.println("---------------------------------");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) addBook();
            else if (choice == 2) removeBook();
            else if (choice == 3) registerMember();
            else if (choice == 4) removeMember();
            else if (choice == 5) listAvailableBooks();
            else if (choice == 6) listMembers();
            else if (choice == 7) return;
            else System.out.println("Invalid choice. Please try again.");
        }
    }

    public static void memberMenu() {
        Scanner scanner = new Scanner(System.in);

        Member default_mem = new Member("name", 0, "phone");

        System.out.print("Enter your member id :");
        int member_id=scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter your Phone Number : ");
        String phone_num=scanner.nextLine();

        for(Member i : library.getAllMembers()) if(member_id == i.getId() && phone_num.equals(i.getPhoneNumber())) default_mem = i;

        if(default_mem.getName().equals("name")) {
            System.out.println("Invalid Login information !");
            return;
        }

        while (true) {
            System.out.println("Member Menu:");
            System.out.println("1. Available Books");
            System.out.println("2. List My Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            //System.out.println("5. Pay Fine");
            System.out.println("6. Back to main menu");
            System.out.println("---------------------------------");

            int input_2 = scanner.nextInt();
            scanner.nextLine();

            switch (input_2) {
                case 1:
                    listAvailableBooks();
                    break;
                case 2:
                    listMyBooks(default_mem);
                    break;
                case 3:
                    issueBook(default_mem);
                    break;
                case 4:
                    returnBook(default_mem);
                    break;

                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    public static void addBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the title of the book:");
        String title = scanner.nextLine();
        System.out.println("Enter the author of the book:");
        String author = scanner.nextLine();
        System.out.println("Enter the total number of copies:");
        int totalCopies = scanner.nextInt();
        scanner.nextLine();

        for(int i=0;i<totalCopies;i++) {
            Book book = new Book(title, author, totalCopies);
            library.addBook(book);
        }
        System.out.println("Books added successfully.");
    }

    public static void removeBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the ID of the book to remove:");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        library.removeBook(bookId);
    }

    public static void registerMember() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the member:");
        String name = scanner.nextLine();
        System.out.println("Enter the age of the member:");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the phone number of the member:");
        String phoneNumber = scanner.nextLine();

        Member member = new Member(name, age, phoneNumber);
        library.registerMember(member);
        System.out.println("Member registered successfully.");
    }

    public static void removeMember() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the ID of the member to remove:");
        int memberId = scanner.nextInt();
        scanner.nextLine();

        library.removeMember(memberId);
    }

    public static void listAvailableBooks() {
        List<Book> books = library.getAllBooks();
        System.out.println("Available Books:");
        for (Book book : books) {
            if (book.isIssued()) {
                System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Available Copies: " + book.getAvailableCopies());
            }
        }
    }

    public static void listMembers() {
        List<Member> members = library.getAllMembers();
        System.out.println("Members:");
        for (Member member : members) {
            System.out.println("ID: " + member.getId() + ", Name: " + member.getName() + ", Age: " + member.getAge() + ", Phone Number: " + member.getPhoneNumber());
        }
    }
    public static void issueBook(Member temp_mem) {

        Scanner scanner = new Scanner(System.in);
        listAvailableBooks();

        System.out.print("Enter book ID to issue: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        Book bookToIssue = library.findBookById(bookId);
        String bookTitle = bookToIssue.getTitle();
        if (!(bookToIssue.getTitle().equals("title")) && bookToIssue.getAvailableCopies() > 0) {
            temp_mem.addBorrowedBook(bookToIssue);
            bookToIssue.change_status();
            System.out.println("Book Issued Successfully!");
            for(Book def : library.getAllBooks()) if(def.getTitle().equals(bookTitle)) def.decreaseAvailableCopies();
        } else {
            System.out.println("Book not available or invalid book ID.");
        }
    }

    public static void returnBook(Member temp_mem) {
        Scanner scanner = new Scanner(System.in);

        List<Book> borrowedBooks = temp_mem.getBorrowedBooks();
        System.out.println("Borrowed Books:");
        for (Book book : borrowedBooks) {
            System.out.println("Book ID: " + book.getId());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("---------------------------------");
        }

        System.out.print("Enter book ID to return: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        Book bookToReturn = library.findBookById(bookId);
        if (bookToReturn != null) {
            temp_mem.removeBorrowedBook(bookToReturn);
            bookToReturn.change_status();
            for(Book temp : library.getAllBooks()) if(temp.getTitle().equals(bookToReturn.getTitle())) bookToReturn.increaseAvailableCopies();
            System.out.println("Book Returned Successfully!");
        } else {
            System.out.println("Book not found or not borrowed by you.");
        }
    }

    public static void listMyBooks(Member temp_mem) {
        List<Book> borrowedBooks = temp_mem.getBorrowedBooks();
        System.out.println("Your Borrowed Books:");
        for (Book book : borrowedBooks) {
            System.out.println("Book ID: " + book.getId());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("---------------------------------");
        }
    }
}