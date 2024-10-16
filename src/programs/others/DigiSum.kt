package programs.others

/** 1234
 * The sum of 1+2+3+4 = 10,
 * digSum(x) == 10
 * Hence ans will be 1+0 = 1
 */

fun main(){
    val n = 1234
    println(digisum(n))
}

fun digisum(num: Int): Int{
    var n = num
    var sum = 0
    while(n>0 || sum>9 ){
        if(n==0){
            n = sum
            sum = 0
        }
        sum += n % 10
        n /= 10
    }
    return sum
}