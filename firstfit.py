spaces=input('enter spaces: ').split(' ')
spaces=[int(i) for i in spaces]

inserts=input('enter inserts: ').split(' ')
inserts=[int(i) for i in inserts]

for i in inserts:
    for j in range(len(spaces)):
        if i<spaces[j]:
            print('inserted ',i,' at space ',spaces[j])
            spaces[j]-=i
            break
    if j==len(spaces)-1:
        print('canot insert ',i)
            