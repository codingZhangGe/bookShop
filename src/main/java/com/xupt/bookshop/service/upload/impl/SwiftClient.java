package com.xupt.bookshop.service.upload.impl;

import org.javaswift.joss.client.factory.AccountConfig;
import org.javaswift.joss.client.factory.AccountFactory;
import org.javaswift.joss.client.factory.AuthenticationMethod;
import org.javaswift.joss.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

/**
 * Created by liuyanjiang on 16-4-17.
 */
public class SwiftClient {
    private static Logger logger = LoggerFactory.getLogger(SwiftClient.class);
    private String swiftName;
    private String swiftPassWord;
    private String authUrl;
    private AuthenticationMethod authenticationMethod = AuthenticationMethod.BASIC;
    private Account account;

    public void initAccount() { // 初始化accout对象
        logger.info("swiftName:{},authUrl:{}", swiftName, authUrl);
        Preconditions.checkArgument(!Strings.isNullOrEmpty(swiftName));
        Preconditions.checkArgument(!Strings.isNullOrEmpty(swiftPassWord));
        Preconditions.checkArgument(!Strings.isNullOrEmpty(authUrl));
        AccountConfig swiftAccountConfig = new AccountConfig();
        swiftAccountConfig.setUsername(swiftName);
        swiftAccountConfig.setPassword(swiftPassWord);
        swiftAccountConfig.setAuthUrl(authUrl);
        swiftAccountConfig.setAuthenticationMethod(authenticationMethod);
        this.account = new AccountFactory(swiftAccountConfig).createAccount();
    }

    public void setSwiftName(String swiftName) {
        this.swiftName = swiftName;
    }

    public void setSwiftPassWord(String swiftPassWord) {
        this.swiftPassWord = swiftPassWord;
    }

    public void setAuthUrl(String authUrl) {
        this.authUrl = authUrl;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
