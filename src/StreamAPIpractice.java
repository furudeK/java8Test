import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPIpractice {
    public static void streamAPIpractice(){
        /**
         * 重複してる要素を消して1つにしたい
         * Appleが2、Orangeが3つ
         */
        List<String> list3 = new ArrayList<String>(Arrays.asList("Orange", "Apple", "Orange", "Melon", "Orange", "Apple"));

        //例えばこんな書き方(For)
        List<String> list4 = new ArrayList<>();
        for (String t : list3) {
            if (list4.contains(t)) {
                continue;
            } else {
                list4.add(t);
            }
        }
        System.out.println("For文とif文で記入した場合");
        System.out.println(list4);

        //Stream APIならこのような書き方ができる
        List<String> list6 = list3
                .stream() //Stream化
                .distinct() //要素同士を比較して、重複したものを除いたStreamを返す
                .collect(Collectors.toList());//終端操作、リストに変換する
        System.out.println("StreamAPIで記入した場合");
        System.out.println(list6);
    }

}
