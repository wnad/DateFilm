package com.datefilm.datefilm_server.controller.album;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "2.0. albums", description = "앨범")
@RequestMapping({"/v1/albums"})
@RestController
@Slf4j
public class AlbumController {

}