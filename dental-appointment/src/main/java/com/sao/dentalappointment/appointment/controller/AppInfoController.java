package com.sao.dentalappointment.appointment.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppInfoController {

    public static class AppInfo {

        @Value("${app.version}")
        public String appVersion;
    }

    @ResponseBody
    @RequestMapping("/info")
    public AppInfo info() {
        return new AppInfo();
    }
}
