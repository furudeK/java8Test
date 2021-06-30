import java.rmi.MarshalledObject;
import java.util.*;
import java.util.stream.Stream;

/** Doneの条件
 * [] 宣言的に処理を書くことが「できる」
 *      →StreamAPIやラムダを用いて処理を命令的に1つ１つ書くのではなく、何をしたいのか書くことができる
 * [] どうやってではなく何がやりたいかを表現「できる」
 *      →宣言的に表現する
 */

public class Java8Tester {
    public static void main(String[] args) {
        //ListPractice.listPractice(); //Listの練習用
        //MapPractice.mapPractice(); //Map練習用
        //SetPractice.setPractice();
        //StreamAPIpractice.streamAPIpractice(); //StreamAPI練習用
        //RamdaPractice.ramda(); //ラムダ練習用
        FunctionalInterfacePractice.functionalInterfacePractice();
    }

}
