package crawler;

import java.util.ArrayList;
import java.util.List;

public class CrawlerDemoWithThread {

    public static void main(String[] args) throws InterruptedException {
        long startTime=System.currentTimeMillis();


        List<SportNews> sportNewsList=new ArrayList<>();




        KhabarVarezshi khabarVarezshi=new KhabarVarezshi();
        Thread trKhabareVarzeshi=new Thread(khabarVarezshi,"khabarVarezshi");


       Parsik parsik=new Parsik();
        Thread trParsik=new Thread(parsik,"parsik");

trKhabareVarzeshi.start();
        trParsik.start();



        trKhabareVarzeshi.join();
        trParsik.join();




        sportNewsList.addAll( khabarVarezshi.getSportNewsList());
        sportNewsList.addAll( parsik.getSportNewsList());

        System.out.println("new size="+sportNewsList.size());

        long endTime=System.currentTimeMillis();

        System.out.println("Time duration:"+(endTime-startTime));







    }
}
