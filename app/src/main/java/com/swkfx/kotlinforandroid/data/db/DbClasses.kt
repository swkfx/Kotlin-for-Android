package com.swkfx.kotlinforandroid.data.db

/**
 * <pre>
 *      author : test
 *      e-mail : fangx@hyxt.com
 *      time   : 2018/1/2
 *      desc   :
 * </pre>
 */
class GirlListDb(val map: MutableMap<String, Any>) {

}


class GirlDb(var map: MutableMap<String, Any?>) {
    var girl_id: String by map
    var createAt: String by map
    var desc: String by map
    var publishedAt: String by map
    var source: String by map
    var type: String by map
    var url: String by map
    var used: Long by map
    var who: String by map

    constructor(girl_id: String,
                createAt: String,
                desc: String,
                publishedAt: String,
                source: String,
                type: String,
                url: String,
                used: Long,
                who: String) : this(HashMap()) {
        this.girl_id = girl_id
        this.createAt = createAt
        this.desc = desc
        this.publishedAt = publishedAt
        this.source = source
        this.type = type
        this.url = url
        this.used = used
        this.who = who

    }

    constructor(array: Array<Any?>) : this(HashMap()) {
        this.girl_id = array[1] as String
        this.createAt = array[2] as String
        this.desc = array[3] as String
        this.publishedAt = array[4] as String
        this.source = array[5] as String
        this.type = array[6] as String
        this.url = array[7] as String
        this.used = array[8] as Long
        this.who = array[9] as String
    }




}