学习笔记
# HashMap
- HashMap 是Map接口的一种实现，以key-value的形式存在，允许设置key value 为 null
- 存储的对象是Entry
- HashMap 提供了O(1)复杂度的get 和put操作，由hash函数保证存储元素尽可能均匀分布
- initial capacity 和 load factor，影响性能的关键因素
- HashMap 不是线程安全的，要线程安全应使用ConcurrentHashMap

# HashMap 的操作
- HashMap 是由数组、链表、红黑树实现
- HashMap 用hash 表存储元素，使用开放地址法和链地址法
> 元素根据key计算hash，放入对应hash所在的位置
> 如果两个key定位到相同的位置，发生hash冲突，会使用链表存储碰撞的value
> 如果链表出现过长，JDK1.8会把链表转化为红黑树（链表长度超过8），使用红黑树O（logn）的插入删除查找性能
- 当内部的数组装不下元素时，就需要扩充数组的长度
> 默认的负载银子大小为0.75 
> 重新申请一个2倍当前容量的数组，将原来的数组重新搬运到新的数组，然后设置原来的数组元素引用为null
> 扩充2倍，hash位数多了1bit。元素在重新hash后，在高位多了1bit。这样不需要重新计算hash，只需要判断高位是0还是1，0不变，1就是原索引增加原始容量的值即可
> 就是：元素的位置要么是在原位置，要么是在原位置再移动2次幂的位置
- put操作
> 先对key进行hash，查找对应hash在数组的下标
> 如果没有碰撞，将value放到数组对应位置上
> 如果碰撞了，将位置上的元素以链表存放，新加入的放在链头，后加入的放在链尾
> 碰撞导致链接过长，就转换为红黑树
> 如果是同一个key，就替换对应的value
> 存储元素过长，就要resize数组
- 存储元素的hash
> key进行hash运算，高16位不变，低16位与高16位做了异或

[https://www.smi1e.top/java-hashmap%E5%8E%9F%E7%90%86/][]
