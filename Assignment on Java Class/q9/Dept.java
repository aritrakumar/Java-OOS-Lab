
/*



9) Write a Java class “Employee” containing information name, id, address, salary etc. Write
necessary constructor and read/write methods.
Create a class “Dept” that has a name, location etc. The “Dept” contains a number of
“Employee”. Write methods “add” and “remove” to add and remove an employee to/from this
department.
Write a main() function and create “Information Technology” department. Add five employees
and print yearly expenditure for this department.

*/



import java.util.*;
class Employee1
{
    String name;
    int id;
    String address;
    float sal;

    Employee1()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the Employee : ");
        this.name = sc.nextLine();
        System.out.println("Enter the id of the Employee : ");
        this.id = sc.nextInt();
        String dummy = sc.nextLine();
        System.out.println("Enter the address of the Employee : ");
        this.address = sc.nextLine();
        System.out.println("Enter the salary of the Employee : ");
        this.sal = sc.nextFloat();
    }
}

class Dept
{
    Employee1 obj[]  = new Employee1[100];
    int ind = -1;
    float totalExp = 0;

    void add()
    {
        ind++;
        obj[ind] = new Employee1();
    }

    void remove(int idx)
    {
        obj[idx] = null;
    }

    void totalExpenditure()
    {
        for(int i = 0; i <= ind; i++)
            totalExp+=obj[i].sal;
    }

    public static void main(String args[])
    {
        Dept InformationTechnology = new Dept();
        InformationTechnology.add();
        InformationTechnology.add();
        InformationTechnology.add();
        InformationTechnology.add();
        InformationTechnology.add();
        InformationTechnology.totalExpenditure();
        System.out.println("The yearly expenditure of the department is : "+InformationTechnology.totalExp);
    }
}
