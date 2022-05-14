package sample_two;

import static sample_two.Planet.EARTH;

public class PlanetTest {


        public static void main(String[] args) {

            double earthWeight = 175;
            double mass = earthWeight/EARTH.surfaceGravity();
            for (Planet p : Planet.values())
                System.out.printf("Your weight on %s is %f%n",
                        p, p.surfaceWeight(mass));
        }
    }

