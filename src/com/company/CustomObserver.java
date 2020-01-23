package com.company;

import java.util.ArrayList;
import java.util.List;

public class CustomObserver {

    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();

        Channel abcNews = new AbcNews();
        agency.addChannel(abcNews);

        agency.addChannel(new Channel() {
            @Override
            public void publishNews(String news) {
                System.out.println("Anonymous News -> " + news);
            }
        });


        agency.setNews("Donald Trump Impeachment Hearings Started");
    }
}

interface Channel {
    void publishNews(String news);
}

//publisher - публикует новости
class NewsAgency {
    private List<Channel> channels = new ArrayList<>();

    public void addChannel(Channel channel) {
        channels.add(channel);
    }

    public void removeChannel(Channel channel) {
        channels.remove(channel);
    }

    public void setNews(String news) {
        channels.forEach(x -> x.publishNews(news));
    }
}

//Subscriber
class AbcNews implements Channel {

    @Override
    public void publishNews(String news) {
        System.out.println("ABC NEWS -> " + news);
    }
}

