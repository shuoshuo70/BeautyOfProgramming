package Chapter1;

/**
 * Created by shuoshu on 2018/1/1.
 */
public class Floor {
    public static void main(String[] args) {
        Floor solution = new Floor();
        int[] persons = {2, 3, 1, 5, 2};
        System.out.println(solution.getFloor(persons, 2));
    }

    public int getFloor(int[] persons, int k) {
        int n1 = 0, n2 = persons[0], n3 = 0, total = 0;
        for (int i = 1; i < persons.length; i++) {
            n3 += persons[i];
            total += persons[i] * i;
        }

        int targetFloor = 1;
        for (int i = 1; i < persons.length; i++) {
            if (n1 + n2 < n3 * k) {
                total += n1 + n2 - n3;
                n1 += n2;
                n2 = persons[i];
                n3 -= persons[i];
                targetFloor = i + 1;
            } else {
                break;
            }
        }


        return targetFloor;
    }
}
