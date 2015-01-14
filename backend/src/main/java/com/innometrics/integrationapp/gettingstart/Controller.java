package com.innometrics.integrationapp.gettingstart;

import org.springframework.web.bind.annotation.RequestMapping;

import java.net.MalformedURLException;
import java.util.concurrent.ExecutionException;

/**
 * Created by killpack on 13.01.15.
 */
@org.springframework.stereotype.Controller
public class Controller {
//    @Autowired
//    private ProfileCloudWrapper profileCloudDAO;


    @RequestMapping(value = "/" )
    public String root() {
//        try {
//            profileCloudDAO.getApp();
//        } catch (NoPropertyAvailableException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
        return "test";
    }

    @RequestMapping(value = "/test")
    public String all() {
        return "test";
    }
}
