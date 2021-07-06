import java.util.HashSet;
import java.util.Set;

public class SetPractice {
    public static void setPractice(){

        /** リストとの違いは、重複要素を保持しないという点 */
        Set<String> hashSet = new HashSet<>(); //ハッシュ値で管理している(Object型のところにhashcodeみてみる）
        //要素を追加
        hashSet.add("Apple");
        hashSet.add("orange");
        hashSet.add("melon");
        hashSet.add("Apple"); //重複要素を追加してみる（falseがかえてっくる）

        System.out.println("要素サイズ："+hashSet.size());
        hashSet.forEach(System.out::println);
        //要素を削除
        hashSet.remove("melon");
        System.out.println("要素サイズ："+hashSet.size());
        hashSet.forEach(System.out::println);
        //最後に、要素を全て消す
        hashSet.clear();
        System.out.println("要素サイズ："+hashSet.size());

    }
}
