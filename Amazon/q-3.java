package Amazon;

import java.util.*;

class Solution {
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        // Your code here
        ArrayList<Integer> al = new ArrayList<>();

        if (arr.length < k) {
            return al;
        }
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.removeLast();
            }

            dq.addLast(i);
        }

        for (int i = k; i < n; i++) {
            al.add(arr[dq.peekFirst()]);

            // Check whether the greatest element is in range
            // Remove outdated: out-of-range elements

            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.removeFirst();
            }

            // Check the smaller elements
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.removeLast();
            }

            dq.addLast(i);

        }
        al.add(arr[dq.peekFirst()]);

        return al;

    }
}
// O(n^2log(k)) - Time Complexity
// class Solution {
// static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
// // Your code here
// ArrayList<Integer> res=new ArrayList<>();
// PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
// int tracker=0;
// for(int i=0;i<n;i++){
// pq.add(arr[i]);
// if(i>=k-1){
// int element=pq.peek();
// res.add(element);
// pq.remove(arr[tracker]);
// tracker++;
// }
// }

// return res;
// }
// }
