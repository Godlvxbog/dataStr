//package his_2018.TuijianAlg;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
///**
// * Created by Administrator on 2017/3/11.
// */
//public class CountSim {
//
//
//    public void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
////        long startTime = System.currentTimeMillis();   //获取开始时间
//
//        UserListVector ul = new UserListVector();
//        DisDAO disdao = new DisDAO();
//        SimDao simdao = new SimDao();
//        similarity sim = new similarity();
//        ArrayList<UserVo> ulist = ul.getList();
//        String likeId[] = request.getParameterValues("num");//表单传来的已选择的菜谱的ID
//        ArrayList<Integer> likeList = new ArrayList<Integer>();//转换成动态数据int型
//        for (int i = 0; i < likeId.length; i++) {
//            likeList.add(Integer.parseInt(likeId[i]));
//        }
//
//        int userid = Integer.parseInt(request.getParameter("userid"));//表单传来的选择菜谱的用户的id
//        UserVo user = null;
//        for (int i = 0; i < ulist.size(); i++) {//找到id为这个的用户,并为他添加喜欢的菜谱id
//            user = ulist.get(i);
//            if (user.getUserId() == userid) {
//                user.setLike(likeList);
//            }
//        }
//        ArrayList<String> str1 = new ArrayList<String>();//这个作为用户的向量空间.
//        str1 = simdao.getUserVector(userid);//得到这个用户的向量空间
//        Map<Integer, Double> simList = new HashMap<Integer, Double>();//存放计算的相似值
//        for (int i = 0; i < 1000; i++) {//在这里修改总共对比的条数
//            double res = sim.getSimilarDegree(str1, simdao.getRecipeVector(i));
//            if (!Double.isNaN(res)) {
//                simList.put((Integer) disdao.idlist.get(i), res);
//            }
//            System.out.println(res);
//        }
//
//         /*
//            对map进行排序取前十
//             */
//        List<Map.Entry<Integer, Double>> infoIds = new ArrayList<Map.Entry<Integer, Double>>(simList.entrySet());
//        //对value进行排序
//        Collections.sort(infoIds, new Comparator<Map.Entry<Integer, Double>>() {
//            @Override
//            public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
//                return (o2.getValue()).toString().compareTo(o1.getValue().toString());
//            }
//
//        });
//
//
//        // 对HashMap中的 value 进行排序后  显示排序结果
//
//        long endTime = System.currentTimeMillis(); //获取结束时间
//        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
//
//        request.setAttribute("list", infoIds);
//        request.getRequestDispatcher("/Rec_list.jsp").forward(request, response);
//    }
//
//}
