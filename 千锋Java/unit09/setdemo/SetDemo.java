package com.unit09.setdemo;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Set接口
 *      1. 无序的（不保证顺序）
 *      2. 不允许重复元素
 * 具体实现子类
 *      HashSet、TreeSet、LinkedHashSet
 *
 * 如果要排序，选择TreeSet
 * 如果不要排序，也不用保证顺序 选择HashSet
 * 不要排序，要保证顺序 选择LinkedHashSet
 * @author littlecorgi_a1203991686@126.com
 * @Date 2018/07/25 11:06
 */
public class SetDemo {

    /*
     * LinkedHashSet
     * 哈希表和链接列表实现
     * 维护着一个运行所有条目的双重链接列表。此链接列表定义了迭代顺序，即按照将元素插入到set中的顺序（插入顺序）进行迭代
     */
    private static void linkerHashSet(){
        LinkedHashSet<Cat> set = new LinkedHashSet<>();
        Cat c1 = new Cat("miaomiao",5,1);
        Cat c2 = new Cat("huahua",2,2);
        Cat c3 = new Cat("tom",5,3);
        Cat c4 = new Cat("miaomiao",3,1);
        set.add(c1);
        set.add(c2);
        set.add(c3);
        set.add(c4);
        for (Cat c : set){
            System.out.println(c);
        }
    }

    /*
     * TreeSet
     * 有序的，基于TreeMap（二叉树数据结构），对象需要比较大小通过对象比价器来实现。
     * 对象比较器还可以用来去除重复元素，如果自定义的数据类，没有实现比较器接口，将无法添加到TreeSet集合中
     */
    private static void treeSet(){
        TreeSet<Cat> tree = new TreeSet<>(new CatComparator());
        Cat c1 = new Cat("miaomiao",5,1);
        Cat c2 = new Cat("huahua",2,2);
        Cat c3 = new Cat("tom",5,3);
        Cat c4 = new Cat("miaomiao",3,1);
        tree.add(c1);
        tree.add(c2);
        tree.add(c3);
        tree.add(c4);
        System.out.println(tree.size());
        for (Cat x : tree){
            System.out.println(x);
        }
    }

    /*
     * HashSet
     *      1. 实现原理，基于哈希表(HashMap)实现
     *      2. 不允许重复，可以有一个null元素
     *      3. 不保证顺序恒久不变
     *      4. 添加元素时把元素作为HashMap的key存储，HashMap的value使用一个固定的Object对象
     *      5. 排除重复元素是通过equals来检查对象时候相同
     *      6. 判断两个对象时候相同，先判断两个对象的hashCode是否相同（如果两个对象的hashCode相同，未必是同一的对象；如果不同，那就一定不是同一个对象），
     *         如果不同，则两个对象不是同一对象，如果相同，还要进行判断equals判断，equals相同则是同一个对象，不同则不是。
     *      7. 自定义对象要认为属性值都相同时，为同一个对象，有这种需求时，那么我们要重写对象所在类的hashCode和equals方法
     *
     * 小结
     * (1) 哈希表的存储结构：数组+链表，数组里的每个元素以链表的形式存储
     * (2）如何把对象存储到哈希表中，先计算对象的hashCode值，在对数组长度求余数，来决定对象要存储在数组中的那个位置
     * (3) 解决hashSet中的重复值使用的方式是，参考第6点
     */
    private static void hashSet(){
        Set<String> set = new HashSet<>();
        set.add("飞飞");
        set.add("备备");
        set.add("亮亮");
        set.add("关关");
        set.add("曹操");
        set.add("亮亮"); //覆盖了之前的元素

        // String[] names = (String[])set.toArray();
        String[] names = set.toArray(new String[]{});
        for (String s : names){
            System.out.println(s);
        }

        Set<Cat> cats = new HashSet<>();
        Cat c1 = new Cat("miaomiao",5,1);
        Cat c2 = new Cat("huahua",2,2);
        Cat c3 = new Cat("tom",5,3);
        Cat c4 = new Cat("miaomiao",5,1);
        cats.add(c1);
        cats.add(c2);
        cats.add(c3);
        cats.add(c4);
        // cats.add(c1);
        System.out.println(cats.size());

        for (Cat c : cats){
            System.out.println(c);
        }
        System.out.println("c1=" + c1.hashCode());
        System.out.println("c2=" + c2.hashCode());
        System.out.println("c3=" + c3.hashCode());
        System.out.println("c4=" + c4.hashCode());
    }
    public static void main(String[] args) {
        // hashSet();
        // treeSet();
        linkerHashSet();
    }
}
