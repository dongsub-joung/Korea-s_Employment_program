// https://softwareengineering.stackexchange.com/questions/280622/using-system-err-println-for-debugging-in-java

import org.apache.log4j.Logger;

public class Main {
    private final static Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        LOG.debug("Oops");
        LOG.info("This is awkward");
        LOG.error("This is bad");
    }
}

//    and there, in red on my console, I see:
//
//        2015-04-30 20:18:34 DEBUG Main:9 - Oops
//        2015-04-30 20:18:34 INFO  Main:10 - This is awkward
//        2015-04-30 20:18:34 ERROR Main:11 - This is bad
//
//        Meanwhile, in my log file:
//
//        2015-04-30 20:18:34 ERROR Main:11 - This is bad
