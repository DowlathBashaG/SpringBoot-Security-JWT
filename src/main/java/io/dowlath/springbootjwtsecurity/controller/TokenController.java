package io.dowlath.springbootjwtsecurity.controller;

import io.dowlath.springbootjwtsecurity.model.JwtUser;
import io.dowlath.springbootjwtsecurity.security.JwtGenerator;
import org.springframework.web.bind.annotation.*;

import java.util.stream.DoubleStream;

/**
 * @Author Dowlath
 * @create 7/10/2020 6:46 PM
 */
@RestController
@RequestMapping("/token")
public class TokenController {

    private JwtGenerator jwtGenerator;

    public TokenController(JwtGenerator jwtGenerator){
        this.jwtGenerator = jwtGenerator;
    }

   @PostMapping
    public String generate(@RequestBody final JwtUser jwtUser){

       return jwtGenerator.generate(jwtUser);
    }

}
