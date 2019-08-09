package com.john.showmecode.javacore;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 两个乒乓球队进行比赛，各出三人。甲队为a,b,c三人，乙队为x,y,z三人。已抽签决定比赛名单。有人向队员打听比赛的名单。
 * a说他不和x比，c说他不和x,z比，请编程序找出三队赛手的名单
 * @Author: kangq
 * @Date: 2019/8/9 10:32
 */
public class CodingExam1 {

    public static void solution1() {
        String[] team1 = {"a","b","c"};
        String[] team2 = {"x","y","z"};
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                //a说他不和x比
                if(i == 0 && j == 0)
                    continue;
                else if(i == 2 && (j == 0 || j == 2))
                    continue;//c说他不和x,z比
                else{
                    System.out.println(team1[i] + "<-->" + team2[j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        solution1();
    }
}
