package GoldmanSachs;

// User function Template for Java

class Solution {
    public boolean canPair(int[] nums, int k) {
        // Code here
        boolean isVisited[] = new boolean[nums.length];
        if (nums.length % 2 != 0) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % k != 0) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (isVisited[i] == true) {
                continue;
            }
            boolean flag = false;
            for (int j = i + 1; j < nums.length; j++) {
                int pair = nums[j];
                if (isVisited[j] == false && (pair + curr) % k == 0) {
                    isVisited[j] = true;
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                return false;
            } else {
                isVisited[i] = true;
            }
        }

        return true;
    }
}

// class Solution {
// public boolean canPair(int[] nums, int k) {
// // Code here
// HashMap<Integer,Integer> hm =new HashMap<>();
// for(int i=0;i<nums.length;i++){
// int rem=nums[i]%k;
// hm.put(rem,hm.getOrDefault(rem,0)+1);
// }

// for(int i=0;i<nums.length;i++){
// int rem=nums[i]%k;
// int frequency=hm.get(rem);

// if(rem==0){
// if(frequency%2!=0){
// return false;
// }else{

// continue;
// }
// }
// if(2*rem==k){
// if(frequency%2!=0){
// return false;
// }else{
// continue;
// }
// }

// int pair=k-rem;
// if(!hm.containsKey(pair)){
// return false;
// }else{
// if(hm.get(pair)!=frequency){
// return false;
// }
// }

// }
// return true;
// }
// }