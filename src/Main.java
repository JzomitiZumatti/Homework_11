public class Main {
    public static void main(String[] args) {
        ArrayValueCalculator calculator = new ArrayValueCalculator();


        String[][][] test = {
                {{"1", "2", "3", "4"}, {"6", "7", "8","9"}, {"5", "3", "7", "1"}, {"2", "4", "5", "8"}},
                {{"1", "2", "three", "4"}, {"6", "7", "8","9"}, {"5", "3", "7", "1"}, {"2", "4", "5", "8"}},
                null,
                {{"1", "2", "3"}, {"6", "7", "8","9"}, {"5", "3", "7", "1"}, {"2", "4", "5", "8"}},
        };

        System.out.println("Without streams: ");
        for (String[][] testArray : test) {
            try {
                System.out.println(calculator.doCalc(testArray));
            } catch (ArraySizeException | ArrayDataException exception) {
                System.out.println(exception.getMessage());
            } catch (NullPointerException exception) {
                System.out.println("Array = null");
            }
        }

        System.out.println("\nUsing streams: ");
        for (String[][] testArray : test) {
            try {
                System.out.println(calculator.doCalcWithStreams(testArray));
            } catch (ArraySizeException | ArrayDataException exception) {
                System.out.println(exception.getMessage());
            } catch (NullPointerException exception) {
                System.out.println("Array = null");
            }
        }
    }
}
