package encapsulation;

import encapsulation.mydate.MyDate;

public class MyDateTest {
    public static void main(String[] args) {
        MyDate date = new MyDate(1, 1);
        date.printDate();

        MyDate date1 = new MyDate(3, 78);
        date1.printDate();

        MyDate date2 = new MyDate(12, 31);
        date2.printDate();

        MyDate date3 = new MyDate(2, 29);
        date3.printDate();

        MyDate date4 = new MyDate(13, 1);
        date4.printDate();

        MyDate date5 = new MyDate(2, 28);
        date5.printDate();

        MyDate date6 = new MyDate(4, 30);
        date6.printDate();
    }
}
