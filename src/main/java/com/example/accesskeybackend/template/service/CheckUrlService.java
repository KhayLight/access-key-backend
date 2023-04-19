package com.example.accesskeybackend.template.service;

import com.example.accesskeybackend.exception.CheckUrlException;
import com.example.accesskeybackend.template.dto.CheckUrlResponse;

public interface CheckUrlService {

    CheckUrlResponse checkIpv6Support(String siteUrl) throws CheckUrlException;

}

