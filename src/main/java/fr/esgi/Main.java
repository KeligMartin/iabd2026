package fr.esgi;


import fr.esgi.log.CRITICITY;
import fr.esgi.log.Log;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static void main() {

        Log log = new Log();
        log.setCriticity(CRITICITY.INFO);
        log.setMessage("Hello World");
        log.setStatus(200);

        Log log2 = new Log();
        log2.setCriticity(CRITICITY.INFO);
        log2.setMessage("Hello World");
        log2.setStatus(200);


        List<Log> logList = new ArrayList<>();
        logList.add(log);
        logList.add(log2);


    }
}
