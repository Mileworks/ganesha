package cn.com.epicc.ganesha.front.design.factory;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-07-09 16:16
 */
public class CarFactory {

    public static <T extends Car> T createCar(Class<T> clazz){
        Car car = null;
        try {
            car = (T) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T) car;
    }
}
