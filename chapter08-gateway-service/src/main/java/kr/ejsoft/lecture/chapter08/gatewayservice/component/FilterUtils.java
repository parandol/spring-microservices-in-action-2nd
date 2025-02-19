package kr.ejsoft.lecture.chapter08.gatewayservice.component;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.List;

@Component
public class FilterUtils {

    public static final String CORRELATION_ID = "tmx-correlation-id";

    public boolean isCorrelationIdPresent(HttpHeaders requestHeaders) {
        if(this.getCorrelationId(requestHeaders) != null) return true;
        return false;
    }

    public String getCorrelationId(HttpHeaders requestHeaders) {
        if(requestHeaders.get(CORRELATION_ID) != null) {
            List<String> header = requestHeaders.get(CORRELATION_ID);
            return header.stream().findFirst().get();
        }
        return null;
    }

    public ServerWebExchange setCorrelationId(ServerWebExchange exchange, String correlationId) {
        return this.setRequestHeader(exchange, CORRELATION_ID, correlationId);
    }

    public ServerWebExchange setRequestHeader(ServerWebExchange exchange, String name, String value) {
        return exchange.mutate().request(
                exchange.getRequest().mutate()
                        .header(name, value)
                        .build()
        ).build();
    }
}
