package com.example.The.Book.Sphere.Enum;

public enum CardStatus {
    ACTIVE,      // Card is valid and can be used to borrow books
    BLOCKED,     // Card is blocked due to unpaid fines or rule violations
    EXPIRED,     // Card validity period has ended
    LOST,        // Card reported lost
    INACTIVE     // Card temporarily disabled but not permanently blocked
}
