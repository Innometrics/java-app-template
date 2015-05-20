package com.innometrics.integrationapp.gettingstart;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.innometrics.commons.model.Attribute;
import com.innometrics.commons.model.Profile;
import com.innometrics.util.JacksonUtil;
import com.innometrics.utils.app.commons.settings.exception.NoPropertyAvailableException;
import com.innometrics.utils.app.commons.settings.wrapper.ProfileCloudWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by killpack on 13.01.15.
 */
@Component
public class Controller {
    @Autowired
    private ProfileCloudWrapper profileCloudDAO;
    List<String> urls = new ArrayList<String>();
    @RequestMapping(value = "/", method = RequestMethod.POST, headers = {"Accept=*/*", "Content-Type=*/*"})
    public String root(@RequestBody String body) {
        try {
            JsonNode jsonNode = JacksonUtil.getObjectMapper().readTree(body);
            Profile profile = JacksonUtil.getObjectMapper().readValue(jsonNode.get("profile").toString(), Profile.class);
            JsonNode jsonData = profile.getSessions().get(0).getEvents().get(0).getData();
            if (jsonData.has("page-url")) {
                urls.add(jsonData.get("page-url").toString());
                if (urls.size()>=10){
                    urls.remove(0);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "test";
    }

    @RequestMapping(value = "/view")
    public String view(Model model) {
        model.addAttribute("profileCloudDAO", profileCloudDAO);
        model.addAttribute("urls", urls);
        return "test";
    }

    @RequestMapping(value = "/sendAttribute")
    public String sendAttribute(@RequestParam("section") String section, @RequestParam("key") String key,
                                @RequestParam("value") String value,@RequestParam("profileId") String profileId, Model model) {
        model.addAttribute("profileId", profileId);
        model.addAttribute("section", section);
        model.addAttribute("key", key);
        model.addAttribute("value", value);
        model.addAttribute("profileCloudDAO", profileCloudDAO);
        model.addAttribute("urls", urls);
        try {
            Attribute attribute = new Attribute();
            attribute.setSection(section);
            ObjectNode objectNode = JacksonUtil.getObjectMapper().createObjectNode();
            objectNode.put(key,value);
            attribute.setData(objectNode);
            Profile profile = profileCloudDAO.getProfile(profileId).getProfile();
            profile.getAttributes().add(attribute);
            profileCloudDAO.updateProfile(profile);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (NoPropertyAvailableException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "test";
    }

}
