package A301v500.A303RangeSumQueryImmutable;

class SegmentTree<E> {
    private E[] tree;
    private E[] data;

    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merge) {
        this.merger = merge;
        this.data = arr;

        data = arr;
        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0, arr.length - 1);
    }

    //在treeIndex的位置 创建表示区间[l..r]的线段数  递归调用.
    private void buildSegmentTree(int treeindex, int l, int r) {

        if (l == r) {
            tree[treeindex] = data[l];
            return;
        }

        int leftIndex = leftChild(treeindex);
        int rightIndex = rightChild(treeindex);

        //防止整型 溢出
        // int mid = (l + r) / 2;
        int mid = l + (r - l) / 2;
        //左右俩个节点互相分裂..
        buildSegmentTree(leftIndex, l, mid);
        buildSegmentTree(rightIndex, mid + 1, r);
        //treeindex 可以根据自己的业务

        tree[treeindex] = merger.merge(tree[leftIndex], tree[rightIndex]);

    }

    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length
                || queryL > queryR) {
            throw new IllegalArgumentException("查询参数错误");
        }
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    //在以tree为根的线段树中[l...r]的范围,搜索区间(queryL.....queryR);
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {

        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }
        int mid = l + (r - l) / 2;
        int leftIndex = leftChild(treeIndex);
        int rightIndex = rightChild(treeIndex);
        //去右子树找
        if (queryL >= mid + 1) {
            return query(rightIndex, mid + 1, r, queryL, queryR);
        } else if (queryR <= mid) {
            return query(leftIndex, l, mid, queryL, queryR);
        }
        //在左右子树 中间.
        E leftResult = query(leftIndex, l, mid, queryL, mid);
        E rightResult = query(rightIndex, mid + 1, r, mid + 1, queryR);
        return merger.merge(leftResult, rightResult);
    }


    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("index is error");
        }
        return data[index];
    }


    public int leftChild(int index) {
        return index * 2 + 1;
    }

    public int rightChild(int index) {
        return index * 2 + 2;
    }

    @Override
    public String toString() {

        StringBuilder a = new StringBuilder();
        a.append('[');

        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                a.append(tree[i]);
            } else {
                a.append("null");
            }
            if (i != tree.length - 1) {
                a.append(", ");
            }
        }
        a.append("]");
        return a.toString();

    }
}
interface Merger<E> {

    E merge(E a ,E b);
}

class NumArray {

    private SegmentTree<Integer> segmentTree;
    public NumArray(int[] nums) {

        if(nums.length > 0){
            Integer[] integers = new Integer[nums.length];
            for (int i = 0; i <nums.length ; i++) {
                integers[i] = nums[i];

            }
            segmentTree = new SegmentTree<>(integers,(a,b)->a+b);
        }
    }

    public int sumRange(int i, int j) {
        return segmentTree.query(i,j);
    }
}