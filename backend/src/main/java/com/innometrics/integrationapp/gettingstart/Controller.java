package com.innometrics.integrationapp.gettingstart;

import com.innometrics.utils.app.commons.settings.wrapper.ProfileCloudWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by killpack on 13.01.15.
 */
@org.springframework.stereotype.Controller
public class Controller {



    @RequestMapping(value = "/" )
    public String root() {
        return "test";
    }

    @RequestMapping(value = "/test")
    public String all() {
        return "test";
    }
}
