class DistributeCandies{
 public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        ArrayList temp = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j] && !temp.contains(nums1[i])) {
                    temp.add(nums1[i]);
                }
            }
        }
        int[] a = new int[temp.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) temp.get(i);
        }
        return a;

        /*
        这是 O(n)的解答
        public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 != null && nums1.length > 0 && nums2 != null && nums2.length > 0) {
            Set<Integer> set = new HashSet<>();
            for (int i : nums1) {
                set.add(i);
            }
            Set<Integer> intersectSet = new HashSet<>();
            for (int i : nums2) {
                if (set.contains(i)) {
                    intersectSet.add(i);
                }
            }
            int[] result = new int[intersectSet.size()];
            int index = 0;
            for (int integer : intersectSet) {
                result[index] = integer;
                index++;
            }
            return result;
        }
        return new int[0];
    }
        * */
    }


}
