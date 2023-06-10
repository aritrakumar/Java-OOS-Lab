/*

Name : ARITRA KUMAR
Roll No. 302211001010
BE IT UG2 A3

1) Create a class “Room” which will hold the “height”, “width” and “breadth” of the room in
three fields. This class also has a method “volume()” to calculate the volume of this room. Create
another class “RoomDemo” which will use the earlier class, create instances of rooms, and
display the volume of room.
*/

class Room
{
    float height,width,bread;
    Room()
    {
        height=width=bread=0;
    }
    Room(float h, float w, float b)
    {
        height=h;
        width=w;
        bread=b;
    }
    float volume()
    {
        return height*width*bread;
    }
}
class RoomDemo
{
    public static void main(String args[])
    {
        Room rooms=new Room(12,13,14);
        System.out.println("Volume of the room is: "+ rooms.volume());
    }
}