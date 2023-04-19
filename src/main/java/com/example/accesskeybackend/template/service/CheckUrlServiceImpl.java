package com.example.accesskeybackend.template.service;

import com.example.accesskeybackend.exception.CheckUrlException;
import com.example.accesskeybackend.template.dto.CheckUrlResponse;
import org.springframework.stereotype.Service;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CheckUrlServiceImpl implements CheckUrlService {

    @Override
    public CheckUrlResponse checkIpv6Support(String siteUrl) throws CheckUrlException {
        if (!isValidUrl(siteUrl)) {
            throw new CheckUrlException("Invalid URL: " + siteUrl);
        }

        boolean supportsIPv6 = false;

        try {
            InetAddress address = InetAddress.getByName(siteUrl);
            supportsIPv6 = (address instanceof Inet6Address);
        } catch (UnknownHostException e) {
            throw new CheckUrlException("Error checking IPv6 support for URL: " + siteUrl);
        }

        CheckUrlResponse response = new CheckUrlResponse(supportsIPv6);
        return response;
    }

    private boolean isValidUrl(String url) {
        Pattern urlPattern = Pattern.compile("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");
        Matcher matcher = urlPattern.matcher(url);
        return matcher.matches();
    }
}



