public class SearchRotate {
    public static int rotatedSeach(int arr[], int target, int si, int ei) {
        if (si > ei) {
            return -1;
        }
        int mid = si + (ei - si) / 2;
        if (arr[mid] == target) {
            return mid + 1;
        }
        if (arr[si] <= arr[mid]) {
            if (arr[si] <= target && target <= arr[mid - 1]) {
                return rotatedSeach(arr, target, si, mid - 1);
            } else {
                return rotatedSeach(arr, target, mid + 1, ei);
            }
        } else {
            if (arr[mid + 1] <= target && target <= arr[ei]) {
                return rotatedSeach(arr, target, mid + 1, ei);
            } else {
                return rotatedSeach(arr, target, si, mid - 1);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 4, 5, 6, 7, 0, 1, 2, 3 };
        System.out.println("Position of target in the array: " + rotatedSeach(arr, 0, 0, arr.length));
    }
}