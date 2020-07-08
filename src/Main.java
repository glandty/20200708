/**
 * 大家应该都会玩“锤子剪刀布”的游戏：
 *
 * 现给出两人的交锋记录，请统计双方的胜、平、负次数，并且给出双方分别出什么手势的胜算最大。
 *
 * 输入描述:
 * 输入第1行给出正整数N（<=105），即双方交锋的次数。随后N行，每行给出一次交锋的信息，即甲、乙双方同时给出的的手势。C代表“锤子”、J代表“剪刀”、B代
 * 表“布”，第1个字母代表甲方，第2个代表乙方，中间有1个空格。
 *
 *
 * 输出描述:
 * 输出第1、2行分别给出甲、乙的胜、平、负次数，数字间以1个空格分隔。第3行给出两个字母，分别代表甲、乙获胜次数最多的手势，中间有1个空格。如果解不唯
 * 一，则输出按字母序最小的解。
 * 示例1
 * 输入
 * 10<br/>C J<br/>J B<br/>C B<br/>B B<br/>B C<br/>C C<br/>C B<br/>J B<br/>B C<br/>J J
 * 输出
 * 5 3 2<br/>2 3 5<br/>B B
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int v = 0;
            int f = 0;
            Map<Character, Integer> mapA = new TreeMap<>();
            Map<Character, Integer> mapB = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                char a = sc.next().charAt(0);
                char b = sc.next().charAt(0);
                int re = match(a, b);
                if (re == 1) {
                    v++;
                    if (mapA.containsKey(a)) {
                        mapA.put(a, mapA.get(a) + 1);
                    } else {
                        mapA.put(a, 1);
                    }

                } else if (re == -1) {
                    f++;
                    if (mapB.containsKey(b)) {
                        mapB.put(b, mapB.get(b) + 1);
                    } else {
                        mapB.put(b, 1);
                    }
                }
            }
            System.out.println(v + " " + (n - v - f) + " " + f);
            System.out.println(f + " " + (n - v - f) + " " + v);
            int max = 0;
            for (Map.Entry<Character, Integer> m : mapA.entrySet()) {
                if (m.getValue() > max) {
                    max = m.getValue();
                }
            }
            if (max == 0) {
                System.out.print("B");
            } else {
                for (Map.Entry<Character, Integer> m : mapA.entrySet()) {
                    if (m.getValue() == max) {
                        System.out.print(m.getKey());
                        break;
                    }
                }
            }
            max = 0;
            System.out.print(" ");
            for (Map.Entry<Character, Integer> m : mapB.entrySet()) {
                if (m.getValue() > max) {
                    max = m.getValue();
                }
            }
            if (max == 0) {
                System.out.print("B");
            } else {
                for (Map.Entry<Character, Integer> m : mapB.entrySet()) {
                    if (m.getValue() == max) {
                        System.out.print(m.getKey());
                        break;
                    }
                }
            }
        }
    }

    public static int match(char a, char b) {
        if (a == b) {
            return 0;
        } else if ((a == 'C' && b == 'J') || (a == 'J' && b == 'B') || (a == 'B' && b == 'C')) {
            return 1;
        } else {
            return -1;
        }
    }
}