package com.itheima;
/**
 * Miscellaneous {@link String} utility methods.
 *
 * <p>Mainly for internal use within the framework; consider
 * <a href="http://commons.apache.org/proper/commons-lang/">Apache's Commons Lang</a>
 * for a more comprehensive suite of {@code String} utilities.
 *
 * <p>This class delivers some simple functionality that should really be
 * provided by the core Java {@link String} and {@link StringBuilder}
 * classes. It also provides easy-to-use methods to convert between
 * delimited strings, such as CSV strings, and collections and arrays.
 *
 */
public class Singer {
    private String name;
    private int age;
    private String like;

    public Singer(String name, int age, String like) {
        this.name = name;
        this.age = age;
        this.like = like;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Singer returnMy() {
        return this;
    }

    public String getALL() {
        return "姓名：" + name + "，年龄：" + age + "，爱好：" + like;
    }

    public void set(int age) {
        this.name = name;
    }

    public void set(String like) {
        this.like = like;
    }
}
