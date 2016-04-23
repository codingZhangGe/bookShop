package com.qunar.qauction.common.utils;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.GeneralSecurityException;

/**
 * @author yunfeng.yang created on 16-4-17
 * @version 1.0
 */
public class CipherUtil {

    private static final String strKey = "qauction_cipher";
    private static String mode = "AES/CBC/PKCS5Padding";
    private static String cipherIV = "0102030405060708";

    /**
     * 加密
     *
     * @param strIn String 需要加密的信息
     * @return String 密文
     * @throws java.security.GeneralSecurityException
     */
    public static String encrypt(String strIn) throws GeneralSecurityException {
        SecretKeySpec keySpec = getKey(strKey);

        Cipher cipher = Cipher.getInstance(mode);
        IvParameterSpec iv = new IvParameterSpec(cipherIV.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);
        byte[] encrypted = cipher.doFinal(strIn.getBytes());
        return new Base64().encodeToString(encrypted);
    }

    /**
     * 解密
     *
     * @param strIn String 密文
     * @return String 明文
     * @throws GeneralSecurityException
     */
    public static String decrypt(String strIn) throws GeneralSecurityException {
        SecretKeySpec keySpec = getKey(strKey);
        Cipher cipher = Cipher.getInstance(mode);

        IvParameterSpec iv = new IvParameterSpec(cipherIV.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, keySpec, iv);
        byte[] encrypted1 = new Base64().decode(strIn);

        byte[] original = cipher.doFinal(encrypted1);
        return new String(original);
    }

    /**
     * 格式化key
     *
     * @param strKey String 密钥
     * @return String 格式化后的密钥
     */
    private static SecretKeySpec getKey(String strKey) {
        byte[] arrBTmp = strKey.getBytes();
        byte[] arrB = new byte[16];
        for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
            arrB[i] = arrBTmp[i];
        }
        return new SecretKeySpec(arrB, "AES");
    }
}
