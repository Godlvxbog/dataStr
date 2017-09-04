package TuijianAlg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/3/11.
 */
public class Similarity {
    /*
    * 计算两个字符串(英文字符)的相似度，简单的余弦计算，未添权重
    */
    public double getSimilarDegree(ArrayList<String> str1, ArrayList<String> str2)
    {
        //创建向量空间模型，使用map实现，主键为词项，值为长度为2的数组，存放着对应词项在字符串中的出现次数
        Map<String, int[]> vectorSpace = new HashMap<String, int[]>();
        int[] itemCountArray = null;//为了避免频繁产生局部变量，所以将itemCountArray声明在此

        //动态数组转为数组

        int size1=str1.size();
        String[] strArray1 = (String[])str1.toArray(new String[size1]);

        for(int i=0; i<strArray1.length; ++i)
        {
            if(vectorSpace.containsKey(strArray1[i]))
                ++(vectorSpace.get(strArray1[i])[0]);
            else
            {
                itemCountArray = new int[2];
                itemCountArray[0] = 1;
                itemCountArray[1] = 0;
                vectorSpace.put(strArray1[i], itemCountArray);
            }
        }
        int size2=str2.size();
        String[] strArray2 = (String[])str2.toArray(new String[size2]);
        for(int i=0; i<strArray2.length; ++i)
        {
            if(vectorSpace.containsKey(strArray2[i]))
                ++(vectorSpace.get(strArray2[i])[1]);
            else
            {
                itemCountArray = new int[2];
                itemCountArray[0] = 0;
                itemCountArray[1] = 1;
                vectorSpace.put(strArray2[i], itemCountArray);
            }
        }

        //计算相似度
        double vector1Modulo = 0.00;//向量1的模
        double vector2Modulo = 0.00;//向量2的模
        double vectorProduct = 0.00; //向量积
        Iterator iter = vectorSpace.entrySet().iterator();

        while(iter.hasNext())
        {
            Map.Entry entry = (Map.Entry)iter.next();
            itemCountArray = (int[])entry.getValue();

            vector1Modulo += itemCountArray[0]*itemCountArray[0];
            vector2Modulo += itemCountArray[1]*itemCountArray[1];

            vectorProduct += itemCountArray[0]*itemCountArray[1];
        }

        vector1Modulo = Math.sqrt(vector1Modulo);
        vector2Modulo = Math.sqrt(vector2Modulo);

        //返回相似度
        return (vectorProduct/(vector1Modulo*vector2Modulo));
    }

    /*
    计算原料列相似度的时候去除数字和“克”这些无用词
    用正则表达式
     */
    public boolean delUseless(String value){

        Pattern pattern = Pattern.compile("^\\pN");

        Matcher isNum = pattern.matcher(value);
        if(isNum.find()){
            return true;
        }else
            return false;
    }
}
