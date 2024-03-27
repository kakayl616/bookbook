import java.util.ArrayList;
import java.util.List;

interface LibraryItem {
    void borrowItem();
    void returnItem();
    boolean isBorrowed();
    String getTitle();
}

class Book implements LibraryItem {
    private String title;
    private String author;
    private int publicationYear;
    private boolean borrowed;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.borrowed = false;
    }

    @Override
    public void borrowItem() {
        if (!borrowed) {
            borrowed = true;
            System.out.println("Book \"" + title + "\" has been borrowed.");
        } else {
            System.out.println("Book \"" + title + "\" is already borrowed.");
        }
    }

    @Override
    public void returnItem() {
        if (borrowed) {
            borrowed = false;
            System.out.println("Book \"" + title + "\" has been returned.");
        } else {
            System.out.println("Book \"" + title + "\" is not currently borrowed.");
        }
    }

    @Override
    public boolean isBorrowed() {
        return borrowed;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
}

class DVD implements LibraryItem {
    private String title;
    private String director;
    private int runningTime;
    private boolean borrowed;

    public DVD(String title, String director, int runningTime) {
        this.title = title;
        this.director = director;
        this.runningTime = runningTime;
        this.borrowed = false;
    }

    @Override
    public void borrowItem() {
        if (!borrowed) {
            borrowed = true;
            System.out.println("DVD \"" + title + "\" has been borrowed.");
        } else {
            System.out.println("DVD \"" + title + "\" is already borrowed.");
        }
    }

    @Override
    public void returnItem() {
        if (borrowed) {
            borrowed = false;
            System.out.println("DVD \"" + title + "\" has been returned.");
        } else {
            System.out.println("DVD \"" + title + "\" is not currently borrowed.");
        }
    }

    @Override
    public boolean isBorrowed() {
        return borrowed;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public int getRunningTime() {
        return runningTime;
    }
}

abstract class LibraryUser {
    public abstract void borrowItem(LibraryItem item);
    public abstract void returnItem(LibraryItem item);
    public abstract void printItemsBorrowed();
}

class Student extends LibraryUser {
    private List<LibraryItem> borrowedItems;
    private String name;

    public Student(String name) {
        this.name = name;
        borrowedItems = new ArrayList<>();
    }

    @Override
    public void borrowItem(LibraryItem item) {
        if (!item.isBorrowed()) {
            item.borrowItem();
            borrowedItems.add(item);
        } else {
            System.out.println("Item \"" + item.getTitle() + "\" is already borrowed.");
        }
    }

    @Override
    public void returnItem(LibraryItem item) {
        if (borrowedItems.contains(item)) {
            item.returnItem();
            borrowedItems.remove(item);
        } else {
            System.out.println("You haven't borrowed item \"" + item.getTitle() + "\".");
        }
    }

    @Override
    public void printItemsBorrowed() {
        System.out.println("Student: " + name);
        System.out.println("Borrowed items:");
        for (LibraryItem item : borrowedItems) {
            System.out.println("- Book: " + item.getTitle() + " by " + ((Book) item).getAuthor());
        }
    }
}

class Teacher extends LibraryUser {
    private List<LibraryItem> borrowedItems;
    private String name;

    public Teacher(String name) {
        this.name = name;
        borrowedItems = new ArrayList<>();
    }

    @Override
    public void borrowItem(LibraryItem item) {
        if (!item.isBorrowed()) {
            item.borrowItem();
            borrowedItems.add(item);
        } else {
            System.out.println("Item \"" + item.getTitle() + "\" is already borrowed.");
        }
    }

    @Override
    public void returnItem(LibraryItem item) {
        if (borrowedItems.contains(item)) {
            item.returnItem();
            borrowedItems.remove(item);
        } else {
            System.out.println("You haven't borrowed item \"" + item.getTitle() + "\".");
        }
    }

    @Override
public void printItemsBorrowed() {
    System.out.println("Teacher: " + name);
    System.out.println("Borrowed items:");
    for (LibraryItem item : borrowedItems) {
        if (item instanceof Book) {
            System.out.println("- Book: " + item.getTitle() + " by " + ((Book) item).getAuthor());
        } else if (item instanceof DVD) {
            System.out.println("- DVD: " + item.getTitle() + " by " + ((DVD) item).getDirector());
        }
    }
}
}

public class LibMng {
    public static void main(String[] args) {
        // Creating some books and DVDs
        Book book1 = new Book("Tambook", "Chun Li", 1960);
        DVD dvd1 = new DVD("Knee Wang", "Topher Y Kaon", 148);

        // Creating some students and teachers
        Student student1 = new Student("Babi");
        Teacher teacher1 = new Teacher("Bobi");

        // Demonstrating borrowing items
        student1.borrowItem(book1);
        teacher1.borrowItem(dvd1);

        // Printing items borrowed by student and teacher
        student1.printItemsBorrowed();
        teacher1.printItemsBorrowed();

        // Demonstrating returning items
        student1.returnItem(book1);
        teacher1.returnItem(dvd1);
    }
}
