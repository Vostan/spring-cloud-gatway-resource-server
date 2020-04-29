package ee.trigon.userservice.controller;

import ee.trigon.userservice.entity.User;
import ee.trigon.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

  private final UserService userService;

  @GetMapping("/users/list")
  public Flux<User> getUsers(@RequestHeader(value = "Authorization", required = false) String auth){
    log.info(auth); //here we can see that Auth header is NULL
    return Flux.fromIterable(userService.getUsers())
        .doOnNext( user -> log.info("Getting User : " + user.getUsername()));
  }

}
