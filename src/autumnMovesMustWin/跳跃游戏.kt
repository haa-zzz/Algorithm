package autumnMovesMustWin


/**
每次取最大跳跃步数（取最大覆盖范围），最后看最大覆盖范围，看是否能到终点。其实和1差不多
注意点在语法：当用for循环直接在循环中修改cover值时，发现for循环中的判断还是原来的值。
*/
fun canJump(nums: IntArray): Boolean {
    var cover = 0
    var i = 0
    while(i <= cover) {
        cover = Math.max(cover, i + nums[i])
        if (cover >= nums.size - 1) {
            return true
        }
        i++
    }
    return false
}