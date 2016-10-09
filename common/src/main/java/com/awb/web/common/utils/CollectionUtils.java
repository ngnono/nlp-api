package com.awb.web.common.utils;

import java.util.*;

/**
 * Created by lianghongpeng on 2016/10/8.
 */
public class CollectionUtils {

    /**
     * 集合类型转换 其实 是新建了一个类型 copy
     *
     * @param collection 集合参数
     * @param <T>
     * @return
     */
    public static <T> List<T> toList(Collection<T> collection) {

        ArrayList<T> list = toArray(collection);

        return list;
    }

    /**
     * 集合类型转换 其实 是新建了一个类型 copy
     *
     * @param collection
     * @param <T>
     * @return
     */
    public static <T> ArrayList<T> toArray(Collection<T> collection) {
        if (collection == null) {
            return new ArrayList<>(0);
        }

        Iterator<T> iterator = collection.iterator();

        ArrayList<T> list = new ArrayList<>();

        iterator.forEachRemaining(list::add);

        return list;
    }

    /**
     * 排序
     * @param collection
     * @param <T>
     * @return
     */
    public static <T> ArrayList<T> sort(ArrayList<T> collection, Comparator<T> comparator) {

        Collections.sort(collection, comparator);

        return collection;

//        Collections.sort(collection, new Comparator<Fruit>() {
//            @Override
//            public int compare(Fruit fruit2, Fruit fruit1)
//            {
//
//                return  fruit1.fruitName.compareTo(fruit2.fruitName);
//            }
//        });

    }

    /**
     * 检查集合
     *
     * @param arrayList
     * @param <T>
     * @return
     */
    private static <T> boolean check(ArrayList<T> arrayList) {
        if (arrayList == null) {
            throw new IllegalArgumentException("arrayList not null");
        }

        return true;
    }

    /**
     * 取数据
     *
     * @param collection
     * @param take
     * @param <T>
     * @return
     */
    public static <T> ArrayList<T> take(ArrayList<T> collection, Integer take) {

        check(collection);

        if(collection.size() ==0){
            return  collection;
        }

        if (take != null) {

            if (take >= collection.size()) {
                return collection;
            }

            if (take <= 0) {
                return new ArrayList<>(0);
            }

            ArrayList<T> result = new ArrayList<>(take);
            for (int i = 0; i < take; i++) {
                result.add(collection.get(i));
            }

            return result;
        }

        return collection;
    }

    /**
     * 跳过数据
     *
     * @param collection 集合
     * @param skip
     * @param <T>
     * @return
     */
    public static <T> ArrayList<T> skip(ArrayList<T> collection, Integer skip) {
        check(collection);

        if(collection.size() ==0){
            return collection;
        }

        if (skip != null) {

            if (skip >= collection.size()) {
                return new ArrayList<>(0);
            }

            if (skip == 0) {
                return collection;
            }

            ArrayList<T> result = new ArrayList<>(collection.size() - skip);

            for (int i = skip; i < collection.size(); i++) {

                result.add(collection.get(i));
            }

            return result;
        }

        return collection;
    }
}
