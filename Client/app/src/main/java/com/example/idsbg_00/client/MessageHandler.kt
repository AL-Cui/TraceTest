package com.example.idsbg_00.client
import org.dom4j.DocumentHelper
import org.apache.mina.core.service.IoHandlerAdapter
import org.apache.mina.core.session.IoSession
import org.dom4j.Document
import org.dom4j.Element


/**
 * Created by cuiduo on 2017/7/22.
 */
class MessageHandler(val macAddress:String) : IoHandlerAdapter() {
//    val logger = LoggerFactory.getLogger(javaClass.simpleName)!!
    override fun sessionCreated(session: IoSession?) {
        super.sessionCreated(session)
    System.out.println("sessionCreated")
    }

    override fun exceptionCaught(session: IoSession?, cause: Throwable) {
//        super.exceptionCaught(session, cause)
        System.out.println("exceptionCaught: ${cause.printStackTrace()}")
    }

    override fun messageReceived(session: IoSession?, message: Any?) {
//        super.messageReceived(session, message
        try {
            // 消息内容
            val text = message.toString()
            // 获取服务端发过来的消息内容
            System.out.println("received message $text")
            if (Util.isNotBlank(text)) {
                // 解析XML文件
                readXML(text, session)
            } else {
                // 返回错误信息
                session?.write("error heartbeat")
            }
        } catch (e: Exception) {
            System.out.println(e.printStackTrace().toString())
        }

    }

    override fun messageSent(session: IoSession?, message: Any?) {
//        super.messageSent(session, message)
        val msg = message.toString()
        System.out.println("sent message $msg")
    }

    override fun sessionClosed(session: IoSession?) {
        super.sessionClosed(session)
    }

    fun readXML(contents: String, session: IoSession?) {
        try {
            var readDoc: Document = DocumentHelper.parseText(contents)
            val rootNode: Element = readDoc.rootElement
            if (Util.NODE_TCP_MSG.equals(rootNode.name)) {
                if (Util.MSG_VALUE_HEARTBEATRES.equals(rootNode.elementTextTrim(Util.NODE_MSG))) {   //收到心跳包回复，什么也不做

                } else if (Util.MSG_VALUE_CTRLNOTIFY.equals(rootNode.elementTextTrim(Util.NODE_MSG))) {
                    //收到服务器发过来的指令
                    println("收到的服务器指令 = ${rootNode.elementTextTrim(Util.NODE_CMD)}")
                    when(rootNode.elementTextTrim(Util.NODE_CMD)){
                        Util.CMD_VALUE -> {
                            Binding().boxIDCreateFirstRequest(macAddress)
                            //绑定指令，待完善
                        }
                        Util.CMD_VALUE_BOXDELETE -> {
                            //删除boxid,待完善
                        }
                        Util.MSG_VALUE_CTRLNOTIFY ->{
                            //去HMS去控制指令，并上报结果，再把状态给回去,待完善
                        }
                    }
                }
            }
        } catch (e: Exception) {
            System.out.println(e.toString())
        }
    }
}