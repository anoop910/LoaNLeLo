package com.loanlelo.LoanLeLe.Service.SecurityUtil;

public class LoginTypeContext {
    private static final ThreadLocal<String> loginTypeHolder = new ThreadLocal<>();
    
    public static void setLoginType(String loginType) {
        loginTypeHolder.set(loginType);
    }
    
    public static String getLoginType() {
        return loginTypeHolder.get();
    }
    
    public static void clear() {
        loginTypeHolder.remove();
    }
}

