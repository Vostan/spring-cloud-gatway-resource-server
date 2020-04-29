package ee.trigon.gateway.router;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

import ee.trigon.gateway.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class UserRouter {

  @Bean
  public RouterFunction<ServerResponse> route(UserHandler handler) {
    return RouterFunctions
        .route(GET("/users/names").and(accept(MediaType.APPLICATION_JSON)), handler::listUserNames);
  }

}
