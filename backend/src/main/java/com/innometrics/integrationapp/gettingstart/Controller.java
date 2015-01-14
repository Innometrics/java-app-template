package com.innometrics.integrationapp.gettingstart;

import com.innometrics.utils.app.commons.settings.exception.IncorrectConfigurationException;
import com.innometrics.utils.app.commons.settings.store.ProfileCloudSettings;
import com.innometrics.utils.app.commons.settings.strategy.OnlyEnvironmentStrategy;
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


    @RequestMapping(value = "/" )
    public String root() {
        return "test";
    }

    @RequestMapping(value = "/view")
    public String view(Model model) {
        try {
            model.addAttribute("profileCloudDAO",new ProfileCloudSettings(new OnlyEnvironmentStrategy()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IncorrectConfigurationException e) {
            e.printStackTrace();
        }
        return "test";
    }
}
