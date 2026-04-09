package fr.esgi.log;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class LogGenerator {

    public static List<Log<?>> generateLogs(int size) {
        List<Log<?>> logs = new ArrayList<>();

        for (int i = 0; i < size; i++) {

            int status = randomHttpStatus();
            String body = "Message #" + i + " - status " + status;

            LocalDateTime timestamp =
                    LocalDateTime.now()
                            .minusDays(ThreadLocalRandom.current().nextInt(0, 60));

            Readable source = new Request(body);

            CRITICITY level =
                    status >= 500 ? CRITICITY.ERROR :
                            status >= 400 ? CRITICITY.WARN :
                                    CRITICITY.INFO;

            Log<Readable> log = new Log<>(level, source);

            logs.add(log);
        }

        return logs;
    }

    private static int randomHttpStatus() {
        int[] statuses = {200, 201, 204, 400, 401, 403, 404, 500, 502, 503};
        return statuses[ThreadLocalRandom.current().nextInt(statuses.length)];
    }
}
