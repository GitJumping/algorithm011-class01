#学习笔记
#Queue
- Queue使一个接口，定义了Java里队列这种数据结构需要实现的方法
- 具体的实现上，常用常见的就是LinkedList，PriorityQueue等实现类
- Queue的操作方法上都提供了两种。操作失误时，一种方法会抛出异常，另一种则返回一个特定的值（适用于给定元素个数的队列对象）
- Queue的操作通常不允许插入null值，尽管在实现类LinkedList里面没有做限制
- Queue的实现类通常不定义自己的equals和hashCode方法，而是继承自Object的对应方法

## Queue定义的方法
总体上就是如下方法，插入删除和取队列顶部的元素
	Throws exception	Returns special value
Insert	add(e)	offer(e)
Remove	remove()	poll()
Examine	element()	peek()

# PriorityQueue
- 优先级队列是Queue的一种实现，基于优先堆（Priority Heap）
- 非线程安全队列
- 入队出队时间复杂度 O(logn)；remove和contain O(n)的时间复杂度；peek element size是O(1)时间复杂度
- 内部为护着一个默认值，代表队列的长度，默认为11
- 提供了多种constructor定义元素的优先级顺序。可以使用入队时的原始顺序，也可以在构造时传入comparator定义优先级顺序

## PriorityQueue内部定义的方法
比起上述3种，多了如下几种
- clear
- comparator
> 返回优先队列元素排序的comparator接口
- contain
- iterator
- size
- spliterator
- toArray




# 本周学习心得
## 基础知识
### Array-数组
- 最为基础的数据结构，后续很多高级数据结构会用到数组来做实现
- 数组定义时，硬件层面会维护一个内存控制器，达到随机访问数据O（1）的时间复杂度
- 查找速度很快，但相对应的插入和删除操作就比较慢了，是O(n)的时间复杂度

### LinkedList-链表
- 链表由一个个的节点连接组成，每个节点包含Value和next指针
- 最开头的节点称为Head，最尾的节点为Tail。除了tail的的next指向null以外，其余节点都指向的下一个节点的next地址
- 链表的插入删除操作时间复杂度为O(1)

### DoubleLinkedList-双向链表
- 链表增加了一个previous指针，可以快速查找头和尾的节点
- 对双向链表的插入更新操作时间复杂度为O(1)，查找还是O(n)

### SkipList-跳表
- 只能针对元素有序的情况
- 对标的是平衡树和二分查找。且实现原理简单，容易实现
- 是对有序链表的添加索引操作
- 跳表查询任意数据的时间复杂度时O(logn)，空间复杂度是O(n)

### Stack-栈
- LIFO 特性
- 添加删除时间复杂度O(1)

### Queue-队列
- LILO FIFO
- 添加删除时间复杂度O(1)

### Deque-双端队列
- 两端都可以进出的Queue
- 插入和删除时间复杂度为O(1)

### PriorityQueue-优先队列
- 插入操作O(1)
- 取出操作O(logn)
- 底层的实现 heap bst treap 


