package crawler;

import java.util.ArrayList;
import java.util.List;

public class CrawlerDemoWithoutThread {

    public static void main(String[] args) {
        List<SportNews> sportNewsList=new ArrayList<>();



        long startTime=System.currentTimeMillis();


        KhabarVarezshi khabarVarezshi=new KhabarVarezshi();
        khabarVarezshi.run();

      sportNewsList.addAll( khabarVarezshi.getSportNewsList());
     //   Thread threadKhabarVarezdhi=new Thread(khabarVarezshi);


       Parsik parsik=new Parsik();
       // Thread threadParsik=new Thread(parsik);

        parsik.run();
        sportNewsList.addAll( parsik.getSportNewsList());
        System.out.println("new size="+sportNewsList.size());

        long endTime=System.currentTimeMillis();

        System.out.println("Time duration:"+(endTime-startTime));







    }
}
