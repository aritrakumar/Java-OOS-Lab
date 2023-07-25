
/*



11) Create an abstract class “Publication” with data members ‘noOfPages’, ‘price’,
‘publisherName’ etc. with their accessor/modifier functions. Now create two sub-classes “Book”
and “Journal”. Create a class Library that contains a list of Publications. Write a main() function
and create three Books and two Journals, add them to library and print the details of all
publications.

*/



import java.util.*;

abstract class Publication
{
    int noOfPages;
    double price;
    String publisherName;

    abstract void pub();


    void getData()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of pages : ");
        noOfPages = sc.nextInt();
        System.out.println("Enter the price : ");
        price = sc.nextDouble();
        System.out.println("Enter the publisher name : ");
        publisherName = sc.next();
    }

    void putData()
    {
        System.out.println("The number of pages : "+noOfPages);
        System.out.println("The price : "+price);
        System.out.println("The publisher name : "+publisherName);
        System.out.println("-------------------------------------------");
    }
}

class Book2 extends Publication
{
    void pub()
    {
        System.out.println("Pub method implementd in Book");
    }
}

class Journal extends Publication
{
    void pub()
    {
        System.out.println("Pub method implemented in Journal");
    }
}

class Library
{
    public static void main(String args[])
    {
        Book2 b1 = new Book2();
        b1.getData();
        Book2 b2 = new Book2();
        b2.getData();
        Book2 b3 = new Book2();
        b3.getData();

        Journal j1 = new Journal();
        j1.getData();
        Journal j2 = new Journal();
        j2.getData();

        b1.putData();
        b2.putData();
        b3.putData();
        j1.putData();
        j2.putData();
    }
}
