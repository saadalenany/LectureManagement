package lecturemanagementdoctor.doctor.Models;

import java.util.Date;

/**
 *
 * @author Saad Alenany
 */
public class Chat {

    private int Chat_id;
    private int sender_id;
    private int reciever_id;
    private String message_content;
    private Date message_date;
    private int message_lecture;

    public Chat(int message_id, int sender_id, int reciever_id, String message_content, Date message_date, int message_lecture) {
        this.Chat_id = message_id;
        this.sender_id = sender_id;
        this.reciever_id = reciever_id;
        this.message_content = message_content;
        this.message_date = message_date;
        this.message_lecture = message_lecture;
    }

    public Chat(int sender_id, int reciever_id, String message_content, Date message_date, int message_lecture) {
        this.sender_id = sender_id;
        this.reciever_id = reciever_id;
        this.message_content = message_content;
        this.message_date = message_date;
        this.message_lecture = message_lecture;
    }

    public int getMessage_lecture() {
        return message_lecture;
    }

    public void setMessage_lecture(int message_lecture) {
        this.message_lecture = message_lecture;
    }

    public int getChat_id() {
        return Chat_id;
    }

    public void setChat_id(int Chat_id) {
        this.Chat_id = Chat_id;
    }

    public int getSender_id() {
        return sender_id;
    }

    public void setSender_id(int sender_id) {
        this.sender_id = sender_id;
    }

    public int getReciever_id() {
        return reciever_id;
    }

    public void setReciever_id(int reciever_id) {
        this.reciever_id = reciever_id;
    }

    public String getMessage_content() {
        return message_content;
    }

    public void setMessage_content(String message_content) {
        this.message_content = message_content;
    }

    public Date getMessage_date() {
        return message_date;
    }

    public void setMessage_date(Date message_date) {
        this.message_date = message_date;
    }

    @Override
    public String toString() {
        return "Chat{" + "message_id=" + Chat_id + ", sender_id=" + sender_id + ", reciever_id=" + reciever_id + ", message_content=" + message_content + ", message_date=" + message_date + ", message_lecture=" + message_lecture + '}';
    }

}
