package com.kdda.designPatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

// 主题接口
interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

// 具体主题实现类
class NewsAgency implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String news;

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(news);
        }
    }

    public void setNews(String news) {
        this.news = news;
        notifyObservers();  // 通知所有观察者
    }
}

// 观察者接口
interface Observer {
    void update(String news);
}

// 具体观察者实现类
class NewsSubscriber implements Observer {
    private String name;

    public NewsSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.println(name + " received news update: " + news);
    }
}

// 使用观察者模式
public class ObserverPatternExample {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();
        NewsSubscriber user1 = new NewsSubscriber("User1");
        NewsSubscriber user2 = new NewsSubscriber("User2");

        agency.registerObserver(user1);
        agency.registerObserver(user2);

        agency.setNews("Breaking News: Java Observer Pattern!");
    }
}
