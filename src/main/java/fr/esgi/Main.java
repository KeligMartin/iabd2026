package fr.esgi;


import fr.esgi.log.CRITICITY;
import fr.esgi.log.Log;

import java.util.*;

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
        Set<Log> logsUniques = new HashSet<>();
        logsUniques.add(log);
        logsUniques.add(log2);
        logsUniques.add(log);




        Map<CRITICITY, Integer> logByCriticity = new HashMap<>();

        // Ajouter 5 logs différents à la liste
        // faire en sorte que la map fonctionne pour de vrai
        for(Log current : logList) {
            logByCriticity.put(current.getCriticity(), 1);
        }

        System.out.println(logByCriticity);
    }
}
