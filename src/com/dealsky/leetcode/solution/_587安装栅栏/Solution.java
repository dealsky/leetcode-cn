package com.dealsky.leetcode.solution._587安装栅栏;

import java.util.*;

/**
 * @author dealsky
 * @date 2021/1/9 下午5:33
 */
public class Solution {

    public class Data {
        int x;
        int top;
        int bottom;
        List<Integer> yList = new ArrayList<>();

        public Data(int x, int y) {
            this.x = x;
            top = y;
            bottom = y;
            yList.add(y);
        }
    }

    public int[][] outerTrees(int[][] points) {
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        Map<Integer, Data> map = new TreeMap<>();
        for (int[] arr : points) {
            int x = arr[0];
            int y = arr[1];
            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);
            if (map.containsKey(x)) {
                Data data = map.get(x);
                data.top = Math.max(data.top, y);
                data.bottom = Math.min(data.bottom, y);
                data.yList.add(y);
            } else {
                Data data = new Data(x, y);
                map.put(x, data);
            }
        }

        List<Integer> keyList = new ArrayList<>(map.keySet());
        List<int[]> list = new ArrayList<>();
        if (keyList.size() > 0) {
            Data data = map.get(keyList.get(0));
            for (int y : data.yList) {
                list.add(new int[]{data.x, y});
            }
            if (keyList.size() > 1) {
                data = map.get(keyList.get(keyList.size() - 1));
                for (int y : data.yList) {
                    list.add(new int[]{data.x, y});
                }
            }
        }
        for (int i = 0; i < keyList.size() - 1; ) {
            Data data1 = map.get(keyList.get(i));
            double maxSlope = -1e10;
            int nextI = i + 1;
            for (int j = i + 1; j < keyList.size(); j++) {
                Data data2 = map.get(keyList.get(j));
                double slope = calcSlope(data1.x, data1.top, data2.x, data2.top);
                if (slope > maxSlope) {
                    maxSlope = slope;
                    nextI = j;
                }
            }
            for (int j = i + 1; j < keyList.size(); j++) {
                Data data2 = map.get(keyList.get(j));
                double slope = calcSlope(data1.x, data1.top, data2.x, data2.top);
                if (Math.abs(slope - maxSlope) < 1e-6) {
                    list.add(new int[]{data2.x, data2.top});
                }
            }
            i = nextI;
        }

        for (int i = 0; i < keyList.size() - 1; ) {
            Data data1 = map.get(keyList.get(i));
            double minSlope = 1e10;
            int nextI = i + 1;
            for (int j = i + 1; j < keyList.size(); j++) {
                Data data2 = map.get(keyList.get(j));
                double slope = calcSlope(data1.x, data1.bottom, data2.x, data2.bottom);
                if (slope < minSlope) {
                    minSlope = slope;
                    nextI = j;
                }
            }
            for (int j = i + 1; j < keyList.size(); j++) {
                Data data2 = map.get(keyList.get(j));
                double slope = calcSlope(data1.x, data1.bottom, data2.x, data2.bottom);
                if (Math.abs(slope - minSlope) < 1e-6) {
                    list.add(new int[]{data2.x, data2.bottom});
                }
            }
            i = nextI;
        }

        list.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        List<int[]> newList = new ArrayList<>();
        for (int[] arr : list) {
            if (newList.size() == 0) {
                newList.add(arr);
            } else {
                int[] last = newList.get(newList.size() - 1);
                if (last[0] != arr[0] || last[1] != arr[1]) {
                    newList.add(arr);
                }
            }
        }

        int[][] result = new int[newList.size()][];
        int i = 0;
        for (int[] arr : newList) {
            result[i++] = arr;
        }
        return result;
    }

    public double calcSlope(int x1, int y1, int x2, int y2) {
        if (x2 - x1 == 0) {
            return 0;
        }
        return (double) (y2 - y1) / (x2 - x1);
    }

    public static void main(String[] args) {
//        int[][] points = new int[][]{{1, 1}, {2, 2}, {2, 0}, {2, 4}, {3, 3}, {4, 2}};
//        int[][] points = new int[][]{{1, 1}, {2, 2}, {4, 2}};
        int[][] points = new int[][]{{3, 0}, {4, 0}, {5, 0}, {6, 1}, {7, 2}, {7, 3}, {7, 4}, {6, 5}, {5, 5}, {4, 5}, {3, 5}, {2, 5}, {1, 4}, {1, 3}, {1, 2}, {2, 1}, {4, 2}, {0, 3}};
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.outerTrees(points)));
    }

    // [[7,4],[5,0],[7,3],[2,1],[5,5],[4,5],[3,5],[7,2],[1,2],[1,4],[4,0],[2,5],[6,1],[6,5],[0,3],[3,0]]

}
