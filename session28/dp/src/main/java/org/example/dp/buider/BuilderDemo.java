package org.example.dp.buider;

import org.example.dp.buider.Article;
import org.example.dp.buider.User;

public class BuilderDemo {
    public static void main(String[] args) {
        User user1 = new User.UserBuilder("Lokesh", "Gupta")
                .age(30)
                .phone("1234567")
                .address("Fake address 1234")
                .build();

        System.out.println(user1);
        System.out.println("-----------------");
        User user2 = new User.UserBuilder("Jack", "Reacher")
                .age(40)
                .phone("5655")
                //no address
                .build();

        System.out.println(user2);
        System.out.println("-----------------");


        User user3 = new User.UserBuilder("Super", "Man")
                //No age
                //No phone
                //no address
                .build();

        System.out.println(user3);

        //--------------builder lombok
        Article a = Article.builder()
                .id(1L)
                .tag("TestTag1")
                .tag("TestTag2")
                .build();

// Article(id=1, title=Title Placeholder, tags=[TestTag1, TestTag2])
        System.out.println(a);
    }
}
