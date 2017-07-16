package cm.com.alien.user.client;

import cn.com.alien.user.api.UserService;
import cn.com.alien.user.api.req.UserReq;
import cn.com.alien.user.api.req.base.BaseReq;
import org.mockito.cglib.beans.BeanMap;
import org.spring.boot.thrift.client.annotation.ThriftClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Howell on 17/1/11.
 */
@RestController
public class UserController {

    @ThriftClient(serviceId = "userServer", path = "/userService")
    UserService.Client UserServiceClient;

    @RequestMapping(method = RequestMethod.GET, value = "/userLogin")
    public Object userService() throws Exception {
        Map<String, Object> o = new HashMap<>();
        UserReq userReq = new UserReq();
        userReq.setUserPasswd("123456");
        userReq.setUserId("123456");
        userReq.setUserIp("123456");
        userReq.setUserMac("123456");
        userReq.setBaseReq(new BaseReq().setIp("123456").setKeep("123456"));
        UserServiceClient.userLogin(userReq);
        o = BeanMap.create(UserServiceClient.userLogin(userReq).getBaseResp());
        return o;
    }





}