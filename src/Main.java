import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        List<Integer> intListResult = new ArrayList<>();
        for (int value : intList) {
            if (value > 0 && value % 2 == 0) intListResult.add(value);
        }
        quickSort(intListResult, 0, intListResult.size() - 1);
        for (int value : intListResult) {
            System.out.println(value);
        }
    }

    public static void quickSort(List<Integer> intList, int low, int high) {
        if (intList.size() == 0) return;
        if (low >= high) return;
        int middle = low + (high - low) / 2;
        int base = intList.get(middle);
        int i = low, j = high;
        while (i <= j) {
            while (intList.get(i) < base) {
                i++;
            }
            while (intList.get(j) > base) {
                j--;
            }
            if (i <= j) {
                int buff = intList.get(i);
                intList.set(i, intList.get(j));
                intList.set(j, buff);
                i++;
                j--;
            }
        }
        if (low < j) quickSort(intList, low, j);
        if (high > i) quickSort(intList, i, high);
    }
}
