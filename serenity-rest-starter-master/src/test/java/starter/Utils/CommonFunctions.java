package starter.Utils;

public class CommonFunctions {

    /* This method generates the random alphabets of any given length
     * @param length
     * @return alphanumeric characters
     */
    public static String generateRandomAlphabets(int length) {
        String alphabets = "";
        try {
            for (int i = 1; i <= length; i++) {
                alphabets += (char) (Math.random() * ('Z' - 'A' + 1) + 'A');
            }
            return alphabets;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return alphabets;
    }
}
