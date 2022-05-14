package crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parsik implements Runnable {

  private   List<SportNews> sportNewsList=new ArrayList<>();

    public List<SportNews> getSportNewsList() {
        return sportNewsList;
    }

    @Override
    public void run() {

        //newslist
//news-list-items clearfix
        Document doc = null;
        try {
            doc = Jsoup.connect("https://www.parseek.com/Sport/").get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Element element = doc.getElementsByClass("newsbox").get(0);

        // Element elementsNewsList=  element.getElementsByClass("newslist").get(0);


        Element elementsUl=element.getElementsByTag("ul").get(0);
        Elements lis=elementsUl.getElementsByTag("li");
        lis.forEach(element1 -> {
            Element elA=element1.getElementsByTag("a").get(0);
            String title=elA.text();
            String link= elA.attr("href");
            SportNews sportNews=new SportNews();
            sportNews.setTitle(title);
            sportNews.setLink(link);

            sportNewsList.add(sportNews);
    });

    }
}
