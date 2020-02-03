package xdml;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("repos")
public class IssueController {

    @DeleteMapping("/{owner}/{repo}/issues/{issueNumber}/lock")
    public void unlock(
        @PathVariable("owner") String owner, //把url中的{owner}与参数owner 关联起来
        @PathVariable("repo") String repo,
        @PathVariable("issueNumber") String issueNumber
    ){
        System.out.println(owner);
        System.out.println(repo);
        System.out.println(issueNumber);

    }

    //以github api的create an issue为例
    //POST请求：整个body就是参数，适用于JSON对象作为参数
    @PostMapping("/{owner}/{repo}/issues")
    public void creat(
            @PathVariable("owner") String owner, //把url中的{owner}与参数owner 关联起来
            @PathVariable("repo") String repo,
            @RequestBody MyParam object
    ){
        System.out.println(object.getTitle());
        System.out.println(object.getLabels().get(0));
    }

    //POST请求: 从form中拿参数
    @PostMapping("/login")
    public void login(@RequestParam("username")String userName
                     ,@RequestParam("password")Integer password){
        System.out.println("username: " + userName);
        System.out.println("pasword: " + password);
    }

}
