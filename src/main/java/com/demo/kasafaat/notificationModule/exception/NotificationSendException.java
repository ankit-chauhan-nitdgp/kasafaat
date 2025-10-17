package com.demo.kasafaat.notificationModule.exception;

import com.demo.kasafaat.commonModule.exception.BaseAppException;

public class NotificationSendException extends BaseAppException {
    public NotificationSendException(String channel) {
        super("Failed to send notification via " + channel, "NOTIFICATION_SEND_FAILED");
    }
}
