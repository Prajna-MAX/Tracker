package org.zeta;

import java.time.LocalDateTime;

public class TransactionInfo {

        private final String type;
        private final int amount;
        private final LocalDateTime timestamp;

        public TransactionInfo(String type, int amount) {
            this.type = type;
            this.amount = amount;
            this.timestamp = LocalDateTime.now();
        }

        @Override
        public String toString() {
            return timestamp + " | " + type + " | Amount: " + amount;
        }
    }

