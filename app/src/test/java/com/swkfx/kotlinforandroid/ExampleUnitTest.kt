package com.swkfx.kotlinforandroid

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }


    @Test
    fun testCollectionOperator() {
        val list = listOf(3, 4, 5, 6, 7)
        val charList = listOf("a", "b", "c", "d")
        val listWithNull = listOf(null, "a", 6)
        val unsortedList = listOf(5, 7, 3, 4, 6)

        //any 如果至少有一个元素符合给出的判断条件，则返回true。
        assertEquals(true, list.any { it % 2 == 0 })
        assertEquals(false, list.any { it > 10 })

        //all 如果全部的元素符合给出的判断条件，则返回true。
        assertEquals(true, list.all { it < 10 })
        assertEquals(false, list.all { it % 2 == 0 })

        //count 返回符合给出判断条件的元素总数。
        assertEquals(2, list.count { it % 2 == 0 })
        assertEquals(3, list.count { it % 2 != 0 })

        //fold 在一个初始值的基础上从第一项到最后一项通过一个函数累计所有的元素。
        assertEquals(30, list.fold(5) { total, next ->
            println("total = $total , next = $next")
            total + next
        })
        //从右往左
        assertEquals(30, list.foldRight(5) { total, next -> total + next })

        //带index 的
        assertEquals(0, list.foldRightIndexed(5) { index, next, total ->
            println("total = $total , next = $next ,index = $index")
            index
        })

        //迭代
        list.forEach { println("forEach it = $it") }
        list.forEachIndexed { index, i -> println("forEach index = $index ,i = $i") }

        //max
        assertEquals(7, list.max())
        //maxBy 会根据制定函数给出集合中最大的元素.
        assertEquals(3, list.maxBy {
            println("test maxBy " + (-it))
            -it
        })
        //min
        assertEquals(3, list.min())
        //minBy(没有最小值 返回null) 测不出null的情况.
        assertEquals(charList[0], charList.minBy {
            println("minBy test " + (it))
            it
        })

        //none 如果没有任何元素与给定的函数匹配，则返回true。
        assertEquals(true, charList.none { it == "e" })

        //reduce 与 fold  一样，但是没有一个初始值。通过一个函数从第一项到最后一项进行累计。
        assertEquals("abcd", charList.reduce { total, next ->
            println("total=$total ,next=$next")
            total + next
        })
        //从右至左,需要注意的是两个参数代表的意义.
        assertEquals("dcba", charList.reduceRight { next, total ->
            println("total=$total ,next=$next")
            total + next
        })
        /*sumBy
        返回所有每一项通过函数转换之后的数据的总和。*/
        assertEquals(10, list.sumBy {
            val flag = (it % 2) == 0
            if (flag) {
                it
            } else {
                0
            }
        })


        //过滤操作符
        /*drop
        返回包含去掉前n个元素的所有元素的列表。*/
        assertEquals(listOf(7), list.drop(list.size - 1))
        assertEquals(listOf(5, 6, 7), list.dropWhile { it != 5 }) //给出所给条件之前的都移除
        assertEquals(listOf(3), list.dropLast(list.size - 1))
        assertEquals(listOf(3, 4, 5), list.dropLastWhile { it > 5 })

        /*filter
        过滤所有符合给定函数条件的元素。*/
        assertEquals(listOf(3, 5, 7), list.filter { it % 2 != 0 })
        assertEquals(listOf(3, 5, 7), list.filterNot { it % 2 == 0 })
        assertEquals(listWithNull.subList(1, listWithNull.size), listWithNull.filterNotNull())


        /*slice
        过滤一个list中指定index的元素。*/ //保留指定index的元素
        val indexList = listOf(0, 2, 4)
        assertEquals(listOf(3, 5, 7), list.slice(indexList))
        assertEquals(listOf("a", "c"), charList.slice(listOf(0, 2)))


        /*take
        返回从第一个开始的n个元素。*/
        assertEquals(charList.subList(0, 2), charList.take(2))
        assertEquals(charList.subList(2, charList.size), charList.takeLast(2))
        assertEquals(charList.subList(2, charList.size), charList.takeLastWhile { it > "b" })

        //映射操作符
        /*flatMap
        遍历所有的元素，为每一个创建一个集合，最后把所有的集合放在一个集合中。*/
        assertEquals(listOf("a1", "b1", "c1", "d1"), charList.flatMap { listOf(it + "1") })
        assertEquals(listOf("a1", "b1", "c1", "d1"), charList.map { it + "1" })
        //groupBy 分组
        val map = list.groupBy { if (it % 2 == 0) "even" else "odd" }
        map.entries.forEach {
            println("key = " + it.key + " ,value = " + it.value)
        }
        assertEquals(mapOf("odd" to listOf(3, 5, 7), "even" to list.filter { it % 2 == 0 }),
                map)

        /*mapIndexed
        返回一个每一个元素根据给定的包含元素index的函数转换所组成的List。*/
        assertEquals(listOf("a0", "b1", "c2", "d3"), charList.mapIndexed { index, s -> s + index })
        assertEquals(listOf("a0", "b1", "c2", "d3"), charList.mapIndexed { index, s -> s + index })
        assertEquals(listOf("a", 6), listWithNull.mapNotNull { it })


        /*元素操作符
        contains
        如果指定元素可以在集合中找到，则返回true。*/
        assertEquals(true, list.contains(3))
        /*elementAt返回给定index对应的元素，如果index数组越界则会抛出 IndexOutOfBoundsException  。*/
        assertEquals(list[2], list.elementAt(2))
        /*elementAtOrElse
        返回给定index对应的元素，如果index数组越界则会根据给定函数返回默认值。*/
        assertEquals(0, list.elementAtOrElse(6, { 0 }))
        /*elementAtOrNull
        返回给定index对应的元素，如果index数组越界则会返回null。*/
        assertEquals(null, list.elementAtOrNull(6))

        /*first
        返回符合给定函数条件的第一个元素。*/
        assertEquals(4, list.first { it % 2 == 0 })
        /*indexOf
        返回指定元素的第一个index，如果不存在，则返回 -1  。*/
        assertEquals(1, list.indexOf(4))
        assertEquals(-1, list.indexOfFirst { it > 8 })
        /*single
        返回符合给定函数的单个元素，如果没有符合或者超过一个，则抛出异常。*/
        val singleList = listOf("1")
        val single = singleList.single()
        println("single test : $single")
        assertEquals(5, list.single { it % 5 == 0 })
        /*singleOrNull
        返回符合给定函数的单个元素，如果没有符合或者超过一个，则返回null。*/
        assertEquals(null, list.singleOrNull() { it % 8 == 0 })

        /*生产操作符*/

        //在1.0.2 版本后面弃用了
        /*merge
        把两个集合合并成一个新的，相同index的元素通过给定的函数进行合并成新的元素
        作为新的集合的一个元素，返回这个新的集合。新的集合的大小由最小的那个集合
        大小决定。*/

        /*partition
        把一个给定的集合分割成两个，第一个集合是由原集合每一项元素匹配给定函数条
        件返回 true  的元素组成，第二个集合是由原集合每一项元素匹配给定函数条件返
                回 false  的元素组成。*/
        assertEquals(Pair(list.filter { it % 2 == 0 }, list.filter { it % 2 != 0 }),
                list.partition { it % 2 == 0 }
        )

        /*plus
        返回一个包含原集合和给定集合中所有元素的集合，因为函数的名字原因，我们可
        以使用 +  操作符。*/
        assertEquals(list.plus(8), list.plus(listOf(8)))
        assertEquals(list.plus(8), list + listOf(8))
        assertEquals(list.plus(list), list + list)

        /*zip
        返回由 pair  组成的List，每个 pair  由两个集合中相同index的元素组成。这个返
        回的List的大小由最小的那个集合决定。*/
        val zip = list.zip(list)
        zip.forEach { println("zip test -> " + it) }
        val pair = zip[0]
        val i = pair.first + pair.second
        assertEquals(6, i)
        assertEquals(listOf(Pair(3, 8), Pair(4, 8)), list.zip(listOf(8, 8)))

        /*upzip
        * 与上面的相反
        * */
        val unzip = zip.unzip()
        println("unzip test ->" + unzip)
        assertEquals(list, unzip.first)
        assertEquals(list, unzip.second)

        /*顺序操作符
        reverse 估计也是弃用了.换了api
        返回一个与指定list相反顺序的list。*/
        assertEquals(listOf(7, 6, 5, 4, 3), list.asReversed())

        /*sort 估计也是弃用了.换了api
        返回一个自然排序后的list。*/
        assertEquals(list, unsortedList.sorted())

        /*sortBy val unsortedList = listOf(5, 7, 3, 4, 6)
        返回一个根据指定函数排序后的list。
        猜测是根据 返回值  负数 0 整数 来判断
        */
        val sortedBy = unsortedList.sortedBy { it % 2 }
        println("sortedBy src -> " + unsortedList)
        println("sortedBy test -> " + sortedBy)
        assertEquals(listOf(4, 6, 5, 7, 3), sortedBy)
        /* 当返回是 int 会按 自然排序来一下.*/
        assertEquals(listOf(3, 6, 7, 4, 5), unsortedList.sortedBy { it % 3 })
        assertEquals(listOf(4, 5, 6, 7, 3), unsortedList.sortedBy { it % 4 })
        /* 当返回 true false 时 会把 false 排在前面*/
        assertEquals(listOf(5, 7, 3, 6, 4), unsortedList.sortedBy { it == 4 })
        assertEquals(listOf(3, 4, 5, 7, 6), unsortedList.sortedBy { it > 4 })


        /* sortDescending
         返回一个降序排序后的List。
         sortDescendingBy
         返回一个根据指定函数降序排序后的list。*/
        assertEquals(list.asReversed(), unsortedList.sortedDescending())
        /* 依然是从左到右 根据返回值降序排列  */
        assertEquals(listOf(5, 7, 4, 3, 6), unsortedList.sortedByDescending { it % 3 })
    }

}
