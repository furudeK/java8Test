import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPIpractice {
    public static void streamAPIpractice() {
        /** まずは肩慣らし
         * StreamAPIで単純に数字を表示してみる*/
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5); //1~5までの要素を持つリストを作成
        //普通に書くと
        for (Integer num : list) {
            System.out.println(num);
        }

        Stream<Integer> stream = list.stream(); //listをStream化して参照型Streamのstreamに入れる
        stream.forEach(System.out::println); //forEachを使用し、streamの要素を1つずつ表示

        //シンプルに書くとこうなる
        list.stream().forEach(System.out::println);

        //余談、プリミティブ型もStream化できる
        int[] array = new int[]{1, 2, 3, 4, 5};
        IntStream intStream = Arrays.stream(array);


        /** ここまでだとあんまりStreamAPIのうまみを感じない。*/


        /**
         * 重複してる要素を消して1つにしたい
         * Appleが2、Orangeが3つ
         */
        List<String> list3 = new ArrayList<String>(Arrays.asList("Orange", "Apple", "Orange", "Melon", "Orange", "Apple", "Banana"));

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


        /** 記述量はあんまり変わらないけれども、StreamAPIによって宣言的に書くことができた
         * でも、まだまだforとifの組み合わせでも良いのでは無いかと感じてしまう。*/

        /**
         * よりStreamAPIのうまみを感じるために…
         * 文字列にoを含むものだけ抽出したいとする（OrangeとMelonが該当）
         * さらに、ABC順に並べる（期待する出力：[Melon, Orange]）
         */

        //forの場合
        List<String> forList = new ArrayList<>();
        for (String str : list3) {
            if (forList.contains(str)) {
                continue;
            } else if(str.contains("o") || str.contains("O")){ //追加部分に条件を追記
                forList.add(str);
            }
        }
        Collections.sort(forList); //ソート処理を行う
        System.out.println("For文とif文で記述した場合のOまたはoを含むフルーツの名前");
        System.out.println(forList);


        //StreamAPIの場合
        List<String> streamList = list3
                .stream() //Stream化
                .distinct() //要素同士を比較して、重複したものを除いたStreamを返す
                .filter(o -> o.contains("O") || o.contains("o"))//Oまたはoを含むもののみ抽出
                .sorted() //ABC順に並べ替え
                .collect(Collectors.toList());//終端操作、リストに変換する

        System.out.println("StreamAPIで記述した場合のOまたがoを含むフルーツの名前");
        System.out.println(streamList );

        /**
         * これくらいの単純な処理だと、まだforでも良い気がするが1月後にコードを見返した時、どちらの方がわかりやすいだろうか。
         * もしも、Oを含むものだけではなく、6文字のフルーツも表示したいと追加が来たら？（Bananaが該当）
         * StreamAPIの場合は、フィルター処理を追加すれば良いのだとわかりやすい！
         */
    }
}
