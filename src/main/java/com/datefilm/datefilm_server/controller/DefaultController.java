package com.datefilm.datefilm_server.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name="0. health check",description = "상태 체크를 위한 컨트롤러")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/v1/health")
@RestController
public class DefaultController {

    @Operation(summary = "0.1")
    @GetMapping
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("ok");
    }
}
