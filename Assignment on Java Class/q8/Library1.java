
/*



8) Implement a class for a “Book”. Book contains a title (a String), a list of authors (array of
authors), number of pages (an integer), price (floating point number), publisher (a String) etc.
Write suitable constructor and accessor/modifier methods.
Implement a class for “Library”. A library contains a list of books (array of Book). Write add (to
add a book) and remove (to delete a book) methods for library.
Write a main() function to create a “Library” and add five “Book” to library. Print the total price
of all books.

*/



class Book1 {
    String title;
    String authors[];
    int numPages;
    double price;
    String publisher;

    Book1(String title, String authors[], int numPages, double price, String publisher) {
        this.title = title;
        this.authors = authors;
        this.numPages = numPages;
        this.price = price;
        this.publisher = publisher;
    }
}


class Library1 {
    Book1 books[];
    int numBooks;

    Library1(int maxNumBooks) {
        books = new Book1[maxNumBooks];
        numBooks = 0;
    }

    void addBook(Book1 book) {
        if (numBooks < books.length) {
            books[numBooks] = book;
            numBooks++;
        } else {
            System.out.println(" Lib is full.");
        }
    }

    void removeBook(Book1 book) {
        int index = -1;
        for (int i = 0; i < numBooks; i++) {
            if (books[i] == book) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Lib is empty");
        } else {
            for (int i = index; i < numBooks - 1; i++) {
                books[i] = books[i + 1];
            }
            numBooks--;
        }
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (int i = 0; i < numBooks; i++) {
            totalPrice += books[i].price;
        }
        return totalPrice;
    }


    public static void main(String args[]) {
        Library1 library = new Library1(5);
        Book1 book1 = new Book1("a", new String[]{"aa"}, 1, 11, "aaa");
        Book1 book2 = new Book1("b", new String[]{"bb"}, 2, 22, "bbb");
        Book1 book3 = new Book1("c", new String[]{"cc","ccc"}, 3, 33, "cccc");
        Book1 book4 = new Book1("d", new String[]{"dd"}, 4, 44, "ddd");
        Book1 book5 = new Book1("e", new String[]{"ee"}, 5, 55, "eee");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        System.out.println("Total price of all books in the library: Rs " + library.getTotalPrice());

    }
}


