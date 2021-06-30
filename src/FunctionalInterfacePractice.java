import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionalInterfacePractice {
    /**
     * 関数型インタフェース
     * Consumer < T > ：T型の引数を受け取って、戻り値無しの処理を実装する
     * Function < T, R > (Tは引数の型、Rは戻り値の型）：T型の引数を受け取ってR型の値を返す
     * Predicate < T > ： T型の引数を受け取って、booleanの値を返す処理を実装する
     */
    static void functionalInterfacePractice() {
        /** Consumer
         * どこかで見たことがあるぞ！
         * RamdaPractice.javaの匿名クラスの際に利用した
         * */

        //匿名クラスでの実装
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5); //1~5までの要素を持つリストを作成
        //↓ここで利用。Integer型の引数を受け取って、戻り値なしのiを表示という処理を実装していた。
        Consumer<Integer> anonymous = new Consumer<>() {
            @Override
            public void accept(Integer i) {
                System.out.println(i);
            }
        };
        list.stream().forEach(anonymous);

        //改めてConsumerインタフェース書いてみる
        Consumer<String> todaysLunch = (lunch) -> {
            System.out.println(lunch + "をお昼に食べました");
        };
        todaysLunch.accept("ラーメン");

        //でも行っていることは以下と同じ
        String lunch = "ラーメン";
        System.out.println(lunch + "を食べました");

        /** これだとあんまり関数型インタフェースのうまみがわからない
         * Consumer型にすることによって、forEachとか使えるが良いんだろうなぁ*/

        /** Function */
        //FunctionはT型の引数を受け取って、R型の値を返す
        Function<String, String> addHello = (name) -> {
            return "Hello " + name;
        };
        System.out.println(addHello.apply("Taro"));
        //computeIfAbsentの例
        Map<String, String> map = new HashMap<>();
        map.put("key1", "apple");
        map.put("key2", "orange");
        map.put("key3", "melon");

        System.out.println("before : " + map);
        map.computeIfAbsent("key4", (value) -> null); //nullの場合は無視される
        map.computeIfAbsent("key4", (value) -> "Banana");
        System.out.println("after : " + map);

        /** Functionを利用することでcomputeIfAbsentを実現している？*/


        /** Predicate  T型の引数を受け取って、booleanの値を返す処理を実装する*/
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);

        list2.removeIf(t -> t % 2 == 0); //偶数を取り除く処理
        System.out.println(list2);
    }
}
