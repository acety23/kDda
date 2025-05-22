package com.kdda.javaSE;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;

public class ReferenceTest {
    public static void main(String[] args) {
        Player mj = new Player("mj", "23");
        Player kb = new Player("kb", "24");
        Player dw = new Player("dw", "03");
        List<Player> list = Arrays.asList(mj, kb);
        System.out.println(list);
        for (Player player : list) {
            if (player == kb) {
                System.out.println("kb");
                player = dw;
            }
        }
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            Player player = list.get(i);
            if (player == kb) {
                System.out.println("kb");
                list.set(i, dw);
            }
        }
        System.out.println(list);

    }

}


@AllArgsConstructor
@ToString
class Player {
    String name;
    String num;
}
