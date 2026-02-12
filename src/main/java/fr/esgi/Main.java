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

        List<Log> successfulLogs = new ArrayList<>();
        List<Log> errorLogs = new ArrayList<>();
        int successCount = 0;

        for (int i = 0; i < logList.size(); i++) {
            if (logList.get(i).isSuccess()) {
                successCount++;
                successfulLogs.add(logList.get(i));
            }
        }

        for (Log currentLog : logList) {
            if(currentLog.isError()) {
                errorLogs.add(currentLog);
            }
        }

        System.out.println(successfulLogs);
        System.out.println(successCount);
        System.out.println(errorLogs);
    }
}
