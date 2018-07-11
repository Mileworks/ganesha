package cn.com.epicc.ganesha.front.design.template;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-07-09 17:05
 */
public class Test {

    public static void main(String[] args) {
        IInsured insured1 = InsuredFactory.create(InsuredAbstractImpl.class);
        insured1.insert();

        IInsured insured2 = InsuredFactory.create(InsuredNormalImpl.class);
        insured2.insert();
    }
}
