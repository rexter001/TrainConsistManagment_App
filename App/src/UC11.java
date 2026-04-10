import java.util.Scanner;
import java.util.regex.Pattern;

public class UC11 {

    public static boolean isValidTrainId(String trainId) {
        return Pattern.matches("TRN-\\d{4}", trainId);
    }

    public static boolean isValidCargoCode(String cargoCode) {
        return Pattern.matches("PET-[A-Z]{2}", cargoCode);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println(" UC11 - Validate Train ID and Cargo Code ");
        System.out.println("====================================\n");

        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        boolean trainValid = isValidTrainId(trainId);
        boolean cargoValid = isValidCargoCode(cargoCode);

        System.out.println("\nValidation Results:");
        System.out.println("Train ID Valid: " + trainValid);
        System.out.println("Cargo Code Valid: " + cargoValid);

        System.out.println("\nUC11 validation completed...");
    }
}