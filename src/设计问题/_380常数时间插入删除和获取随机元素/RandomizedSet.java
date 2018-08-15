package 设计问题._380常数时间插入删除和获取随机元素;

// https://leetcode-cn.com/problems/insert-delete-getrandom-o1/description/

import java.util.*;

public class RandomizedSet {

    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            map.put(val, list.size());
            list.add(val);

            return true;
        }
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        } else {
            int index = map.get(val);
            map.remove(val);

            if (index != list.size() - 1) {
                int lastVal = list.get(list.size() - 1);
                list.set(index, lastVal);
                map.put(lastVal, index);
            }

            list.remove(list.size() - 1);

            return true;
        }
    }

    public int getRandom() {
        try {
            return list.get(random.nextInt(list.size()));
        } catch (Exception e) {
            return -1;
        }
    }
}
