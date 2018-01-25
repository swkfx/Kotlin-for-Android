package com.swkfx.kotlinforandroid

import org.junit.Test
import java.text.SimpleDateFormat
import java.util.*

/**
 * <pre>
 *      author : test
 *      e-mail : fangx@hyxt.com
 *      time   : 2018/1/24
 *      desc   :
 *          yyyy：年
 *          MM：月
 *          dd：日
 *          hh：1~12小时制(1-12)
 *          HH：24小时制(0-23)
 *          mm：分
 *          ss：秒
 *          S：毫秒
 *          E：星期几
 *          D：一年中的第几天
 *          F：一月中的第几个星期(会把这个月总共过的天数除以7)
 *          w：一年中的第几个星期
 *          W：一月中的第几星期(会根据实际情况来算)
 *          a：上下午标识
 *          k：和HH差不多，表示一天24小时制(1-24)。
 *          K：和hh差不多，表示一天12小时制(0-11)。
 *          z：表示时区
 *
 * 日期和时间格式由 日期和时间模式字符串 指定。在 日期和时间模式字符串 中，
 * 未加引号的字母 'A' 到 'Z' 和 'a' 到 'z' 被解释为模式字母，用来表示日期或时间字符串元素。
 * 文本可以使用单引号 (') 引起来，以免进行解释。所有其他字符均不解释；只是在格式化时将它们简单复制到输出字符串
 *
 * </pre>
 */
class KotlinTest {
    @Test
    fun dateTest() {
        //    2015-08-06T04:16:55.575Z
        val timeStr = "2015-08-06T04:16:55.575Z"

        val millis = System.currentTimeMillis()
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S'Z'", Locale.getDefault())
        val parse = dateFormat.parse(timeStr)
        println("parseTime-->${parse.time}")
        println("date-->" + dateFormat.format(millis))

    }
}