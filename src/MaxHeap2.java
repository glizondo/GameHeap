// Java program to implement Max Heap

// Main class
public class MaxHeap2 {
	private int[] Heap;
	private int size;
	private int maxsize;

	// Constructor to initialize an
	// empty max heap with given maximum
	// capacity
	public MaxHeap2(int maxsize) {
		// This keyword refers to current instance itself
		this.maxsize = maxsize;
		this.size = 0;
		Heap = new int[this.maxsize];
	}

	// Method 1
	// Returning position of parent
	private int parent(int pos) {
		return (pos - 1) / 2;
	}

	// Method 2
	// Returning left children
	private int leftChild(int pos) {
		return (2 * pos + 1);
	}

	// Method 3
	// Returning left children
	private int rightChild(int pos) {
		return (2 * pos) + 2;
	}

	// Method 4
	// Returning true of given node is leaf
	private boolean isLeaf(int pos) {
		if (pos > (size / 2) - 1 && pos <= size - 1) {
			return true;
		}
		return false;
	}

	// Method 5
	// Swapping nodes
	private void swap(int fpos, int spos) {
		int tmp;
		tmp = Heap[fpos];
		Heap[fpos] = Heap[spos];
		Heap[spos] = tmp;
	}

	// Method 6
	// Recursive function to max heapify given subtree
	private void maxHeapify(int pos) {
		if (isLeaf(pos))
			return;

		if (rightChild(pos) >= size) {

			if (Heap[pos] < Heap[leftChild(pos)]) {
				swap(pos, leftChild(pos));
				maxHeapify(leftChild(pos));
			}
			return;
		}

		if (Heap[pos] < Heap[leftChild(pos)] || Heap[pos] < Heap[rightChild(pos)]) {

			if (Heap[leftChild(pos)] > Heap[pos]) {
				swap(pos, leftChild(pos));
				maxHeapify(leftChild(pos));
			} else if (Heap[rightChild(pos)] > Heap[pos]) {
				swap(pos, rightChild(pos));
				maxHeapify(rightChild(pos));
			}
		}
	}

	// Method 7
	// Inserts a new element to max heap
	public void insert(int element) {
		Heap[size] = element;

		// Traverse up and fix violated property
		int current = size;
		while (Heap[current] > Heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
		size++;
	}

	// Method 8
	// To display heap
	public void print() {
//		for (int i = 0; i <= size / 2 - 1; i++) {
//			System.out.print(
//					" PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2 * i + 1] + " RIGHT CHILD :" + Heap[2 * i + 2]);
//			System.out.println("HELLO" + i);
//		}

		for (int i = 0; i <= size / 2 - 1; i++) {
			System.out.println("----" + Heap[i] + "----");
			System.out.println(Heap[2 * i + 1] + "-------" + Heap[2 * i + 2]);
			System.out.println();

		}
	}

	public int peek() {
		return Heap[0];
	}

	public boolean isEmpty() {
		if (Heap.length <= 0) {
			return true;
		}
		return false;
	}

	// Method 9
	// Remove an element from max heap
	public int extractMax() throws Exception {
		if (size >= 1) {
			int popped = Heap[0];
			Heap[0] = Heap[--size];
			Heap[size] = 0;
			maxHeapify(0);
			return popped;
		}
		throw new Exception("You cannot extract from the heap: it is empty!");
	}

	public void printOrder() {
		for (int i = 0; i < Heap.length; i++) {
			System.out.println(Heap[i]);
		}
	}

	// Method 10
	// main dri er method
	public static void main(String[] arg) throws Exception {
		int numelements = 21;
		// Display message for better readability
		System.out.println("The Max Heap is ");

		MaxHeap2 maxHeap = new MaxHeap2(numelements);

		// Inserting nodes
		// Custom inputs
		// 8,9,16,1, 25, 4}

		maxHeap.insert(8);
		maxHeap.insert(9);
		maxHeap.insert(16);
		maxHeap.insert(1);
		maxHeap.insert(25);
		maxHeap.insert(4);

		maxHeap.printOrder();

		/*
		 * maxHeap.insert(5); maxHeap.insert(3); maxHeap.insert(17); maxHeap.insert(10);
		 * maxHeap.insert(84); maxHeap.insert(19); maxHeap.insert(6);
		 * maxHeap.insert(22); maxHeap.insert(9);
		 */
		// Calling maxHeap() as defined above
		maxHeap.print();
		for (int i = 0; i < numelements; i++) {
			// Print and dis10lay the maximum value in heap
			System.out.println("The max val is " + maxHeap.extractMax());
			maxHeap.print();
		}
	}
}

//Task 1
// A) Tested
// B) The do show up from bigger to smaller
