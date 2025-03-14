package org.example;
import java.util.*;

class User {
    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name + ", возраст " + age + " лет";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, List<User>> userMap = new HashMap<>();

        for (int i = 1; i <= 5; i++) {
            System.out.println("Введите имя пользователя " + i);
            String name = scanner.nextLine();
            System.out.println("Введите возраст пользователя " + i);
            int age = scanner.nextInt();
            scanner.nextLine();

            userMap.computeIfAbsent(age, k -> new ArrayList<>()).add(new User(name, age));
        }

        System.out.println("Введите требуемый возраст");
        int requiredAge = scanner.nextInt();

        if (userMap.containsKey(requiredAge)) {
            List<User> users = userMap.get(requiredAge);
            users.sort(Comparator.comparing(User::getName));
            for (User user : users) {
                System.out.println(user);
            }
        } else {
            System.out.println("Пользователь с возрастом '" + requiredAge + "' не найден");
        }
    }
}
