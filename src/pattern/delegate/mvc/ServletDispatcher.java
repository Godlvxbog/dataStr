package pattern.delegate.mvc;


import pattern.delegate.mvc.controllers.MemberAction;
import pattern.delegate.mvc.controllers.OrderAction;
import pattern.delegate.mvc.controllers.SystemAction;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 相当于是项目经理的角色
 * Created by Tom on 2018/3/14.
 * 经典场景：dispatch
 *
 * 接受消息之后然后分发给不同的处理器Handler
 * 委派模式：
 * 1、分配任务之前，需要做一个选择，选择不同处理器？类似于策略模式
 * 以Delegate结尾、dispatcher结尾的
 *
 * 策略常量:这里是url，也可以是其他枚举类。
 *
 */
public class ServletDispatcher {

    private List<Handler> handlerMapping = new ArrayList<Handler>();

    public ServletDispatcher(){
        try {
            Class<?> memberActionClass = MemberAction.class;
            handlerMapping.add(new Handler()
                    .setController(memberActionClass.newInstance())
                    .setMethod(memberActionClass.getMethod("getMemberById", new Class[]{String.class}))
                    .setUrl("/web/getMemberById.json"));


            handlerMapping.add(new Handler()
                    .setController(new OrderAction())
                    .setMethod(memberActionClass.getMethod("getOrderById", new Class[]{String.class}))
                    .setUrl("/web/getOrderById.json"));

            handlerMapping.add(new Handler()
                    .setController(new SystemAction())
                    .setMethod(memberActionClass.getMethod("logout", new Class[]{String.class}))
                    .setUrl("/web/getOrderById.json"));
        }catch(Exception e){

        }
    }



    public void doService(HttpServletRequest request, HttpServletResponse response){
        doDispatch(request,response);
    }


    /**
     * 分发策略
     * @param request
     * @param response
     */
    private void doDispatch(HttpServletRequest request, HttpServletResponse response){

        //1、获取用户请求的url
        //   如果按照J2EE的标准、每个url对对应一个Serlvet，url由浏览器输入
       String uri = request.getUri();

        //2、Servlet拿到url以后，要做权衡（要做判断，要做选择）
        //   根据用户请求的URL，去找到这个url对应的某一个java类的方法

        //3、通过拿到的URL去handlerMapping（我们把它认为是策略常量）
        Handler handle = null;
        for (Handler h: handlerMapping) {
            if(uri.equals(h.getUrl())){
                handle = h;
                break;
            }
        }

        //4、将具体的任务分发给Method（通过反射去调用其对应的方法）
        Object object = null;
        try {
            object = handle.getMethod().invoke(handle.getController(),request.getParamters("mid"));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //5、获取到Method执行的结果，通过Response返回出去
//        response.getWriter().write();

    }


    class Handler{

        private Object controller;
        private Method method;
        private String url;

        public Object getController() {
            return controller;
        }

        public Handler setController(Object controller) {
            this.controller = controller;
            return this;
        }

        public Method getMethod() {
            return method;
        }

        public Handler setMethod(Method method) {
            this.method = method;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Handler setUrl(String url) {
            this.url = url;
            return this;
        }
    }


    private class HttpServletRequest {
        private String uri;
        private HashMap paramters = new HashMap();

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public Object getParamters(String key) {
            return paramters.get(key);
        }

        public void setParamters(HashMap paramters) {
            this.paramters = paramters;
        }
    }

    private class HttpServletResponse {
    }
}
