package com.datefilm.datefilm_server.controller.user;

import com.datefilm.datefilm_server.service.user.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name="1.0. user",description = "유저")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/v1/users")
@RestController
public class UserController {

}
