import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;

public class ListPractice {

    static long addTest(Random rand, List list) {
        long startTime = System.nanoTime();  // 処理前の時刻を取得
        for (int j = 0; j < 10000000; j++) {
            int num = rand.nextInt(1000);
            list.set(num, num);
        }
        long endTime = System.nanoTime(); // 処理後の時刻を取得
        return endTime - startTime;
    }

    static long getTest(Random rand, List list) {
        long startTime = System.nanoTime();  // 処理前の時刻を取得
        for (int j = 0; j < 10000000; j++) {
            int num = rand.nextInt(1000);
            list.get(num);
        }
        long endTime = System.nanoTime(); // 処理後の時刻を取得
        return endTime - startTime;
    }

    static void judge(long arrayTime, long linkedTime) {
        if (arrayTime > linkedTime) {
            System.out.println("LinkedListの方が早いです。");
        } else {
            System.out.println("ArrayListの方が早いです。");
        }
    }

    static void listPractice() {
        /** リストの違いを学ぶ*/
        //MEMO: Listはインタフェース。だからあくまでリストと宣言しているだけ。リストの実装はnew以下で宣言
        /**
         * ArrayList : 要素がそれぞれ順序番号を持っている。だから特定要素へのアクセスが早いけど、
         * リストの真ん中とかに要素を追加すると、それ以降が一つずつずれなきゃいけなくなり、その書き換えに時間がかかってしまう。
         * [長所と短所]
         * 特定の要素にアクセスするスピードが早い
         * 要素を追加するスピードが遅い
         */
        //ArrayListは参照型だからintは入らない
        List<Integer> arrayList = new ArrayList<>();
        for (
                Integer i = 0;
                i < 1000; i++) {
            arrayList.add(i); //要素をリストに追加する
        }
//        //空かどうか判定
//        System.out.println(arrayList.isEmpty());
//        //要素を取り出す
//        System.out.println(arrayList.get(10));

        /**
         * LinkedList：要素同士が、それぞれ前後に持っているリンク情報で繋がっている。だから、要素の追加削除は前後の
         * リンク情報を書き換えるだけで良い。ただし、先頭または後ろから数えて特定要素へアクセスするためスピードは遅くなる。
         * * [長所と短所]
         * 要素を追加したり削除するスピードが早い
         * 特定の要素にアクセスするスピードが遅い
         */
        List<Integer> lnkdList = new LinkedList<>();
        for (
                Integer i = 0;
                i < 1000; i++) {
            lnkdList.add(i); //要素をリストに追加する
        }


        /** 本当にそうなの? ナノ秒で計測してみる*/
        System.out.println("要素の追加時間を計測します。");
        //要素の追加
        Random rand = new Random();
        long arrayAddtime, linkedAddtime = 0;
        arrayAddtime = addTest(rand, arrayList);
        System.out.println("ArrayListの処理時間：" + arrayAddtime + " ナノ秒");
        linkedAddtime = addTest(rand, lnkdList);
        System.out.println("LinkedListの処理時間：" + linkedAddtime + " ナノ秒");
        judge(arrayAddtime, linkedAddtime); //速さの判定を行う


        System.out.println("\n要素のアクセス時間を計測します。");
        long arrayGetTime, linkedGetTime = 0;
        arrayGetTime = getTest(rand, arrayList);
        System.out.println("ArrayListの処理時間：" + arrayGetTime + " ナノ秒");
        linkedGetTime = getTest(rand, lnkdList);
        System.out.println("LinkedListの処理時間：" + linkedGetTime + " ナノ秒");
        judge(arrayGetTime, linkedGetTime); //速さの判定を行う


        //AbstractList
//        List<Integer> abstList = new AbstractList<Integer>() {
//            @Override
//            public Integer get(int index) {
//                return null;
//            }
//
//            @Override
//            public int size() {
//                return 0;
//            }
//        }


        /**
         * リストの初期化
         */
        List<String> list = new ArrayList<String>(Arrays.asList("Apple", "Orange", "Melon"));

        for (
                int i = 0; i < list.size(); i++) {
            //System.out.println(list.get(i));
        }
        list.add("lemon");
        list.remove("Orange");//要素名でも指定可能
        //System.out.println(list);
        list.remove(0); //要素番号でも指定可能
        //System.out.println(list);

        /**
         * 同じ要素が2、3つあった場合はどうなるのか？
         */
        List<String> list2 = new ArrayList<String>(Arrays.asList("Orange", "Apple", "Orange", "Melon", "Orange"));
        for (
                int i = 0; i < list2.size(); i++) {
            //System.out.println(list2.get(i));
        }
        list2.remove("Orange");//先頭のOrangeが削除されている
        //System.out.println(list2);
    }


}
