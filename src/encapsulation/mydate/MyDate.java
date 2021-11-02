package encapsulation.mydate;

public class MyDate {
    private int month;
    private int day;

    public MyDate() {
    }

    public MyDate(int month, int day) {
        setMonth(month);
        setDay(day);
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (isValidDay(month, day)) {
            this.day = day;
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (isValidMonth(month)) {
            this.month = month;
        }
    }

    public void printDate(){
        if(isValidDate(day, month)){
            System.out.println(month + "." + day);
        }else{
            System.out.println("Invalid date");
        }
    }

    private boolean isValidMonth(int month){
        return month > 0 && month < 13;
    }

    private boolean isValidDay(int month, int day){
        if (month == 2) {
            return day > 0 && day < 29;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return day > 0 && day < 31;
        }
        return day > 0 && day < 32;
    }

    public boolean isValidDate(int day, int month){
        return isValidMonth(month) && isValidDay(month, day);
    }
}
