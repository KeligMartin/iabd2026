package fr.esgi;


import fr.esgi.log.*;
import fr.esgi.log.Readable;

import java.time.LocalDateTime;
import java.util.*;

public class Main {

    static void main() {

        Readable source1 = new Request("Je me connecte");
        Readable source2 = new Response("Je suis connecté", 200);

        Log<Readable> log = new Log<>(CRITICITY.INFO, LocalDateTime.now(), source1);
        Log<Readable> log2 = new Log<>(CRITICITY.ERROR, LocalDateTime.now(), source2);

        try {
            log2.triggerException();
        } catch (BodyNotReadableException e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Analyse du body terminée");
        }

        // 15 minutes pour rédiger l'exception FutureTimestampException

    }
}
