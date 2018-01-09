package com.swkfx.kotlinforandroid.extensions

/**
 * <pre>
 *      author : test
 *      e-mail : fangx@hyxt.com
 *      time   : 2018/1/8
 *      desc   :
 * </pre>
 */
fun <K, V : Any> Map<K, V?>.toVarargArray(): Array<out Pair<K, V>> = map({ Pair(it.key, it.value!!) }).toTypedArray()


fun <T, R> Iterable<T>.firstResult(girls: (T) -> R?): R {
    for (element in this) {
        val result = girls(element)
        if (result != null) {
            return result
        }
    }
    throw NoSuchElementException("No element matching girls was found.")
}
