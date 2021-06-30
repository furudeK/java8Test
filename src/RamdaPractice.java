import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;


public class RamdaPractice {
    static void print(Integer i) {
        System.out.println(i);
    }
    void hoge(){
        System.out.println("u");
    }
    static void ramda() {
        /** メソッド参照を紐解く*/
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5); //1~5までの要素を持つリストを作成
        //メソッド参照(System.out::println）
        /** 今回はよりわかりやすくするために、printメソッドを用意*/
        //クラス名::メソッド名でメソッド参照が可能
        list.stream().forEach(RamdaPractice::print);

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

        /** ラムダ式はローカルクラスと無名クラスという仕組みで成り立っている */

        //Runnableインタフェースを実装したローカルクラス
        class Local implements Runnable {
            @Override
            public void run() {
                System.out.println("Hello Lambda!");
            }
        }

        Runnable person = new Local();
        person.run(); // Hello Lambda!

        //無名クラス = インタフェースを実装したローカルクラスの宣言を省略（26行目）
        Runnable mumeiPerson = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Lambda!");
            }
        };
        mumeiPerson.run(); //Hello Lambda!

        //ラムダ式 無名クラスからさらにnew Runnable()とpublic void runを省略
        Runnable ramdaPerson = () -> {
            System.out.println("Hello Lambda!");
        };
        ramdaPerson.run(); //Hello Lambda

        //抽象メソッドが1つでなければいけない
    }
}
