package HomeWork1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Created by Roman Omelchenko on ${29.10.2016}.
 */
public class PhoneNumberValidator {

        private static String phoneNumber;
        private static Integer summaryNumber;

        public static void main(String[] args) throws IOException {
            getValidatePhoneNumber();
            getPhoneNumber();
            getCalculationNumber();
            outputResult();
        }

        private static void outputResult() {

            System.out.print("Final result is: ");
            switch (summaryNumber){
                case 1:
                    System.out.println("One");
                    break;
                case 2:
                    System.out.println("Two");
                    break;
                case 3:
                    System.out.println("Three");
                    break;
                case 4:
                    System.out.println("Four");
                    break;
                case 5:
                    System.out.println("Five");
                    break;
                default:
                    System.out.println(summaryNumber);
                    break;
            }
        }

        private static void getCalculationNumber() {

            char[] phoneNumbersArray;
            do {
                summaryNumber = 0;
                phoneNumbersArray = phoneNumber.toCharArray();
                for (char chars : phoneNumbersArray) {
                    summaryNumber += Character.getNumericValue(chars);
                }
                phoneNumber = summaryNumber.toString();
            } while (!(phoneNumber.length() == 1));
        }

        private static void getPhoneNumber() throws IOException {
            Scanner scanner = new Scanner(phoneNumber);
            phoneNumber = scanner.findInLine("\\d");

            System.out.println("Input phone number. (Example: 0631111111)\n");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            phoneNumber = reader.readLine();
        }

        private static void getValidatePhoneNumber() throws IOException {
            Matcher matcher;
            do {
                getPhoneNumber();
                Pattern pattern = Pattern.compile("(050|063|066|067|068|093|095|096|097|098|099)\\d{7}");
                matcher = pattern.matcher(phoneNumber);
            } while (!matcher.matches());
        }
}
