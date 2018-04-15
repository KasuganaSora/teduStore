package cn.tedu.store.service.ex;

public class PhoneAlreadyExistException extends RuntimeException {
    public PhoneAlreadyExistException() {
    }

    public PhoneAlreadyExistException(String message) {
        super(message);
    }
}
