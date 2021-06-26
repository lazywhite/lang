import heapq

nums = [1, 8, 2, 23, 7, -4, 18, 23, 42, 37, 2]
print(heapq.nlargest(3,nums))
print(heapq.nsmallest(3,nums))
heapq.heapify(nums)
print(nums)

heapq.heappop(nums) # pop smallest
heapq.heappop(nums)
heapq.heappop(nums)

print(nums)


# heappush() and heappop() always insert and remove items from a list
# _queue so that the first item in the list has the smallest priority
