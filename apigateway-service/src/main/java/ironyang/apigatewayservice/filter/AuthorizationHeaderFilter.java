package ironyang.apigatewayservice.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Slf4j
@Component
public class AuthorizationHeaderFilter extends AbstractGatewayFilterFactory {
    private final Environment env;
    @Override
    public GatewayFilter apply(Object config) {
        return (((exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();

            if (!request.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                return onError(exchange, "no authorization header", HttpStatus.UNAUTHORIZED);
            }

            String authorizationHeader = request.getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
            String jwt = authorizationHeader.replace("Bearer ", "");
            if (!isJwtValid(jwt)) {
                return onError(exchange, "JWT is not valid", HttpStatus.UNAUTHORIZED);
            }

            return chain.filter(exchange);
        }));
    }

    private boolean isJwtValid(String jwt) {
        boolean result = true;
        String secret = "jc";
//        String secret = env.getProperty("token.secret");
        String subject = JWT.require(Algorithm.HMAC512(secret))
                .build()
                .verify(jwt)
                .getClaim("email")
                .asString();

        log.info("AuthorizationHeaderFilter.isJwtValid().subject={}", subject);

        if (subject == null || subject.isEmpty()) {
            result = false;
        }

        return result;
    }

    // Mono, Flux : Spring WebFlux 에서 나온 개념
    private Mono<Void> onError(ServerWebExchange exchange, String errorMessage, HttpStatus status) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(status);
        log.error(errorMessage);

        return response.setComplete();
    }
}
