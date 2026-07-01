package datastructure;

import model.Transaction;
import model.TransactionNode;

public class TransactionList {
    private TransactionNode head;
    private TransactionNode tail;

    // Thêm giao dịch vào cuối danh sách
    public void addTransaction(Transaction t) {
        TransactionNode newNode = new TransactionNode(t);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
    }

    // Xóa giao dịch theo id
    public Transaction deleteTransaction(String id) {
        TransactionNode current = head;
        while (current != null) {
            if (current.getData().getId().equals(id)) {
                if (current == head) {
                    head = head.getNext();
                    if (head != null) head.setPrev(null);
                } else if (current == tail) {
                    tail = tail.getPrev();
                    if (tail != null) tail.setNext(null);
                } else {
                    current.getPrev().setNext(current.getNext());
                    current.getNext().setPrev(current.getPrev());
                }
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }

    // Hiển thị lịch sử giao dịch
    public void displayHistory() {
        TransactionNode current = head;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

    // Merge Sort theo số tiền
    public void mergeSortByAmount() {
        head = mergeSort(head, true);
        resetTail();
    }

    // Merge Sort theo ngày
    public void mergeSortByDate() {
        head = mergeSort(head, false);
        resetTail();
    }

    private TransactionNode mergeSort(TransactionNode node, boolean sortByAmount) {
        if (node == null || node.getNext() == null) return node;

        TransactionNode middle = getMiddle(node);
        TransactionNode nextOfMiddle = middle.getNext();
        middle.setNext(null);

        TransactionNode left = mergeSort(node, sortByAmount);
        TransactionNode right = mergeSort(nextOfMiddle, sortByAmount);

        return sortedMerge(left, right, sortByAmount);
    }

    private TransactionNode sortedMerge(TransactionNode a, TransactionNode b, boolean sortByAmount) {
        if (a == null) return b;
        if (b == null) return a;

        TransactionNode result;
        if (sortByAmount) {
            if (a.getData().getAmount() <= b.getData().getAmount()) {
                result = a;
                result.setNext(sortedMerge(a.getNext(), b, true));
                if (result.getNext() != null) result.getNext().setPrev(result);
            } else {
                result = b;
                result.setNext(sortedMerge(a, b.getNext(), true));
                if (result.getNext() != null) result.getNext().setPrev(result);
            }
        } else {
            if (a.getData().getDate().compareTo(b.getData().getDate()) <= 0) {
                result = a;
                result.setNext(sortedMerge(a.getNext(), b, false));
                if (result.getNext() != null) result.getNext().setPrev(result);
            } else {
                result = b;
                result.setNext(sortedMerge(a, b.getNext(), false));
                if (result.getNext() != null) result.getNext().setPrev(result);
            }
        }
        return result;
    }

    private TransactionNode getMiddle(TransactionNode node) {
        if (node == null) return node;
        TransactionNode slow = node, fast = node;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    private void resetTail() {
        TransactionNode current = head;
        while (current != null && current.getNext() != null) {
            current = current.getNext();
        }
        tail = current;
    }
}
