import java.util.Arrays;

public class ArrayValueCalculator {

    public int doCalc(String[][] data) throws ArraySizeException, ArrayDataException {
        if (!isCorrectSize(data)) {
            throw new ArraySizeException("Incorrect array size.");
        }

        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                sum += parseInt(data[i][j], i, j);
            }
        }
        return sum;
    }

    public int doCalcWithStreams(String[][] data) throws ArraySizeException, ArrayDataException {
        if (!isCorrectSize(data)) {
            throw new ArraySizeException("Incorrect array size.");
        }
        try {
            return Arrays.stream(data)
                    .flatMap(Arrays::stream)
                    .mapToInt(Integer::parseInt)
                    .sum();
        } catch (NumberFormatException e) {
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    parseInt(data[i][j], i, j);
                }
            }
            return 0;
        }
    }

    private boolean isCorrectSize(String[][] data) {
        if (data.length != 4) {
            return false;
        }
        for (String[] arr : data) {
            if (arr.length != 4) {
                return false;
            }
        }
        return true;
    }

    private int parseInt(String arrElement, int i, int j) throws ArrayDataException {
        try {
            return Integer.parseInt(arrElement);
        } catch (NumberFormatException e) {
            throw new ArrayDataException("Invalid data at position : [" + i + "][" + j + "]");
        }
    }
}