package fr.esgi;


import fr.esgi.log.*;
import fr.esgi.log.Readable;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {

    static void main() {

        Readable source1 = new Request("Je me connecte");
        Readable source2 = new Response("Je suis connecté", 200);
        Log<Readable> log = new Log<>(CRITICITY.INFO, source1);
        Log<Readable> log2 = new Log<>(CRITICITY.ERROR, source2);

        List<Log<Readable>> logs = List.of(log, log2);

        Consumer<Log<Readable>> printMessage = (Log<Readable> l) -> System.out.println(l.getMessage());

        Predicate<Log<Readable>> isError = (Log<Readable> l) -> l.getCriticity() == CRITICITY.ERROR;

        logs                                // parcours mes logs
                .stream()                   // j'ouvre le flux de données
                .map(Log::getMessage)
                //.map(l -> l.getMessage()
                // je transforme un log en message (càd une String)
                .forEach(String::toUpperCase);
    }
}
