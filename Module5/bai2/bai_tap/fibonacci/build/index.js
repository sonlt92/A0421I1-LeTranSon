function SumFibonacci(endPoint) {
    let a = 1;
    let b = 1;
    let sum = 2;
    let tmp;
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
