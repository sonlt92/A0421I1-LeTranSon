package letranson.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.TreeMap;

@Controller
public class DictionaryController {
    @RequestMapping(value = "/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("dictionary");
        return modelAndView;
    }

    @RequestMapping(value = "/dictionary", method = RequestMethod.GET)
    public ModelAndView dictionary(@RequestParam String word) {
        boolean check = false;
        String result = "";
        ModelAndView modelAndView = new ModelAndView("dictionary");
        Map<String, String> listWord = new TreeMap<>();
        listWord.put("hello", "Xin chào");
        listWord.put("how", "Thế nào");
        listWord.put("able", "Có tài");
        listWord.put("to", "Đến");
        listWord.put("about ", "Khoảng");
        for (int i = 0; i < listWord.size(); i++) {
            if (word.contains((CharSequence) listWord.keySet().toArray()[i])) {
                result = listWord.get(listWord.keySet().toArray()[i]);
                check = true;
                break;
            }
        }
        if (check == false) {
            result = "Không tìm thấy từ cần tra";
        }
        modelAndView.addObject("result", result);
        return modelAndView;
    }
}
