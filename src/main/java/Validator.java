public class Validator {

    public static boolean validatePesel(String pesel){
        String peselarray[] = pesel.split("");
        int[] check = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
        int numpesel[] = new int[peselarray.length];
        for (int i = 0; i < peselarray.length; i++) {
            numpesel[i] = Integer.parseInt(peselarray[i]);
        }

        if (numpesel.length != 11) {
            return false;
        } else {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum = sum + numpesel[i] * check[i];
            }
            sum = sum % 10;
            if (sum != 0) {
                sum = 10 - sum;
            }
            return sum == numpesel[10];
        }
    }
}
