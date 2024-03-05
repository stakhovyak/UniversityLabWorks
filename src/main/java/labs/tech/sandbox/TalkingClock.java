package labs.tech.sandbox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

public class TalkingClock {
    private final int interval;
    private final boolean beep;
    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start() {
        var listener = new TimePrinter(); // var is ActionListener in this case WTF
        var timer = new Timer(interval, listener);
        timer.start();
    }

    /**
     * The time printer class has no instance field of variable named
     * beep. Instead, beep refers to the field of the TalkingClock
     * object that created this TimePrinter.
     */
    public class TimePrinter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            // Note that the method checks beep flag before emitting a beep.
            System.out.println("At the tone, the time is " +
                    Instant.ofEpochMilli(event.getWhen()));
            if (beep) {
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }

    public static void main(String[] args) {
        // NOTE
        // since TimePrinter is public inner class, you can construct TimePrinter for any TalkingClock
        var altClock = new TalkingClock(1500, false);
        TalkingClock.TimePrinter listener = altClock.new TimePrinter();
        // END OF NOTE
        var clock = new TalkingClock(1000, true);
        clock.start();

        // Keep program running until the user selects "OK"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);


    }
}
