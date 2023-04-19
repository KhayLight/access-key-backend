package com.example.accesskeybackend.template.controller;

import com.example.accesskeybackend.exception.CheckUrlException;
import com.example.accesskeybackend.template.service.CheckUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/web")
public class CheckUrlController {

    private final CheckUrlService checkUrlService;

    @Autowired
    public CheckUrlController(CheckUrlService checkUrlService) {
        this.checkUrlService = checkUrlService;
    }

    @GetMapping("/checkIpv6Support")
    public ResponseEntity<Boolean> checkIpv6Support(@RequestParam String siteUrl) throws CheckUrlException {
        boolean result = checkUrlService.checkIpv6Support(siteUrl).isSuccess();
        return ResponseEntity.ok(result);
    }

    @ExceptionHandler(CheckUrlException.class)
    public ResponseEntity<String> handleCheckUrlException(CheckUrlException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}

