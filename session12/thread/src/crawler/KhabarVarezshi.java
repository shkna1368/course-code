package crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KhabarVarezshi implements Runnable{



   private List<SportNews> sportNewsList=new ArrayList<>();

    public List<SportNews> getSportNewsList() {
        return sportNewsList;
    }





    @Override
    public void run() {
        Document doc = null;
        try {
            doc = Jsoup.connect("https://www.khabarvarzeshi.com/").get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements elementH3 = doc.getElementsByTag("h3");



        elementH3.forEach(element1 -> {
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
