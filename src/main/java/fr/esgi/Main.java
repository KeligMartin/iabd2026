package fr.esgi;


import fr.esgi.log.*;
import fr.esgi.log.Readable;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static fr.esgi.log.LogGenerator.generateLogs;

public class Main {

    static void main() {

        List<String> animaux = List.of("chat", "chien", "cheval", "ours", "lapin", "cochon");

        Readable source1 = new Request("Je me connecte");
        Readable source2 = new Response("Je suis connecté", 200);
        Log<Readable> log = new Log<>(CRITICITY.INFO, source1);
        Log<Readable> log2 = new Log<>(CRITICITY.ERROR, source2);

        List<Log<Readable>> logs = List.of(log, log2);

        Consumer<Log<Readable>> printMessage = (Log<Readable> l) -> System.out.println(l.getMessage());

        Predicate<Log<Readable>> isError = (Log<Readable> l) -> l.getCriticity() == CRITICITY.ERROR;

        Predicate<Log<Readable>> isOld = (Log<Readable> l) -> l.getTimestamp().isAfter(LocalDateTime.now().minusDays(30));

        Map<CRITICITY, List<Log<Readable>>> criticityMap =  logs                                // parcours mes logs
                .stream()
                .filter(isOld)
                .collect(Collectors.groupingBy(Log::getCriticity)
        );

        // SELECT * FROM Log GROUP BY criticity;

        /**
         * { INFO : [
         *  log1, log2, ...
         * ],
         * ERROR : []
         * WARN :
         *
         */


        List<Log<?>> myLogs = generateLogs(10000000);
        List<Log<?>> result = new ArrayList<>();


        long start = System.currentTimeMillis();

        long end = System.currentTimeMillis();
        System.out.println("Temps : " + (end - start) + " ms");
    }
}
