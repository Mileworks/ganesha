package cn.com.epicc.ganesha.front.design.factory;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-07-09 16:23
 */
public class Test {

    public static void main(String[] args) {
        CarFactory.createCar(BaoMaCar.class).banner();
        CarFactory.createCar(BenChiCar.class).banner();
        CarFactory.createCar(FlLaLiCar.class).banner();
    }
}
