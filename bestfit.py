spaces=input('enter spaces: ').split(' ')
spaces=[int(i) for i in spaces]
spaces.sort()

inserts=input('enter inserts: ').split(' ')
inserts=[int(i) for i in inserts]

for i in inserts:
    j=0
    while j<len(spaces):
        if i<spaces[j]:
            break
        j+=1
    if j==len(spaces):
        print('cannot insert ',i)
    elif i<spaces[j]:
        print('inserted ',i,' at space ',spaces[j])
        spaces[j]-=i
        spaces.sort()
