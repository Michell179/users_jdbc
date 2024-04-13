package org.michell.users.maintainer.view;

import org.michell.users.maintainer.models.User;

import java.util.List;
import java.util.Scanner;

public class TextComponentView {

    private static Scanner scanner = new Scanner(System.in);


    public enum TextMessage {
        TYPE_ID( "Type ID: "), TYPE_USERNAME("Type Username: "),
        TYPE_PASSWORD("Type Password: "), TYPE_EMAIL("Type Email: "),
        TEXT_EMPTY("Text is empty"), UPDATE("UPDATE"),
        DELETE("DELETE"), CREATE("CREATE"),
        SHOW("SHOW"), EXIT("Users system shutdown...");

        private String value;

        public String getValue(){
            return value;
        }

        TextMessage(String value) {
            this.value = value;
        }
    }

    public TextComponentView(){
        scanner = new Scanner(System.in);
    }


    public static Long delete(){
        println(TextMessage.DELETE);

        print(TextMessage.TYPE_ID);
        Long id = scanner.nextLong();

        if (id == null){
            println(TextMessage.TEXT_EMPTY);
            return null;
        }

        return id;
    }

    public static User create(){
        User user = new User();
        println(TextMessage.CREATE);

        print(TextMessage.TYPE_USERNAME);
        user.setUsername(scanner.next());

        print(TextMessage.TYPE_PASSWORD);
        user.setPassword(scanner.next());

        print(TextMessage.TYPE_EMAIL);
        user.setEmail(scanner.next());

        return user;
    }

    public static void show(List list){
        list.forEach(System.out::println);
    }



    public static User update(){
        User user = new User();
        println(TextMessage.UPDATE);

        print(TextMessage.TYPE_ID);
        user.setId(scanner.nextLong());

        print(TextMessage.TYPE_USERNAME);
        user.setUsername(scanner.next());

        print(TextMessage.TYPE_PASSWORD);
        user.setPassword(scanner.next());

        print(TextMessage.TYPE_EMAIL);
        user.setEmail(scanner.next());

        return user;
    }

    public static void exit(){
        println(TextMessage.EXIT);
    }

    private static void println(TextMessage textMessage){
        System.out.println(textMessage.getValue());
    }

    private static void print(TextMessage textMessage){
        System.out.print(textMessage.getValue());
    }

}
