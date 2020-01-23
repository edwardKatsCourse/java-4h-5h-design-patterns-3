package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class JavaObserver {
    public static void main(String[] args) {
        JavaNewsAgency agency = new JavaNewsAgency();

        Observer javaPrimeNews = new JavaPrimeNews();
        agency.addChannel(javaPrimeNews);

        agency.setNews("Spring Framework Conference in Austin 2019");
        agency.removeObserver(javaPrimeNews);

        agency.setNews("Java 14 beta released");


    }
}

//Observable = publisher
//Observer = subscriber (подписчик)
class JavaNewsAgency extends Observable {

    //News Channel
    private List<Observer> observers = new ArrayList<>();

    public void addChannel(Observer observer) {
//        this.observers.add(observer);
        super.addObserver(observer);
    }

    public void removeObserver(Observer observer) {
//        this.observers.remove(observer);
        super.deleteObserver(observer);
    }

    public void setNews(String news) {
        //
        super.setChanged(); //has changes = true
        super.notifyObservers(news); // has changes = false
    }
}

class JavaPrimeNews implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Java Prime News: " + arg);
    }
}