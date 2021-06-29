import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class RamdaPractice {
    static void ramda() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5); //1~5までの要素を持つリストを作成

        //メソッド参照を紐解く
        list.stream().forEach(System.out::println);

    }
}
