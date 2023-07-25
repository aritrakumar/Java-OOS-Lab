

/*



7) Implement a class for “Date”. Write member functions for (i) getting the previous day, (iv)
getting the next day, (iii) printing a day
There should be four constructors: (i) day, month and year are initialized to 01, 01, 1970; (ii) day
is initialized to user specified value but month and year are initialized to 01, 1970; (iii) day,
month are initialized to user specified value but year is initialized to 1970; (iv) day, month and
year are initialized to user defined values.
Also, write a main() function to (i) create a date object; (ii) print the next and the previous day.

*/


class Date
{
    int day, month, year;
    Date()
    {
        month=day=01;
        year=1970;
    }
    Date(int d)
    {
        day=d;
        month=01;
        year=1970;
    }
    Date(int d, int m)
    {
        day=d;
        month=m;
        year=1970;
    }
    Date(int d, int m, int y)
    {
        day=d;
        month=m;
        year=y;
    }
    void print()
    {
        System.out.println(day+"/"+month+"/"+year);
    }
    Date previousDate()
    {
        Date nd=new Date();
        if(day==1)
        {
            if(month==1)
            {
                nd.year=year-1;
                nd.day=31;
                nd.month=12;
            }
            else
            {
                nd.month=month-1;
                switch(nd.month)
                {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        nd.day=31;
                        break;
                    case 2:
                        if(leapyear(nd.year))
                            nd.day=29;
                        else
                            nd.day=28;
                        break;
                    default:
                        nd.day=30;
                        break;
                }
            }
        }
        else
            nd.day=day-1;
        return nd;
    }
    boolean leapyear(int yr)
    {
        if(yr%100==0)
        {
            if(yr%400==0)
                return true;
            else
                return false;
        }
        else
        {
            if(yr%4==0)
                return true;
            else
                return false;
        }
    }
    Date nextDate()
    {
        Date nd=new Date();
        switch(month)
        {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
                if(day==31)
                {
                    nd.day=1;
                    nd.month=month+1;
                }
                else
                {
                    nd.day=day+1;
                }
                break;
            case 2:
                if(leapyear(nd.year))
                {
                    if(day==29)
                    {
                        nd.day=1;
                        nd.month=3;
                    }
                    else
                        nd.day=day+1;
                }
                else
                {
                    if(day==28)
                    {
                        nd.day=1;
                        nd.month=3;
                    }
                    else
                        nd.day=day+1;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if(day==30)
                {
                    nd.day=1;
                    nd.month=month+1;
                }
                else
                    nd.day=day+1;
                break;
            case 12:
                if(day==31)
                {
                    nd.day=1;
                    nd.month=1;
                    nd.year=year+1;
                }
                else
                    nd.day=day+1;
                break;
        }
        return nd;
    }
    public static void main(String args[])
    {
        Date dd=new Date();
        dd.print();
        System.out.println("Pevious date is: ");
        dd.previousDate().print();
        System.out.println("Next date is: ");
        dd.nextDate().print();
    }
}
