package myChat.controller;

import myChat.tools.ClientSocket;
import myChat.tools.ScanIP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@org.springframework.web.bind.annotation.RestController

@RequestMapping("api")
public class RestController {

    private final Logger logger = LoggerFactory.getLogger(RestController.class);

    @GetMapping("/testingConnection")
    public HttpStatus testing()
    {
        logger.info("testingConnection request");
        return HttpStatus.OK;
    }


    @GetMapping("/get/Ip")
    public List<String> getAllIp()
    {
        logger.info("getting All Client Ip");
        return ClientSocket.getClientIpAddress();
    }


}
