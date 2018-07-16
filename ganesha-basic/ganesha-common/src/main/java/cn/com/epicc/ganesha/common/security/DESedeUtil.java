package cn.com.epicc.ganesha.common.security;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;


/**
 * Description: DESede 对称加密算法
 * Author: lishangmin
 * Created: 2018-07-12 13:23
 */
@Slf4j
public class DESedeUtil {

    private static final String KEY_ALGORITHM = "DESede";

    private static final String DEFAULT_CIPHER_ALGORITHM = "DESede/ECB/PKCS5Padding";

    /**
     * 加密
     */
    public static String encrypt(String content,String key){
        try {
            //实例化
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);

            byte[] byteContent = content.getBytes("UTF-8");

            //设置为加密模式
            cipher.init(Cipher.ENCRYPT_MODE,getSecretKey(key));

            //加密
            byte[] result = cipher.doFinal(byteContent);

            return Base64.encodeBase64String(result);
         } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密
     */
    public static String decrypt(String content,String key){
        try {
            //实例化
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            //设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE,getSecretKey(key));
            //解密
            byte[] result = cipher.doFinal(Base64.decodeBase64(content));
            return new String(result,"UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 生成密钥
     */
    public static SecretKey getSecretKey(final String key) throws Exception{
        KeyGenerator kg;
        try {
            kg = KeyGenerator.getInstance(KEY_ALGORITHM);
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(key.getBytes());
            kg.init(random);
            SecretKey secretKey = kg.generateKey();
            log.info("{},{},{}", Arrays.toString(secretKey.getEncoded()),secretKey.getAlgorithm(),secretKey.getFormat());
            return new SecretKeySpec(secretKey.getEncoded(),KEY_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String key = "!@#$%^&999--";
        String encrypt = encrypt("白日梦想家、荒野生存、我的神、肖申克的救赎",key);
        log.info(encrypt);
        log.info("{}",encrypt.length());
        String decrypt = decrypt(encrypt,key);
        log.info(decrypt);
    }
}
