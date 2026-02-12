package fr.esgi;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class LogGenerator {

    private static final String[] ENDPOINTS = {
            "/api/login", "/api/orders", "/api/products",
            "/api/users", "/api/cart", "/api/payments"
    };

    private static final String[] METHODS = {
            "GET", "POST", "PUT", "DELETE"
    };

    private static final int[] STATUSES = {
            200, 201, 204, 400, 401, 404, 500, 503
    };

    public static List<LogEntry> generate(int size) {

        return IntStream.range(0, size)
                .parallel()
                .mapToObj(i -> new LogEntry(
                        LocalDateTime.now()
                                .minusSeconds(ThreadLocalRandom.current().nextInt(0, 200000)),
                        "user" + ThreadLocalRandom.current().nextInt(1, 5000),
                        ENDPOINTS[ThreadLocalRandom.current().nextInt(ENDPOINTS.length)],
                        METHODS[ThreadLocalRandom.current().nextInt(METHODS.length)],
                        STATUSES[ThreadLocalRandom.current().nextInt(STATUSES.length)],
                        ThreadLocalRandom.current().nextLong(5, 3000)
                ))
                .toList();
    }
}
