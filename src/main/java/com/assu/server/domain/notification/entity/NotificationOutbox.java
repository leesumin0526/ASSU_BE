package com.assu.server.domain.notification.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationOutbox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="notification_id", nullable=false, unique=true)
    private Notification notification;

    // 알림 전송 상태 (PENDING → SENDING → DISPATCHED → SENT/FAILED)
    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private Status status;

    @Column(nullable=false) private int retryCount;

    public void updateStatus(Status status) {
        this.status = status;
    }

    public void incrementRetryCount() {
        this.retryCount++;
    }

    public enum Status { PENDING, SENDING, DISPATCHED, SENT, FAILED }
}
