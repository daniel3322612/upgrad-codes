##Binary search tree
A node-based binary tree data structure which has the following properties:
* The left subtree of a node contains only nodes with keys lesser than the node’s key.
* The right subtree of a node contains only nodes with keys greater than the node’s key.
* The left and right subtree each must also be a binary search tree.

###Operations:
* Insertion: Time complexity `O(h)` with h been the height
* Traversals : `O(n + m)`, where `n` is the number of nodes, and `m` is the number of edges. Since the number of edges that can originate from a node is limited to 2 in the case of a Binary Tree, the maximum number of total edges in a Binary Tree is `n-1`. The complexity then becomes `O(n + n-1)`, which is `O(n)`.
  1. Inorder (Left, Root, Right)
  2. Preorder (Root, Left, Right)
  3. Postorder (Left, Right, Root)
* Search: `O(h)`
* Height: `O(h)`
* Deletion: `O(h)`
    * Node to be deleted is a leaf: Just delete the node
    * Node to be deleted has only one child: copy the child to the node and delete child
    * Node to be deleted gas 2 children: Find inorder successor(min value in the right subtree) of the node. Copy contents of the inorder successor to the node and delete the inorder successor.

##Heaps 
A Heap is a special Tree-based data structure in which the tree is a complete binary tree two types:
1. Max-Heap: In a Max-Heap the key present at the root node must be greatest among the keys present at all of it’s children. The same property must be recursively true for all sub-trees in that Binary Tree.
2. Min-Heap: In a Min-Heap the key present at the root node must be minimum among the keys present at all of it’s children. The same property must be recursively true for all sub-trees in that Binary Tree.

###Implementation
Mapping the elements of a heap into an array is trivial: if a node is stored an index k, then its left child is stored at index `2k+1` and its right child at index `2k+2`.
The root element will be at `Arr[0]`. Below table shows indexes of other nodes for the ith node, i.e., `Arr[i]`:
* `Arr[(i-1)/2]` Returns the parent node. 
* `Arr[(2*i)+1]` Returns the left child node. 
* `Arr[(2*i)+2]` Returns the right child node.

###Operations:
* Insert: `O(log n)`
* getMax : `O(1)`
* extractMax: `O(Log n)`

##Heap sort
* Time complexity: `O(n*log(n))`
* Space complexity: `O(1)`
	
###Implementation: 
1. Build a max heap from the input data.
2. At this point, the largest item is stored at the root of the heap. Replace it with the last item of the heap followed by reducing the size of heap by 1. Finally, heapify the root of the tree. 
3. Repeat step 2 while the size of the heap is greater than 1.

##Queue 
is a linear structure which follows a particular order in which the operations are performed. The order is `First In First Out` (FIFO).
####Use cases:
1. When a resource is shared among multiple consumers. Examples include CPU scheduling, Disk Scheduling. 
2. When data is transferred asynchronously (data not necessarily received at same rate as sent) between two processes. Examples include IO Buffers, pipes, file IO, etc.
###Operations:
* Enqueue: Adds an item to the queue. If the queue is full, then it is said to be an Overflow condition. 
* Dequeue: Removes an item from the queue. The items are popped in the same order in which they are pushed. If the queue is empty, then it is said to be an Underflow condition. 
* Front: Get the front item from queue.
* Rear: Get the last item from queue.
###Implementation:
Keep track of: 
* Front and rear indices
* Size 
* Capacity
* Data

##Priority Queues 
An extension of a queue with the following properties:
* Every item has a priority associated with it.
* An element with high priority is dequeued before an element with low priority.
* If two elements have the same priority, they are served according to their order in the queue.
###Operations
* Enqueue
* Dequeue
* Peek:
* Top:
