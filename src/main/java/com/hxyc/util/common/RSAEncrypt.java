/*
 * @(#)RSAEncrypt.java    Created on 2019年9月6日
 * Copyright (c) 2019 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.hxyc.util.common;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

/**
 * @author huangzy
 * @version $Revision: 1.0 $, $Date: 2019年9月6日 上午10:39:23 $
 */
public class RSAEncrypt {

    public static void main(String[] args) throws Exception {
        // 生成公钥和私钥
        Map<Integer, String> keyMap = genKeyPair();
        // 加密字符串
        String message = "123456";
        String pubString = "MF0wDQYJKoZIhvcNAQEBBQADTAAwSQJCAUp+h292H+2cuXXzcNuYKuoxO8moy3FVfqNC5+eSkSTqP1Hbd5HbF4ihF8iIOtY7rwgYxgadh/Fr3QPULUPqPRVRAgMBAAE=";
        String priString = "MIIBWQIBADANBgkqhkiG9w0BAQEFAASCAUMwggE/AgEAAkIBSn6Hb3Yf7Zy5dfNw25gq6jE7yajLcVV+o0Ln55KRJOo/Udt3kdsXiKEXyIg61juvCBjGBp2H8WvdA9QtQ+o9FVECAwEAAQJCATsg7s8PGV6eJBEd8SzSKYlpLJMayfHlDX1q3GlozdEfDRbxMz6z2mMFMFrP3nnPF0lZBPmbWuPXXEb3HKERqoQBAiEb9dNXzlVF6ZB5ZcUBp/TTMTo4aw1oUltgK3IwG35+T/ECIQvR9PWLRWo58/ggixgKRvPcPi8k+L3rXiCDdBK9A3h7YQIhDxpR9nP1i7YF3A0kxSg8DnfgwujQbTFPOjs9is7PHNuBAiEFmWbFrjyqrltArgHV2IB14l3erU/bf5RuKHcirUDooOECIRRLcHmIz+v2nf3UhbN1xedZHTu1wC1n9spx/lmk2zcGKA==";
        System.out.println("随机生成的公钥为:" + keyMap.get(0));
        System.out.println("随机生成的私钥为:" + keyMap.get(1));
        String messageEn = encrypt(message, pubString);
        System.out.println(message + "\t加密后的字符串为:" + messageEn);
        String messageDe = decrypt(messageEn, priString);
        System.out.println("还原后的字符串为:" + messageDe);
    }

    /**
     * 随机生成密钥对
     *
     * @return
     *
     * @throws NoSuchAlgorithmException
     */
    public static Map<Integer, String> genKeyPair() throws NoSuchAlgorithmException {
        Map<Integer, String> keyMap = new HashMap<Integer, String>();
        // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        // 初始化密钥对生成器，密钥大小为96-1024位
        keyPairGen.initialize(521, new SecureRandom());
        // 生成一个密钥对，保存在keyPair中
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate(); // 得到私钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic(); // 得到公钥
        String publicKeyString = new String(Base64.encodeBase64(publicKey.getEncoded()));
        // 得到私钥字符串
        String privateKeyString = new String(Base64.encodeBase64((privateKey.getEncoded())));
        // 将公钥和私钥保存到Map
        keyMap.put(0, publicKeyString); // 0表示公钥
        keyMap.put(1, privateKeyString); // 1表示私钥
        return keyMap;
    }

    /**
     * RSA公钥加密
     *
     * @param str
     *            加密字符串
     * @param publicKey
     *            公钥
     * @return 密文
     * @throws Exception
     *             加密过程中的异常信息
     */
    public static String encrypt(String str, String publicKey) throws Exception {
        // base64编码的公钥
        byte[] decoded = Base64.decodeBase64(publicKey.getBytes());
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA")
                .generatePublic(new X509EncodedKeySpec(decoded));
        // RSA加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        String outStr = new String(Base64.encodeBase64(cipher.doFinal(str.getBytes("UTF-8"))));
        return outStr;
    }

    /**
     * RSA私钥解密
     *
     * @param str
     *            加密字符串
     * @param privateKey
     *            私钥
     * @return 铭文
     * @throws Exception
     *             解密过程中的异常信息
     */
    public static String decrypt(String str, String privateKey) throws Exception {
        // 64位解码加密后的字符串
        byte[] inputByte = Base64.decodeBase64(str.getBytes("UTF-8"));
        // base64编码的私钥
        byte[] decoded = Base64.decodeBase64(privateKey.getBytes());
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA")
                .generatePrivate(new PKCS8EncodedKeySpec(decoded));
        // RSA解密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        String outStr = new String(cipher.doFinal(inputByte));
        return outStr;
    }
}
