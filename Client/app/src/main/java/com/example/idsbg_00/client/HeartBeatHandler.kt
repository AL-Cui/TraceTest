package com.example.idsbg_00.client

import org.dom4j.DocumentHelper
import org.apache.mina.core.session.IoSession
import org.apache.mina.filter.keepalive.KeepAliveMessageFactory
import org.dom4j.Document
import org.dom4j.Element


/**
 * Created by cuiduo on 2017/7/22.
 */
class HeartBeatHandler(var str:String) : KeepAliveMessageFactory {
    //    val logger = LoggerFactory.getLogger(javaClass.simpleName)!!
    //创建我的心跳包内容
    fun createHeartBeatxml(): String {
        var result: String = ""
        // DocumentHelper提供了创建Document对象的方法
        val writeDoc = DocumentHelper.createDocument()
        // 添加节点：tcp_msg
        val root = writeDoc.addElement(Util.NODE_TCP_MSG)
        // 添加节点：msg
        val msg = root.addElement(Util.NODE_MSG)
        // 设置节点信息
        msg.text = Util.MSG_VALUE_HEARTBEAT

        // 添加节点:data
        val data = root.addElement(Util.NODE_DATA)
        // 添加节点:mac_address
        val mac_address = data.addElement(Util.NODE_MAC_ADDRESS)
//        val s = str
//        val s = Util.getRandomMacAddress()
        System.out.println(str)
        //添加mac_address节点内容
        mac_address.text = str

        val version_number = data.addElement(Util.NODE_VERSION)
        version_number.text = Util.SHARP_VERSION

        val mach_version_number = data.addElement(Util.NODE_VERSIONMACHVER)
        mach_version_number.text = Util.MACHINE_VERSION
        result = writeDoc.asXML()
        // 将document文档对象直接转换成字符串
        System.out.println("发送内容: " + writeDoc.asXML())
//        session.write(writeDoc.asXML())
        return result
    }

    fun readHeartBeatXML(contents: String) :Boolean{
        try {
            var readDoc: Document = DocumentHelper.parseText(contents)
            val rootNode: Element = readDoc.rootElement
            var mac: String = ""
            if (Util.NODE_TCP_MSG.equals(rootNode.name)) {
                println("contents = ${rootNode.elementTextTrim(Util.NODE_MSG)}")
                return (Util.MSG_VALUE_HEARTBEATRES.equals(rootNode.elementTextTrim(Util.NODE_MSG)))
            }
        } catch (e: Exception) {
            System.out.println(e.toString())
        }
        return false
    }

    override fun getResponse(p0: IoSession?, request: Any?) = null

    override fun isRequest(p0: IoSession?, message: Any?): Boolean = false

    override fun isResponse(p0: IoSession?, message: Any?): Boolean {
        System.out.println("收到内容：" + message.toString())
        return readHeartBeatXML(message.toString())
    }

    override fun getRequest(session: IoSession?): Any = createHeartBeatxml()
}