package ee.trigon.gateway.entity;

import lombok.Data;

@Data
public class User {

  Long id;
  String username;
  String password;

}
