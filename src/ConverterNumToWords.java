public class ConverterNumToWords {

    private static final String[] units = {
            "", "one", "two", "three", "four", "five", "six", "seven",
            "eight", "nine", "ten", "eleven", "twelve"
    };

    private static final String[] specialUnits = {
            "", "", "twen", "thir", "for", "fif", "","","eigh"
    };


    private static String convertSpecialUnits(final int unit) {
            return specialUnits[unit];
        }

    private static String convertUnits(final int unit) {
        return units[unit];
    }


     public static String convert(final int num) {
         if (num == 0) {
             return "zero";
         }
         if (num < 0) {
             return "minus " + convert(num);
         }
         if (num < 13)
            return  convertUnits(num);
         if ((num < 16 || num== 18) && num!= 14)
             return  convertSpecialUnits(num%10) + "teen";
         if (num < 20)
            return  convertUnits(num%10) + "teen";
         if (num < 60 || (num>=80 && num <90))
             return  convertSpecialUnits(num/10) + "ty " + convertUnits(num%10);
         if (num < 100)
             return  convertUnits(num/10) + "ty " + convertUnits(num%10);
         if (num < 1000)
             return  convertUnits(num/100) + " hundred " + convert(num%100);
         if (num < 1000000)
            return  convert(num/1000) + " thousand " + convert(num%1000);
         if (num < 1000000000)
            return  convert(num/1000000) + " million " + convert(num%1000000);
         return  convert(num/1000000000) + " billion " + convert(num%1000000000);
     }

}

