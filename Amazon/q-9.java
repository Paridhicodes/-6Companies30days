package Amazon;

import java.util.*;
//User function Template for Java

class Solution {
    static int isValid(int mat[][]) {
        // code here
        HashSet<Integer> hs1 = new HashSet<>();
        HashSet<Integer> hs2 = new HashSet<>();
        // Checking row Validity
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (hs1.contains(mat[i][j])) {
                    return 0;
                } else {
                    if (mat[i][j] != 0) {
                        hs1.add(mat[i][j]);
                    }
                }
                if (hs2.contains(mat[j][i])) {
                    return 0;
                } else {
                    if (mat[j][i] != 0) {
                        hs2.add(mat[j][i]);
                    }
                }
            }

            hs1 = new HashSet<>();
            hs2 = new HashSet<>();
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                boolean res = checkSquare(i, j, mat);
                if (res == false) {
                    return 0;
                }
            }
        }

        return 1;

    }

    public static boolean checkSquare(int r, int c, int mat[][]) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (mat[i][j] != 0) {
                    if (hs.contains(mat[i][j])) {
                        return false;
                    }
                    hs.add(mat[i][j]);
                }
            }
        }
        return true;
    }
}
