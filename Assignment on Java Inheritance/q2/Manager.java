
/*

Name : ARITRA KUMAR
Roll No. 302211001010
BE IT UG2 A3

12) Write a class for “Account” containing data members ‘accountNumber’, ‘holderName’,
‘balance’ and add constructors and necessary accessor/modifier functions for these data
members. Now create two class “SavingsAccount” and “CurrentAccount” extending from this
class. SavingsAccount will have a member variable ‘interestRate’ and member function
‘calculateYearlyInterest’. Write another class “Manager” that contains a list Account. Also write
a main() function to create an instance of Manager class. Add two SavingsAccount and three
CurrentAccount to Manager. Calculate interest of each SavingsAccount. Print the details of all
accounts.

*/



import java.util.*;
class Account
{
    int accountNumber;
    String holderName;
    double balance;

    Account()
    {
        this.accountNumber = -1;
        holderName = "";
        balance = 0.0d;
    }

    void getData()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the account number : ");
        accountNumber = sc.nextInt();
        String dummy = sc.nextLine();
        System.out.println("Enter the account holder name : ");
        holderName = sc.nextLine();
        System.out.println("Enter the balance : ");
        balance = sc.nextDouble();
    }

    void putData()
    {
        System.out.println("The account number is : "+accountNumber);
        System.out.println("The account holder name is : "+holderName);
        System.out.println("The available balance is : "+balance);
    }
}

class SavingsAccount extends Account
{
    double interestRate = 3.5;

    void calculateYearlyInterest()
    {
        double interest = (balance*interestRate*1.0)/100.0;
        System.out.println("The yearly interest is : "+interest);
        System.out.println("-----------------------------------------");
    }
}

class CurrentAccount extends Account
{

}

class Manager
{
    public static void main(String args[])
    {
        SavingsAccount sa1 = new SavingsAccount();
        sa1.getData();
        CurrentAccount ca1 = new CurrentAccount();
        ca1.getData();
        sa1.putData();
        sa1.calculateYearlyInterest();
        ca1.putData();
    }
}