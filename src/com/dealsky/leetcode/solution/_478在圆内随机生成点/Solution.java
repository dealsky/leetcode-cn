package com.dealsky.leetcode.solution._478在圆内随机生成点;

// https://leetcode-cn.com/problems/generate-random-point-in-a-circle/

import java.util.Arrays;
import java.util.Random;

/**
 * @author dealsky
 * @date 2021/2/25 上午11:49
 */
class Solution {

    private double radius;
    private double x;
    private double y;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        x = x_center;
        y = y_center;
    }

    public double[] randPoint() {
        double angle = Math.random() * 2 * Math.PI;
        double r = Math.sqrt(Math.random()) * radius;
        double y1 = r * Math.sin(angle);
        double x1 = r * Math.cos(angle);
        return new double[]{x + x1, y + y1};
    }

    public static void main(String[] args) {
        Solution solution = new Solution(1, 0, 0);
        for (int i = 0; i < 100; i++) {
            System.out.println(Arrays.toString(solution.randPoint()));
        }
    }

}
