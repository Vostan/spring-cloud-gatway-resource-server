package ee.trigon.gateway.handler;

import static org.springframework.http.MediaType.APPLICATION_STREAM_JSON;

import ee.trigon.gateway.client.UserClient;
import ee.trigon.gateway.dto.UsernameDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Component
@Slf4j
public class UserHandler {

  private final UserClient userClient;

  public UserHandler(UserClient userClient) {
    this.userClient = userClient;
  }

  public Mono<ServerResponse> listUserNames(ServerRequest request) {

    var usernamesMono = userClient.getUserNames().subscribeOn(Schedulers.elastic());

    return ServerResponse.ok().contentType(APPLICATION_STREAM_JSON)
        .body(usernamesMono, UsernameDTO[].class);
  }
}
