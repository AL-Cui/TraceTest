package com.example.idsbg_00.client

import java.util.*
import org.dom4j.DocumentHelper
import java.util.*

/**
 * Created by cuiduo on 2017/7/24.
 */
object Util {
    val strings = arrayOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F")
    val indexInt = arrayOf(1, 3, 5, 7, 9, 11, 13, 15)
    val numberInt = arrayOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "0")

    val CLIENT_AGREEMENT = "TLS"
    /** Xml:节点信息内容  */
    val SHARP_VERSION = "SHARP_AP_1_0.1.43"
    /** Xml:节点信息内容  */
    val MACHINE_VERSION = "SHARPPCIANRS_AP_FPCH70_3_0"
    /** Xml:节点  */
    val NODE_TCP_MSG = "tcp_msg"

    /** Xml:节点  */
    val NODE_MSG = "msg"

    /** Xml:节点信息内容  */
    val MSG_VALUE_HEARTBEATRES = "heartbeatres"

    /** Xml:节点信息内容  */
    val MSG_VALUE_HEARTBEAT = "heartbeat"

    /** Xml:节点信息内容  */
    val MSG_VALUE_NOTIFY = "notify"

    /** Xml:节点信息内容  */
    val MSG_VALUE_LINKRESET = "linkreset"

    /** Xml:节点信息内容  */
    val MSG_VALUE_UPDATE = "updateversionres"

    /** Xml:节点信息内容  */
    val MSG_VALUE_MACHVER = "updatemachverres"

    /** Xml:节点信息内容  */
    val CMD_VALUE_RECEIVE = "receiveverionres"

    /** Xml:节点信息内容  */
    val CMD_VALUE_RECEIVEMACHVER = "receivemachverres"

    /** Xml:节点信息内容  */
    val MSG_VALUE_CTRLNOTIFY = "ctrlnotify"

    /** Xml:节点信息内容  */
    val CMD_VALUE_UPDATEVERSION = "updateversion"

    /** Xml:节点信息内容  */
    val CMD_VALUE_UPDATEMACHVER = "updatemachver"

    /** Xml:节点  */
    val NODE_CMD = "cmd"

    /** Xml:节点  */
    val NODE_URL = "url"

    /** Xml:节点  */
    val NODE_VERSION = "version_number"

    /** Xml:节点  */
    val NODE_VERSIONMACHVER = "mach_version_number"

    /** Xml:节点  */
    val NODE_UPDATEFLAG = "update_flag"

    /** Xml:节点信息内容  */
    val CMD_VALUE = "initialsetcmd"

    /** Xml:节点信息内容  */
    val CMD_VALUE_CHECKCMD = "checkcmd"

    /** Xml:节点信息内容  */
    val CMD_VALUE_BOXDELETE = "boxdelete"

    /** Xml:节点  */
    val NODE_DATA = "data"

    /** Xml:节点  */
    val NODE_MAC_ADDRESS = "mac_address"

    /** Xml:节点  */
    val NODE_SERVER_TIME = "server_time"

    val BID = "https://vmdb.cloudlabs.sharp.co.jp/clpf/key/u7NdgXmkPzzAQVqjd34wG--w2OKp6S5VD3DSSXuIBgk"

    val MONITORING = "monitoring"

    val AUTH = "auth"

    val INFO = "info"

    val MONITOR = "monitor"

    val DTVER = "dtver"

    val DTVER_VALUE = "SHARP_A01 0.14.6252"

    val STATUS = "status"

    val STATUS_VALUE = "00"

    val TYPE = "type"

    val TYPE_VALUE = "wifimodule"

    val ID = "id"

    val ID_VALUE = "FF-FF-FF-FF-CH-N1"

    val PASS = "pass"

    val PV_ADDR = "pv_addr"

    val PV_ADDR_VALUE = "120.000.000.001"

    val MEMBOPTION = "memboption"

    val MEMBOPTION_VALUE = "force_create_id='true' app_secret='orCPmn4UHx5bptZm1mmEUQ3XC1q%2BI%2B3gRdCVX4YfTEY%3D'"

    val CMD = "cmd"

    val MEMB = "memb"

    val MEMBER = "member"


    val EXTENSION = "extension"

    val ONE = "1"

    val BOX_ID = "box_id"

    val DATA = "data"

    val PUT = "put"

    val SET_TIME = "set_time"

    val SET_TIME_VALUE = "1438662643073"

    //   public static final String PASS_VALUE= "IKk4dEFt";

    val NEXT_COMM = "next_comm"

    val NEXT_COMM_VALUE = "10000"

    val CENTER_ADDR = "center_addr"

    val CENTER_ADDR_VALUE = "shcloud-rd.sharp.cn"

    val END = "end"

    //ControlTest:
    val CMONITORING = "cmonitoring"

    val STATUS_VALUE2 = "01"

    val CHECKCTRL = "checkctrl"

    val CONTROL = "control"

    val CONF = "conf"

    val BOXCONF = "boxconf"

    val DEVCTRL = "devctrl"

    val ECHO = "echo"

//status:

    val STATUS_VALUE3 = "02"

    @JvmStatic
    fun isNotBlank(inputValue: String?): Boolean {
        if (inputValue == null) {
            return false
        }
        if ("" != inputValue.trim { it <= ' ' }) {
            return true
        }
        return false
    }

    @JvmStatic
    fun getRandomMacAddress(): String {
        var result: String = ""
        var index: Int
        val random = Random()
        for (i: Int in 1..17) {
            if (i == 2) {
                index = indexInt[random.nextInt(8)]
                result += strings[index]
            } else if (i % 3 == 0) {
                result += "-"
            } else {
                index = random.nextInt(16)
                result += strings[index]
            }
        }
        return result
    }

    fun getPhoneNumber(): String {
        var phoneNumber = "120"
        val random = Random()
        var index: Int
        for (i: Int in 1..8) {
            index = random.nextInt(10)
            phoneNumber += numberInt[index]
        }
        return phoneNumber
    }

}