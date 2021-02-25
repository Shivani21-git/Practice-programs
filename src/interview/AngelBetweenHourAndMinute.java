package interview;

import static java.lang.Math.abs;

public class AngelBetweenHourAndMinute {
    public static void main(String... args)
    {

        AngelBetweenHourAndMinute obj = new AngelBetweenHourAndMinute();
        System.out.println(obj.calculateAngle(9,60));

    }
    public int calculateAngle(int hours, int minutes) {
        // 1 degree angle made by hour hand in 1 mins= 0.5 degree
        // 1 degree angle made by minute hand in 1 mins = 6 degree
        if (hours > 12 || minutes > 60 || hours < 0 || minutes < 0) {
            return 0;
        } else if ((hours == 12 && minutes == 0) || (hours == 0 && minutes == 60)) {
            return 0;
        } else {
            int anglemadebyhour = (int) (((hours * 60) + minutes) * 0.5);
            int anglemadebyminute = minutes * 6;
            int anglemade = abs(anglemadebyhour - anglemadebyminute);
            return anglemade;
        }
    }
}
