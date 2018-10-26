package com.example.demo.bean;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/14.
 */

/**
 * 将配置文件的每一个属性值映射到该类中
 * ConfigurationProperties：告诉SpringBoot将本类中所有属性与配置文件中对应属性值绑定；
 * 这个组件只有是容器中的组件，才可以使用@ConfigurationProperties的功能
 */

//@PropertySource(value={"classpath:person.properties"})
//@Component
//@ConfigurationProperties(prefix="person")//默认从全局配置文件中获取值
public class Person {
    private String lastName;
    private int age;
    private boolean boss;
    private Date birth;
    private Map<String, Object> maps;
    private List<String> lists;
    private Dog dog;

    public Person(String lastName, int age, boolean boss, Date birth, Map<String, Object> maps, List<String> lists, Dog dog) {
        this.lastName = lastName;
        this.age = age;
        this.boss = boss;
        this.birth = birth;
        this.maps = maps;
        this.lists = lists;
        this.dog = dog;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isBoss() {
        return boss;
    }

    public void setBoss(boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<String> getLists() {
        return lists;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }
}
