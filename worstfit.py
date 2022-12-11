spaces=input('enter spaces: ').split(' ')
spaces=[int(i) for i in spaces]
spaces.sort(reverse=True)

inserts=input('enter inserts: ').split(' ')
inserts=[int(i) for i in inserts]

for i in inserts:
    if i>spaces[0]:
        print('cant insert ',i)
    else:
        print('inserted ',i,' at size of ',spaces[0])
        spaces[0]=spaces[0]-i
        spaces.sort(reverse=True)

