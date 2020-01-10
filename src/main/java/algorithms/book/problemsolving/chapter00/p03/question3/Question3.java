package algorithms.book.problemsolving.chapter00.p03.question3;

class Question3 {

    private static int count = 0;

    void rotationToRightForK(int arr[], int k) {
        int move = k % arr.length;
        recursiveRotation(arr, move, 0);
    }

    private void recursiveRotation(int arr[], int k, int sIdx) {

        count++;
        int toGoIdx = sIdx + k;
        if (toGoIdx >= arr.length) {
            toGoIdx -= arr.length;
        }

        if (count == arr.length) {
            return;
        }

        recursiveRotation(arr, k, toGoIdx);
        swap(arr, sIdx, toGoIdx);
    }

    private void swap(int arr[], int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
