package co.kr.smhrd.mvc_maven_20230621.dto;

public class BoardLikesDto {
    //stpring 에서 사용해보세요!!
    //    enum StateType{
    //        LIKE,BAD,BEST,SAD
    //    }
    private int blNum; //pk BOARD_LIKES_BL_NUM_SEQ
//    private StateType state; //('LIKE','BAD','BEST',SAD)
    private String state; //('LIKE','BAD','BEST',SAD)
    private String uId;//fk Users.u_id
    private int bNum;//fk Boards.b_num
    //UK(u_id,b_num) : 한사람이 한게시물에 한번만 좋아요 가능

    public int getBlNum() {
        return blNum;
    }

    public void setBlNum(int blNum) {
        this.blNum = blNum;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public int getbNum() {
        return bNum;
    }

    public void setbNum(int bNum) {
        this.bNum = bNum;
    }
}
