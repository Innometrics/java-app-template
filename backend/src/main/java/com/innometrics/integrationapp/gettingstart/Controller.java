package com.innometrics.integrationapp.gettingstart;

import com.innometrics.utils.app.commons.settings.wrapper.ProfileCloudWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

/**
 * Created by killpack on 13.01.15.
 */
@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private ProfileCloudWrapper profileCloudDAO;


    @RequestMapping(value = "/")
    public String root() {
        return "test";
    }

    @RequestMapping(value = "/view")
    public String view(Model model) {
        model.addAttribute("profileCloudDAO", profileCloudDAO);
        return "test";
    }
}
