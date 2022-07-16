/**
 * @author Dm.Petrov
 * DATE: 16.07.2022
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {14, 16, 19, 32, 32, 32, 56, 69, 72};
        System.out.println(calculatingTheNumberOfLargeSizedBooks(arr, 60));
    }

    public static int calculatingTheNumberOfLargeSizedBooks(int[] arr, int newBookSize) {

        if(newBookSize<0){
            return -1;
        }
        if (newBookSize < arr[0]) {
            return arr.length;
        }
        if (newBookSize >= arr[arr.length-1]) {
            return 0;
        }
        int left = 0;
        int right = arr.length - 1;
        int result = 0;
        while (left < right) {
            int middle = (left + right) / 2;
            if (arr[middle] > newBookSize && arr[middle - 1] <= newBookSize) {
                result = arr.length - middle;
                break;
            } else if (arr[middle] <= newBookSize) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        if (left == right) {
            return 1;
        }
        return result;
    }

}
