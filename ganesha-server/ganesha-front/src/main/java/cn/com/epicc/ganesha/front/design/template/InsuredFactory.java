package cn.com.epicc.ganesha.front.design.template;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-07-09 17:05
 */
public class InsuredFactory {

    public static <T extends IInsured> T create(Class<T> c){
        IInsured iInsured = null;
        try {
           iInsured = (T)Class.forName(c.getName()).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T) iInsured;
    }
}
