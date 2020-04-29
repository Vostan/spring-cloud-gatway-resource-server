package ee.trigon.gateway.client;

import ee.trigon.gateway.dto.UsernameDTO;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient.Builder;
import reactor.core.publisher.Mono;

@Service
public class UserClient {

  private final Builder loadBalancedWebClientBuilder;

  public UserClient(Builder loadBalancedWebClientBuilder) {
    this.loadBalancedWebClientBuilder = loadBalancedWebClientBuilder;
  }

  public Mono<UsernameDTO[]> getUserNames() {
    return loadBalancedWebClientBuilder.build().get().uri("localhost:8081/users/list")
        .accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .bodyToMono(UsernameDTO[].class);
  }
}
