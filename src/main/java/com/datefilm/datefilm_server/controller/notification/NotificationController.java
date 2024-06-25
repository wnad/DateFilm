package com.datefilm.datefilm_server.controller.notification;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name="5.0. notifications",description = "알림")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/v1/notifications")
@RestController
public class NotificationController {
}
