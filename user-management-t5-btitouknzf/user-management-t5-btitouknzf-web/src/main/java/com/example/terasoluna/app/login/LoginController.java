package com.example.terasoluna.app.login;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.terasoluna.domain.service.userdetails.SampleUserDetails;
import com.example.terasoluna.domain.service.userdetails.SampleUserDetailsService;

@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory
            .getLogger(LoginController.class);

    /*
	@RequestMapping( value = "check", params = "chk")
	public String firstLogin(@AuthenticationPrincipal SampleUserDetails sampleUserDetails, Model model ){
		if(sampleUserDetails.getUserInfo().getState() == 0){
			model.addAttribute(sampleUserDetails);
			return "password/changeForm";
		}
		model.addAttribute(sampleUserDetails);
		return "top/menu";
	}
	*/

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public String home(Locale locale, @AuthenticationPrincipal SampleUserDetails sampleUserDetails, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);

        /*
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
                DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        return "login/test";
        */
        
        if(sampleUserDetails.getUserInfo().getState() == 0){
			model.addAttribute(sampleUserDetails);
			return "password/changeForm";
		}
		model.addAttribute(sampleUserDetails);
		return "top/menu";
    }

}
