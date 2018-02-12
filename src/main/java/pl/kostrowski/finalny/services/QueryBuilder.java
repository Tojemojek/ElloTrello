package pl.kostrowski.finalny.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class QueryBuilder {

    @Value("${trello.server.address}")
    private String trelloAddress;

    @Value("${trello.user.key}")
    private String key;

    @Value("${trello.user.token}")
    private String token;


    public String createQueryPath(String request) {
        if (request.contains("?")) {
            return trelloAddress + request + "&key=" + key + "&token=" + token;
        } else {
            return trelloAddress + request + "?key=" + key + "&token=" + token;
        }
    }
}
