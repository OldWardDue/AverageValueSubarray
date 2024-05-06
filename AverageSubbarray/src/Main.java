import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        System.out.println("EEEVVVEEVV");           //puke sounds
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 5));
        int k = 2;

        getRollingAverage(arr, k);
    }

    public static void getRollingAverage(ArrayList<Integer> arr, int k) {
        LinkedList<Integer> subarray = new LinkedList<>();           //создаем листик для "окна"
        ArrayList<Double> res = new ArrayList<>();                   //в этот array запихнем результаты с типом double
        Double sum = 0.0;                                            //для суммирования элементов между собой

        for (int i = 0; i < k; i++) {
            subarray.add(arr.get(i));
            sum += arr.get(i);
        }

        res.add(sum/k);                                           //результат первого подмассива

        for (int i = k; i < arr.size(); i++) {
            subarray.add(arr.get(i));
            subarray.remove();

            sum = subarray.stream().mapToDouble(Double::valueOf).sum();                     //работаем с каждым элементом

            res.add(sum/k);                                              //кладем остальные в array под именем res
        }
        System.out.println(res);
    }
}
