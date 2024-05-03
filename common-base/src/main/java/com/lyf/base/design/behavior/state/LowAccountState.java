package com.lyf.base.design.behavior.state;

/**
 * @author liyunfei
 **/
public class LowAccountState extends BaseAccountState{
    
    public LowAccountState(Account account, int score) {
        super(account, score);
    }
    
    @Override
    protected void writeFile(int score) {
        System.out.printf("低级用户下载文件，当前积分：%s\n",this.score);
        super.writeFile(score);
        checkAndTransferState(score);
        System.out.printf("剩余积分：：%s\n",this.score);
    }
    
    @Override
    protected void leaveMsg(String msg) {
        throw new UnsupportedOperationException("低级用户，不支持---");
//        System.out.printf("低级用户下载文件，当前积分：%s\n",this.score);
//        super.leaveMsg(msg);
//        checkAndTransferState(20);
//        System.out.printf("剩余积分：：%s\n",this.score);
    }
    
    @Override
    protected void lookMsg(String msg) {
        super.lookMsg(msg);
      
    }
}
