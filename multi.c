#include <stdio.h>

int main()
{
    int num1 = 10, num2 = 15, sum = 0;
    asm __volatile( "addl %%ebx,%%eax"
    :"=a"(num1)
    :"a"(num1), "b"(num2)
    );
    printf("num1 + num2=%d\n", num1);
    asm __volatile( "movl %%eax, %%ecx"
    :"=c"(sum)
    :"a"(num1)
    );
    printf("num1 + num2=%d\n", sum); return 0;
}