package com.datefilm.datefilm_server.controller.reply;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name="4.0. reply",description = "유저")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/v1/replies")
@RestController
public class ReplyController {
}
