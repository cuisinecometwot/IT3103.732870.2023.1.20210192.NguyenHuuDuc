import java.util.Scanner;
// Nguyen Huu Duc - 20210192
public class DisplayDaysOfAMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int month;
        System.out.println("Nguyen Huu Duc - 20210192");
        System.out.println("Enter a month (E.g: January, Jan., Jan, or 1); ");
        String inputMonth = scanner.next();
        switch (inputMonth) { // convert month to int type
            case "January":
            case "Jan.":
            case "Jan":
            case "1":
                month = 1;
                break;
            case "February":
            case "Feb.":
            case "Feb":
            case "2":
                month = 2;
                break;
            case "March":
            case "Mar.":
            case "Mar":
            case "3":
                month = 3;
                break;
            case "April":
            case "Apr.":
            case "Apr":
            case "4":
                month = 4;
                break;
            case "May":
            case "5":
                month = 5;
                break;
            case "June":
            case "Jun":
            case "6":
                month = 6;
                break;
            case "July":
            case "Jul":
            case "7":
                month = 7;
                break;
            case "August":
            case "Aug.":
            case "Aug":
            case "8":
                month = 8;
                break;
            case "September":
            case "Sept.":
            case "Sep":
            case "9":
                month = 9;
                break;
            case "October":
            case "Oct.":
            case "Oct":
            case "10":
                month = 10;
                break;
            case "November":
            case "Nov.":
            case "Nov":
            case "11":
                month = 11;
                break;
            case "December":
            case "Dec.":
            case "Dec":
            case "12":
                month = 12;
                break;
            default:
                System.out.println("Invalid month!"); 
                scanner.close();     
                return;
        }
        System.out.println("Enter a year (E.g: 1999): ");
        int year = scanner.nextInt();
        if (year <= 0) {
            System.out.println("Invalid year!");
            scanner.close();
            return;
        }
        scanner.close();
        boolean isLeapYear = false;
        /* Check leap year
         * If a year is fully divisible by 400 or 
         * is divisible by 4 and not divisible by 100, it is a leap year.
         * */
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) isLeapYear = true;
        if (isLeapYear && month == 2) {
			System.out.println("29 days."); // In Leap year, February has 29 days.
			return;
		} else if (month == 2) {
			System.out.println("28 days.");
			return;
		}
		switch (month) { // April, June, September and November have 30 days.
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("30 days.");
                return;
            default: // Otherwise 31 days.
                System.out.println("31 days.");     
                return;
        }
    }
}
