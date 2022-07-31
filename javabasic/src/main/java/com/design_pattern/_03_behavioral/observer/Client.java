package com.design_pattern._03_behavioral.observer;

public class Client {
    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();

        User user1 = new User(chatServer);
        user1.sendMessage("디자인패턴","이번엔 옵저버 패턴입니다.");
        user1.sendMessage("알고리즘", "자료구조부터 하세요!");

        User user2 = new User(chatServer);
        System.out.println(user2.getMessage("디자인패턴"));

        user1.sendMessage("디자인패턴", "예제 코드 보는 중...");
        System.out.println(user2.getMessage("디자인패턴"));
    }
}
