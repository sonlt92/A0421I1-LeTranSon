package letranson.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.NumberFormat;

@Controller
public class ConvertController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage() {
        return "index";
    }

    @RequestMapping(value = "/convert", method = RequestMethod.GET)
    public ModelAndView convertMoney(@RequestParam double money) {
        ModelAndView  convertPage = new ModelAndView("index");
        double  result = money * 23000;
//        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
//        String  resultString = numberFormat.format(result);
        convertPage.addObject("result", result);
        return convertPage;
    }
}




