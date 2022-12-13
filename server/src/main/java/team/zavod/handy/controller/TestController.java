package team.zavod.handy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/test")
public class TestController {
  @GetMapping
  public ResponseEntity<String> test() {
    return new ResponseEntity<>("Hello, world!", HttpStatus.OK);
  }
}
