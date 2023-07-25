/*



2) Write a program to implement a class “student” with the following members.
Name of the student.
Marks of the student obtained in three subjects.
Function to assign initial values.
Function to compute total average.
Function to display the student’s name and the total marks.
Write an appropriate main() function to demonstrate the functioning of the above.

*/

class Student1
{
    String name;
    float mark1,mark2,mark3;
    void getData(String args,float m1,float m2, float m3)
    {
        name=args;
        mark1=m1;
        mark2=m2;
        mark3=m3;
    }
    float average()
    {
        return (mark1+mark2+mark3)/3;
    }
    void display()
    {
        System.out.println("The name of the student is: "+name+"\nTotal marks is: "+ average()*3);
    }
    public static void main(String args[])
    {
        Student1 s1=new Student1();
        s1.getData("Aritra", 12, 13, 14);
        System.out.println("Student information is: ");
        s1.display();
        System.out.println("Average marks is: "+s1.average());
    }
}
