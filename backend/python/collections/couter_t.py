from collections import Counter

# determin the most frequently occuring items in sequence
words = ['look', 'into', 'my', 'eyes', 'look', 'into', 'my', 'eyes',   'the', 'eyes', 'the', 'eyes', 'the', 'eyes', 'not', 'around', 'the',   'eyes', "don't", 'look', 'around', 'the', 'eyes', 'look', 'into', 'my', 'eyes', "you're", 'under']

word_counts = Counter(words)
# Outputs [('eyes', 8), ('the', 5), ('look', 4)]
top_three = word_counts.most_common(3)
print(top_three)

