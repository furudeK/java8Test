import java.util.*;

/**
 * キーに対してキーに紐づく値を保持できるコレクション
 */
public class MapPractice {
    public static void mapPractice() {
        // HashMapの宣言 Map<キーの型名、値の型名＞オブジェクト名 = new HashMap<キーの型名、値の型名>(); ←ここの<>内部は省略可能
        Map<String, String> hashMap = new HashMap<>();

        //HashMapにデータを格納
        hashMap.put("key1", "apple");
        hashMap.put("key2", "orange");
        hashMap.put("key3", "melon");
        //hashMap.put("key3", "orange"); //同じkeyを指定した場合は上書きされてしまう。出力：[apple, orange, orange]

        System.out.println(hashMap.get("key2")); // orange
        System.out.println(hashMap.get("key4")); //key外の場合はnullを返す
        System.out.println(hashMap.keySet()); //keyを全て取得
        System.out.println(hashMap.values());//keyを要素を取得

        /** Mapは内部でデーターベースっぽく値を保持したい時に使えそう！ */

        // LinkedHashMapの宣言
        Map<String, String> linkedHashMap = new LinkedHashMap<>();

        // LinkedHashMapにデータを格納
        // HashMapを継承している。違いは、LinkedHashMapはクラスに格納された順番を保持している。
        linkedHashMap.put("key1", "Apple");
        linkedHashMap.put("key2", "orange");
        linkedHashMap.put("key3", "melon");
        System.out.println(linkedHashMap.keySet());
        System.out.println(linkedHashMap.values());

        /**基本的にHashMapで問題ないが、追加した要素に順序が必要な場合はLinkedHashMap、キーがenumの場合はEnumMapを使用する */

    }
}
