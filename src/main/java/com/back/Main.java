package com.back;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("== 명언 앱 ==");

        Scanner sc = new Scanner(System.in);

        int lastId = 0;

        while (true) {
            System.out.println("명령) ");

            String cmd = sc.nextLine().trim();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                System.out.print("명언: ");
                String content = sc.nextLine().trim();

                System.out.print("작가: ");
                String author = sc.nextLine().trim();

                // 등록할때 마다 생성되는 명언번호가 증가
                int id = ++lastId;


                System.out.printf("%d번 명언이 등록되었습니다.\n", id);
            }

        }

    }
}

