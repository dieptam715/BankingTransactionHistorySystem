package model;

import java.util.HashMap;

public class TransactionMap {

    private final HashMap<String, Transaction> transactions;
    
    public TransactionMap() {
        transactions = new HashMap<>();
    }

    public boolean put(Transaction transaction) {

        if (transaction == null) {
            return false;
        }

        String transactionId = transaction.getTransactionId();

        if (transactionId == null || transactionId.trim().isEmpty()) {
            return false;
        }

        if (transactions.containsKey(transactionId)) {
            return false;
        }

        transactions.put(transactionId, transaction);
        return true;
    }

    public Transaction get(String transactionId) {

        if (transactionId == null) {
            return null;
        }

        return transactions.get(transactionId);
    }


    public Transaction remove(String transactionId) {

        if (transactionId == null) {
            return null;
        }

        return transactions.remove(transactionId);
    }

    public boolean containsKey(String transactionId) {

        if (transactionId == null) {
            return false;
        }

        return transactions.containsKey(transactionId);
    }
}