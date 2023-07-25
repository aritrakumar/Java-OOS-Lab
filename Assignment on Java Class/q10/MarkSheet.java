
/*


10) Implement a class for a “Student”. Information about a student includes name, roll no and an
array of five subject names. The class should have suitable constructor and get/set methods.
Implement a class “TabulationSheet”. A tabulation sheet contains roll numbers and marks of
each student for a particular subject. This class should have a method for adding the marks and
roll no of a student.
Implement a class “MarkSheet”. A mark sheet contains marks of all subjects for a particular
student. This class should have a method to add name of a student and marks in each subject.
Write a main() function to create three “Student” objects, Five “Tabulationsheet” objects for Five
subjects and three “Marksheet” object for three students. Print the mark sheets.

*/



import java.util.Scanner;

class Student2 {

    String name;
    int rollno;
    static String sub[]=new String[5];

    static{

        sub[0]=new String("Java");
        sub[1]=new String("CN");
        sub[2]=new String("Graphics");
        sub[3]=new String("Graph");
        sub[4]=new String("Math");

    }

    Student2(){

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Name & Roll ");
        name=sc.nextLine();
        rollno=sc.nextInt();

    }


}

class TabulationSheet{

    int totalMarks;
    int marks[]=new int[5];

    {

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Marks for Each Subjects Respectively");
        for(int i=0;i<5;i++)
            marks[i]=sc.nextInt();

    }

    int TotalMarks(){

        for(int i=0;i<5;i++)
            totalMarks+=marks[i];

        return totalMarks;
    }
}



class MarkSheet{

    public static void main(String args[]){


        Student2 st[]=new Student2[3];
        for(int i=0;i<3;i++)
            st[i]=new Student2();

        TabulationSheet ts[]=new TabulationSheet[3];
        for(int i=0;i<3;i++)
            ts[i]=new TabulationSheet();


        for(int i=0;i<3;i++){
            System.out.println("Name : "+st[i].name+"  & "+"Roll No. : "+st[i].rollno);
            System.out.println("MARKSHEET");

            for(int j=0;j<5;j++){
                System.out.println(st[i].sub[j]+" "+ts[i].marks[j]);
            }
            System.out.println("Total Marks :"+ts[i].TotalMarks());
            System.out.println();

        }


    }

}
