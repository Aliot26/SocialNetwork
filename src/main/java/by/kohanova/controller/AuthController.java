package by.kohanova.controller;

import by.kohanova.model.Token;
import by.kohanova.model.User;
import by.kohanova.security.TokenService;
import by.kohanova.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final TokenService tokenService;
    private final UserService userService;

    @Autowired
    public AuthController(TokenService tokenService, UserService userService) {
        this.tokenService = tokenService;
        this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> authenticate(@RequestBody User requestUser) {
        if (isNotEmpty(requestUser.username) && isNotEmpty(requestUser.password)) {
            User user = userService.findByUsername(requestUser.username);
            String token = tokenService.generate(user, requestUser.password);
            System.out.println(token);
            if (token != null) {
                user.password = "";
                return new ResponseEntity<>(new Token(token, user), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}