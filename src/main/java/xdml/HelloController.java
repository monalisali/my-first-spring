package xdml;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @RequestMapping("/search")
    public String search(@RequestParam("q")String searchKeyword,
                         @RequestParam(value = "charset", required = false)String charset) {
        return "you are searching, key word: " + searchKeyword + "  charset:" + charset;
    }

}