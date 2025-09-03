class HashMap:

    def __init__(self,capacity):
        self.capacity = capacity
        self.size = 0
        self.buckets = [[] for _ in range(capacity)]
    
    def __len__(self):
        return self.size

    def __contains__(self,key):
        index = self._hashfuction(key)
        bucket = self.buckets[index]

        for k,v in bucket:
            if k == key:
                return True
        
        return False

    def put(self,key,value):
        index = self._hashfuction(key)
        bucket = self.buckets[index]

        for i , (k,v) in enumerate(bucket):
            if k == key:
                bucket[i] = (key,value)
                break
        else:
            bucket[key].append((key,value))

        self.size+=1

    def get(self,key):
        index = self._hashfuction(key)
        bucket = self.buckets[index]

        for k,v in bucket:
            if k == key:
                return v
        
        raise ValueError("Key Not Found!")

    def remove(self,key):
        index = self._hashfuction(key)
        bucket = self.buckets[index]

        for i, (k,v) in enumerate(bucket):
            if k == key:
                del bucket[i]
                self.size-=1
                break
            else:
                raise ValueError("Key Not Found!")

    def keys(self):
        return [k for bucket in self.buckets for k,v in bucket]

    def values(self):
        return [v for bucket in self.buckets for k,v in bucket]

    def items(self):
        return [(k,v) for bucket in self.buckets for k,v in bucket]

    # within the class
    def _hashfuction(self,key):
        key_string = str(key)
        hash_result = 0

        for char in key_string:
            hash_result = (hash_result * 31 + ord(char)) % self.capacity
        
