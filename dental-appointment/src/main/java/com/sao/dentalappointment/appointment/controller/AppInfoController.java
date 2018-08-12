package com.sao.dentalappointment.appointment.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AppInfoController {

    @Value("${app.version:test}")
    public String appVersion;

    @ResponseBody
    @RequestMapping("/info")
    public Map info() {
        Map map = new HashMap();
        map.put("appVersion", appVersion);
        return map;
    }
}
