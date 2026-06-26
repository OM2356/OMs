class Solution {
    class Fenwick {
        long[] bit;
        int n;

        Fenwick(int n) {
            this.n = n;
            bit = new long[n + 1];
        }

        void update(int idx, long val) {
            while (idx <= n) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        long query(int idx) {
            long res = 0;
            while (idx > 0) {
                res += bit[idx];
                idx -= idx & -idx;
            }
            return res;
        }
    }

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        long[] pref = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + (nums[i] == target ? 1 : -1);
        }

        long[] vals = pref.clone();
        java.util.Arrays.sort(vals);

        int m = 0;
        for (int i = 0; i < vals.length; i++) {
            if (i == 0 || vals[i] != vals[i - 1]) {
                vals[m++] = vals[i];
            }
        }

        Fenwick ft = new Fenwick(m);
        long ans = 0;

        for (long p : pref) {
            int rank = lowerBound(vals, m, p) + 1;

            // count previous prefix sums strictly smaller than p
            ans += ft.query(rank - 1);

            ft.update(rank, 1);
        }

        return ans;
    }

    private int lowerBound(long[] arr, int len, long target) {
        int l = 0, r = len;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}