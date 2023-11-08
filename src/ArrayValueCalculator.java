import java.util.Arrays;

public class ArrayValueCalculator {

    public int doCalc(String[][] twoDimArr) throws ArraySizeException, ArrayDataException {
        if (!isCorrectSize(twoDimArr)) {
            throw new ArraySizeException("Incorrect array size.");
        }

        int sum = 0;
        for (int i = 0; i < twoDimArr.length; i++) {
            for (int j = 0; j < twoDimArr[i].length; j++) {
                sum += parseInt(twoDimArr[i][j], i, j);
            }
        }
        return sum;
    }

    public int doCalcWithStreams(String[][] twoDimArr) throws ArraySizeException, ArrayDataException {
        if (!isCorrectSize(twoDimArr)) {
            throw new ArraySizeException("Incorrect array size.");
        }
        try {
            return Arrays.stream(twoDimArr)
                    .flatMap(Arrays::stream)
                    .mapToInt(Integer::parseInt)
                    .sum();
        } catch (NumberFormatException e) {
            for (int i = 0; i < twoDimArr.length; i++) {
                for (int j = 0; j < twoDimArr[i].length; j++) {
                    parseInt(twoDimArr[i][j], i, j);
                }
            }
            return 0;
        }
    }

    private boolean isCorrectSize(String[][] twoDimArr) {
        if (twoDimArr.length != 4) {
            return false;
        }
        for (String[] arr : twoDimArr) {
            if (arr.length != 4) {
                return false;
            }
        }
        return true;
    }

    private int parseInt(String str, int i, int j) throws ArrayDataException {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new ArrayDataException("Invalid data at position : [" + i + "][" + j + "]");
        }
    }
}




    /*public int doCalc(String[][] twoDimArr) throws ArraySizeException, ArrayDataException {
        int sum = 0;
        for (int i = 0; i < twoDimArr.length; i++) {
            for (int j = 0; j < twoDimArr[i].length; j++) {
                if (twoDimArr.length != 4 || twoDimArr[i].length != 4)
                    throw new ArraySizeException("Incorrect array size in " + (i + 1) + " row.");
                try {
                    sum += Integer.parseInt(twoDimArr[i][j]);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException("Invalid data at position : [" + i + "][" + j + "]");
                }
            }
        }
        return sum;
    }*/

/*public int doCalWithStreams(String[][] twoDimArr) throws ArraySizeException, ArrayDataException {
        if (twoDimArr.length != 4 || !Arrays.stream(twoDimArr).allMatch(a -> a.length == 4)) {
            throw new ArraySizeException("Incorrect array size.");
        }
        try {
            return Arrays.stream(twoDimArr)
                    .flatMap(Arrays::stream)
                    .mapToInt(Integer::parseInt)
                    .sum();
        } catch (NumberFormatException e) {
            for (int i = 0; i < twoDimArr.length; i++) {
                for (int j = 0; j < twoDimArr[i].length; j++) {
                    try {
                        Integer.parseInt(twoDimArr[i][j]);
                    } catch (NumberFormatException ex) {
                        throw new ArrayDataException("Invalid data at position : [" + i + "][" + j + "]");
                    }
                }
            }
            return 0;
        }
    }*/