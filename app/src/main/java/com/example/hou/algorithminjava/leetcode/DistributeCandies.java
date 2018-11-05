class DistributeCandies{
 

  public static int distributeCandies(int[] candies) {
        if (candies == null || candies.length == 0) {
            return 0;
        }
        int middle = candies.length/2;
        Arrays.sort(candies);
        LinkedList arrayList = new LinkedList();
        arrayList.add(candies[0]);
        for (int i = 0; i < candies.length; i++) {
            if ((int)arrayList.getLast()!=candies[i]&&arrayList.size()!=middle){
                arrayList.add(candies[i]);
            }
        }
        return arrayList.size();
    }
}
