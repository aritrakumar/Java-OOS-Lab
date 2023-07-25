
/*



17) Imagine a toll booth and a bridge. Cars passing by the booth are expected to pay an amount
of Rs. 50/- as toll tax. Mostly they do but sometimes a car goes by without paying. The toll booth
keeps track of the number of the cars that have passed without paying, total number of cars
passed by, and the total amount of money collected. Execute this with a class called “Tollbooth”
and print out the result as follows:
The total number of cars passed by without paying.
Total number of cars passed by.
Total cash collected.

*/



import java.util.*;
import java.lang.*;
class Tollbooth
{
    int totalCarsPassed;
    int carsPassedWithoutPaying;
    int tollCollected;

    Tollbooth()
    {
        totalCarsPassed = 0;
        carsPassedWithoutPaying = 0;
        tollCollected = 0;
    }

    void getData()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total number of cars passed : ");
        totalCarsPassed = sc.nextInt();
        System.out.println("Enter the number of cars that did not pay the toll : ");
        carsPassedWithoutPaying = sc.nextInt();
        if(carsPassedWithoutPaying > totalCarsPassed)
        {
            System.out.println("Cars passed without paying toll must be less than the total number of cars passed!");
            System.exit(0);
        }
    }

    void calculateToll()
    {
        tollCollected = 50*(totalCarsPassed-carsPassedWithoutPaying);
    }

    void printDetails()
    {
        System.out.println("\t\t\t TOLL DETAILS \t\t\t");
        System.out.println("---------------------------------------------------------------");
        System.out.println("Total number of cars passed without paying : "+carsPassedWithoutPaying);
        System.out.println("Total number of cars passed : "+totalCarsPassed);
        System.out.println("Total cash collected : "+tollCollected);
    }
}

class Traffic
{
    public static void main(String args[])
    {
        Tollbooth obj = new Tollbooth();
        obj.getData();
        obj.calculateToll();
        obj.printDetails();
    }
}
