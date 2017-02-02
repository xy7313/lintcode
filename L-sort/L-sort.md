##sort

####1. quickSort
61B 中讲的quickSort的思路：
arr[low]...arr[high], i point to low, j point to high

1. 选取pivot，最好是random，swap pivot and arr[high]
2. i++, if arr[i]>pivot, stop
3. j--, if arr[j]<pivot, stop]
4. swap arr[i] and arr[j]
5. until i and j cross, swap i and piot(in arr[high])
6. quickSort low--i-1
7. quickSort i+1,high

注意：

1. 和pivot比较的时候，一定是>=/<=,代码里`a[left]<pivot`是为了确保指针停在a[left]>=pivot的位置


####2. mergeSort
1. divide-conquer
2. extra O(n) space, can not implement in place
3. merge: 相当于merge的套路了
while(left<.. && right<..){...}
while(left<...){...}
while(right<...){...}

