package pattern.decorator.passport;


import pattern.decorator.passport.old.ISigninService;
import pattern.decorator.passport.old.SigninService;
import pattern.decorator.passport.upgrede.ISigninForThirdService;
import pattern.decorator.passport.upgrede.SigninForThirdService;

/**
 * Created by Tom on 2018/3/17.
 */
public class SigginTest {


    public static void main(String[] args) {

        //原来的功能依旧对外开放，依旧保留
        //新的功能同样的也可以使用



        //对老的没有影响，增加了新的功能
        ISigninService oldService = new SigninService();
        oldService.login("xbog","laowei");

        //增加了新的功能
        ISigninForThirdService signinForThirdService = new SigninForThirdService(new SigninService());
        signinForThirdService.login("old","old");
        signinForThirdService.loginForQQ("新功能");




//        Decorator
//        Wrapper


        /*

            ===============================================================------
            装饰器模式                          |   适配器模式
            -----------------------------------+---------------------------------
            是一种非常特别的适配器模式            |  可以不保留层级关系
            -----------------------------------+---------------------------------
            装饰者和被装饰者都要实现同一个接口     |  适配者和被适配者没有必然的层级联系
            主要目的是为了扩展，依旧保留OOP关系    |  通常采用代理或者继承形式进行包装
            -----------------------------------+----------------------------------
            满足is-a的关系                      |   满足has-a
            -----------------------------------+----------------------------------
            注重的是覆盖、扩展                   |   注重兼容、转换
            -----------------------------------+----------------------------------


        */


    }

}
