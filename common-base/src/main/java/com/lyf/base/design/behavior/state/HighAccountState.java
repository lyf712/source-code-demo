package com.lyf.base.design.behavior.state;

/**
 * @author liyunfei
 **/
public class HighAccountState extends BaseAccountState{
    
    private final static Integer LEAVE_DEC_SCORE = 5;
    
    public HighAccountState(Account account, int score) {
        super(account, score);
    }
    
    @Override
    protected void writeFile(int score) {
        System.out.printf("高级用户下载文件，当前积分：%s\n",this.score);
        super.writeFile(score);
        checkAndTransferState(score);
        System.out.printf("剩余积分：：%s\n",this.score);
    }
    
    @Override
    protected void leaveMsg(String msg) {
        System.out.printf("高级用户下载文件，当前积分：%s\n",this.score);
        super.leaveMsg(msg);
        checkAndTransferState(LEAVE_DEC_SCORE);
        System.out.printf("剩余积分：：%s\n",this.score);
    }
    
    @Override
    protected void lookMsg(String msg) {
        super.lookMsg(msg);
    }
    
//    @Override
//    void checkAndTransferState(int score) {
//        checkScore(score);
//
//    }
}
