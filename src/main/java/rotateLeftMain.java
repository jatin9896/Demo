import java.util.ArrayList;
import java.util.List;

public class rotateLeftMain {
    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        // Write your code here
        int i=0;
        int start=0;
        int temp = arr.get(0);
        if(d>arr.size()) {
            d=d%arr.size();
        }
        while(start < arr.size()) {
            int position = (i-d) >= 0 ? (i-d): (arr.size() + (i-d));
            int last = arr.get(position);
            arr.set(position, temp);
            temp = last;
            i = position;
            start++;
        }
        return arr;

    }

    public static void main(String[] args) {
        ArrayList<Integer> ar =new ArrayList<>();

//        98 67 35 1 74 79 7 26 54 63 24 17 32 81

        ar.add(98);
        ar.add(67);
        ar.add(35);
        ar.add(1);
        ar.add(74);
        ar.add(79);
        ar.add(7);
        ar.add(26);
        ar.add(54);
        ar.add(63);
        ar.add(24);
        ar.add(17);
        ar.add(32);
        ar.add(81);
        ar.remove(7);
        List list = rotateLeft(7, ar);
        list.add(0,26);
        //26 54 63 24 17 32 81 98 67 35 1 74 79 7
        System.out.println(list);
    }
}
