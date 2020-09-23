package day23_09;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();

        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(5);
        nums.add(0);

        nums.remove(nums.size()-1);
        System.out.println(nums);
    }
}
