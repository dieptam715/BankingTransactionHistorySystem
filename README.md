YÊU CẦU NGHIÊM TÚC: PULL CODE VỀ CODE, CODE XONG PULL LẠI LẦN NỮA XEM CÓ CODE MỚI KHÔNG RỒI MỚI PUSH ĐỂ TRÁNH VIỆC CONFICT
PHÂN CÔNG CÔNG VIỆC DỰ ÁN BANK TRANSACTION HISTORY SYSTEM
Tuấn Khải – Team Lead / Core Architecture
Phụ trách:
Transaction.java
TransactionNode.java
TransactionManager.java
Main.java
Nhiệm vụ:
Thiết kế cấu trúc dữ liệu Transaction.
Thiết kế TransactionNode cho Doubly Linked List.
Xây dựng TransactionManager để điều phối toàn bộ hệ thống.
Kết nối TransactionList, TransactionMap, TransactionQueue, TransactionStack và FileHandler.
Thiết lập cấu trúc project và package.
Review, merge và kiểm tra code của các thành viên khác.
Các chức năng cần xử lý:
addTransaction()
deleteTransaction()
searchTransaction()
processQueue()
undoDelete()
sortByAmount()
sortByDate()
saveData()
loadData()

Hồng Phúc – Transaction History Module (Doubly Linked List)
Phụ trách:
TransactionList.java
Nhiệm vụ:
Xây dựng Doubly Linked List để lưu trữ lịch sử giao dịch.
Quản lý head và tail.
Thực hiện các thao tác thêm, xóa và duyệt danh sách.
Cài đặt thuật toán Merge Sort để sắp xếp giao dịch.
Các chức năng cần xử lý:
addTransaction()
deleteTransaction()
displayHistory()
mergeSortByAmount()
mergeSortByDate()
Vai trò trong hệ thống:
Là nơi lưu trữ chính của Transaction History.
Hỗ trợ hiển thị và sắp xếp dữ liệu giao dịch.

Khải Nguyễn – Search Module (HashMap)
Phụ trách:
TransactionMap.java
Nhiệm vụ:
Xây dựng HashMap để tìm kiếm giao dịch theo Transaction ID.
Tối ưu tốc độ tìm kiếm.
Đồng bộ dữ liệu với TransactionManager.
Các chức năng cần xử lý:
put()
get()
remove()
containsKey()
Vai trò trong hệ thống:
Hỗ trợ tìm kiếm giao dịch với độ phức tạp trung bình O(1).
Thực hiện chức năng Search Transaction by ID.

Gia Huy – Queue, Stack & File Module
Phụ trách:
TransactionQueue.java
TransactionStack.java
FileHandler.java
Nhiệm vụ:
Xây dựng Queue để mô phỏng xử lý giao dịch theo thời gian thực.
Xây dựng Stack để hỗ trợ Undo Delete.
Xây dựng FileHandler để lưu và tải dữ liệu từ file.
Queue:
Chức năng:
enqueue()
dequeue()
isEmpty()
Vai trò:
Xử lý giao dịch theo nguyên tắc FIFO (First In First Out).
Stack:
Chức năng:
push()
pop()
peek()
isEmpty()
Vai trò:
Lưu các giao dịch vừa bị xóa để hỗ trợ Undo.
FileHandler:
Chức năng:
saveToFile()
loadFromFile()
Vai trò:
Lưu dữ liệu giao dịch vào file.
Đọc dữ liệu từ file khi khởi động hệ thống.

YÊU CẦU CHUNG
Tất cả thành viên phải thống nhất class Transaction trước khi bắt đầu code.
Transaction gồm:
transactionId : String
amount : double
type : String
date : LocalDate
Tiếp theo là TransactionNode là dành riêng cho Transaction list
Nghiêm cấm việc dùng nó ngoài file List, tự tạo node từ transaction mà dùng
Sau khi hoàn thành module của mình, mỗi thành viên phải cung cấp:
Source code.
Test case đơn giản.
Giải thích cách hoạt động của module để phục vụ phần bảo vệ và viva.
Mục tiêu Sprint 1:
Tất cả class compile thành công.
Các Data Structure hoạt động độc lập.
Chưa cần giao diện Java Swing.
Giao diện Java Swing sẽ được thực hiện sau khi toàn bộ chức năng backend hoàn thiện.
