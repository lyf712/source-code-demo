package com.lyf.base.design.behavior.state;

/**
 * state的功能抽象一个接口处理。。。。
 * @author liyunfei
 **/
public abstract class BaseAccountState {
    
    protected final Account account;//; = new Account();
    
    protected int score;
    
    public BaseAccountState(Account account, int score) {
        this.account = account;
        this.score = score;
    }
    
    protected void writeFile(int score) {
        System.out.println("下载文件...");
    }
    
    protected void leaveMsg(String msg) {
        System.out.println("留言...");
    }
    
    protected void lookMsg(String msg) {
        System.out.println("查看...");
    }
    
    public Account getAccount() {
        return account;
    }
    
    public int getScore() {
        return score;
    }
    
    //abstract
    protected void checkAndTransferState(int score) {
        checkScore(score);
        // 双向关联的逻辑有点绕》。
        if (this.score >= LevelConstants.HIGH) {
            this.account.setState(new HighAccountState(this.account, this.score));
        } else if (this.score >= LevelConstants.MIDDLE) {
            this.account.setState(new MiddleAccountState(this.account, this.score));
        }else {
            this.account.setState(new LowAccountState(this.account, this.score));
        }
    }
    
    
    private void checkScore(int deScore) {
        if (this.score - deScore < 0) {
            throw new UnsupportedOperationException("积分不够用...");
        }
        this.score -= deScore;
    }
}
