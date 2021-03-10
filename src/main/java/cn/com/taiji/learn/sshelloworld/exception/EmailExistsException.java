package cn.com.taiji.learn.sshelloworld.exception;

public class EmailExistsException extends Throwable {

    public EmailExistsException(final String message) {
        super(message);
    }

}