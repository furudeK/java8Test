import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;


class LambdaPractice {
    public interface Hello {
        void getHello(String str);
    }

    public interface HelloAndReply {
        void getHello(String name, String reply);
    }


    static void print(Integer i) {
        System.out.println(i);
    }

    static void ramda() {
        /** メソッド参照を紐解く*/
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5); //1~5までの要素を持つリストを作成
        //メソッド参照(System.out::println）
        /** 今回はよりわかりやすくするために、printメソッドを用意*/
        //クラス名::メソッド名でメソッド参照が可能
        list.stream().forEach(LambdaPractice::print);

        // ラムダ式で記入するとこうなる 引数->処理（メソッド名）
        list.stream().forEach(i -> print(i)); //引数iをprintメソッドに渡して表示をする

        //匿名クラスでの実装
        Consumer<Integer> anonymous = new Consumer<>() {
            @Override
            public void accept(Integer i) {
                System.out.println(i);
            }
        };
        list.stream().forEach(anonymous);

        //Consumer型に変換

        //for文で書く
        for (Integer i : list) {
            print(i);
        }

//        Hello hello = new Hello() {
//            @Override
//            public void getHello(String str) {
//                System.out.println("hello" + str);
//            }
//        };
        //引数ありのラムダ式
        Hello hello = str -> System.out.println("Hello" + str);
        hello.getHello("again!");

        //複数の引数ありのラムダ式
        HelloAndReply helloAndReply = ((name, reply) -> System.out.println(name + reply));
        helloAndReply.getHello("Taro", " say Hello");


    }
}
