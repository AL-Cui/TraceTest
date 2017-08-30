

package com.example.idsbg_00.client

/**
 * Created by cuiduo on 2017/7/26.
 */
fun main(args: Array<String>) {
    for (i in 1..2){
        val macAddress = Util.getRandomMacAddress()
        startClient(macAddress)
    }

}

fun startClient(macAddress: String) {
    val client = Client(macAddress)
    client.start()
}