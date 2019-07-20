package pattern.adapter.passport;


import pattern.adapter.Member;
import pattern.adapter.ResultMsg;

/**
 * Created by Tom on 2018/3/14.
 *
 * 其别名为包装器(Wrapper)
 *
 * Spring AOP 模块对 BeforeAdvice、 AfterAdvice、 ThrowsAdvice 三种通知类型的支持实际上是借助适配器模式来实现的
 */
public class SiginService {

    /**
     * 注册方法
     * @param username
     * @param password
     * @return
     */
    public ResultMsg regist(String username, String password){
        return  new ResultMsg("200","注册成功",new Member());
    }


    /**
     * 登录的方法
     * @param username
     * @param password
     * @return
     */
    public ResultMsg login(String username,String password){
        return null;
    }

}
