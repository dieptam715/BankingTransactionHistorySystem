package datastructure;

import model.Transaction;
import model.TransactionNode;

public class TransactionList {
    // Node nội bộ để quản lý liên kết
    private class InternalNode {
        TransactionNode dataNode;   // chứa Transaction
        InternalNode next;
        InternalNode prev;

        InternalNode(Transaction t) {
            this.dataNode = new TransactionNode(t);
        }
    }

    private InternalNode head;
    private InternalNode tail;

    // 1. Thêm giao dịch
    public void addTransaction(Transaction t){
        InternalNode newNode = new InternalNode(t);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // 2. Xóa giao dịch theo ID
    public Transaction deleteTransaction(String id){
        InternalNode current = head;
        while (current != null) {
            if (current.dataNode.data.getTransactionId().equals(id)) {
                Transaction deleted = current.dataNode.data;

                if (current == head) {
                    head = current.next;
                    if (head != null) head.prev = null;
                    else tail = null;
                } else if (current == tail) {
                    tail = current.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                return deleted;
            }
            current = current.next;
        }
        return null;
    }

    // 3. Hiển thị lịch sử
    public void displayHistory(){
        if (head == null) {
            System.out.println("Transaction history is empty.");
            return;
        }
        InternalNode current = head;
        System.out.println("\n--- Banking Transaction History ---");
        while (current != null) {
            current.dataNode.data.display();
            current = current.next;
        }
        System.out.println("-----------------------------------");
    }

    // 4. Merge Sort theo Amount
    public void mergeSortByAmount(){
        head = mergeSortByAmount(head);
        // cập nhật lại tail
        InternalNode temp = head;
        while (temp != null && temp.next != null) temp = temp.next;
        tail = temp;
    }

    private InternalNode mergeSortByAmount(InternalNode h){
        if (h == null || h.next == null) return h;

        InternalNode middle = getMiddle(h);
        InternalNode nextOfMiddle = middle.next;
        middle.next = null;

        InternalNode left = mergeSortByAmount(h);
        InternalNode right = mergeSortByAmount(nextOfMiddle);

        return sortedMergeByAmount(left, right);
    }

    private InternalNode sortedMergeByAmount(InternalNode a, InternalNode b){
        if (a == null) return b;
        if (b == null) return a;

        InternalNode result;
        if (a.dataNode.data.getAmount() <= b.dataNode.data.getAmount()) {
            result = a;
            result.next = sortedMergeByAmount(a.next, b);
            if (result.next != null) result.next.prev = result;
        } else {
            result = b;
            result.next = sortedMergeByAmount(a, b.next);
            if (result.next != null) result.next.prev = result;
        }
        return result;
    }

    // 5. Merge Sort theo Date
    public void mergeSortByDate(){
        head = mergeSortByDate(head);
        InternalNode temp = head;
        while (temp != null && temp.next != null) temp = temp.next;
        tail = temp;
    }

    private InternalNode mergeSortByDate(InternalNode h){
        if (h == null || h.next == null) return h;

        InternalNode middle = getMiddle(h);
        InternalNode nextOfMiddle = middle.next;
        middle.next = null;

        InternalNode left = mergeSortByDate(h);
        InternalNode right = mergeSortByDate(nextOfMiddle);

        return sortedMergeByDate(left, right);
    }

    private InternalNode sortedMergeByDate(InternalNode a, InternalNode b){
        if (a == null) return b;
        if (b == null) return a;

        InternalNode result;
        if (a.dataNode.data.getDate().isBefore(b.dataNode.data.getDate()) 
            || a.dataNode.data.getDate().isEqual(b.dataNode.data.getDate())) {
            result = a;
            result.next = sortedMergeByDate(a.next, b);
            if (result.next != null) result.next.prev = result;
        } else {
            result = b;
            result.next = sortedMergeByDate(a, b.next);
            if (result.next != null) result.next.prev = result;
        }
        return result;
    }

    // Hàm hỗ trợ lấy middle node
    private InternalNode getMiddle(InternalNode h){
        if (h == null) return h;
        InternalNode slow = h, fast = h.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
