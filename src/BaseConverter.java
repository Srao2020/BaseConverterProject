import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Javadoc me
 * @version 11.30.2022
 * @author Srao2020
 */
public class BaseConverter {
    private final String DIGITS = "0123456789ABCDEF";
    /**
     * Convert a String num in fromBase to base-10 int.
     * @param num the original number
     * @param fromBase the original from base
     * @return a base-10 int of num base fromBase
     */
    public int strToInt(String num, String fromBase)    {
        int value = 0, exp = 0;
        for ( int i = num.length() - 1; i >= 0; i--) {
            value += DIGITS.indexOf(num.charAt(i)) * Math.pow(Integer.parseInt(fromBase), exp);
            exp++;
        }
        //String s = "" + 'c';
        return value;
    }

    /**
     * Javadoc me
     * @param num
     * @param toBase
     * @return
     */
    public String intToStr(int num, int toBase) {
        //value = DIGITS.charAt(num % toBase) + value;

        String toNum = new String();
        int index = -1;
        while (num > 0) {
            index = num % toBase;
            toNum = DIGITS.charAt(index) + toNum;
            num /= toBase;
        }
        return (toNum.equals("")) ? "0" : toNum;
    }

    /**
     * Javadoc me
     */
    public void inputConvertPrintWrite() {
        Scanner in = null;
        PrintWriter out = null;
        try {
            in = new Scanner(new File ("datafiles/values20.dat"));
            out = new PrintWriter(new File("datafiles/converted.dat"));
            String[] line;
            String output;
            while(in.hasNext()) {
                //for (String item : line)
                    //System.out.print(item + "hi");
                line = in.nextLine().split("\t");
                if (Integer.parseInt(line[1]) < 2 || Integer.parseInt(line[1]) > 16)
                    System.out.println("Invalid input base " + line[1]);
                else if (Integer.parseInt(line[2]) < 2 || Integer.parseInt(line[2]) > 16)
                    System.out.println("Invalid input base " + line[2]);
                else {
                    output = intToStr(strToInt(line[0], line[1]), Integer.parseInt(line[2]));
                    out.println(line[0] + "\t" + line[1] + "\t" + output + "\t" + line[2]);
                    System.out.println(line[0] + "base" + line[1] + " = " + output + " base " + line[2]);
                }


                //System.out.println(line[0]);
                //System.out.println(line[1]);
                //System.out.println(line[2]);
                //System.out.println(line.split("\t"));
            }
            if (out != null)
                out.close();
            if (out != null)
                out.close();
        }
        catch(Exception e) {
            System.out.println("Something bad happened. Details here:" +e.toString());
        }
    }

    /**
     * Javadoc me
     * @param args
     */
    public static void main(String[] args) {
        BaseConverter bc = new BaseConverter();
        bc.strToInt("","");
        bc.inputConvertPrintWrite();
    }
}

/*
String toNum = "";
while base-10 num >0

while b10num > 0:
    toNum = "" A+3+ 4
    b10Num /= 13; --> 2
 */