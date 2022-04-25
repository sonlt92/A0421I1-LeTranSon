function SumFibonacci(endPoint: number): number {
    let a: number = 1;
    let b: number = 1;
    let sum: number = 2;
    let tmp: number;
    if (endPoint < 1) {
        return 0;
    }
    while (b < endPoint) {
        tmp = b;
        b = a + b;
        a = tmp;
        sum += b;
    }
    sum -= b;
    return sum;
}

console.log(SumFibonacci(10));