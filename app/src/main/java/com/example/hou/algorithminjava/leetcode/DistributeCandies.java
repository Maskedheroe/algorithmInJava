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
 
 
 public int distributeCandies(int[] candies) {  
        Set<Integer> set = new HashSet<Integer>();
        for(int x : candies) {
            set.add(x);
        }
        return set.size() > candies.length / 2 ? candies.length / 2 : set.size();
    }
 
 //HashSet的特点hashset的特点
无序性
唯一性（允许使用null）
本质上来讲就是hashmap
需要重写hashcode（）方法和equals（）方法（这是废话，是个集合类都需要重写）
HashSet没有提供get()方法，同HashMap一样，因为Set内部是无序的，所以只能通过迭代的方式获得
hashset和hashmap的联系
HashSet初始化（构造方法）是采用HashMap实现的（不信看源码），也就是说hashset=hashmap的实例，
 HashSet 的绝大部分方法都是通过调用 HashMap 的方法来实现的
HashMap的key=HashSet的对象，HashMap的value=HashSet中定义的一个统一常量private static final Object PRESENT = new Object()。  
 也就是说，在hashset中，我们用add方法添加元素时，传给底层hashmap实例的还是键值对（两个对象），
 只不过key直接就是对象元素本身，而value则是一个object常量（这就是让我们把这个value忽略掉，当成只传了一个对象）
hashset中的添加方法是add，而hashmap中的添加方法是put。                                                                                 
 put（）方法应用于map集合中，add（）方法应用于set集合中。                                                                                                                 
 二者的主要区别是：返回值类型不一样。add（）放回布尔（boolean）类型。                                                                                             
 因为像Set集合中不允许添加重复的元素。当HashSet调用add（）方法时，如果返回false，表示添加不成功。                                               
 put（）的使用是：添加时出现相同的键，那么后添加的值会替换（覆盖）掉此键对应的原来的值。并返回此键对应的原来的值。

 
}
