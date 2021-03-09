package cn.com.taiji.learn.sshelloworld.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

//    @RequestMapping(value = "/h",method = RequestMethod.GET)
    @GetMapping("/h")
    public String helloWorld(){
        return "Hello World!";
    }

    @PostMapping("/h")
    public String add(
            @RequestParam(value = "name",required = true)
                    String name){
//        if(StrUtil.isBlank(name)){
//           throw new RuntimeException("不能为null");
//        }
        return "Added Success:"+name;
    }

//    Delete  Update
}
