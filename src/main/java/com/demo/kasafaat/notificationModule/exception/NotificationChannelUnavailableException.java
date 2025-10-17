package com.demo.kasafaat.notificationModule.exception;

import com.demo.kasafaat.commonModule.exception.BaseAppException;

public class NotificationChannelUnavailableException extends BaseAppException {
    public NotificationChannelUnavailableException(String channel) {
        super("Notification channel unavailable: " + channel, "NOTIFICATION_CHANNEL_UNAVAILABLE");
    }
}
