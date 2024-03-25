package aprilnotificationtwilio.assets.controller;

import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import aprilnotificationtwilio.request.TwilioRequest;
import aprilnotificationtwilio.service.TwilioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TwilioController {

    @Autowired
    private TwilioService twilioService;

    private TwilioRequest twilioRequest;

    @RequestMapping("/")
    public String homepage(ModelAndView model) {
        return "index";
    }

    @PostMapping("path")
    public String postMethodName(@RequestBody String entity) {
        return entity;
    }

    @PostMapping("/sendmessage")
    public ResponseEntity<String> sendMessage(@RequestBody TwilioRequest twilioRequest) {
        String status = twilioService.sendsms(twilioRequest);
        if ("sent".equals(status) || "queued".equals(status)) {
            return ResponseEntity.ok("Message sent successfully");
        } else {
            
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to send message");
        }
    }

}
