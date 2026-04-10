public class UC15 {

    // ---- CUSTOM RUNTIME EXCEPTION ----
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    // ---- GOODS BOGIE MODEL ----
    static class GoodsBogie {
        String shape;
        String cargo;
        boolean validationCompleted = false;

        GoodsBogie(String shape) {
            this.shape = shape;
        }

        void assignCargo(String cargo) {
            try {
                // Rule: Rectangular bogie cannot carry Petroleum
                if (shape.equals("Rectangular") &&
                        cargo.equals("Petroleum")) {

                    throw new CargoSafetyException(
                            "Unsafe cargo assignment!"
                    );
                }

                this.cargo = cargo;

                System.out.println(
                        "Cargo assigned successfully -> " + cargo
                );

            } catch (CargoSafetyException e) {

                System.out.println("Error: " + e.getMessage());

            } finally {

                validationCompleted = true;

                System.out.println(
                        "Cargo validation completed for "
                                + shape + " bogie"
                );
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println(" UC15 - Safe Cargo Assignment ");
        System.out.println("=================================\n");

        GoodsBogie safe = new GoodsBogie("Cylindrical");
        safe.assignCargo("Petroleum");

        System.out.println();

        GoodsBogie unsafe = new GoodsBogie("Rectangular");
        unsafe.assignCargo("Petroleum");

        System.out.println("\nUC15 runtime handling completed...");
    }
}