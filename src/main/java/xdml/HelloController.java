package xdml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import xdml.dao.UserMapper;
import xdml.entity.RankItem;
import xdml.service.RankService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {
    @Autowired
    UserMapper userMapper;

    @Autowired
    RankService rankService;

    @RequestMapping("/search")
    public String search(@RequestParam("q") String searchKeyword,
                         @RequestParam(value = "charset", required = false) String charset) {
        return "you are searching, key word: " + searchKeyword + "  charset:" + charset;
    }

    //返回值:直接拼接HTML返回
    //原始、粗暴、不常用
    @RequestMapping("/searchHtml")
    public String searchHtml() {
        return "<html><body><h1>直接返回拼接的HTML字符串</h1></body></html>";
    }

    //返回值:直接使用HttpServletResponse对象拼接返回值
    //原始、粗暴、不常用
    @RequestMapping("/searchHttpResponse")
    public void searchHttpResponse(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.getWriter().write("HttpServletResponse write something");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //返回值: 返回值为JSON对象
    //最常用
    @RequestMapping("/searchMap")
    @ResponseBody
    public Object searchMap() {
        Map<String, Object> result = new HashMap<>();
        result.put("a", "aaaa");
        result.put("b", "bbbbb");
        return result;
    }

    @RequestMapping("/getUserById")
    public Object getUserById(@RequestParam("id") Integer id) {
        return userMapper.getUserById(id);
    }

    @RequestMapping("/getRank")
    public Object getRank() {
        return rankService.getRank();
    }

    @RequestMapping("/getDataByFreeMaker")
    public ModelAndView getDataByFreeMaker(){
        List<RankItem> items = rankService.getRank();
        HashMap<String,Object> model = new HashMap<>();
        model.put("rankItems",items);
        //index是resources/templates/index.ftlh文件
        return new ModelAndView("index",model);
    }

    @RequestMapping("/getRankItemByJS")
    public List<RankItem> getRankItemByJS(){
        return rankService.getRank();
    }
}