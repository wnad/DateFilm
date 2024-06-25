package com.datefilm.datefilm_server.controller.record;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "2.0. records", description = "기록")
@RequestMapping({"/v1/records"})
@RestController
@Slf4j
public class RecordController {

}