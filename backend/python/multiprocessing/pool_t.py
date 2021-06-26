import multiprocessing 
import time

def do_cal(data):
    return data * 2
    

def  start_process():
    print('starting',multiprocessing.current_process().name)

inputs = list(range(38))
print('Inputs: ',inputs)

pool_size = multiprocessing.cpu_count() * 2
print("Pool Size: %d" % pool_size)

#pool=multiprocessing.Pool(processes=pool_size, initializer=start_process)
pool=multiprocessing.Pool(processes=pool_size, initializer=start_process,
                        maxtasksperchild=2)

#pool_output = pool.map(do_cal, inputs)
pool_output = pool.map_async(do_cal, inputs)
#pool_output = pool.starmap(do_cal, inputs)
#pool_output = pool.starmap_async(do_cal, inputs)
#pool_output = pool.apply(do_cal, inputs)
#pool_output = pool.apply_async(do_cal, inputs)


#time.sleep(5)
pool.close()
pool.join()
#pool.terminate()

'''
for map_async
'''
print(type(pool_output))

while True:
    if pool_output.ready():
        print(pool_output.get())
        break
    else:
        continue

'''
for map
print(pool_output)
'''
