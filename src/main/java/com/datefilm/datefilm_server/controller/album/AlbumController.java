package com.datefilm.datefilm_server.controller.album;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name="2.0. album",description = "앨범")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/v1/albums")
@RestController
public class AlbumController {
}
