package com.datefilm.datefilm_server.controller.reply;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "4.0. replies", description = "댓글")
@RequestMapping({"/v1/replies"})
@RestController
@Slf4j
public class ReplyController {

}