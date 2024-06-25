package com.datefilm.datefilm_server.controller.user;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "1.0. users", description = "유저")
@RequestMapping({"/v1/users"})
@RestController
@Slf4j
public class UserController {

}