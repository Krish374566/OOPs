class Book {
    String title;
    String author;
    int publicationYear;

    // Default constructor
    Book() {
        this.title = "Untitled";
        this.author = "Unknown Author";
    }

    // Parameterized constructor (title and author)
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Constructor with title, author, and publication year
    Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        if (publicationYear != 0)
            System.out.println("Year: " + publicationYear);
    }
}
