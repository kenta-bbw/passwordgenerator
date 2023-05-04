import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {
        private String Lowercaseletters = "abcdefghijklmnopqrstuvwxyz";
        private String Uppercaseletters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        private String Numbers = "0123456789";
        private String Symbols = "!@#$%^&*()_+-=[]{}|;':\"<>,.?/~`";
        private Random Random = new Random();
        private Scanner Scanner = new Scanner(System.in);
        private int length;
        private boolean useLowercase;
        private boolean useUppercase;
        private boolean useNumbers;
        private boolean useSymbols;
    

    public String generate() {
        StringBuilder password = new StringBuilder();
        StringBuilder characterSet = new StringBuilder();

        if (useLowercase) {
            characterSet.append(Lowercaseletters);
        }
        if (useUppercase) {
            characterSet.append(Uppercaseletters);
        }
        if (useNumbers) {
            characterSet.append(Numbers);
        }
        if (useSymbols) {
            characterSet.append(Symbols);
        }

        int characterSetLength = characterSet.length();

        for (int i = 0; i < length; i++) {
            int index = Random.nextInt(characterSetLength);
            password.append(characterSet.charAt(index));
        }

        return password.toString();
    }

    public static void main(String[] args) {
        PasswordGenerator generator = new PasswordGenerator();

        System.out.println("How long should the Password be?");
        generator.length = Integer.parseInt(generator.Scanner.nextLine());

        System.out.println("Do you want to use lowercase letters? yes/no");
        generator.useLowercase = generator.Scanner.nextLine().equals("yes");

        System.out.println("Do you want to use uppercase letters? yes/no");
        generator.useUppercase = generator.Scanner.nextLine().equals("yes");

        System.out.println("Do you want to use Symbols? yes/no");
        generator.useSymbols = generator.Scanner.nextLine().equals("yes");

        System.out.println("Do you want to use Numbers? yes/no");
        generator.useNumbers = generator.Scanner.nextLine().equals("yes");

        String password = generator.generate();
        System.out.println(password);
    }
}