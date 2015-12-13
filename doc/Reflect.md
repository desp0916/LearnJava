#Class 類

[慕课网 反射——Java高级开发必须懂的](http://www.imooc.com/learn/199)

## 1. 在物件導向的世界裡，萬事萬物皆物件。

Java 語言中，靜態成員、普通數據類型類是不是物件呢？

### 類是誰的物件呢？

類是物件，類是 java.lang.Class 類的實例物件

### 2. 這個物件到底如何表示呢？

There is class named Class

### 3. Class.forName("類的全稱")

 - 不僅表示了類的類類型（class type），還代表了動態加載類
 - 請大家區分編譯、運行
 - 編譯時刻加載類是靜態加載類、運行時刻加載類是動態加載類