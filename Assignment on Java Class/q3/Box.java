/*

Name : ARITRA KUMAR
Roll No. 302211001010
BE IT UG2 A3

3) Write a class “Box” that with three member-variables “height”, “width” and “breadth”. Write
suitable constructors to initialize them. Add functions like “getVolume” and “getArea” that will
return volume and surface area respectively. Instantiate two arbitrary boxes and then print their
volume and surface area.

*/

class Box
{
    float height, width, breadth;
    Box()
    {
        height=width=breadth=0;
    }
    Box(float h, float w, float b)
    {
        height=h;
        width=w;
        breadth=b;
    }
    float getVolume()
    {
        return height*width*breadth;
    }
    float getArea()
    {
        return width*breadth;
    }
    public static void main(String args[])
    {
        Box b1=new Box();
        Box b2=new Box(14,12,15);
        System.out.println("Volume of the 1st box is: "+ b1.getVolume() +" \t Surface Area of the 1st box is: "+ b1.getArea());
        System.out.println("Volume of the 2nd box is: "+ b2.getVolume() +" \t Surface Area of the 2nd box is: "+ b2.getArea());
    }

}