/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 *
 * @author Admin PC
 */
public class TimeUtils {
    public static String timeAgo(LocalDateTime createdAt) {
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(createdAt, now);
        long diffMinutes = duration.toMinutes();

        if (diffMinutes < 60) {
            return diffMinutes + " minutes ago";
        } else if (diffMinutes < 1440) {
            long hours = diffMinutes / 60;
            return hours + " hours ago";
        } else {
            long days = diffMinutes / 1440;
            return days + " days ago";
        }
    }
}
