package testDrivenDevelopment.exercises;

import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {
    private Map<Integer, Transaction> transactionMap;

    public ChainblockImpl() {
        this.transactionMap = new LinkedHashMap<>();
    }

    public int getCount() {
        return transactionMap.size();
    }

    public void add(Transaction transaction) {
        if (!transactionMap.containsKey(transaction.getId())) {
            transactionMap.put(transaction.getId(), transaction);
        }
    }

    public boolean contains(Transaction transaction) {
        return transactionMap.containsKey(transaction.getId());
    }

    public boolean contains(int id) {
        return transactionMap.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        if (this.transactionMap.containsKey(id)) {
            this.transactionMap.get(id).setStatus(newStatus);
        } else {
            throw new IllegalArgumentException("Chainblock doesn't contain a transaction with the given Id: " + id);
        }
    }

    public void removeTransactionById(int id) {
        if (this.transactionMap.containsKey(id)) {
            this.transactionMap.remove(id);
        } else {
            throw new IllegalArgumentException("Chainblock doesn't contain a transaction with the given Id: " + id);
        }
    }

    public Transaction getById(int id) {
        if (this.transactionMap.containsKey(id)) {
            return this.transactionMap.get(id);
        }
        throw new IllegalArgumentException("Chainblock doesn't contain a transaction with the given Id: " + id);
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> transactionList = new ArrayList<>();
        for (Transaction transaction : this.transactionMap.values()) {
            if (transaction.getStatus() == status) {
                transactionList.add(transaction);
            }
        }

        if (transactionList.size() > 0) {
            return transactionList.stream()
                    .sorted((a, b) -> Double.compare(b.getAmount(), a.getAmount()))
                    .collect(Collectors.toList());
        }
        throw new IllegalArgumentException("Chainblock doesn't contain a transaction with the given status: " + status);
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        List<Transaction> transactionList = new ArrayList<>();
        for (Transaction transaction : this.transactionMap.values()) {
            if (transaction.getStatus() == status) {
                transactionList.add(transaction);
            }
        }

        if (transactionList.size() > 0) {
            List<String> senderList = transactionList.stream()
                    .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                    .map(Transaction::getFrom)
                    .collect(Collectors.toList());
            return senderList;
        }
        throw new IllegalArgumentException("Chainblock doesn't contain a transaction with the given status: " + status);
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        List<Transaction> transactionList = new ArrayList<>();
        for (Transaction transaction : this.transactionMap.values()) {
            if (transaction.getStatus() == status) {
                transactionList.add(transaction);
            }
        }

        if (transactionList.size() > 0) {
            List<String> receiverList = transactionList.stream()
                    .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                    .map(Transaction::getTo)
                    .collect(Collectors.toList());
            return receiverList;
        }
        throw new IllegalArgumentException("Chainblock doesn't contain a transaction with the given status: " + status);
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        List<Transaction> transactionList = new ArrayList<>();
        for (Transaction transaction : this.transactionMap.values()) {
            transactionList.add(transaction);
        }
        return transactionList.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                        .thenComparing(Transaction::getId))
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        List<Transaction> transactionList = new ArrayList<>();
        for (Transaction transaction : this.transactionMap.values()) {
            if (transaction.getFrom().equals(sender)) {
                transactionList.add(transaction);
            }
        }

        if (transactionList.size() > 0) {
            return transactionList.stream()
                    .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                    .collect(Collectors.toList());
        }
        throw new IllegalArgumentException("Chainblock doesn't contain any transactions with the given sender: " + sender);
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        List<Transaction> transactionList = new ArrayList<>();
        for (Transaction transaction : this.transactionMap.values()) {
            if (transaction.getTo().equals(receiver)) {
                transactionList.add(transaction);
            }
        }

        if (transactionList.size() > 0) {
            return transactionList.stream()
                    .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                    .thenComparing(Transaction::getId))
                    .collect(Collectors.toList());
        }
        throw new IllegalArgumentException("Chainblock doesn't contain any transactions with the given receiver: " + receiver);
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        List<Transaction> transactionList = new ArrayList<>();
        for (Transaction transaction : this.transactionMap.values()) {
            if (transaction.getStatus() == status && transaction.getAmount() <= amount) {
                transactionList.add(transaction);
            }
        }
        transactionList.sort(Comparator.comparing(Transaction::getAmount).reversed());
        return transactionList;
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        List<Transaction> transactionList = new ArrayList<>();
        for (Transaction transaction : this.transactionMap.values()) {
            if (transaction.getFrom().equals(sender) && transaction.getAmount() > amount) {
                transactionList.add(transaction);
            }
        }
        transactionList.sort(Comparator.comparing(Transaction::getAmount).reversed());
        if (transactionList.size() > 0) {
            return transactionList;
        }
        throw new IllegalArgumentException("The chainblock doesn't contain transactions meeting the criteria: amount > " + amount + " sender: " + sender);
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        List<Transaction> transactionList = new ArrayList<>();
        for (Transaction transaction : this.transactionMap.values()) {
            if (transaction.getTo().equals(receiver) && transaction.getAmount() >= lo && transaction.getAmount() < hi) {
                transactionList.add(transaction);
            }
        }
        transactionList.sort(Comparator.comparing(Transaction::getAmount).reversed().thenComparing(Transaction::getId));
        if (transactionList.size() > 0) {
            return transactionList;
        }
        throw new IllegalArgumentException("The chainblock doesn't contain transactions meeting the criteria " + receiver + lo + hi);
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        List<Transaction> transactionList = new ArrayList<>();
        for (Transaction transaction : this.transactionMap.values()) {
            if (transaction.getAmount() >= lo && transaction.getAmount() <= hi) {
                transactionList.add(transaction);
            }
        }
        return transactionList;
    }

    public Iterator<Transaction> iterator() {
        return transactionMap.values().iterator();
    }
}
